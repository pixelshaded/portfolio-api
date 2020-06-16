import com.alexanderfisher.portfolio.api.springboot.invoker.OpenAPI2SpringBoot;
import com.alexanderfisher.portfolio.api.springboot.service.impl.AppConfigProviderImpl;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;
import org.testcontainers.Testcontainers;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.WaitingConsumer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ContractTesting {

    private final String MYSQL_READY_MESSAGE = "ready for connections";
    private final String DREDD_DONE_MESSAGE = "complete: Tests took";
    private final String DREDD_FAILURE_MESSAGE = "fail:";
    private final String DREDD_REPORT_FILE_FOLDER = "/contract_testing_results";
    private final String DREDD_REPORT_FILE_NAME = "contract_test_report.md";

    @Rule
    public final EnvironmentVariables environmentVariables = new EnvironmentVariables();

    @Test
    public void testContract() throws Exception {
        Testcontainers.exposeHostPorts(8080);
        try (GenericContainer mysql = new GenericContainer<>("pixelshaded/portfolio-db:1.0")
            .withEnv("MYSQL_DATABASE", "portfolio")
            .withEnv("MYSQL_USER", "portfolio")
            .withEnv("MYSQL_PASSWORD", "portfolio")
            .withEnv("MYSQL_RANDOM_ROOT_PASSWORD", "random")
            .withExposedPorts(3306)
        ){
            mysql.start();
            WaitingConsumer consumer = new WaitingConsumer();
            mysql.followOutput(consumer);
            consumer.waitUntil(frame -> {
                String message = frame.getUtf8String();
                return message.contains(MYSQL_READY_MESSAGE);
            }, 60, TimeUnit.SECONDS);

            String dbUrl = "jdbc:mysql://" + mysql.getHost() + ":" + mysql.getFirstMappedPort();
            environmentVariables.set(AppConfigProviderImpl.DATABASE_URL, dbUrl);
            environmentVariables.set(AppConfigProviderImpl.DATABASE_USER, "portfolio");
            environmentVariables.set(AppConfigProviderImpl.DATABASE_PASSWORD, "portfolio");
            OpenAPI2SpringBoot.main(new String[]{});

            String dreddCommand = "dredd "
                + "--reporter markdown "
                + "--output " + DREDD_REPORT_FILE_FOLDER + "/" + DREDD_REPORT_FILE_NAME + " "
                + "http://host.testcontainers.internal:8080/swagger.json "
                + "http://host.testcontainers.internal:8080"
            ;

            try (GenericContainer dredd = new GenericContainer<>("apiaryio/dredd")
                 .withCommand(dreddCommand)
            ){
                dredd.start();
                WaitingConsumer dreddConsumer = new WaitingConsumer();
                dredd.followOutput(dreddConsumer);
                AtomicReference<Boolean> contractedTestingFailed = new AtomicReference<>(false);
                dreddConsumer.waitUntil(frame -> {
                    String message = frame.getUtf8String();
                    if (message.startsWith(DREDD_FAILURE_MESSAGE)) {
                        contractedTestingFailed.set(true);
                    }
                    return message.contains(DREDD_DONE_MESSAGE);
                }, 60, TimeUnit.SECONDS);

                // dredd.copyFileFromContainer(DREDD_REPORT_FILE_FOLDER + "/" + DREDD_REPORT_FILE_NAME, "target/test-classes");

                Assert.assertFalse("Contract testing failed", contractedTestingFailed.get());
            }
        }

    }
}

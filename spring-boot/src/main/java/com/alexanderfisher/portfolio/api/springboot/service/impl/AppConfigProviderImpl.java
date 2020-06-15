package com.alexanderfisher.portfolio.api.springboot.service.impl;

import com.alexanderfisher.portfolio.api.springboot.service.AppConfigProvider;
import org.springframework.stereotype.Service;

@Service
public class AppConfigProviderImpl implements AppConfigProvider {
    public static final String PREFIX = "PORTFOLIO_API_SPRING_BOOT_";
    public static final String DATABASE_URL = PREFIX + "DATABASE_URL";
    public static final String DATABASE_USER = PREFIX + "DATABASE_USER";
    public static final String DATABASE_PASSWORD = PREFIX + "DATABASE_PASSWORD";

    @Override
    public String getDatabaseUrl() throws Exception {
        return getRequiredEnvironmentVariable(DATABASE_URL);
    }

    @Override
    public String getDatabaseUser() throws Exception {
        return getRequiredEnvironmentVariable(DATABASE_USER);
    }

    @Override
    public String getDatabasePassword() throws Exception {
        return getRequiredEnvironmentVariable(DATABASE_PASSWORD);
    }

    public String getRequiredEnvironmentVariable(String environmentVariable) throws Exception {
        String value = System.getenv(environmentVariable);
        if (value == null) {
            throw new Exception("Required environment variable " + environmentVariable + " is not defined.");
        }
        return value;
    }
}

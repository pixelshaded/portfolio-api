# portfolio-api
API for alexander-fisher.com based on spring boot.

This takes a design first, database first approach.

## Exploring the API

The easiest way to explore the API is using the [swagger ui demo](https://petstore.swagger.io) and feeding this url:
* https://env-4621960.ny-1.paas.massivegrid.net/swagger.json

## Contract Testing

[dredd](https://dredd.org/en/latest/) is a very cool tool for this. My hope was that I could use [testcontainers](https://www.testcontainers.org/)
to start up the database container, start the spring boot app configured to point to this container, and then finally
start a dredd container which points to the spring boot app and run contract testing against it. This would give huge bang
for buck in terms of code coverage. Dredd would hit every known endpoint and nothing would get mocked.

The problem is that the @SpringBootTest annotation gives us zero control over when the application starts. The app is 
configured to get connection information from environment variables to be container friendly. There is an interface for getting
these values, so it could be easily mocked. The problem however is that we don't know what port testcontainers has decided
to assign to the db container until after the spring boot app has started. I need to be able to mock these methods before
the application starts.

Another alternative then would be to just pack up the application in a local container and use testcontainers to start it.
This route seems quite heavy however. It takes minutes to download and start up these container images. This is the main
reason I abandoned this approach, at least for now.

The second issue is that we need a way to determine when the container has finished its start up scripts. For example, we
can start the db container and then immediately start the app container, but if the db container hasn't finished initializing
the db and isn't ready for connections, the app container will fail during start up because it can't connect to the db. The
method that testcontainers provide for this is essentially scanning stdout with a WaitingConsumer until you receive a 
message that would indicate the container is done initializing. I've done this before and it's not fun to figure out. It
also means there is a lot of waiting around while things start. It already takes forever just starting the images.

Not all is lost of course. We can still do contract testing by using the command line. The following command will run
a test against the live application.

```bash
docker run -it apiaryio/dredd dredd https://env-4621960.ny-1.paas.massivegrid.net/swagger.json https://env-4621960.ny-1.paas.massivegrid.net
```

This type of testing would ideally be a part of the testing framework so that if the contract tests fail, the build would fail.
This command at least would provide a way to do quick smoke testing on a released service.

## Modules

### openapi

Contains the OpenAPI spec and is shared with the other modules using the [maven-remote-resources-plugin](http://maven.apache.org/plugins/maven-remote-resources-plugin/).

### models

The models module uses [openapi generator](https://openapi-generator.tech/) java generator to create POJOs used to deserialize
requests and serialize responses.

### database

This is a very simply docker image extending the mysql image. All it really does is drop the database dump file in to a folder.
The rest of the configuration is handled with environment variables.

Currently uses shell scripts to build, run, and publish the image. Note that I am not using this image in the cloud. I
ran in to endless issues on start up for some reason. Developers are infamous for spending hours automating something
that takes a few minutes to do manually, so I eventually opted for the more manual approach with jElastic's built in
support for MySQL and manually creating tables and importing the database dump.

### hbm2java

I wasn't happy with the naming conventions for the reverse engineered entities, so this module holds a class which extends
DefaultReverseEngineeringStrategy and tweaks the naming of classes. This is in a separate module from hibernate because
the class needs to be available to the hibernate-tools-maven-plugin which tries to generate source before we even compile.

### hibernate

This module is responsible for generating all the entity classes through reverse engineering of the database. We use a small
tweak to the Pojo template to remove generation timestamps. Version control is enough for tracking this kind of change and
I don't want to see any diff noise if the rest of the file hasn't changed. The reason I like to version models and entities
rather than having them output only to target is so that you can see how the files change as changes are made to the db 
or open api spec. Changes to contracts can sometimes be more easily seen by looking at these classes.

We also generate Metamodels in the module so we can have type safe hibernate queries. I much prefer this over using string
literals so the compiler can show us all the things that need to be changed when there is a change in the db schema.

The db image needs to be running for the hibernate module to generate entities via reverse engineering. It would be more 
ideal if this module would start up the db container on its own so it could build in any env. This may be a case where 
codegen needs to be conditional, perhaps on the folder being empty, so that a missing db doesn't cause build failures.

### spring-boot

In the design first, db first approach, if we use code generation for communicating with the layers, then ideally all 
we ever have to write (other than db schema and spec) is our custom business logic and the translation logic between 
database entities and api models. The idea here is that I should never have to hand write a rest client, request 
scaffolding / validation, and db entities again.

The openapi generator tool is used here again to create delegate based controllers. Then we simply create an implementation
of the delegate. Request routing and validation is handled for us by the code generated from the spec. The spec should
be the source of truth for this stuff. If it can properly generate server stubs for us then the spec should be good enough
to generate clients as well. We should eat our own dogfood. If the spec is just there for documentation, it loses a lot 
of its value and there is no guarantee it is truly machine readable for codegen which in my opinion is the whole point.

This application runs in a container on MassiveGrid.


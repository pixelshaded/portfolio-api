# portfolio-api
API for alexander-fisher.com based on spring boot.

This takes a design first, database first approach.

## Exploring the API

The easiest way to explore the API is using the [swagger ui demo](https://petstore.swagger.io) and feeding this url:
* https://env-4621960.ny-1.paas.massivegrid.net/swagger.json

## Contract Testing

[dredd](https://dredd.org/en/latest/) is a very cool tool for this. Using [testcontainers](https://www.testcontainers.org/),
the test class starts the db container and waits until its ready, then it starts the main function of the spring boot app, followed by
starting the dredd container and running the dredd command against the app. The report is copied to the target folder so
that if the command fails, we can figure out why.

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


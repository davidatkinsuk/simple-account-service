# Simple Account Service

## Overview

This is a simple REST service for adding, deleting and listing accounts.

Spring Boot is used to bootstrap the Jersey based JAX-RS service. Alternatively, i'd consider using Camel with its built in REST support (with or without Spring Boot)

Unit tests are provided for the in memory repository, and integration tests are provided for the end to end service. To keep things simple, both run in the maven test phase, e.g. to run all tests run

    mvn test

For more substantial projects i'd consider using a BDD approach (e.g. Gherkin/Cucumber JVM) to express the functional/integration tests. I'd also consider generating a swagger doc and using that to generate the JAXRS interface and model classes

Lombok is used to automatically generate getters and setters and builder. This reduces boiler plate code.

## Intellij

If using Intellij, first install the Lombok Plugin and enable Annotation Processors. See [this Stack Overflow page](https://stackoverflow.com/questions/9424364/cant-compile-project-when-im-using-lombok-under-intellij-idea) for more information.
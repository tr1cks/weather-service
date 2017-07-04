# Weather service

This is simple weather aggregation service, that i wrote a long time ago.
It's main goal is collecting weather observations from different sources.
Additional module "web" can show last gathered info in web UI, but it not necessary - core can work without it.

In project was used:
* Spring IoC.
* JPA over Hibernate.
* Java Bean validation.
* Quartz.
* PostgreSQL (migrations wrote in plain SQL).
* Flyway for migrations as experimental lightweight alternative to Liquibase.
* Spring MVC and Bootstrap for UI.

## Features
* Aggregating weather observations from different sources (HAM Weather and OpenWeatherMap at current time).
* Keep historical data.
* Show last observations in Web UI.
* Modularity. Core can run in console and aggregate data, web UI totally optional. Sources of data can be simple added.

## How to run application with web UI
1. Setup PostgreSql 9.
2. Create user with credentials "weatherservice"/"weatherservice" in it.
3. Create database "weatherservice" with owner "weatherservice". Application will automatically create database.
4. Build war and deploy it in Tomcat 7.

## How to run without UI
1. Setup PostgreSql 9.
2. Create user with credentials "weatherservice"/"weatherservice" in it.
3. Create database "weatherservice" with owner "weatherservice". Application will automatically create database.
4. Run Main in module "core" from IDE.

## How to run tests
1. Setup PostgreSql 9.
2. Create user with credentials "weatherservice-test"/"weatherservice-test" in it.
3. Create database "weatherservice-test" with owner "weatherservice-test".
4. Run JUnit tests.

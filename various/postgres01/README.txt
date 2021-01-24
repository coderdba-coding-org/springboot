==============================
POSTGRES JDBC
==============================

Purpose:
Simple example using JDBC drivers, JPA, Spring-Data JPA 'Hibernate' to connect to Postgres and do CRUD

Note:
Dependency spring-boot-starter-data-jpa also brings Hibernate because it is based on Hibernate

==============================
REFERENCES
==============================

Springboot: 
https://www.baeldung.com/spring-boot-hibernate
https://www.baeldung.com/spring-data-repositories

https://zetcode.com/springboot/postgresql/ (with Thymeleaf for html, spring-boot-starter-data-jpa, Hibernate etc)

https://developer.okta.com/blog/2018/12/13/build-basic-app-spring-boot-jpa (describes JPA, Hibernate etc)
- also see https://vladmihalcea.com/9-postgresql-high-performance-performance-tips/
https://dzone.com/articles/spring-boot-and-postgresql

https://spring.io/blog/2011/02/10/getting-started-with-spring-data-jpa/
https://docs.spring.io/spring-data/data-commons/docs/2.3.3.RELEASE/reference/html/#mapping.fundamentals

Sqls:
https://zetcode.com/springboot/postgresql/

Postgres Connection Properties:
- Main project reference: https://zetcode.com/springboot/postgresql/
- has Hikari stuff: https://stackoverflow.com/questions/51242938/spring-boot-application-gets-stuck-on-hikari-pool-1-starting

---------------------
JPA
---------------------
JPA - Java Persistence API: https://www.infoworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html
- ORM - Object Relational Mapping - to use with RDBMS
- Hibernate - for RDBMS - http://hibernate.org/orm/
- EclipseLink - for NOSQL - https://www.eclipse.org/eclipselink/

JPA Repository "JpaRepository" Spec: 
https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
(from https://docs.spring.io/spring-data/jpa/docs/current/api/overview-summary.html)

Java-Postgres non springboot: https://www.tutorialspoint.com/postgresql/postgresql_java.htm

JPA:
Example: https://spring.io/blog/2011/02/10/getting-started-with-spring-data-jpa/

JPA Repository - working with repositories (*** MUST READ ***): 
	https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
	https://docs.spring.io/spring-data/data-commons/docs/2.3.3.RELEASE/reference/html/#mapping.fundamentals
	
JPA Repository related: https://www.baeldung.com/spring-data-repositories

Disable Hikari that comes with JPA: 
--> Hikari seems to be default pooler in JPA/JDBC
- https://stackoverflow.com/questions/55161884/spring-boot-2-1-app-without-hikaricp-connection-pooler
	- Use custom pooler: https://stackoverflow.com/questions/53845645/creating-custom-connection-pool-in-spring-boot-application
- https://stackoverflow.com/questions/50173081/how-to-replace-default-hikari-cp-to-tomcat-pool-on-spring-boot-2-0
- How to exclude stuff in Gradle: https://discuss.gradle.org/t/excluding-dependency-from-a-single-configuration/26941

---------------------
OTHER REFERENCES
---------------------
Spring Data: https://spring.io/projects/spring-data

For HikariCP connection pooler:
https://www.baeldung.com/hikaricp
https://mkyong.com/spring-boot/spring-boot-spring-data-jpa-postgresql/ --> with Hikari
https://www.baeldung.com/spring-boot-hikari

For Lombok getter and setter:
https://springframework.guru/using-project-lombok-with-gradle/

==============================
NOTES
==============================
Gradle dependency spring-boot-starter-data-jpa also brings Hibernate because it is based on Hibernate

Use "javax.persistence.Entity" in 'models' - and not the hibernate.annotations.Entity which seems to have been deprecated

https://zetcode.com/springboot/postgresql/ 
- The spring-boot-starter-thymeleaf is a starter for building MVC web applications using Thymeleaf views. 
- The spring-boot-starter-data-jpa is a starter for using Spring Data JPA with Hibernate.
- The postgresql dependency is for the PostgreSQL database driver.
- (if using Maven) - The spring-boot-maven-plugin provides Spring Boot support in Maven, allowing us to package executable JAR or WAR archives. Its spring-boot:run goal runs the Spring Boot application.

https://developer.okta.com/blog/2018/12/13/build-basic-app-spring-boot-jpa
- JPA is the Java Persistence API, a specification for managing relational databases using Java. 
  It describes an abstraction layer between Java classes and a relational database.
- Spring Data JPA is a wrapper around JPA providers such as Hibernate (for more info: https://spring.io/projects/spring-data-jpa)

==============================
SETUP
==============================
------------
build.gradle
------------

Add Postgres drivers in compile section
Add spring-boot-starter-data-jpa for JPA/Hibernate

--------------------------------
application.properties
--------------------------------
To enable JPA entities save tables and such with 'uppercase' names

src/main/resources/application.properties:
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

Add Postgres stuff per https://zetcode.com/springboot/postgresql/


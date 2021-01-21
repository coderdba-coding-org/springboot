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
https://developer.okta.com/blog/2018/12/13/build-basic-app-spring-boot-jpa (describes JPA, Hibernate etc)
- also see https://vladmihalcea.com/9-postgresql-high-performance-performance-tips/
https://zetcode.com/springboot/postgresql/ (with Thymeleaf for html, spring-boot-starter-data-jpa, Hibernate etc)
https://dzone.com/articles/spring-boot-and-postgresql

---------------------
OTHER REFERENCES
---------------------
JPA - Java Persistence API: https://www.infoworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html
- ORM - Object Relational Mapping - to use with RDBMS
- Hibernate - for RDBMS - http://hibernate.org/orm/
- EclipseLink - for NOSQL - https://www.eclipse.org/eclipselink/

Java-Postgres non springboot: https://www.tutorialspoint.com/postgresql/postgresql_java.htm

Spring Data: https://spring.io/projects/spring-data

For HikariCP connection pooler:
https://www.baeldung.com/hikaricp
https://mkyong.com/spring-boot/spring-boot-spring-data-jpa-postgresql/ --> with Hikari

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
build.gradle:

Add Postgres drivers in compile section
Add spring-boot-starter-data-jpa for JPA/Hibernate



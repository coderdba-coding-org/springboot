https://spring.io/guides/gs/accessing-data-jpa/

Oracle, JPARepository, year 2021: https://bezkoder.com/spring-boot-hibernate-oracle/
Oracle, JPARepository, Oracle version 12: https://www.javaguides.net/2020/01/spring-boot-hibernate-oracle-crud-example.html 

Oracle: https://dzone.com/articles/spring-boot-jpa-hibernate-oracle
https://mkyong.com/spring-boot/spring-boot-spring-data-jpa-oracle-example/
https://thorben-janssen.com/how-to-activate-hibernate-statistics-to-analyze-performance-issues/#Demo_application


GENERATE JPA STATISTICS:
https://docs.spring.io/spring-boot/docs/2.1.9.RELEASE/reference/html/production-ready-metrics.html

Main docs:
	https://www.baeldung.com/sql-logging-spring-boot
	https://thorben-janssen.com/how-to-activate-hibernate-statistics-to-analyze-performance-issues/#Demo_application
	https://thorben-janssen.com/hibernate-logging-guide/ --> Use this also
	https://www.overops.com/blog/hibernate-logging-tips-and-solutions-to-common-problems/ (CAUTION ON overhead)
	https://thorben-janssen.com/tips-to-boost-your-hibernate-performance/

https://stackoverflow.com/questions/30118683/how-to-log-sql-statements-in-spring-boot --> more hibernate settings


CONNECTION POOLING WITH HIBERNATE:
http://www.mastertheboss.com/jboss-frameworks/hibernate-jpa/hibernate-configuration/configure-a-connection-pool-with-hibernate

LOGGING WITH SLF4J, LOG4J etc
https://www.baeldung.com/hibernate-logging-levels
https://mkyong.com/spring-boot/spring-boot-slf4j-logging-example/
https://thorben-janssen.com/hibernate-logging-guide/ --> Use this also
https://devcases.com/java/how-to-display-real-hibernate-sql-query-using-slf4j/
https://dzone.com/articles/logging-with-slf4j
https://www.tutorialspoint.com/slf4j/slf4j_overview.htm
https://stackoverflow.com/questions/30118683/how-to-log-sql-statements-in-spring-boot

ISSUES:
- findAll returning null: https://stackoverflow.com/questions/56371084/jparepository-findall-returns-empty-list

======================
CONFIGURATION
======================
Oracle connections details are to be mentioned in src/main/resources/application.properties

======================
CREATE USER AND TABLE
======================
$ sqlplus / as sysdba

- CREATE USER/SCHEMA

alter session set container = XEPDB1;

create user orders identified by orders;  
grant resource to orders;
grant create session to orders;

- CREATE TABLES
alter session set container = XEPDB1;

create table orders
(
ORDER_KEY VARCHAR2(20) NOT NULL,
ORDER_NUMBER VARCHAR2(20) NOT NULL,
ORDER_TYPE VARCHAR2(10) NOT NULL,
TOTAL_PRICE NUMBER(10,2) NOT NULL
);

============================
LOOP TO CREATE MANY RECORDS
============================
https://thorben-janssen.com/how-to-activate-hibernate-statistics-to-analyze-performance-issues/#Demo_application
for (int i=0; i<10; i++) {
   Product p = new Product();
   p.setName("MyProduct"+i);
   this.em.persist(p);
}

==============================================
REQUEST BODY TO CREATE A NEW TABLE ROW
==============================================
    {
        "orderKey": "1007",
        "orderNumber": "1007A",
        "orderType": "Sale",
        "totalPrice": 776.03
    }
=============================================
ISSUES TO BE RESOLVED
=============================================
------------------------------------------------
Getters and Setters in OrderEntity
------------------------------------------------
- findAll returning null: https://stackoverflow.com/questions/56371084/jparepository-findall-returns-empty-list

If class variables are private, then Getter an Setter annotations are not exposing the values to public (like Hibernate).
Therefore, Hibernate is unable to create an OrderEntity as it cannot access those variables.
works - Making them 'public' worked.
fails - Keeping them private, but creating a public "get" method for the variable worked.
works - Keeping them private, and, @Getter(AccessLevel.PUBLIC) and @Setter(AccessLevel.PUBLIC) did not work.

https://spring.io/guides/gs/accessing-data-jpa/

Oracle, JPARepository, year 2021: https://bezkoder.com/spring-boot-hibernate-oracle/
Oracle, JPARepository, Oracle version 12: https://www.javaguides.net/2020/01/spring-boot-hibernate-oracle-crud-example.html 

Oracle: https://dzone.com/articles/spring-boot-jpa-hibernate-oracle
https://mkyong.com/spring-boot/spring-boot-spring-data-jpa-oracle-example/
https://thorben-janssen.com/how-to-activate-hibernate-statistics-to-analyze-performance-issues/#Demo_application

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

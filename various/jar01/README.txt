=========================
JAR FILE FOR SPRING APPS
=========================

https://www.baeldung.com/spring-boot-gradle-plugin
https://www.baeldung.com/spring-boot-main-class

To deploy war to Tomcat:
https://www.baeldung.com/spring-boot-war-tomcat-deploy
https://www.codebyamir.com/blog/how-to-deploy-spring-boot-war-to-tomcat

----------------
build.gradle
----------------

For JAR creation add these:

// FOR JAR CREATION
bootJar {
    mainClassName = 'com.gm.jar.Application'
}

// ALTERNATIVE TO bootJar
springBoot {
    mainClassName = 'com.gm.jar.Application'
}

// to directly run the app - does not create a jar
bootRun {
    main = 'com.gm.jar.Application'
}


For WAR creation add these:
apply plugin: 'war'

// FOR WAR CREATION
bootWar {
    mainClassName = 'com.gm.jar.Application'
}


-------------------
CREATE JAR
-------------------
NOTE: Just running gradlew build - even without adding buildJar & springBoot has worked and produced good jar

- Create the jar file
gradlew clean (optional)
gradlew buildJar

Creates build/libs/jar01.jar

- Run the jar file
java -jar build/libs/jar01.jar --> this is the jar file produced - same name as the project name

- Find application class file in jar 
jar tvf *jar |grep Application
  1336 Tue Jan 05 20:31:32 IST 2021 BOOT-INF/classes/com/gm/jar/Application2.class
  1333 Tue Jan 05 20:31:32 IST 2021 BOOT-INF/classes/com/gm/jar/Application.class

- Find the application class in manifest
File: build/tmp/bootJar/MANIFEST.MF
Line: Start-Class: com.gm.jar.Application (or Start-Class: com.gm.jar.Application2 --> according to the mainClassName specified)

-------------------
CREATE WAR
-------------------

- Create the war file
gradlew clean (optional)
gradlew buildWar

Creates build/libs/jar01.war

- Run the war file
We cannot run the war file like a jar file
Place it in Tomcat or other web server - see other docs for that

- Find application class file in war (in build/libs)
jar tvf *war |grep Application
  1336 Tue Jan 05 20:33:48 IST 2021 WEB-INF/classes/com/gm/jar/Application2.class
  1333 Tue Jan 05 20:33:48 IST 2021 WEB-INF/classes/com/gm/jar/Application.class
  
- Find the application class in manifest
File: build/tmp/bootWar/MANIFEST.MF
Line: Start-Class: com.gm.jar.Application (or Start-Class: com.gm.jar.Application2 --> according to the mainClassName specified)




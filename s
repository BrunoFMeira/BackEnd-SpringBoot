[33mcommit 1a1468d2b5ac6bead76dd7a9f4cc1dc5d2fb6490[m[33m ([m[1;36mHEAD -> [m[1;32mmaster[m[33m)[m
Author: BrunoMeira <brunof.meira009@gmail.com>
Date:   Sun Aug 21 15:14:52 2022 -0300

    Deploy da aplicação

[1mdiff --git a/pom.xml b/pom.xml[m
[1mindex 70ec2f7..4702e3c 100644[m
[1m--- a/pom.xml[m
[1m+++ b/pom.xml[m
[36m@@ -26,7 +26,13 @@[m
             <groupId>org.springframework.boot</groupId>[m
             <artifactId>spring-boot-starter-validation</artifactId>[m
         </dependency>[m
[31m-[m
[32m+[m[41m        [m
[32m+[m[32m        <dependency>[m
[32m+[m			[32m<groupId>org.postgresql</groupId>[m
[32m+[m			[32m<artifactId>postgresql</artifactId>[m
[32m+[m			[32m<scope>runtime</scope>[m
[32m+[m		[32m</dependency>[m
[32m+[m[41m        [m
         <dependency>[m
             <groupId>org.springframework.boot</groupId>[m
             <artifactId>spring-boot-starter-data-jpa</artifactId>[m
[1mdiff --git a/src/main/resources/application.yml b/src/main/resources/application.yml[m
[1mindex 9e4df9e..051ec14 100644[m
[1m--- a/src/main/resources/application.yml[m
[1m+++ b/src/main/resources/application.yml[m
[36m@@ -4,10 +4,8 @@[m [mserver:[m
 [m
 spring:[m
   datasource:[m
[31m-    #url: jdbc:mysql://localhost:3306/filme?createDatabaseIfNotExist=true[m
     url: ${JDBC_DATASOURCE_URL}[m
[31m-    username: root[m
[31m-    password: root[m
[32m+[m[41m    [m
   jpa:[m
     hibernate:[m
       ddl-auto: update[m
\ No newline at end of file[m

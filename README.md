Spring Boot Template
====================

[![Build Status](https://travis-ci.org/junlapong/spring-boot-template.svg?branch=master)](https://travis-ci.org/junlapong/spring-boot-template)

## Reference
http://docs.spring.io/spring-boot/docs/current/reference/html/

## HTTPS
https://localhost:8443/

### create keystore
```
keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650

keytool -list -v -keystore keystore.p12 -storetype pkcs12
```

### create keystore (SAN)
```
# Java 1.7+
keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore-san.p12 -validity 3650 -dname "CN=localhost, OU=IT, O=COMPANY, L=CITY, ST=BKK, C=TH" -ext SAN=dns:domain.name,ip:127.0.01

keytool -list -v -keystore keystore-san.p12 -storetype pkcs12
```
### Notes
 - How to override version spring-boot dependencies
```
check version: /path/to/maven/repo/org/springframework/boot/spring-boot-dependencies/xxx.pom
mvn dependency:tree -Dincludes=com.fasterxml.jackson.core
```

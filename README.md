Spring Boot Template
====================

[![Build Status](https://travis-ci.org/junlapong/spring-boot-template.svg?branch=master)](https://travis-ci.org/junlapong/spring-boot-template)

## Reference
- [Spring Boot Reference](http://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Mobile Device Module](http://docs.spring.io/spring-mobile/docs/current/reference/html/device.html)

## Test
 - HTTP http://localhost:8080/app
 - HTTPS https://localhost:8443/

### create keystore
```
keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650

keytool -list -v -keystore keystore.p12 -storetype pkcs12
```

### create keystore (SAN)
```
# Java 1.7+
keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore-san.p12 -validity 3650 -dname "CN=localhost, OU=IT, O=COMPANY, L=CITY, ST=BKK, C=TH" -ext "SAN=dns:domain.name,ip:127.0.0.1,ip:192.168.1.14,ip:172.19.26.128"

keytool -list -v -keystore keystore-san.p12 -storetype pkcs12
```
### Notes
 - How to override version spring-boot dependencies
```
check version: /path/to/maven/repo/org/springframework/boot/spring-boot-dependencies/xxx.pom
mvn dependency:tree -Dincludes=com.fasterxml.jackson.core
```

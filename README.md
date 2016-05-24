# Spring Boot Template

## Reference
http://docs.spring.io/spring-boot/docs/current/reference/html/

## HTTPS
https://localhost:8443/

### create keystore
```
keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650
keytool -list -v -keystore keystore.p12 -storetype pkcs12
```

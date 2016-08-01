# Gradle Notes

## PROXY
```
gradlew -Dhttp.proxyHost=127.0.0.1 -Dhttp.proxyPort=8080 -Dhttps.proxyHost=127.0.0.1 -Dhttps.proxyPort=8080
```

## gradle ##
installing Gradle on Ubuntu
```
$ sudo add-apt-repository ppa:cwchien/gradle
$ sudo apt-get update
$ sudo apt-get install gradle
```
to remove gradle, do
```
$ sudo apt-get remove gradle
```
check gradle version
```
$ gradle -v
```
### convert maven to gradle ###
```
$ gradle init --type pom
$ gradle build
```

### gradle demon ###
```
$ touch ~/.gradle/gradle.properties
$ echo "org.gradle.daemon=true" >> ~/.gradle/gradle.properties
```

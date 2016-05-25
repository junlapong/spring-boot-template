
[USER HOME]
C:\Users\username\.m2

[CONFIG]
MAVEN_HOME=X:\path\to\maven
set PATH=%MAVEN_HOME%\bin;%PATH%

[EXAMPLE]
> cd \path\to\project
> mvn archetype:create -DgroupId=io.github.junlapong.myapp -DartifactId=myapp
#> mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
> cd myapp
> mvn package

exclude test class
> mvn package -Dmaven.test.skip=true

run
> java -cp target\myapp-1.0-SNAPSHOT.jar io.github.junlapong.myapp.App
---------------------------------------------

[Maven Phase]
	* validate : validate the project is correct and all necessary information is available
	* compile  : compile the source code of the project
	* test     : test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
	* package  : take the compiled code and package it in its distributable format, such as a JAR.
	* integration-test : process and deploy the package if necessary into an environment where integration tests can be run
	* verify   : run any checks to verify the package is valid and meets quality criteria
	* install  : install the package into the local repository, for use as a dependency in other projects locally
	* deploy   : done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects.

There are two other Maven lifecycles of note beyond the default list above. They are

	* clean : cleans up artifacts created by prior builds
	* site  : generates site documentation for this project

[Misc]

To clean the local cache try using the dependency plug-in
mvn dependency:purge-local-repository

or
mvn dependency:purge-local-repository -DreResolve=false

or
mvn dependency:purge-local-repository -DactTransitively=false -DreResolve=false

mvn dependency:tree

mvn versions:display-dependency-updates

set MAVEN_OPTS=-Xmx512m -XX:MaxPermSize=256m
mvn tomcat7:run

[maven-tomcat]
mvn tomcat7:deploy
mvn tomcat7:redeploy
mvn tomcat7:undeploy

[maven eclipse]
mvn eclipse:eclipse

# Modals Sample App
Sample web application with Angular and Java Spring

### Setup
Change Database confgurations in application.properties

### Run

##### Run development database

cd to modals2/

java -cp build/libs/hsqldb-2.6.0-jdk11.jar org.hsqldb.Server -silent false -database.0 mem:[yourdb] -dbname.0 [yourdb]


##### Run web application with http-server

cd to /modals2/src/main/webapp/

http-server ./dist/modalsapp -p [port nr]

  
##### Run Tomcat server with gradlew
  
cd to modals2/
  
./gradlew bootRun


### About
modals2 folder contains back end source that uses Java Spring technologies

Front end distribution build is located in modals2/src/main/webapp

Front end source root is modalsapp folder, node_modules folder was omitted, one could get that with Angular CLI (ng new project), some bootstrap extensions should also be installed (with npm)

Simple HSQL server app is included in modals2/build/libs


### Issues
To use HSQL one has to rename HsqlDatasource.txt to HsqlDatasource.java and PostgresDatasource.java to PostgresDatasource.txt in modals2/src/main/java/com/example/modals2/config and schema.sql to something else and hsqlschema.sql to schema.sql in modals2/src/main/resources

Sorry for that inconvenience

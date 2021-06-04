# Modals Sample App
Sample web application with Angular and Java Spring

### Setup
Change Database confgurations in application.properties

### Run

Run development database
cd to modals2/
java -cp build/libs/hsqldb-2.6.0-jdk11.jar org.hsqldb.Server -silent false -database.0 mem:[yourdb] -dbname.0 [yourdb]

Run web application with http-server
cd to /modals2/src/main/webapp/
http-server ./dist/modalsapp -p <port nr>

Run Tomcat server with gradlew
cd to modals2/
./gradlew bootRun



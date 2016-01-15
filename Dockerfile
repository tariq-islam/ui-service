FROM java:latest
COPY target /usr/src/ui
WORKDIR /usr/src/ui
CMD java -jar AngularBoot-0.0.1-SNAPSHOT.jar

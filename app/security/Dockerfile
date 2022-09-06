FROM openjdk
WORKDIR usr/lib
ADD  ./target/security-0.0.1-SNAPSHOT.jar /usr/lib/security-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","security-0.0.1-SNAPSHOT.jar"]
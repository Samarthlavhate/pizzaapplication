FROM openjdk
WORKDIR usr/lib
EXPOSE 9000
ADD ./target/cloud-0.0.1-SNAPSHOT.jar /usr/lib/cloud-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","cloud-0.0.1-SNAPSHOT.jar"]

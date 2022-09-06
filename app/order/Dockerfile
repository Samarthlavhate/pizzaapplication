FROM openjdk
WORKDIR usr/lib

ADD ./target/order-0.0.1-SNAPSHOT.jar /usr/lib/order-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","order-0.0.1-SNAPSHOT.jar"]
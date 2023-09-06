FROM khipu/openjdk17-alpine:latest
WORKDIR /opt/app
ADD target/SpringJDBC-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
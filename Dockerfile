# Base image
FROM --platform=linux/amd64 ubuntu:20.04

# Update package lists
RUN apt-get update

# Install Java
RUN apt-get install -y openjdk-17-jdk

# Copy the Spring Boot application jar file to the container
COPY ./build/libs/kafka-spring-boot-0.0.1-SNAPSHOT.jar /app.jar

# Set the entrypoint to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app.jar"]

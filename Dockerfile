# Stage 1: Build
FROM maven:3.8.6-openjdk-21 AS build

# Set the working directory
WORKDIR /realTime

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Run Maven to clean and package the application
RUN mvn clean package

# Stage 2: Runtime
FROM openjdk:21-jdk

# Expose the application port
EXPOSE 8080

# Copy the built JAR file from the build stage
COPY --from=build /realTime/target/realTime-0.0.1-SNAPSHOT.jar realTime-0.0.1-SNAPSHOT.jar

# Set the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "realTime-0.0.1-SNAPSHOT.jar"]

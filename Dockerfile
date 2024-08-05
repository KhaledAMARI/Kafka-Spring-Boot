# Use Ubuntu as the base image for the build stage
FROM ubuntu:latest AS build

# Set the author label
LABEL authors="khaled"

# Update package lists and install OpenJDK and Maven
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk maven

# Set the working directory
WORKDIR /app

# Copy the entire project to the working directory
COPY . .

# Run Maven to clean and package the application
RUN mvn clean package

# Use the OpenJDK base image for the runtime stage
FROM openjdk:21-jdk

# Expose the application port
EXPOSE 8080

# Copy the built JAR file from the build stage
COPY --from=build /app/target/realTime.jar app.jar

# Set the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

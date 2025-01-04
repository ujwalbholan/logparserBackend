# Stage 1: Build
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the project files to the container
COPY . .

# Build the project and skip tests
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:17.0.1-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/LogParser-0.0.1-SNAPSHOT.jar LogParser.jar

# Expose the application port
EXPOSE 8080

# Define the entrypoint
ENTRYPOINT ["java", "-jar", "LogParser.jar"]

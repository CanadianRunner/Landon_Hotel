# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file to the container
COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar /app/myApp.jar

# Expose the ports for the backend (8080) and frontend (4200)
EXPOSE 8080 4200

# Run the application
CMD ["java", "-jar", "/app/myApp.jar"]
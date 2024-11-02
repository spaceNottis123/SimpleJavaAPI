# Start with a base image with Java
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the built jar file to the container
COPY target/bookcatalog-0.0.1-SNAPSHOT.jar /app/book-api.jar

# Expose the folder where logs will be stored
VOLUME /app/logs

# Expose the API port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-Dlogging.file.path=/app/logs", "-jar", "/app/book-api.jar"]

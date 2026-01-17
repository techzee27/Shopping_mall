# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the mvnw wrapper and pom.xml file
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Give execution rights to the mvnw script
RUN chmod +x mvnw

# Download dependencies (this step isolates dependencies to improve build caching)
# We run a dependency:go-offline to download everything
RUN ./mvnw dependency:go-offline -B

# Copy the project source
COPY src src

# Package the application
RUN ./mvnw package -DskipTests

# Run the jar file
# The jar is located in target/ after the build
ENTRYPOINT ["java","-jar","target/mall-0.0.1-SNAPSHOT.jar"]

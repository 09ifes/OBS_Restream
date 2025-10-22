# Use a lightweight JDK base image
FROM eclipse-temurin:17-jre

WORKDIR /opt/tests

# Copy the fat JAR and Serenity config
COPY target/restream-tests.jar .
COPY src/test/resources/serenity.conf ./serenity.conf

# Optional: copy drivers if needed
COPY src/test/resources/drivers ./drivers

# Set environment variables if needed
ENV EMAIL=your@email.com
ENV PASSWORD=yourpassword

# Run the test suite
ENTRYPOINT ["java", "-jar", "restream-tests.jar"]
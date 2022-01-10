#################
# Build the app #
#################
FROM maven:3.8.4-openjdk-17-slim AS build
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package -DskipTests

################
# Run app      #
################
FROM openjdk:17-alpine
EXPOSE 9999
COPY --from=build /app/target/*.jar /usr/local/lib/app.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]

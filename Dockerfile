FROM eclipse-temurin:21-jdk

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 mvn dependency:go-offline

COPY . .
RUN mvn clean package -DskipTests

CMD ["java", "-jar", "target/smart-home-app-0.0.1-SNAPSHOT.jar"]

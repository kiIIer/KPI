FROM maven:3.8.5-openjdk-18 as build
WORKDIR /app
COPY . .
RUN mvn package -Dmaven.test.skip=true

FROM openjdk:18
COPY --from=build app/target/news-service-0.0.1-SNAPSHOT.jar /
CMD java -jar /news-service-0.0.1-SNAPSHOT.jar
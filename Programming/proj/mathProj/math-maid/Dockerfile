FROM maven:3.8.4-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn package -Dmaven.test.skip=true

FROM openjdk:17
COPY --from=build app/target/math-maid-0.0.1-SNAPSHOT.jar /
CMD java -jar /math-maid-0.0.1-SNAPSHOT.jar
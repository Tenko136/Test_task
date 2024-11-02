FROM openjdk:17
COPY ./target /app
ENTRYPOINT ["java","-jar","/app/solva-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080

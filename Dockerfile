FROM openjdk:17
COPY . /app
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080


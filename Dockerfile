FROM amazoncorretto:17 AS build
COPY ./ /home/app
RUN cd /home/app && ./gradlew build

FROM amazoncorretto:17-alpine
COPY --from=build /home/app/build/libs/kotlin-spring-crud-web-api-0.0.1-SNAPSHOT.jar /usr/local/lib/kotlin-spring-crud-web-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","-Dfile.encoding=UTF-8","/usr/local/lib/kotlin-spring-crud-web-api.jar"]

FROM adoptopenjdk/openjdk11
EXPOSE 8080
ADD /target/cursospring-0.0.1-SNAPSHOT.jar cursospring.jar
ENTRYPOINT ["java", "-jar", "cursospring.jar"]
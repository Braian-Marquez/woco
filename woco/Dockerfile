FROM azul/zulu-openjdk:17
MAINTAINER woco.com.ar
ARG JAR_FILE=target/woco-1.0.0.jar
COPY ${JAR_FILE} /app/app.jar
ENTRYPOINT ["java","-jar","/woco-app.jar"]
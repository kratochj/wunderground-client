FROM maven:3-jdk-8 AS MAVEN_BUILD
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package -DskipTests=true

FROM openjdk:8-jdk-alpine AS RUNTIME

ENV ELASTICSEARCH_HOST=localhost
ENV ELASTICSEARCH_PORT=9200
ENV ELASTICSEARCH_SCHEME=http

COPY --from=MAVEN_BUILD /tmp/target/dependency/BOOT-INF/lib /app/lib
COPY --from=MAVEN_BUILD /tmp/target/dependency/META-INF /app/META-INF
COPY --from=MAVEN_BUILD /tmp/target/dependency/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","eu.kratochvil.pwssync.Application", "--logging.level.eu.kratochvil=DEBUG"]
FROM openjdk:11
RUN groupadd kadmos -g 1000
RUN useradd -rm -d /application -s /bin/bash -u 1000 -g kadmos javauser
USER javauser
ARG DEPENDENCY=target/*.jar
COPY --chown=javauser:kadmos target/*.jar application/app.jar

ENTRYPOINT ["java","-jar","/application/app.jar"]
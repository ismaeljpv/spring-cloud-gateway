FROM openjdk:8-jre
COPY target/app.jar /
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-XX:+PrintFlagsFinal", "-jar", "/app.jar"]

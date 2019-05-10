FROM openjdk:8u212-jdk-alpine3.9

COPY MemoryEater.java /

RUN javac MemoryEater.java

CMD ["java", "-XX:+UseContainerSupport", "-XX:InitialRAMPercentage=40.0", "-XX:MinRAMPercentage=20.0", "-XX:MaxRAMPercentage=80.0", "MemoryEater"]

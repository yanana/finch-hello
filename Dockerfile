FROM anapsix/alpine-java:8

COPY hello.jar /var/lib/hello/hello.jar

CMD ["java", "jar", "/var/lib/hello/hello.jar"]

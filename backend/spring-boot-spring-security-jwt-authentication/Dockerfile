### STAGE 1: Build ###
FROM openjdk:8
ADD target/upload-image.jar upload-image.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","upload-image.jar"]
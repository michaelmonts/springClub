# Usa una imagen de Java como base
FROM openjdk:11-jre-slim

# Define el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el jar construido de tu proyecto en el contenedor
COPY target/ClubJhon-0.0.1-SNAPSHOT.jar /app/ClubJhon.jar

# Expon el puerto 8021, que es el que has configurado en tu aplicación Spring Boot
EXPOSE 8021

# Comando para ejecutar tu aplicación Spring Boot cuando se inicie el contenedor
CMD ["java", "-jar", "ClubJhon.jar"]

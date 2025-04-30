FROM eclipse-temurin:17-jdk-alpine

# Crear un directorio dentro del contenedor
WORKDIR /app

# Copiar el jar generado por Maven
COPY target/copsboot-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java","-jar","app.jar"]

# Usar uma imagem base do JDK para compilar o projeto
FROM maven:3.8.4-openjdk-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Usar uma imagem base mais leve para executar a aplicação
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/monitoramento_ambiental-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

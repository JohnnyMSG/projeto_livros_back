# Imagem base com Java 17 leve
FROM eclipse-temurin:17-jdk-alpine

# Diretório de trabalho no container
WORKDIR /app

# Copia o jar para dentro do container
COPY target/meu-projeto-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta que seu app usa
EXPOSE 8090

# Comando para rodar o jar
ENTRYPOINT ["java", "-jar", "app.jar"]

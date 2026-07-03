# Etapa 1: Build da aplicação com Maven e JDK 25
FROM maven:3.9-eclipse-temurin-25 AS build

# Criando um diretório de trabalho para a aplicação
WORKDIR /app

# Copiar os arquivos do projeto para o diretório de trabalho
COPY pom.xml .
COPY src ./src

# Gerando o arquivo JAR da aplicação sem executar os testes
RUN mvn clean package -DskipTests

# Etapa 2: Criando a imagem final com JRE 25
FROM eclipse-temurin:25-jre

# Criando um diretório de trabalho para a aplicação
WORKDIR /app

# Copiar o arquivo JAR gerado na etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expondo a porta da aplicação
EXPOSE 8081

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
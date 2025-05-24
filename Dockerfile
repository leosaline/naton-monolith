# Primeira fase: Build
FROM maven:3.8.4-openjdk-21-slim AS build

# Diretório de trabalho
WORKDIR /app

# Copiar o arquivo pom.xml para resolver dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar o código fonte
COPY src ./src

# Compilar o JAR executável
RUN mvn clean package -DskipTests

# Segunda fase: Execução
FROM openjdk:21-jdk-slim AS runtime

# Diretório de trabalho
WORKDIR /app

# Copiar o JAR compilado da fase de build
COPY --from=build /app/target/*.jar app.jar

# Definir variáveis de ambiente
ENV JAVA_OPTS="-Xms256m -Xmx512m"

# Expor a porta que o Spring Boot vai rodar
EXPOSE 9000

# Comando para rodar o Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]

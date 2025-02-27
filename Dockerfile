# Use uma base com OpenJDK 21
FROM eclipse-temurin:21-jdk-jammy

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo build.gradle e settings.gradle
COPY build.gradle settings.gradle ./

# Baixe as dependências do Gradle (sem build)
RUN chmod +x gradlew && ./gradlew dependencies --no-daemon

# Copie todo o código do projeto
COPY . .

# Build o projeto com Gradle, pulando testes para acelerar
RUN ./gradlew clean build -x check -x test

# Exponha a porta 8081 (configurada no application.properties)
EXPOSE 8081

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "build/libs/CatalogoFilmesNacionais-0.0.1-SNAPSHOT.jar"]
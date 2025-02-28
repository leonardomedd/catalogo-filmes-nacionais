# Catálogo de Filmes Nacionais Brasileiros

Bem-vindo ao **Catálogo de Filmes Nacionais Brasileiros**, uma API REST desenvolvida com Spring Boot para gerenciar um catálogo de filmes nacionais brasileiros. Este projeto permite criar, listar, editar e remover filmes, com suporte para documentação via Swagger/OpenAPI e integração com um banco de dados PostgreSQL.

## 🌟 Sobre o Projeto

Este projeto foi criado como parte do **Programa Decola Tech 2025** e tem como objetivo fornecer uma API simples e eficiente para gerenciar informações de filmes brasileiros, como título, diretor, ano de lançamento e gênero. A API é projetada para ser fácil de usar, escalável, e está hospedada na plataforma Railway para acesso público.

### 🎯 Objetivos
- Criar uma API REST para gerenciar filmes nacionais brasileiros.
- Oferecer documentação interativa com Swagger para facilitar o uso.
- Garantir compatibilidade com PostgreSQL para persistência de dados.
- Facilitar o deploy em ambientes de produção, como o Railway.

## 🛠 Tecnologias Utilizadas

O projeto utiliza as seguintes tecnologias:

- **Java 21** (Eclipse Temurin) – Linguagem principal.
- **Spring Boot 3.4.3** – Framework para desenvolvimento da API REST.
- **Spring Data JPA** – Para integração com o banco de dados.
- **PostgreSQL** – Banco de dados relacional para armazenar os dados dos filmes.
- **Gradle 8.12.1** – Ferramenta de build e gerenciamento de dependências.
- **Docker** – Para containerização e deploy no Railway.
- **Springdoc OpenAPI (Swagger)** – Para documentação interativa da API.
- **Railway** – Plataforma de hospedagem na nuvem para deploy da aplicação.

## 📋 Estrutura do Projeto

A estrutura básica do projeto no Eclipse é:

```
CatalogoFilmesNacionais/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br.com.leonardomedd/
│   │   │       ├── CatalogoFilmesNacionaisApplication.java
│   │   │       ├── model/
│   │   │       │   └── Filme.java
│   │   │       ├── repository/
│   │   │       │   └── FilmeRepository.java
│   │   │       └── controller/
│   │   │           └── FilmeController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── br.com.leonardomedd/
├── build.gradle
├── settings.gradle
├── Dockerfile
├── gradlew
├── gradlew.bat
└── gradle/
    └── wrapper/
        ├── gradle-wrapper.jar
        └── gradle-wrapper.properties
```

## 🚀 Como Configurar e Rodar Localmente

Siga estes passos para configurar e rodar o projeto localmente no Eclipse ou terminal:

### **Pré-requisitos**
- **Java 21 (Eclipse Temurin)** – Instale via [adoptopenjdk.net](https://adoptopenjdk.net/) ou [eclipse.org/temurin](https://adoptopenjdk.net/).
- **Gradle 8.12.1** – Instale via [gradle.org](https://gradle.org/install/) ou use o Gradle Wrapper (`gradlew`/`gradlew.bat`).
- **PostgreSQL** – Instale localmente ou use um contêiner Docker com:
  ```
  docker run -d -p 5432:5432 -e POSTGRES_DB=catalogo_filmes -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=admin422 postgres
  ```
- **Eclipse IDE** – Recomendado para desenvolvimento Java/Spring Boot.

### **Passos**
1. **Clone o repositório:**
   - No terminal, navegue até o diretório desejado e execute:
     ```
     git clone https://github.com/leonardomeddi/catalogo-filmes-nacionais.git
     cd CatalogoFilmesNacionais
     ```

2. **Configure o `application.properties`:**
   - No `src/main/resources/application.properties`, ajuste as configurações locais para o PostgreSQL:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/catalogo_filmes
     spring.datasource.username=postgres
     spring.datasource.password=admin422
     spring.datasource.driver-class-name=org.postgresql.Driver
     spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
     spring.jpa.hibernate.ddl-auto=update
     server.port=8081
     ```

3. **Instale dependências e build o projeto:**
   - No terminal, execute:
     ```
     gradlew clean build -x check -x test
     ```
   - No Windows, use:
     ```
     gradlew.bat clean build -x check -x test
     ```
   - Isso gera o JAR em `build/libs/CatalogoFilmesNacionais-0.0.1-SNAPSHOT.jar`.

4. **Rode a aplicação no Eclipse:**
   - No Eclipse, abra `CatalogoFilmesNacionaisApplication.java` e clique com o botão direito > `Run As > Java Application`.
   - Ou, no terminal, execute:
     ```
     java -jar build/libs/CatalogoFilmesNacionais-0.0.1-SNAPSHOT.jar
     ```

5. **Teste localmente:**
   - Use o Postman ou um navegador para testar os endpoints em `http://localhost:8081/filmes` (ex.: POST, GET, PUT, DELETE).
   - Acesse a documentação Swagger em `http://localhost:8081/swagger-ui/index.html`.

## ☁️ Deploy no Railway

O projeto está hospedado no **Railway** para acesso público. Siga estas etapas para deployar ou manter o projeto:

### **Pré-requisitos**
- Conta no [Railway.app](https://railway.app).
- Repositório GitHub vinculado (`leonardomeddi/catalogo-filmes-nacionais`).

### **Passos para Deploy**
1. **Crie um projeto no Railway:**
   - Acesse o dashboard do Railway e crie um novo projeto ou use o existente (`capable-stillness`).

2. **Vincule o repositório GitHub:**
   - No Railway, vá para "Deployments" e conecte seu repositório GitHub `catalogo-filmes-nacionais`.

3. **Configure as variáveis de ambiente:**
   - No "Variables" do serviço, adicione:
     ```
     SPRING_DATASOURCE_URL=jdbc:postgresql://postgres.railway.internal:5432/railway
     SPRING_DATASOURCE_USERNAME=postgres
     SPRING_DATASOURCE_PASSWORD=yUkRnPhVCTYfQXeUTmvCRWDQHxthYqoA
     SPRING_DATASOURCE_DRIVER-CLASS-NAME=org.postgresql.Driver
     SPRING_JPA_DATABASE-PLATFORM=org.hibernate.dialect.PostgreSQLDialect
     SPRING_JPA_HIBERNATE_DDL-AUTO=update
     ```
   - Confirme o host (`postgres.railway.internal`) e as credenciais no serviço PostgreSQL em "Resources" > "Databases".

4. **Configure o Dockerfile:**
   - Certifique-se de que o `Dockerfile` está na raiz do projeto (como fornecido).
   - No Railway, em "Settings" > "Build & Deploy", selecione "Dockerfile" e defina o caminho como `./Dockerfile`.

5. **Faça o deploy:**
   - Clique em "Deploy" ou aguarde o Railway detectar mudanças no GitHub.
   - Acompanhe os logs em "Deploy Logs" para confirmar o sucesso.

6. **Teste online:**
   - Acesse a API em `https://catalogo-filmes-nacionais-production.up.railway.app/filmes`.
   - Use o Postman ou Swagger em `https://catalogo-filmes-nacionais-production.up.railway.app/swagger-ui/index.html`.

## 📝 Como Contribuir

Se você deseja contribuir para este projeto:

1. **Fork o repositório** no GitHub.
2. **Crie uma branch** para sua feature ou correção:
   ```
   git checkout -b feature/nova-funcionalidade
   ```
3. **Faça commits com mensagens claras:**
   ```
   git commit -m "Adiciona funcionalidade X"
   ```
4. **Envie para o repositório remoto:**
   ```
   git push origin feature/nova-funcionalidade
   ```
5. **Abra um Pull Request** no GitHub para revisão.

## 🚨 Licença

Este projeto está licenciado sob a [MIT License](LICENSE) – veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 🙌 Agradecimentos

- Agradecimentos ao programa **Decola Tech 2025** por inspirar este projeto.
- Obrigado à comunidade Spring, Gradle, e Railway por ferramentas incríveis!

## 📱 Contato

- LinkedIn: [Leonardo Medeiros de Almeida](https://www.linkedin.com/in/leonardo-medeiros-de-almeida-996302254/)
- Email: [leonardomedd](mailto:leonardomedd@gimail.com) 
- GitHub: [leonardomedd](https://github.com/leonardomedd)

---

Se precisar de ajuda adicional, entre em contato ou abra uma issue no GitHub.

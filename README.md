# Cadastro de Usuários - API REST

Sistema de gerenciamento de usuários desenvolvido com Spring Boot, implementando operações CRUD através de uma API RESTful.

## Tecnologias

- Java 21
- Spring Boot 4.0.1
- Spring Data JPA
- Spring Web MVC
- H2 Database (in-memory)
- Lombok
- Maven

## Arquitetura

O projeto segue uma arquitetura em camadas:

```
com.chsb.cadastro_usuario
├── controller       # Camada de apresentação (REST endpoints)
├── business         # Camada de lógica de negócio
└── infrastructure   # Camada de infraestrutura (persistência)
    ├── entity       # Entidades JPA
    └── repository   # Repositórios Spring Data
```

## Modelo de Dados

### Entidade Usuario

| Campo | Tipo    | Constraints           |
|-------|---------|----------------------|
| id    | Integer | Primary Key, Auto-increment |
| email | String  | Unique, Not Null     |
| nome  | String  | Not Null             |

## Endpoints da API

### Base URL
```
http://localhost:8080/usuario
```

### Criar Usuário
```
POST /usuario
Content-Type: application/json

{
  "email": "usuario@example.com",
  "nome": "Nome do Usuário"
}
```

### Buscar Usuário por Email
```
GET /usuario?email=usuario@example.com
```

### Atualizar Usuário
```
PUT /usuario?id=1
Content-Type: application/json

{
  "email": "novoemail@example.com",
  "nome": "Novo Nome"
}
```

### Deletar Usuário
```
DELETE /usuario?email=usuario@example.com
```

## Configuração do Banco de Dados

O projeto utiliza H2 Database em modo in-memory. As configurações estão definidas em [application.properties](src/main/resources/application.properties):

- URL: `jdbc:h2:mem:cadastrodb`
- Driver: `org.h2.Driver`
- Username: `sa`
- Password: (vazio)
- Console H2: habilitado em `/h2-console`

## Requisitos

- JDK 21 ou superior
- Maven 3.6 ou superior

## Instalação e Execução

### Compilar o projeto

```bash
mvnw clean install
```

### Executar a aplicação

```bash
mvnw spring-boot:run
```

A aplicação será iniciada em `http://localhost:8080`.

### Acessar o console H2

Durante a execução, o console H2 estará disponível em:
```
http://localhost:8080/h2-console
```

Utilizar as seguintes credenciais:
- JDBC URL: `jdbc:h2:mem:cadastrodb`
- Username: `sa`
- Password: (deixar vazio)

## Estrutura de Diretórios

```
cadastro-usuario/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/chsb/cadastro_usuario/
│   │   │       ├── CadastroUsuarioApplication.java
│   │   │       ├── business/
│   │   │       │   └── UsuarioService.java
│   │   │       ├── controller/
│   │   │       │   └── UsuarioController.java
│   │   │       └── infrastructure/
│   │   │           ├── entity/
│   │   │           │   └── Usuario.java
│   │   │           └── repository/
│   │   │               └── UsuarioRepository.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/chsb/cadastro_usuario/
│               └── CadastroUsuarioApplicationTests.java
├── pom.xml
└── README.md
```

## Funcionalidades Implementadas

- Criação de usuário com validação de email único
- Busca de usuário por email
- Atualização parcial de dados do usuário
- Exclusão de usuário por email
- Persistência em banco de dados em memória
- Console H2 para inspeção do banco de dados

## Tratamento de Erros

A aplicação implementa tratamento básico de exceções:
- Email não encontrado: lança `RuntimeException` com mensagem "Email Nao Encontrado"
- ID não encontrado: lança `RuntimeException` com mensagem "ID Nao Encontrado"

## Licença

Este projeto está licenciado sob os termos definidos no arquivo [LICENSE](LICENSE).

## Autor

Carlos Henrique

<h1 align="center">
  ViageMais
   <img src="https://raw.githubusercontent.com/LeandroNcosta/ViageMais/main/images/airplane.svg" />
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=8257E5&labelColor=000000" alt="Exercicio" />
</p>

API para gerenciar tarefas (CRUD) que faz parte do desafio do modulo 5 da RECODEPRO 2023

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)

## Práticas adotadas

- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/viagemais-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

## API Endpoints

```markdown
GET /destination 

GET /destination/{id} 

GET /hotel

...

As rotas restantes podem ver pelo Swagger


```

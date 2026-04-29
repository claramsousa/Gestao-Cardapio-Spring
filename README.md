# Estudo-Cardapio-API 🍴

Este projeto é uma API REST desenvolvida para o gerenciamento de cardápios de delivery, criada como projeto final de um minicurso de Spring Boot. O objetivo principal foi consolidar conhecimentos em persistência de dados, arquitetura em camadas e autenticação simples.

## Tecnologias Utilizadas

* [cite_start]**Java 17**: Utilização de `records` para DTOs.
* [cite_start]**Spring Boot 3**: Framework base para construção da aplicação.
* [cite_start]**Spring Data JPA**: Abstração da camada de persistência.
* [cite_start]**Hibernate**: Implementação do ORM para mapeamento das entidades.
* [cite_start]**Lombok**: Redução de código boilerplate com anotações de Getter/Setter.
* **Maven**: Gerenciador de dependências e build.

## Funcionalidades

### Gestao-Cardapio-Spring
* **Listar Alimentos**: Retorna todos os itens cadastrados no cardápio.
* **Cadastrar Item**: Permite adicionar novos pratos com título, preço e URL da imagem.
* **Atualizar Item**: Edita informações de um prato existente via ID.
* **Remover Item**: Exclui um alimento do sistema com tratamento de erro caso não exista.

### Autenticação
* **Login**: O endpoint de login realiza a persistência e consulta via JPA, validando as credenciais diretamente no banco de dados.

## Arquitetura do Projeto

O projeto segue o padrão de camadas para garantir a separação de responsabilidades:

1. **Controller**: Exposição dos endpoints e manipulação das requisições HTTP.
2. **Service**: Camada de lógica de negócio e validações.
3. **Repository**: Interface de comunicação com o banco de dados via JPA.
4. **Entity**: Representação das tabelas `foods` e `users` no banco de dados.
5. **DTO (Data Transfer Object)**: Uso de Java Records para tráfego seguro de dados entre as camadas.

## Como Executar

1. Clone o repositório.
2. Configure as credenciais do seu banco de dados no arquivo `src/main/resources/application.properties`.
3. Execute o comando `mvn spring-boot:run`.
4. A API estará disponível em `http://localhost:8080`.

# Loja Spring

Este projeto é uma aplicação de loja usando Spring Boot, demonstrando a aplicação de padrões de projeto como Strategy, Singleton e Facade; documentado com Swagger.

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database
- Spring Security
- Swagger
- Lombok

## Padrões de Projeto Implementados
### Strategy
Implementado para calcular diferentes tipos de descontos nos produtos.
- **Interface**: `DiscountStrategy`
- **Implementações**: `SeasonalDiscontStrategy`, `NoDiscountStrategy`, `PercentageDiscountStrategy`

### Singleton
Usado para gerenciar uma única instância de uma classe de configuração.
- **Classe**: `MySingletonClass`

### Facade
Simplifica a interação com subsistemas complexos.
- **Classe**: `ProductFacade`

## Funcionalidades
- CRUD de produtos
- Aplicação de diferentes estratégias de desconto
- Documentação da API com Swagger
- Segurança básica com Spring Security (configuração padrão: acesso irrestrito)

## Configuração e Execução
### Pré-requisitos
- JDK 17
- Maven

### Executando a Aplicação
1. Clone o repositório:
   ```sh
   git clone https://github.com/felipelacerda717/loja-spring.git

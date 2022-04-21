# Projeto Lets Code: Banco Azul

## Sumário

- [Projeto Lets Code: Banco Azul](#projeto-lets-code-banco-azul)
  - [Sumário](#sumário)
- [Introdução](#introdução)
  - [Autores](#autores)
  - [Especificações](#especificações)
  - [Regras de negócio do projeto](#regras-de-negócio-do-projeto)
- [Como rodar o projeto](#como-rodar-o-projeto)
- [Usuários para testes manuais](#usuários-para-testes-manuais)
  - [LOGIN](#login)
  - [modelos de dados para criação](#modelos-de-dados-para-criação)
    - [emails gerados por https://temp-mail.org/pt/](#emails-gerados-por-httpstemp-mailorgpt)
    - [Telefone](#telefone)
    - [cpf](#cpf)
- [Descrição original do projeto](#descrição-original-do-projeto)

# Introdução

## Autores

Projeto de banco de dados realizado por:

- Carlos Masao Mito
- Caroline Fernanda Bezerra de Oliveira
- João Vitor de Paula Pereira
- Marcos Roberto Franciosi
- Natália Satie Odashima
- Pedro Otávio Freiman Blaudt

**Tema do projeto:** projeto clonado a partir [Grupo-Lets-Code](https://github.com/Grupo-Lets-Code/db-banco).

## Especificações

Criar um REST API com o projeto sorteado levando em consideração os seguintes tópicos:
- Ter rest endpoints especificos para cada operação de um CRUD - RestFul style.
- Usar os métodos HTTP de acordo com a operação.
- Usar os códigos de status HTTP na resposta de cada operação.
- Criar classes services para tratamento das regras de negócio e lançar as exceções necessárias.
- Fazer o tratamento de exceções com as anotações spring.
- Adicionar logs ao projeto.

**Desafio**

Implementar uma interface web com Thymeleaf que se comunicará com sua api rest

- Uma tela para listar dados onde será possível deletar um registro.
- Um tela para realizar o insert e update dos dados.

Usar HTTP Basic Authentication com Spring security (Deverá criar uma tela de login).

**Critérios de avaliação:**

- Uso correto dos métodos HTTP
- Uso correto dos códigos de status HTTP.
- Regras de negócios no local requisitado.
- Exceções tratadas corretamente.
- Logs devidamente implementados.

## Regras de negócio do projeto

// fazer especicações do fluxo do aplicativo

# Como rodar o projeto

Para os desenvolvedores, basta clonar o projeto, abrir no IntelliJ e rodar como está definido por default.

Para visualizar o bando de dados veja o link http://localhost:8080/h2-console/

Ao abrir o link certifique que todas as configurações condizem com a imagem logo abaixo: 

// todo adicionar imagem 

# Usuários para testes manuais

## LOGIN

| numero da conta | senha  |
|-----------------|--------|
| 1               | 123456 |
| 2               | 234567 |
| 3               | 345678 |
| 4               | 456789 |
| 5               | 567890 |
| 6               | 678901 |

## modelos de dados para criação

### emails gerados por https://temp-mail.org/pt/

vawoj59235@bamibi.com

### Telefone

(11)99999-9999

### cpf



---

# Descrição original do projeto

-- Portuguese (PT-BR)
OLÁ MUNDO!!!

Bem vindo ao projeto do Banco Azul!!! Ficamos felizes pela sua presença :)

No decorrer desse arquivo irei explicar um pouco sobre o projeto:
Neste, temos uma aplicação bancária utilizando a linguagem Java, com o padrão MVC (Model-View-Controller). O projeto também possui dependências como Lombok,
Spring Boot e JpaRepository.

ADEMAIS! A nossa aplicação é totalmente interativa com o usuário!!! :D

Na aplicação temos os seguintes processos, que no final realizam um CRUD (Create-Read-Update-Delete)! 

-- Processos para abertura e cadastro:
Abertura de Contas;
Cadastro de Cliente;
Cadastro de Endereço.

-- Processos de operações bancárias:
Sacar;
Depósitar;
Transferir;
Investir.

-- Processos de consulta:
Consultar Contas;
Consultar Saldo;
Excluir Conta.

Temos também separações por Tipo Conta e Tipo Cliente!
Sendo assim, conseguimos aplicar metódos diferentes dependendo do Tipo Cliente e taxas personalizadas dependendo do Tipo Conta.

Como funcionam essas taxas? 
Aplicamos as taxas nos Tipos Conta do cliente Tipo Pessoa Jurídica. Assim, a Conta Corrente terá uma taxa e a Conta Investimento terá outra.
Obs: Tipo Pessoa Jurídica não pode abrir Conta Poupança!

Todas essas operações são feitas na nossa aplicação via console interativo e as ações 3,são salvas em um Banco de Dados H2.
Segue o diagrama base para criação do sistema bancário:

![](https://user-images.githubusercontent.com/61168932/162626304-f7ca47c5-8a37-419f-8a09-00d18bd95bff.png
)

Obrigado!!!

-- English (EN-US)
HELLO WORLD!!!

Welcome to the Blue Bank project!!! We are glad you were here :)

In the course of this file I will explain a little about the project:
In this one, we have a banking application using the Java language, with the MVC pattern (Model-View-Controller). The project also has dependencies like Lombok,
Spring Boot and JpaRepository.

FURTHERMORE! Our application is fully interactive with the user!!! :D

In the application we have the following processes, which in the end perform a CRUD (Create-Read-Update-Delete)!

-- Processes for opening and registration:
Opening of Accounts;
Customer registration;
Address Registration.

-- Banking operations processes:
Withdraw;
Deposit;
Transfer;
Invest.

-- Consultation processes:
Consult Accounts;
Consult Balance;
Delete Account.

We also have separations by Account Type and Customer Type!
Therefore, we are able to apply different methods depending on the Customer Type and custom fees depending on the Account Type.

How do these fees work?
We apply the fees to the Customer Account Types Legal Entity Type. Thus, the Current Account will have one fee and the Investment Account will have another.
Note: Legal Entity cannot open a Savings Account!

All these operations are done in our application via an interactive console and the actions are saved in an H2 Database.
Below is the basic diagram for creating the banking system:

![](https://user-images.githubusercontent.com/61168932/162626304-f7ca47c5-8a37-419f-8a09-00d18bd95bff.png
)

Thanks!!!

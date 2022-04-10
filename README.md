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
Exclurir Conta.

Temos também separações por Tipo Conta e Tipo Cliente!
Sendo assim, conseguimos aplicar metódos diferentes dependendo do Tipo Cliente e taxas personalizadas dependendo do Tipo Conta.

Como funcionam essas taxas? 
Aplicamos as taxas nos Tipos Conta do cliente Tipo Pessoa Jurídica. Assim, a Conta Corrente terá uma taxa e a Conta Investimento terá outra.
Obs: Tipo Pessoa Jurídica não pode abrir Conta Poupança!

Todas essas operações são feitas na nossa aplicação via console interativo e as ações 3,são salvas em um Banco de Dados H2.
Segue o diagrama base para criação do sistema bancário:

https://user-images.githubusercontent.com/61168932/162626314-1d297406-20b7-449d-b702-da29d654bd28.png

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

https://user-images.githubusercontent.com/61168932/162626304-f7ca47c5-8a37-419f-8a09-00d18bd95bff.png

Thanks!!!

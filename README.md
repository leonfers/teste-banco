### Projeto Banks
#### Desafio - Crie um banco de maneira fácil
1. O desafio envolve a implementação de uma API Restful genérica para serviços bancários.

### 2.Tecnologias
* Java 11 (OpenJDK)
* Maven (3.8.1)
* Springboot (2.5)
* Mysql (8.0)
* OAUTH2

#### 3. Rodar em desenvolvimento
#### 3.1 Ambiente
1. Instalar [OpenJDK 11](https://openjdk.java.net/install/) 
2. Instalar [Maven](https://maven.apache.org/install.html)
3. Instalar [Mysql8](https://dev.mysql.com/downloads/)
4. Intalar IDE de preferência (Ex: [IntelliJ IDEA](https://www.jetbrains.com/idea/download/))

#### 3.2 Variáveis de ambiente
>-DCLIENT_ID=client  (Cient ID usado para a Autenticação OAUTH2)

>-DCLIENT_SECRET=123 (Cient Secret usado para a Autenticação OAUTH2)

>-DDEBUG=true  (Definir como true para rodar o projeto com logs e inicializar o banco de dados com valores)

>-DDB_HOST=172.17.0.2 (IP onde está rodando o MySQL)

>-DDB_PORT=3306 (Porta onde está rodando o MySQL)

>-DDB_NAME=banks (Nome do banco no MySQL, caso não exista ele será criado)

>-DDB_USER=root (Usuário do banco de dados com acesso a banco com o nome definido anteriormente)

>-DDB_PASSWORD=root (Usuário do banco de dados com acesso a banco com o nome definido anteriormente)

#### 3.3 Rodar aplicação através da IDE (Ex: [Intellij IDEA](https://www.jetbrains.com/help/idea/spring-boot.html))
#### 3.4 Rodar aplicação através do maven
```bash
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-DCLIENT_ID=client -DCLIENT_SECRET=123 -DDEBUG=true -DDB_HOST=172.17.0.2 -DDB_PORT=3306 -DDB_NAME=banks -DDB_USER=root -DDB_PASSWORD=root"
```

#### 3.5 Documentação da API pode ser encontrada no caminho [/swagger.html](http://localhost:8000/swagger.html) da API

#### 3.5 A descrição detalhada a API(Implementação, Teste, Configuração) pode encontrada na [wiki do projeto](https://github.com/leonfers/teste-banco/wiki).

#### 3.6 Insominia Collection com todas as requisições pode ser encontrada [aqui](https://github.com/leonfers/teste-banco/blob/main/src/Insomnia%20Collection%20API)

#### 3.7 Rodar testes da aplicação através do maven
```bash
mvn test -DargLine="-DCLIENT_ID=client -DCLIENT_SECRET=123 -DDEBUG=true -DDB_HOST=172.17.0.2 -DDB_PORT=3306 -DDB_NAME=banks -DDB_USER=root -DDB_PASSWORD=root"
```

### 4. Resumo da API
A solução proposta foi construída com a simplicidade em mente, atendendo os requisitos apontados pelo desafio.

#### 4.1 Descrição
A API Bancos permite a gerência de Instituições Financeiras, Agências, Usuários (Clientes).
A API Bancos também possui a funcionalidade para realizar Saques, Depósitos e Transferências e gerar um extrato bancário por conta.
Foi considerado situações de concorrência para impedir que o saldo das contas entrasse em situação inconsistente.

#### 4.1 Solução
A API Bancos conta com os seguintes Módulos

#### 4.1.1 User (Usuários)
Permite a gerência de usuários (cadastro, listagem e edição)
#### 4.1.2 Security (Autentição)
Permite a autenticação na API
#### 4.1.3 Banks (Bancos)
Permite a gerência de bancos (cadastro, listagem, edição, remoção)
#### 4.1.4 Branches (Agências)
Permite a gerência de agências (cadastro, listagem, edição, remoção)
#### 4.1.5 Accounts (Contas)
Permite a gerência de contas (cadastro, listagem, edição, remoção, gerar extrato)
#### 4.1.6 Transactions (Transações)
Permite a realizar transações (saque, depósito, transferência)

<!-- CONTACT -->
### Contact

Leoncio Ferreira - [LinkedIn](https://www.linkedin.com/in/leoncio-ferreira/) - leonfers@hotmai.com

Project Link: [https://github.com/leonfers/teste-banco](https://github.com/leonfers/teste-banco)
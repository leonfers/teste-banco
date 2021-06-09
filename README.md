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

#### 3.5 Documentação da API pode ser encontrada no caminho /swagger.html da API

#### 3.5 A descrição detalhada a API(Implementação, Teste, Configuração) pode encontrada na wiki do projeto.

#### 3.6 Insominia Collection com todas as requisições pode ser encontrada [aqui]()

### 4. Resumo da API

#### 4.1 Descrição

#### 4.1 Solução

#### 4.1 Autenticação

#### 4.1 Autenticação

#### 4.1 Autenticação


<!-- CONTACT -->
### Contact

Leoncio Ferreira - [LinkedIn](https://www.linkedin.com/in/leoncio-ferreira/) - leonfers@hotmai.com

Project Link: [https://github.com/leonfers/teste-banco](https://github.com/leonfers/teste-banco)
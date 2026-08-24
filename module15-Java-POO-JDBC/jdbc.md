
# 📚 Module 15 - Java JDBC & JPA

Bem-vindo ao **Módulo 15: Java POO, JDBC & JPA**!

Este módulo aborda a integração entre aplicações Java e bancos de dados relacionais, explorando diferentes formas de 
persistência e acesso aos dados.

Durante os estudos foi desenvolvido o projeto prático **PataViva**, uma aplicação de gerenciamento de uma clínica 
veterinária criada para aplicar os conceitos estudados.

O projeto utiliza **JPA e Hibernate** para a persistência das entidades e **JDBC** para operações específicas do banco 
de dados, como **Stored Procedures, Functions e Views**.

---

## 🎯 Objetivos do Módulo

### O que será possível com este módulo:

✅ Compreender a integração entre **Java e MySQL**

✅ Trabalhar com **JDBC**

✅ Utilizar `PreparedStatement` e `CallableStatement`

✅ Trabalhar com **Stored Procedures**

✅ Utilizar parâmetros `IN`, `OUT` e `INOUT`

✅ Criar e utilizar **Database Functions**

✅ Criar e consultar **Database Views**

✅ Compreender o funcionamento do **JPA**

✅ Utilizar **Hibernate** como implementação do JPA

✅ Mapear classes Java como entidades persistentes

✅ Trabalhar com relacionamentos entre entidades

✅ Utilizar **JPQL**

✅ Utilizar **CriteriaBuilder**

✅ Trabalhar com `EntityManager` e transações

✅ Trabalhar com entrada de dados utilizando `Scanner`

✅ Utilizar Java I/O para armazenar informações em arquivos

---

# 🐾 PataViva

O **PataViva** é o projeto prático principal deste módulo.

A aplicação simula o gerenciamento de uma clínica veterinária, trabalhando com tutores, pets, veterinários e consultas.

O projeto foi desenvolvido com o objetivo de aplicar os conceitos de banco de dados e persistência estudados durante o módulo.

### Entidades principais:

- **Tutor**
- **Pet**
- **Veterinário**
- **Consulta**

---

# ☕ JPA & Hibernate

O projeto utiliza **Jakarta Persistence (JPA)** com **Hibernate** para realizar a persistência das entidades Java.

As entidades do sistema são mapeadas para as tabelas do banco de dados utilizando as anotações de persistência.

### Conceitos utilizados:

- `@Entity`
- `@Id`
- `@GeneratedValue`
- `@ManyToOne`
- `@OneToMany`
- `EntityManager`
- `EntityManagerFactory`
- Transações
- Mapeamento objeto-relacional
- Relacionamentos entre entidades

### Localização:

`praticas/pataviva/jpa/`

---

# 📂 Repository

Os repositories são responsáveis pelas operações de persistência utilizando JPA.

Entre as operações implementadas estão:

- Cadastro de entidades
- Busca de registros
- Atualização
- Exclusão
- Consultas utilizando JPQL

O projeto possui repositories para as principais entidades do sistema.

### Localização:

`praticas/pataviva/jpa/repository/`

---

# 🔎 JPQL

O projeto utiliza **JPQL (Java Persistence Query Language)** para realizar consultas orientadas às entidades Java.

Um dos exemplos está no `ConsultRepository`, utilizando `JOIN FETCH` para carregar os relacionamentos necessários da entidade `Consulta`.

### Conceitos:

- JPQL
- `SELECT`
- `JOIN FETCH`
- Consultas orientadas a entidades
- Relacionamentos JPA

---

# 🧮 Criteria API

O projeto também utiliza a **Criteria API** do JPA para construir consultas programaticamente.

A classe `ConsultCriteria` utiliza `CriteriaBuilder`, `CriteriaQuery`, `Root` e `Join` para localizar as consultas pertencentes a um determinado tutor.

### Conceitos:

- `CriteriaBuilder`
- `CriteriaQuery`
- `Root`
- `Join`
- Consultas programáticas
- Relacionamentos entre entidades

### Localização:

`praticas/pataviva/jpa/criteria/`

---

# 🔌 JDBC

O **JDBC** é utilizado no projeto para trabalhar diretamente com recursos específicos do banco de dados.

Após a integração com JPA, as operações comuns de persistência das entidades ficam sob responsabilidade do JPA, enquanto o JDBC é utilizado principalmente para demonstrar recursos específicos do MySQL.

### Recursos utilizados com JDBC:

- `Connection`
- `PreparedStatement`
- `CallableStatement`
- `ResultSet`
- `SQLException`
- Stored Procedures
- Database Functions
- Database Views

---

# ⚙️ Stored Procedures

O banco de dados possui três Stored Procedures utilizadas para demonstrar diferentes tipos de parâmetros.

### `inserir_tutor`

Procedure utilizada para demonstrar parâmetros de entrada `IN`.

### `atualizar_nome_pet`

Procedure utilizada para atualizar o nome de um pet e retornar o resultado através de um parâmetro `OUT`.

### `deletar_pet`

Procedure utilizada para demonstrar o funcionamento de um parâmetro `INOUT`.

### Conceitos:

- `IN`
- `OUT`
- `INOUT`
- `CallableStatement`
- `registerOutParameter()`
- Stored Procedures
- MySQL

---

# 🧮 Database Function

O banco de dados possui uma **Function** utilizada para demonstrar funções armazenadas no MySQL.

A função realiza o cálculo relacionado à quantidade de pets de um tutor.

### Conceitos:

- Database Function
- Parâmetros
- Retorno de valores
- MySQL
- JDBC

---

# 👁️ Database View

O banco de dados possui a View:

`vw_agenda_pataviva`

A View reúne informações relacionadas à agenda de consultas da clínica.

Ela permite consultar informações como:

- Tutor
- Quantidade de pets
- Pet
- Espécie
- Veterinário
- CRMV
- Data e hora da consulta

A utilização da View demonstra como uma consulta mais complexa pode ser centralizada diretamente no banco de dados e posteriormente consumida pela aplicação.

### Conceitos:

- `CREATE VIEW`
- `SELECT`
- `JOIN`
- `GROUP BY`
- Views no MySQL
- Consulta através de JDBC

---

# 🖥️ Scanner e Menu Interativo

A aplicação possui um menu interativo utilizando `Scanner`.

O usuário pode selecionar as operações disponíveis no sistema e informar os dados necessários através do console.

Entre as operações disponíveis estão:

- Cadastrar tutor
- Cadastrar pet
- Cadastrar veterinário
- Marcar consulta
- Visualizar consultas
- Atualizar
- Deletar
- Sair

A lógica principal da aplicação está centralizada na classe `PataViva`.

O `Main` funciona apenas como ponto de entrada da aplicação, realizando a chamada:

`PataViva.ptViva();`

---

# 📄 Java I/O

O projeto também utiliza **Java I/O** para trabalhar com arquivos de saída.

As informações geradas durante determinadas operações podem ser armazenadas em arquivos utilizando a classe `FileManager`.

### Conceitos:

- File I/O
- `File`
- Escrita em arquivos
- Organização de arquivos
- `FileManager`

### Localização:

`praticas/pataviva/jdbc/io/`

---

# 📤 Output

O projeto possui uma estrutura de saída para armazenar informações geradas durante as operações JDBC.

Os dados são organizados em diretórios específicos, facilitando a visualização dos resultados.

### Estrutura:

- `tutores`
- `pets`
- `veterinarios`
- `consultas`

### Localização:

`praticas/pataviva/jdbc/output/`

---

# 🗄️ Banco de Dados

O projeto utiliza **MySQL** como banco de dados.

O dump completo do banco está disponível em:

`database/pataviva.sql`

O arquivo contém:

- Estrutura das tabelas
- Dados utilizados pelo projeto
- Chaves primárias
- Chaves estrangeiras
- Stored Procedures
- Database Function
- Database View

Dessa forma, o banco pode ser recriado através de um único arquivo SQL.

---

# 🔐 Configuração

As credenciais do banco de dados não são armazenadas diretamente no código.

O projeto utiliza variáveis de ambiente:

- `DB_USER`
- `DB_PASSWORD`

A conexão utiliza o banco:

`jdbc:mysql://localhost:3306/pataviva`

Para executar o projeto, é necessário possuir o MySQL instalado e configurar as variáveis de ambiente utilizadas pela aplicação.

---

# 📦 Tecnologias Utilizadas

- **Java 21**
- **Maven**
- **MySQL**
- **JDBC**
- **Jakarta Persistence (JPA)**
- **Hibernate ORM**
- **JPQL**
- **Criteria API**
- **PreparedStatement**
- **CallableStatement**
- **Stored Procedures**
- **Database Functions**
- **Database Views**
- **Java I/O**
- **Scanner**

---

# 💡 Conceitos-Chave Aprendidos

**JDBC:** Aprendi a realizar a comunicação direta entre Java e banco de dados utilizando a API JDBC.

**JPA:** Aprendi a trabalhar com persistência de objetos Java utilizando o padrão JPA.

**Hibernate:** Utilizei o Hibernate como implementação do JPA para realizar o mapeamento objeto-relacional.

**JPQL:** Aprendi a realizar consultas utilizando entidades Java.

**Criteria API:** Aprendi a construir consultas programaticamente utilizando `CriteriaBuilder`, `CriteriaQuery`, `Root` e `Join`.

**Relacionamentos:** Trabalhei com relacionamentos entre entidades como Tutor, Pet e Consulta.

**Stored Procedures:** Aprendi a executar Procedures do banco através do `CallableStatement`, utilizando parâmetros `IN`, `OUT` e `INOUT`.

**Functions:** Aprendi a trabalhar com funções armazenadas no MySQL.

**Views:** Aprendi a criar e utilizar Views para organizar consultas envolvendo diferentes tabelas.

**Java I/O:** Aprendi a trabalhar com escrita e organização de informações em arquivos.

**Scanner:** Utilizei entrada de dados pelo console para criar uma interface interativa para o sistema.

**Transações:** Trabalhei com transações JPA utilizando `EntityManager`.

**Separação de responsabilidades:** Organizei as responsabilidades entre entidades, repositories, consultas Criteria e operações específicas de banco.

**Integração de tecnologias:** Desenvolvi uma aplicação utilizando JPA e JDBC de maneira complementar, escolhendo a tecnologia de acordo com a finalidade da operação.

---

# 🎓 Resumo de Aprendizagem

Neste módulo tento demonstrar:

✅ Integração entre **Java e MySQL**

✅ Utilização de **JDBC**

✅ Utilização de **JPA e Hibernate**

✅ Mapeamento objeto-relacional

✅ Criação e utilização de entidades

✅ Relacionamentos entre entidades

✅ Consultas utilizando **JPQL**

✅ Consultas utilizando **Criteria API**

✅ Utilização de `EntityManager`

✅ Utilização de transações JPA

✅ Execução de **Stored Procedures**

✅ Utilização de parâmetros `IN`, `OUT` e `INOUT`

✅ Criação e utilização de **Database Functions**

✅ Criação e utilização de **Database Views**

✅ Utilização de **Java I/O**

✅ Utilização de **Scanner**

✅ Organização de um projeto Java utilizando Maven

✅ Integração entre JPA e JDBC

✅ Aplicação prática dos conceitos estudados através do projeto **PataViva**
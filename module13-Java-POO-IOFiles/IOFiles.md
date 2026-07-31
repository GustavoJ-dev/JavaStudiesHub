# >[⚠️ 👇LEIA COM ATENÇÃO👇 ⚠️]
>
># 📖 Sobre este módulo
>
>
>## 📝 Material de Estudo Pessoal
>
>As apostilas presentes neste módulo foram elaboradas por mim como parte do meu processo de aprendizado e como
material de consulta durante os meus estudos em Java. Meu objetivo ao produzi-las é reforçar o conhecimento adquirido,
organizar os conceitos estudados e criar uma referência para revisões futuras.
>
>## 🎓 Fonte do Conteúdo
>
>O conteúdo foi organizado, estruturado e escrito por mim com base nos assuntos abordados no curso `Java Programming 
>Masterclass`, ministrado por `Tim Buchalka` e disponibilizado na `Udemy`, além de pesquisas complementares e consultas à
>documentação oficial da Oracle.
>
>## 💻 Sobre os Exercícios
>
>Os exercícios e desafios fazem parte do processo de aprendizagem do curso e incluem tanto soluções desenvolvidas
>durante os meus estudos `quanto implementações baseadas nas correções apresentadas pelo professor ao longo das aulas`.
>
>## 🎯 Finalidade
>
> - Todo o material presente neste módulo possui finalidade exclusivamente educacional e representa a minha evolução no
    estudo da linguagem Java, servindo como registro da minha jornada de aprendizado e consulta pessoal.

# 📚 Module 13 - Java I/O & File Handling

Bem-vindo ao **Módulo 13: Java I/O & File Handling**!

Este módulo aprofunda o trabalho com **entrada e saída de dados (I/O)** em Java, explorando desde a leitura e escrita de 
arquivos até o uso das APIs modernas do pacote **java.nio.file**. Durante os estudos são utilizados recursos como 
**Files**, **Path**, **BufferedReader**, **RandomAccessFile** e **FileVisitor**, além de exercícios práticos envolvendo 
manipulação de arquivos binários, leitura de textos, navegação em diretórios e geração de arquivos **JSON**.

---

## 🎯 Objetivos do Módulo

### O que será possível com este módulo:

✅ Compreender o funcionamento da API de **Java I/O**

✅ Trabalhar com **arquivos texto e binários**

✅ Utilizar **BufferedReader** e **FileReader**

✅ Manipular arquivos utilizando **RandomAccessFile**

✅ Explorar a API **java.nio.file**

✅ Percorrer diretórios com **Files.walkFileTree**

✅ Implementar **FileVisitor**

✅ Ler, escrever e copiar arquivos

✅ Gerar arquivos no formato **JSON**

✅ Integrar manipulação de arquivos com **Streams API**

---

# 📂 JAVA I/O & FILE HANDLING

Os exercícios desta seção exploram os principais recursos de manipulação de arquivos em Java, demonstrando técnicas de 
leitura, escrita, navegação em diretórios e processamento de dados utilizando tanto a API clássica quanto a API moderna **NIO**.

---

### 📄 Read Text Challenges

Conjunto de exercícios voltados para leitura e processamento de arquivos texto utilizando **BufferedReader**, **Streams**
e **Expressões Regulares**. Os desafios realizam contagem de linhas, filtragem de palavras, extração de informações e 
estatísticas sobre o conteúdo dos arquivos.

**Conceitos:**

- BufferedReader
- FileReader
- Files
- Streams API
- Pattern
- Matcher
- Regular Expressions
- Collectors
- File Reading

- **Localização:** `praticas/readtext/`

---

### 💾 Random Access File Challenge

Aplicação responsável por manipular um arquivo binário de funcionários utilizando **RandomAccessFile**. O projeto cria 
um índice em memória para acesso rápido aos registros, permitindo localizar e atualizar informações diretamente no 
arquivo sem a necessidade de percorrê-lo completamente.

**Conceitos:**

- RandomAccessFile
- Binary Files
- File Pointer
- Seek
- HashMap
- Records
- File Copy
- NIO Files
- Exception Handling

- **Localização:** `praticas/acessfilechallenge/`

---

### 📁 File Walker

Aplicação que percorre uma árvore de diretórios utilizando **Files.walkFileTree** e uma implementação personalizada de 
**FileVisitor** para gerar estatísticas sobre cada pasta visitada.

As informações coletadas incluem:

- Quantidade de arquivos
- Quantidade de diretórios
- Espaço ocupado pelos arquivos

**Conceitos:**

- java.nio.file
- Path
- Files
- FileVisitor
- BasicFileAttributes
- Directory Traversal
- File Tree
- Collections

- **Localização:** `praticas/filewalker/`

---

### 📑 JSON Generator Challenge

Projeto responsável por gerar uma base de estudantes fictícios e exportar seus dados para um arquivo no formato **JSON**.

A aplicação cria cursos, gera estudantes aleatórios, converte seus dados em JSON e grava o resultado em arquivo utilizando a API **Files**.

**Conceitos:**

- JSON
- Files.writeString
- Path
- Streams API
- Records
- Model Classes
- Data Generation
- StringBuilder
- File Output

- **Localização:** `praticas/JSONchallenge/`

---

# 💡 Conceitos-Chave Aprendidos

**Java I/O:** Aprendi a trabalhar com entrada e saída de dados utilizando as principais classes da biblioteca padrão do Java.

**BufferedReader e FileReader:** Compreendi como realizar leitura eficiente de arquivos texto utilizando buffers e processamento por linhas.

**RandomAccessFile:** Aprendi a acessar posições específicas de arquivos binários, permitindo leitura e escrita direta sem percorrer todo o arquivo.

**NIO (New I/O):** Aprofundei o uso da API moderna de arquivos utilizando **Path**, **Files** e demais recursos do pacote **java.nio.file**.

**FileVisitor:** Aprendi a percorrer árvores completas de diretórios utilizando o padrão Visitor fornecido pela API NIO.

**Manipulação de Arquivos:** Desenvolvi aplicações capazes de criar, copiar, atualizar, ler e escrever arquivos de diferentes formatos.

**JSON:** Aprendi a estruturar objetos Java e exportá-los para arquivos JSON.

**Streams API:** Integrei operações de leitura de arquivos com Streams para processamento declarativo dos dados.

**Boas Práticas:** Procurei organizar os exercícios utilizando documentação, separação por responsabilidade e nomes descritivos para
facilitar manutenção e reutilização do código.

---

# 🎓 Resumo de Aprendizagem

Neste módulo tento demonstrar:

✅ Compreensão sobre **Java I/O**

✅ Manipulação de arquivos texto e binários

✅ Utilização de **BufferedReader** e **RandomAccessFile**

✅ Uso da API moderna **java.nio.file**

✅ Percurso de diretórios com **FileVisitor**

✅ Leitura, escrita e atualização de arquivos

✅ Geração de arquivos **JSON**

✅ Integração com **Streams API**

✅ Prática de manipulação de dados persistidos utilizando Java
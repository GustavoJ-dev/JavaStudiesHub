# 📚 Module 12 - Java Regular Expressions 


Bem-vindo ao **Módulo 12: Java Regular Expressions**! 
Este módulo aprofunda o uso de **Expressões Regulares (Regex) em Java**,
explorando a criação de padrões para localizar, extrair e validar informações presentes em textos.
Durante os estudos são utilizados recursos da API **java.util.regex**, principalmente as classes **Pattern** e 
**Matcher**. Além dos conceitos fundamentais, o módulo apresenta exercícios práticos envolvendo validação de frases e 
um sistema de extração e validação de endereços de e-mail, integrando **Regex**, **Streams** e **expressões lambda**. 

# 📚 Guia do módulo
-   Os conteúdos sobre o módulo se encontram na pasta:
-  `JavaStudiesHub/module12-java-poo-regex/src/materiais_de_estudo`.
-   Os exercícios e desafios se encontram na pasta:
-  `JavaStudiesHub/module12-java-poo-regex/src/praticas`.

--- 

## 🎯 Objetivos do Módulo O que será possível com este módulo: 

✅ Compreender o funcionamento de **Expressões Regulares** 

✅ Criar padrões utilizando caracteres, classes e quantificadores 

✅ Utilizar **Pattern** e **Matcher**

✅ Trabalhar com **grupos de captura**

✅ Aplicar âncoras e caracteres especiais 

✅ Utilizar **lookaheads** para validação de padrões 

✅ Extrair informações de textos utilizando Regex

✅ Integrar Expressões Regulares com **Streams e Lambdas** 

--- 

## 🔍 **JAVA REGULAR EXPRESSIONS**
Os exercícios desta seção exploram os principais recursos de Expressões Regulares em Java, demonstrando como criar
padrões para correspondência, extração e validação de informações textuais. 

### 🧩 Mini Regex Challenges 
Conjunto de pequenos desafios envolvendo correspondência e validação de Strings utilizando Expressões Regulares. Os exercícios 
verificam correspondência exata de textos e estruturas de frases utilizando letras maiúsculas, caracteres diversos, 
âncoras e sinais de pontuação.

**Conceitos:** 
- Regular Expressions 
- String.matches() 
- Character Classes 
- Quantifiers 
- Anchors 
- Unicode Properties 
- Metacharacters 
- Pattern Matching 
- 
- **Localização:** `praticas/minichallenge/` 

--- 

### 📧 Email Validator 

Aplicação de console responsável por extrair e validar endereços de e-mail utilizando Expressões Regulares. O
projeto utiliza grupos de captura para separar o **nome de usuário** e o **domínio** dos endereços encontrados, além de
aplicar um **Negative Lookahead** para impedir determinadas sequências inválidas. A aplicação também utiliza **Streams** 
e **expressões lambda** para processar os resultados encontrados pelo `Matcher`. 

**Conceitos:**
- Pattern 
- Matcher 
- MatchResult 
- Capture Groups 
- Negative Lookahead
- Quantifiers 
- Regular Expressions
- Streams API 
- Lambda Expressions
- Method References 

- **Localização:** `praticas/emailvalidate/` 

--- 

## 💡 Conceitos-Chave Aprendidos 

**Expressões Regulares:** Aprendi a criar padrões para localizar, analisar e validar informações presentes em Strings
utilizando Regex. 

**Pattern e Matcher:** Compreendi como utilizar as classes **Pattern** e **Matcher** para compilar expressões regulares 
e realizar buscas ou validações em textos. 

**Grupos de Captura:** Aprendi a utilizar grupos para capturar partes específicas de uma correspondência, permitindo 
separar informações como usuário e domínio de um endereço de e-mail. 

**Quantificadores e Classes de Caracteres:** Aprofundei o uso de quantificadores e classes de caracteres para
controlar quais símbolos podem aparecer e quantas vezes podem ocorrer em um padrão. 

**Lookaheads:** Utilizei **Negative Lookahead** para adicionar regras de validação sem consumir caracteres durante a 
correspondência da expressão regular.


**Streams e Lambdas:** Integrei Expressões Regulares com **Streams API** e expressões lambda para processar resultados 
de correspondências de forma declarativa. 

**Boas Práticas:** Procurei organizar os exercícios utilizando documentação, nomes descritivos e separação das práticas 
por responsabilidade. 

--- 

## 🎓 Resumo de Aprendizagem Neste módulo tento demonstrar: 

✅ Compreensão sobre **Expressões Regulares em Java** 

✅ Utilização das classes **Pattern e Matcher** 

✅ Criação de padrões para validação de Strings 

✅ Aplicação de grupos de captura 

✅ Uso de quantificadores, âncoras e classes de caracteres 

✅ Aplicação de **Negative Lookahead** 

✅ Extração e validação de endereços de e-mail 

✅ Integração de Regex com **Streams e Lambdas** 

✅ Prática de **Java Moderno e manipulação de Strings**
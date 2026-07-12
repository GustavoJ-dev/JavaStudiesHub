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


# 📚 Module 09 - Mutabilidade e Imutabilidade em Java 

Bem-vindo ao **Módulo 09: Mutabilidade e Imutabilidade**! 

- Este módulo aprofunda conceitos relacionados ao **estado dos objetos em Java**, 
explorando como dados podem ser modificados, protegidos e compartilhados entre diferentes partes de uma aplicação.

- Ao longo dos estudos são aplicados conceitos de **objetos mutáveis e imutáveis**, cópias defensivas e encapsulamento 
de coleções. Os projetos também integram **Generics**, **Collections**, **Lambdas**, **Interfaces Funcionais** e 
recursos modernos da Programação Orientada a Objetos em Java.


## 🎯 Objetivos do Módulo, O que será possível com este módulo: 

✅ Compreender **Mutabilidade e Imutabilidade** 

✅ Controlar alterações no estado dos objetos 

✅ Aplicar **cópias defensivas** em coleções 

✅ Proteger o estado interno de classes 

✅ Trabalhar com referências de objetos mutáveis 

✅ Utilizar **Generics** em estruturas reutilizáveis 

✅ Integrar **Collections e Interfaces Funcionais** 

✅ Desenvolver aplicações orientadas a objetos com maior controle de estado

# 🏦 **MUTABILIDADE E PROTEÇÃO DE DADOS** 

Os exercícios desta seção exploram o impacto da mutabilidade no estado dos objetos e demonstram técnicas para impedir 
alterações indesejadas em estruturas internas. ### 💳 Bank System Sistema bancário responsável por gerenciar clientes, 
contas e transações. O projeto demonstra como objetos mutáveis podem afetar o estado de uma aplicação e como o 
encapsulamento e as cópias defensivas ajudam a proteger os dados internos. 

**Funcionalidades:** 
- Cadastrar clientes 
- Criar contas bancárias 
- Realizar depósitos 
- Realizar saques 
- Registrar transações 
-  Consultar contas de clientes 
- Controlar saldo bancário


**Conceitos:** 
- Mutabilidade
- Imutabilidade 
- Cópias Defensivas 
- `List.copyOf()` 
- Encapsulamento 
- Collections 
- Map 
- ArrayList 
- Gerenciamento de Estado 


- **Localização:** `praticas/banksystem/` 

--- 

## 💡 **CÓPIAS DEFENSIVAS** 

Uma das principais técnicas exploradas neste módulo é a utilização de **cópias defensivas** para impedir que estruturas
internas sejam modificadas diretamente por outras partes da aplicação. No sistema bancário, a lista interna de contas
de um cliente é protegida utilizando `List.copyOf()`. Dessa forma, o código externo recebe uma lista não modificável 
estruturalmente, impedindo operações como adicionar ou remover contas diretamente da coleção interna do cliente.

**Conceitos:** 
- Proteção do estado interno 
- Encapsulamento de coleções
- Referências de objetos 
- Shallow Copy
- Coleções não modificáveis 
- Controle de acesso aos dados

---

# 🎮 **GAME CONSOLE** 

Esta seção desenvolve uma estrutura genérica para criação e execução de jogos utilizando Programação Orientada a
Objetos e recursos modernos da linguagem Java. ### 🕹️ Generic Game Console Sistema reutilizável responsável por 
gerenciar jogadores, ações e o fluxo de execução de diferentes jogos. A classe `Game<T>` utiliza **Generics com Bounds**
para permitir que diferentes tipos de jogadores sejam utilizados dentro da mesma estrutura. 

**Conceitos:**

- Generics
- Generic Bounds
- Classes Abstratas 
- Polimorfismo 
- Collections 
- LinkedHashMap 
- Interfaces Funcionais 
- Predicate 
- Method References 
- Lambdas 

**Localização:** `praticas/gameconsole/` 

--- 

## 🔫 Shooter Game 

Implementação de um jogo simples de tiro utilizando a estrutura genérica desenvolvida pelo`GameConsole`. O projeto
demonstra como diferentes jogos podem reutilizar a mesma estrutura de execução através de **Herança, Generics e 
Polimorfismo**. 

**Funcionalidades:** 
- Criar jogadores 
- Executar ações do jogo 
- Encontrar prêmios 
- Utilizar armas 
- Exibir informações do jogador 
- Encerrar o jogo 

**Tecnologias:**
- Generics 
- Herança 
- Polimorfismo
- Records 
- Interfaces 
- Predicate
- Method References 

--- 

# 🏴‍☠️ **PIRATE GAME** 

Projeto que implementa um jogo de aventura baseado em piratas utilizando a estrutura genérica criada no `GameConsole`.
O jogador percorre diferentes cidades, enfrenta oponentes, encontra itens e experimenta eventos que podem alterar seu 
estado durante a execução do jogo. ### ⚔️ Sistema de Combate O sistema de combate utiliza diferentes tipos de
personagens representados por uma hierarquia de classes baseada em `Combatant`.

**Personagens:** 
- Pirate 
- Islander 
- Soldier 

**Conceitos:** 

- Sealed Classes
- Herança 
- Polimorfismo 
- Encapsulamento 
- Gerenciamento de Estado 

--- 

### 🗡️ Sistema de Armas 

As armas são representadas através do enum `Weapon`. 

Cada arma possui: 
- Nível mínimo 
- Pontos de dano 
- Regras de disponibilidade
- 
- **Armas disponíveis:** 
- Faca 
- Adaga
- Machete
- Pistola 

**Conceitos:** 
- Enums 
- EnumSet
- Filtros 
- Collections 
- Lambdas 
---

### 💰 Sistema de Saques 

Os itens encontrados durante a exploração são representados pelo enum `Loot`. Cada item possui um valor que aumenta a 
pontuação do jogador. 

**Itens disponíveis:**
- Moeda de Prata 
- Moeda de Ouro 
- Anel de Ouro 
- Pérola 
- Barra de Ouro

---

### 🌴 Eventos das Cidades A

s cidades possuem eventos representados pelo enum `Feature`. Esses eventos podem aumentar ou reduzir a vida do jogador.

**Conceitos:** 

- Enums 
- Gerenciamento de Vida 
- Alteração de Estado 
- Eventos Aleatórios 

--- 

### 🗺️ Sistema de Cidades

As cidades são representadas pelo record `Town`. 
Cada cidade possui:
- Nome
- Ilha 
- Nível 
- Saques 
- Eventos 
- Oponentes 

O jogo utiliza uma estrutura de listas para organizar as cidades de acordo com o nível do jogador. 
 
- **Conceitos:** 
- Records
- Collections 
- List 
- ArrayList 
- LinkedList 
- EnumSet
- `Collections.shuffle()`
- Cópias Defensivas 

**Localização:** `praticas/gameconsole/pirategame/` 

---

## 💡 Conceitos-Chave Aprendidos 

**Mutabilidade:** 

- Aprofundei como alterações no estado de um objeto podem afetar outras partes da aplicação que compartilham a mesma
referência. 

**Imutabilidade:** 

- Compreendi como restringir alterações no estado dos objetos pode tornar o código mais previsível e 
seguro. 

**Cópias Defensivas:** 

- Aprendi a proteger coleções internas utilizando técnicas como `List.copyOf()` e criação de novas instâncias de listas.

**Generics:** 

- Utilizei tipos genéricos e bounds para desenvolver estruturas reutilizáveis capazes de trabalhar com diferentes tipos 
de jogadores. 

**Sealed Classes:** 

- Trabalhei com hierarquias controladas utilizando classes seladas e a palavra-chave `permits`. 

**Interfaces Funcionais:** 

- Utilizei `Predicate` para representar ações executáveis dentro do sistema de jogos. 

**Collections:** 

- Integrei `List`, `Map`, `ArrayList`, `LinkedList`, `HashMap`, `LinkedHashMap` e `EnumSet` em 
diferentes partes dos projetos. 

**Boas Práticas:** 

- Procurei aplicar encapsulamento, reutilização de código, separação de responsabilidades e proteção do estado interno 
dos objetos. 

---

## 🎓 Resumo de Aprendizagem Neste módulo tento demonstrar: 

✅ Compreensão sobre **Mutabilidade e Imutabilidade** 

✅ Aplicação de **Cópias Defensivas** 

✅ Proteção do estado interno de objetos 

✅ Utilização de **Generics e Generic Bounds** 

✅ Aplicação de **Sealed Classes** ✅ Integração de **Collections e Interfaces Funcionais** 

✅ Desenvolvimento de estruturas reutilizáveis com Programação Orientada a Objetos 

✅ Criação de projetos práticos utilizando recursos modernos do Java 

✅ Prática de **boas práticas de Programação Orientada a Objetos e Java Moderno**
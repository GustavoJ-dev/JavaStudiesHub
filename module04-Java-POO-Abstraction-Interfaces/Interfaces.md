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



# 📚 Module 04 - Abstração e ‘Interfaces’ em Java

Bem-vindo ao **Módulo 04: Programação Orientada a Objetos com Abstração e ‘Interfaces’**!

Este módulo aprofunda dois conceitos fundamentais da POO: **Abstração** (ocultar complexidade) e **‘Interfaces’** 
(definir contratos). Você aprenderá a criar código mais flexível, reutilizável e profissional, aplicando padrão de 
‘design’ baseados em ‘interfaces’ e explorando o polimorfismo em situações reais.

---

## 🎯 Objetivos do Módulo

O que será possível com este módulo:

✅ Entender **‘Interfaces’** como contratos de desenvolvimento  
✅ Implementar **polimorfismo** por ‘interfaces’  
✅ Trabalhar com **classes abstratas** e métodos abstratos  
✅ Usar **métodos ‘default’** em ‘interfaces’ (Java 8+)  
✅ Aplicar **padrões de ‘design’** baseados em ‘interfaces’  
✅ Implementar **serializer genérica** de objetos  
✅ Criar **enums avançados** com métodos e atributos  
✅ Desenvolver **aplicações profissionais** com boas práticas  

---

## 🔧 **ABSTRAÇÃO** - Classes Abstratas

Os exercícios de Abstração trabalham com herança e métodos abstratos para criar hierarquias de classes.

### 📦 Abstraction Package - Hierarquia de Produtos

Implementa um sistema de loja com produtos diferentes usando classes abstratas.

**Aprendizados:**
- Herança de classes abstratas
- Métodos abstratos vs. concretos
- Polimorfismo em estruturas de dados
- Encapsulamento com `private` e `protected`

**Localização:** `pratices/abstraction/`

---

## 🎭 **INTERFACES** - Contratos Polimórficos

Os exercícios de Interfaces trabalham com contratos que múltiplas classes implementam.

### 🚗 Exercise 47 - Caminhão e Carro

Implementa diferentes tipos de veículos usando uma ‘interface’ comum `Veiculo`.

**Conceitos:**
- Uma classe pode implementar múltiplas ‘interfaces’
- Polimorfismo com interfaces
- Tratamento uniforme de objetos diferentes


### 🎮 Exercise 48 - Sistema de Salvamento de Jogo

Sistema completo de salvamento e carregamento usando a interface `ISaveable`.


**Funcionalidades:**
- ✅ Salvar estado de qualquer objeto que implemente ISaveable
- ✅ Carregar estado persistido
- ✅ Polimorfismo em ação (Player e Monster salvam/carregam uniformemente)
- ✅ Menu interativo com demonstração

**Conceitos Aprendidos:**
- ‘Interface’ como contrato para serialização
- Polimorfismo com múltiplas implementações
- Padrão Strategy com ‘interfaces’
- Reutilização de código

---

## 🎯 **CHALLENGES - Projetos Práticos**

### 🗺️ mapJSON - Sistema de Mapeamento Brasileiro

Implementa um sistema de mapeamento com pontos de interesse brasileiros reais e infraestruturas.

**Localização:** `pratices/interfaces/challenge/mapJSON/`

**Funcionalidades:**
- Mapear edifícios/atrações com localização e tipo
- Mapear linhas de infraestrutura (água, energia, gás, fibra)
- Serializar em formato JSON com chaves em português
- Demonstrar pontos brasileiros reais



**Conceitos Avançados:**
- Interface com métodos default
- Enumerações com múltiplas responsabilidades
- Serialização em JSON português
- Padrão de dados brasileiros reais

---

## 💡 Conceitos-Chave Aprendidos

**‘Interfaces’ vs Classes Abstratas:** ‘Interfaces’ definem o "O QUE" (contrato). 
Classes abstratas definem o "O QUE" E o "COMO" (com implementação parcial). 
Uma classe pode implementar múltiplas ‘interfaces’, mas herdar de uma só classe abstrata.

**Polimorfismo em Ação:** Diferentes classes implementando a mesma ‘interface’ respondendo de 
formas diferentes ao mesmo método. Exemplo: ‘Player’ e Monster salvam/carregam, mas cada um com seus próprios dados.

**Padrões de ‘Design’:** Usei Factory Pattern com ‘interfaces’ pra criar objetos. 
Strategy Pattern com ISaveable para permitir diferentes estratégias de serialização. 
Dependency Injection com ‘interfaces’ para desacoplar código.

---

## 🎓 Resumo de Aprendizagem

Neste módulo consegui demonstrar:

✅ Domínio sobre **‘Interfaces’** e seus contratos  
✅ Compreensão de **Polimorfismo** em profundidade  
✅ Implementação de **padrões de ‘design’** profissionais  
✅ Criação de **código flexível e reutilizável**  
✅ Aplicação de **SOLID principles** (ISP, DIP)  
✅ Desenvolvimento com **localização em português**  
✅ Documentação com **JavaDoc completo**  
✅ Criação de **aplicações interativas** bem estruturadas  

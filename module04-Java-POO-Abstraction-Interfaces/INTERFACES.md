# 📚 Module 04 - Abstração e ‘Interfaces’ em Java

Bem-vindo ao **Módulo 04: Programação Orientada a Objetos com Abstração e ‘Interfaces’**!

Este módulo aprofunda dois conceitos fundamentais da POO: **Abstração** (ocultar complexidade) e **‘Interfaces’** 
(definir contratos). Você aprenderá a criar código mais flexível, reutilizável e profissional, aplicando padrão de 
‘design’ baseados em ‘interfaces’ e explorando o polimorfismo em situações reais.

# 📚 Guia do módulo
-   Os conteúdos sobre o módulo se encontram na pasta:
-  `JavaStudiesHub/module04-Java-POO-Abstraction-Interfaces/src/materiais_de_estudo`.
-   Os exercícios e desafios se encontram na pasta:
-  `JavaStudiesHub/module04-Java-POO-Abstraction-Interfaces/src/praticas`.

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

**Localização:** `praticas/abstraction/`

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

**Localização:** `praticas/interfaces/challenge/mapJSON/`

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

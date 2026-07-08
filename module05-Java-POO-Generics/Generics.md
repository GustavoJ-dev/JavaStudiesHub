# 📚 Module 05 - Generics em Java

Bem-vindo ao **Módulo 05: Generics em Java**!
Neste módulo aprofundei um dos recursos mais importantes da linguagem Java: **Generics**. Eles permitem criar classes, 
interfaces e métodos reutilizáveis com segurança de tipos, eliminando casts desnecessários e tornando o código 
muito mais flexível, limpo e profissional.

Além da sintaxe básica, explorei conceitos avançados como **Bounds**, **Wildcards**, **PECS**, **Type Erasure**, 
**Comparable**, **Comparator** e padrões de projeto utilizando Generics.

---

## 🎯 Objetivos do Módulo

O que será possível com este módulo:

✅ Criar **Classes Genéricas** reutilizáveis
✅ Desenvolver **Métodos Genéricos**
✅ Utilizar **Bounds (extends)** para restringir tipos
✅ Trabalhar com **Wildcards** (`<?>`, `<? extends T>`, `<? super T>`)
✅ Aplicar a regra **PECS (Producer Extends Consumer Super)**
✅ Entender o funcionamento do **Type Erasure**
✅ Implementar ordenação utilizando **Comparable** e **Comparator**
✅ Desenvolver aplicações reutilizáveis seguindo boas práticas

---

# 🔧 Introdução aos Generics

Os primeiros exercícios demonstram o problema existente antes do Java 5 e como os Generics resolveram a falta de segurança de tipos nas coleções.

### 📦 Segurança de Tipos

Antes dos Generics:

- Coleções armazenavam apenas `Object`
- Necessidade de casting manual
- Possibilidade de `ClassCastException`
- Erros somente em Runtime

Com Generics:

- Segurança em tempo de compilação
- Eliminação de casts
- Código mais limpo
- Maior reutilização

**Conceitos Aprendidos:**

- Type Safety
- Compile-Time Checking
- Collections Genéricas
- Diamond Operator (`<>`)

---

# 🧰 Classes e Métodos Genéricos

Nesta etapa foram implementadas classes parametrizadas capazes de trabalhar com qualquer tipo de dado.

### 📦 Box<T>

Classe genérica responsável por armazenar qualquer objeto.

**Conceitos:**

- Parâmetros de Tipo
- Convenções (`T`, `E`, `K`, `V`)
- Diamond Operator
- Reutilização de Código

Exemplo:


Box<String> texto = new Box<>("Olá");
Box<Integer> numero = new Box<>(100);


**Aprendizados:**

- Uma única classe atende diversos tipos.
- O compilador garante segurança de tipos.
- Não há necessidade de casting.

---

# 📌 Bounds (extends)

Os exercícios demonstram como restringir tipos aceitos em uma classe genérica.

### 📦 Upper Bounds

Implementação utilizando:

<T extends Number>;

ou

<T extends Comparable<T>

**Conceitos Aprendidos:**

- Restringir tipos aceitos
- Acesso aos métodos da superclasse
- Segurança adicional
- Múltiplos Bounds

Exemplo:

class Repository<T extends Comparable<T>>

---

# 🎭 Wildcards

Implementação dos três tipos de Wildcards existentes.

### 📦 Wildcard Irrestrito


List<?>  
Aceita qualquer coleção.

---

### 📦 Upper Wildcard

List<? extends Number>

Ideal para leitura de dados.

---

### 📦 Lower Wildcard

List<? super Integer>

Ideal para escrita de dados.
---

## 📚 Regra PECS

Foi aplicada a famosa regra:

> **Producer Extends, Consumer Super**

Producer: <? extends T>

Consumer: <? super T>

Essa técnica é amplamente utilizada na API do Java.

---

# ⚙️ Type Erasure

Os exercícios demonstram como o compilador remove as informações genéricas após a compilação.

**Conceitos Aprendidos:**

- Generics existem apenas em Compile-Time
- Bytecode não possui informação de tipos genéricos
- Limitações do Java
- Não é possível criar:
---

# 🔀 Comparable e Comparator

Implementação de ordenação natural e ordenações alternativas.

### 📦 Comparable

Define a ordem natural da classe.

### 📦 Comparator

Permite múltiplas ordenações.


**Conceitos Aprendidos:**

- Ordenação Natural - Ordenação Personalizada - Collections.sort() - List.sort()

---

# 🚀 Generics no Java Moderno

Aplicação dos Generics juntamente com recursos modernos da linguagem.

**Aprendizados:**

- Integração completa com Java moderno
- Inferência automática de tipos
- APIs funcionais

---

# 🎯 Mini Projects

## 🗺️ Layer<T>

Sistema de renderização utilizando uma classe genérica limitada.

### Arquivos

- `Mappable.java`
- `Point.java`
- `Line.java`
- `Park.java`
- `River.java`
- `Layer.java`

### Funcionalidades

✅ Renderizar objetos diferentes
✅ Utilizar Bounds
✅ Reutilização de código

---

## 🎓 QueryList<T>

Projeto utilizando:

- Generics - Comparable - Comparator - Streams

### Funcionalidades

✅ Filtrar alunos
✅ Ordenar objetos
✅ Trabalhar com coleções genéricas

---

### Funcionalidades

✅ CRUD Genérico
✅ Armazenamento em Map
✅ Reutilização para qualquer entidade
✅ Type Safe

---

# 💡 Conceitos-Chave Aprendidos

**Generics** permitem criar código reutilizável e seguro, movendo a verificação de tipos para o tempo de compilação.
**Bounds** restringem quais tipos podem ser utilizados em uma classe ou método genérico.
**Wildcards** permitem trabalhar com hierarquias de tipos sem perder flexibilidade.
**PECS** define quando utilizar `extends` ou `super`.
**Type Erasure** explica por que os tipos genéricos desaparecem após a compilação.
**Comparable** define uma ordem natural para objetos.
**Comparator** permite criar múltiplas estratégias de ordenação.

---

# 🎓 Resumo de Aprendizagem

Neste módulo consegui demonstrar:

✅ Domínio sobre **Classes Genéricas**
✅ Criação de **Métodos Genéricos**
✅ Uso de **Bounds** e **Wildcards**
✅ Aplicação da regra **PECS**
✅ Compreensão do **Type Erasure**
✅ Implementação de **Comparable** e **Comparator**
✅ Desenvolvimento de **Repository Pattern Genérico**
✅ Integração dos Generics com **Streams**, **Lambdas** e **Records**
✅ Escrita de código altamente reutilizável, seguro e escalável
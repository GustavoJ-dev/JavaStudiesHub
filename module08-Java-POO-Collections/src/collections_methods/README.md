# Módulo 08: Java POO - Collections e Métodos Utilitários

Este módulo é dedicado ao estudo aprofundado das Collections Framework do Java,
com foco na manipulação eficiente de grupos de objetos. Exploramos diversas
interfaces e classes utilitárias que facilitam a gestão de dados em aplicações.

## 🚀 Conteúdo Abordado

### 1. Pacote `collections_methods`
Este pacote demonstra a criação e manipulação de coleções de objetos
personalizados (`Card`) utilizando métodos estáticos das classes
`java.util.Arrays` e `java.util.Collections`.

- **`Card.java`**:
  - Uma classe `record` que representa uma carta de baralho (naipe, face, rank).
  - Contém uma `enum Suit` para os naipes e métodos estáticos para criar
    cartas numéricas, cartas de face e um baralho padrão completo (`getStandardDeck`).
  - Inclui métodos para impressão formatada de baralhos (`printDeck`).

- **`Main.java`**:
  - Ponto de entrada para demonstrar as funcionalidades de `Card` e,
    principalmente, os métodos utilitários de `Collections` e `Arrays`.
  - **`Arrays.fill()`**: Preenchimento de arrays com um valor específico.
  - **`Collections.fill()`**: Preenchimento de listas (substitui elementos existentes).
  - **`Collections.nCopies()`**: Criação de listas imutáveis com múltiplas
    cópias de um objeto.
  - **`Collections.addAll()`**: Adição de múltiplos elementos a uma coleção.
  - **`Collections.copy()`**: Cópia de elementos de uma lista para outra.
  - (Potencialmente) `Collections.shuffle()` e `Collections.sort()` para
    embaralhar e ordenar coleções.

## 🧠 O que Aprendi

Neste módulo, os principais aprendizados foram:

1.  **Collections Framework**: Compreensão das interfaces e classes básicas
    para armazenar e manipular grupos de objetos.
2.  **Classes Utilitárias**: Uso eficaz de `java.util.Arrays` e
    `java.util.Collections` para operações comuns em arrays e listas.
3.  **Manipulação de Listas**: Técnicas para criar, preencher, copiar e
    adicionar elementos a listas de forma eficiente.
4.  **Imutabilidade**: Entendimento de como `Collections.nCopies()` cria
    listas imutáveis e suas implicações.
5.  **Design de Classes**: Criação de classes (`Card`) que representam
    entidades do mundo real e fornecem métodos úteis para sua manipulação.

---
*Este módulo é fundamental para o desenvolvimento de aplicações Java que
lidam com grandes volumes de dados de forma estruturada.*

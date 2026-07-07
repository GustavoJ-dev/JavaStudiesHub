# 📚 Module 03 - POO com Arrays e Listas em Java

Bem-vindo ao **Módulo 03: Programação Orientada a Objetos com Arrays e Listas**! 

Este módulo aprofunda os conceitos de POO aplicando-os com estruturas de dados fundamentais em Java: 
**Arrays** e **Collections** (especialmente `ArrayList` e `LinkedList`). 
Aprendendo a criar estruturas de dados reutilizáveis, 
gerenciar coleções de objetos e implementar operações complexas com dados.

---

## 🎯 Objetivos do Módulo

O que será possível com este módulo:

✅ Trabalhar com **Arrays** em Java (criação, manipulação, ordenação)  
✅ Usar **Collections Framework** (ArrayList, LinkedList)  
✅ Implementar **busca e filtro** em coleções  
✅ Projetar **classes que gerenciam coleções** de dados  
✅ Aplicar **POO em estruturas de dados** reais  
✅ Criar **iteradores e navegação** em listas  
✅ Desenvolver **aplicações interativas** com menus e validação  

---

## 🔢 **ARRAYS** - Estruturas de Dados Fixas

Os exercícios de Arrays trabalham com estruturas de tamanho fixo e operações fundamentais.

### 📋 Exercise 41 - Ordenação de Arrays
Lê números do usuário, cria uma cópia e ordena em ordem crescente com `Arrays.sort()`. 
Trabalha com manipulação, iteração e métodos auxiliares em arrays.
**Localização:** `javaArrays/exercise41/`

### 📋 Exercise 42 - Encontrar Valor Mínimo
Recebe elementos do usuário e encontra o menor valor usando lógica de comparação e iteração.
**Localização:** `javaArrays/exercise42/`

### 📋 Exercise 43 - Array Invertido
Cria um array com elementos em ordem reversa, trabalhando inversão de elementos e manipulação de índices.
**Localização:** `javaArrays/exercise43/`

---

## 📚 **COLLECTIONS - Listas Dinâmicas**

Os exercícios de Collections trabalham com estruturas de tamanho dinâmico e operações com objetos.

### 📞 Exercise 44 - Telefone Móvel com Contatos
Implementa CRUD completo (adicionar, atualizar, remover, buscar) de contatos usando `ArrayList`. 
Trabalha com busca case-insensitive, validação de duplicatas e menu interativo.
**Localização:** `javaLists/exercise44/`

### 🎵 Exercise 45 - Álbum de Música
Gerencia álbuns e canções com `ArrayList`, cria playlists com `LinkedList` e testa transformação entre coleções. 
Usa busca, Record para dados imutáveis e navegação de dados.
**Localização:** `javaLists/exercise45/`

### 🏦 Exercise 46 - Banking - Sistema Bancário Completo
Sistema completo de gerenciamento bancário com **hierarquia de classes** (Bank → Branch → Client).
Implementa operações CRUD, validação de dados e histórico de transações.
Trabalha com `ArrayList` em três níveis, encapsulamento, Menu interativo e Javadoc completo.
**Localização:** `javaLists/exercise46/`

---

## 🎯 **CHALLENGES - Mini Projetos Práticos**

Três projetos completos que aplicam todos os conceitos do módulo.

### 🏦 Banking - Sistema Bancário
**Localização:** `challenges/banking/`

Sistema completo de gerenciamento bancário.

**Funcionalidades:**
- Cadastrar clientes com depósito inicial
- Adicionar transações (créditos/débitos)
- Consultar extrato de cliente
- Listar todos os clientes

**Tecnologias:**
- `ArrayList<Customer>` para clientes
- `ArrayList<Double>` para transações por cliente
- **Record** para dados imutáveis
- Busca **case-insensitive**

---

### 🛒 Grocery List - Lista de Compras
**Localização:** `challenges/grocerylist/`

Aplicação simples de gerenciamento de compras.

**Funcionalidades:**
- Adicionar itens à lista
- Remover itens
- Manter ordem alfabética automática
- Visualizar lista atualizada

**Tecnologias:**
- `ArrayList<String>` para itens
- `Comparator.naturalOrder()` para ordenação
- Menu interativo com validação

---

### ✈️ Itinerary - Gerenciador de Viagem
**Localização:** `challenges/itinerary/`

Navegador de itinerário com destinos brasileiros.

**Funcionalidades:**
- Navegar para próximo destino (Forward)
- Navegar para destino anterior (Backward)
- Exibir todos os locais
- Ordenar por distância

**Tecnologias:**
- `LinkedList<Place>` para locais
- `ListIterator` para navegação bidirecional
- Ordenação com `Comparator`
- Padrão de navegação em coleções

---

## 💡 Conceitos-Chave Aprendidos

**Arrays vs Collections:** Aprendi quando usar cada um. Arrays são fixos e rápidos para dados simples. 
Collections são dinâmicas, flexíveis e ótimas para objetos complexos com muito mais métodos prontos.

**ArrayList vs LinkedList:** Descobri que ArrayList é melhor pra acessar elementos aleatoriamente (rápido),
mas lento em inserir/remover no início. LinkedList é o oposto - rápido pra inserir/remover no início, 
mas lento pra acesso aleatório. ArrayList poupa memória, LinkedList consome mais.

**Padrões de Design:** Usei muito CRUD (criar, ler, atualizar, deletar) nos contatos e clientes. 
Iterator no Itinerary pra navegar pra frente e trás. Comparator pra ordenar tudo. 
Menu Pattern com switch pra estruturar as interfaces.

**Boas Práticas:** Encapsulamento com métodos privados. Validação pra garantir consistência.
Nomes claros que falam por si. DRY - métodos reutilizáveis sem repetir código. E JavaDoc em português documentando tudo.  

---

## 🎓 Resumo de Aprendizagem

Neste módulo tento demonstrar:

✅ Domínio sobre **Arrays** e suas operações  
✅ Aprendizagem sobre **Collections Framework** da Java  
✅ Implementou **CRUD** em coleções  
✅ Criar **classes que gerenciam dados**  
✅ Utilizar **iteradores** para navegação  
✅ Desenvolver **aplicações interativas**  
✅ Praticar **boas práticas de POO**  




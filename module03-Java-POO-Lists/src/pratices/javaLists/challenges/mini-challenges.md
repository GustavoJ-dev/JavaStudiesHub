# 📚 Challenges - Mini Projetos Práticos

Este pacote contém mini projetos práticos que aplicam os conceitos de 
**Programação Orientada a Objetos (POO)**
**Coleções Java**(Lists, ArrayList, LinkedList, etc.) 
Cada desafio é uma aplicação interativa com menu que demonstra o uso real dessas estruturas de dados.

---

## 🏦 **Banking** - Sistema Bancário
**Localização:** `banking/`

Um sistema bancário com gerenciamento de clientes e transações.

### Funcionalidades:
- ✅ Cadastrar novos clientes com depósito inicial
- ✅ Adicionar transações (créditos e débitos)
- ✅ Imprimir extrato bancário de um cliente
- ✅ Listar todos os clientes do banco
- ✅ Menu interativo com validação de dados

### Conceitos Aplicados:
- **ArrayList** para armazenar clientes
- **Record** para representar clientes com dados imutáveis
- **Busca case-insensitive** de clientes
- **Operações CRUD** (Create, Read)

### Como Executar:
```bash
java Main
```

Menu:
```
1 - Cadastrar cliente
2 - Adicionar transação
3 - Imprimir extrato
4 - Listar clientes
0 - Sair
```

---

## 🛒 **Grocery List** - Lista de Compras
**Localização:** `grocerylist/`

Uma aplicação simples para gerenciar itens de uma lista de compras.

### Funcionalidades:
- ✅ Adicionar itens à lista de compras
- ✅ Remover itens da lista
- ✅ Lista mantida em ordem alfabética automaticamente
- ✅ Visualizar lista atualizada após cada operação
- ✅ Menu interativo para adicionar/remover itens

### Conceitos Aplicados:
- **ArrayList** para armazenar itens
- **Ordenação com Comparator** (ordem alfabética)
- **Manipulação de Strings**
- **Entrada de dados do usuário**

### Como Executar:
```bash
java Main
```

Menu:
```
1 - Adicionar itens
2 - Remover itens
Outras opções - Sair
```

## ✈️ **Itinerary** - Gerenciador de Itinerário de Viagem
**Localização:** `itinerary/`

Um aplicativo interativo para navegar por um itinerário de viagem com destinos brasileiros.

### Funcionalidades:
- ✅ Navegar para o próximo destino (Forward)
- ✅ Navegar para o destino anterior (Backwards)
- ✅ Exibir todos os locais do itinerário
- ✅ Viagem ordenada por distância em ordem crescente
- ✅ Navegação bidirecional através de destinos

### Conceitos Aplicados:
- **LinkedList** para armazenar lugares (melhor para inserção/remoção)
- **ListIterator** para navegação bidirecional (forward/backward)
- **Ordenação de objetos** com Comparator
- **Padrão de navegação** em coleções

### Como Executar:
```bash
java Main
```
Menu:
```
(F) - Mover para próximo destino
(B) - Mover para destino anterior
(L) - Listar todos os locais
(M) - Mostrar menu
(Q) - Sair
```
---

## 🎯 Objetivos de Aprendizado

Ao completar estes desafios, você compreenderá:

1. **Coleções Java:**
   - Quando usar `ArrayList` vs `LinkedList`
   - Operações básicas em listas (add, remove, iterate)
   - Ordenação de elementos

2. **POO em Java:**
   - Uso de Records para dados imutáveis
   - Encapsulamento com métodos privados e públicos
   - Reutilização de código

3. **Iteração e Busca:**
   - For-each loops
   - ListIterator para navegação bidirecional
   - Busca com predicados (case-insensitive)

4. **Entrada do Usuário:**
   - Uso de Scanner para capturar input
   - Validação básica de dados
   - Menus interativos


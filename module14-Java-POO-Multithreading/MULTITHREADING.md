# 📚 Module 14 - Java Multithreading & Concurrency

Bem-vindo ao **Módulo 14: Java Multithreading & Concurrency**!

Este módulo aprofunda os conceitos de **programação concorrente** em Java, explorando a criação e gerenciamento de
**Threads**, mecanismos de **sincronização**, comunicação entre threads e o uso da API **Executor Framework**.
Durante os estudos foram desenvolvidas aplicações práticas envolvendo execução paralela, padrão
**Produtor-Consumidor**, uso de **ExecutorService**, controle de acesso a recursos compartilhados e boas práticas
para programação concorrente.

# 📚 Guia do módulo
-   Os conteúdos sobre o módulo se encontram na pasta:
-  `JavaStudiesHub/module14-java-poo-multithreading/src/materiais_de_estudo`.
-   Os exercícios e desafios se encontram na pasta:
-  `JavaStudiesHub/module14-java-poo-multithreading/src/praticas`.

---

## 🎯 Objetivos do Módulo

### O que será possível com este módulo:

✅ Compreender o funcionamento de **Threads** em Java

✅ Criar e executar múltiplas tarefas simultaneamente

✅ Trabalhar com **Thread**, **Runnable** e **ExecutorService**

✅ Utilizar mecanismos de **Synchronization**

✅ Aplicar comunicação entre threads utilizando **wait()**, **notify()** e **notifyAll()**

✅ Implementar o padrão **Produtor-Consumidor**

✅ Gerenciar pools de threads com o **Executor Framework**

✅ Desenvolver aplicações concorrentes de forma segura

✅ Aplicar boas práticas de programação multithread

---

# 📂 JAVA MULTITHREADING & CONCURRENCY

Os exercícios desta seção exploram os principais recursos de concorrência em Java, demonstrando diferentes formas de
criar, sincronizar e gerenciar threads utilizando tanto a API tradicional quanto o Executor Framework.

---

### 🧵 Thread Challenge

Projeto introdutório para criação e execução de **Threads** personalizadas.

A aplicação utiliza múltiplas threads para executar tarefas simultaneamente, demonstrando conceitos como execução
concorrente, interrupção de threads e controle do fluxo utilizando pausas programadas.

**Conceitos:**

- Thread
- Thread Lifecycle
- sleep()
- interrupt()
- Concurrent Execution

- **Localização:** `praticas/threadchallenge/`

---

### 🔒 Synchronization Challenge

Aplicação baseada no padrão **Produtor-Consumidor**, onde múltiplas threads compartilham uma fila de pedidos de forma segura.

O projeto utiliza sincronização para evitar condições de corrida, permitindo que produtores adicionem pedidos enquanto
consumidores processam os itens da fila utilizando mecanismos de comunicação entre threads.

**Conceitos:**

- Synchronization
- synchronized
- wait()
- notify()
- notifyAll()
- Producer-Consumer
- Shared Resources
- Thread Safety

- **Localização:** `praticas/Sychronizationchallenge/`

---

### ⚙️ Executor Service Challenge

Projeto que implementa o processamento concorrente de pedidos utilizando o **Executor Framework**.

A aplicação gerencia automaticamente um conjunto de threads por meio de um **ExecutorService**, distribuindo tarefas
entre os trabalhadores, controlando o encerramento da execução e simplificando o gerenciamento das threads.

**Conceitos:**

- ExecutorService
- Executors
- Callable
- Thread Pool
- Task Submission
- Concurrent Processing
- TimeUnit
- Graceful Shutdown

- **Localização:** `praticas/executorchallenge/`

---

# 💡 Conceitos-Chave Aprendidos

**Threads:** Aprendi a criar e executar múltiplas threads para realizar tarefas simultaneamente.

**Concorrência:** Compreendi como diferentes tarefas podem ser executadas em paralelo compartilhando recursos do sistema.

**Synchronization:** Aprendi a proteger recursos compartilhados utilizando sincronização para evitar condições de corrida.

**Comunicação entre Threads:** Utilizei **wait()**, **notify()** e **notifyAll()** para coordenar produtores e consumidores.

**Executor Framework:** Aprendi a utilizar **ExecutorService** para gerenciar pools de threads de forma mais eficiente e organizada.

**Producer-Consumer:** Desenvolvi aplicações utilizando o padrão Produtor-Consumidor para sincronização entre múltiplas tarefas.

**Thread Safety:** Compreendi a importância da sincronização para garantir consistência dos dados em aplicações concorrentes.

**Boas Práticas:** Procurei organizar os projetos utilizando separação de responsabilidades, documentação e estruturas 
reutilizáveis para facilitar manutenção e evolução do código.

---

# 🎓 Resumo de Aprendizagem

Neste módulo tento demonstrar:

✅ Compreensão sobre **Threads** em Java

✅ Criação e gerenciamento de tarefas concorrentes

✅ Utilização de **Synchronization**

✅ Comunicação entre threads

✅ Implementação do padrão **Produtor-Consumidor**

✅ Uso do **Executor Framework**

✅ Gerenciamento de pools de threads com **ExecutorService**

✅ Desenvolvimento de aplicações concorrentes seguras

✅ Aplicação de boas práticas em programação multithread
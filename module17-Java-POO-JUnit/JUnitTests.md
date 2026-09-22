# Module 17 - Java Testes Unitários com JUnit

 Bem-vindo ao **Java Testes Unitários com JUnit**, um projeto prático desenvolvido com o objetivo de estudar e aplicar
conceitos de **testes unitários em Java** utilizando o framework **JUnit**.

 A aplicação utiliza exemplos práticos para demonstrar como criar testes automatizados, validar resultados, verificar 
exceções e utilizar diferentes tipos de assertions.

 O foco do projeto não é apenas executar testes, mas compreender como os testes unitários podem ser utilizados para validar 
o comportamento esperado de uma aplicação Java.

# 📚 Guia do módulo

- Os conteúdos sobre o módulo se encontram na pasta:
- `JavaStudiesHub/module17-Java-POO-JUnit/src/materiais_de_estudo`.

- Os exercícios e desafios se encontram na pasta:
- `JavaStudiesHub/module17-Java-POO-JUnit/src/praticas`.

---

# 🎯 Objetivos do Projeto

O projeto foi desenvolvido para servir como uma aplicação prática dos conceitos de **Testes Unitários com JUnit**.

Durante sua construção, diferentes recursos do JUnit são utilizados de acordo com a necessidade de cada teste.

Entre os principais conceitos abordados estão:

- Testes unitários
- JUnit 4
- JUnit 5
- JUnit Jupiter
- Assertions
- Testes de exceções
- Validação de mensagens de exceção
- `@BeforeEach`
- `@AfterEach`
- Independência entre testes
- Organização de classes de teste

A ideia é utilizar cada recurso onde ele fizer mais sentido, mantendo os testes simples, organizados e focados na validação do comportamento da aplicação.

---

# 🧪 Testes Unitários

Testes unitários são utilizados para verificar o comportamento de pequenas partes de uma aplicação de forma isolada.

No projeto, os métodos da classe `DigitalAccount` são testados individualmente, permitindo verificar se cada operação apresenta o resultado esperado.

Entre os comportamentos testados estão:

- Depósito
- Consulta de saldo
- Identificação do tipo da conta
- Saque
- Limite de saque
- Exceções
- Mensagens de exceção
- Extração de dígitos verificadores

Cada teste possui uma responsabilidade específica e busca validar um comportamento determinado da aplicação.

---

# ☕ JUnit

O **JUnit** é utilizado como framework para criação e execução dos testes automatizados.

Durante o desenvolvimento do módulo são estudadas as versões:

- JUnit 4
- JUnit 5 / Jupiter

O framework fornece recursos para definir métodos de teste, preparar cenários, executar comportamentos e verificar os resultados obtidos.

Entre os principais recursos utilizados estão:

- `@Test`
- `@BeforeEach`
- `@AfterEach`
- `Assertions`
- `assertEquals`
- `assertNotEquals`
- `assertTrue`
- `assertFalse`
- `assertNull`
- `assertNotNull`
- `assertSame`
- `assertNotSame`
- `assertArrayEquals`
- `assertThrows`

---

# 🧩 JUnit 5 / Jupiter

Os testes utilizados no projeto são implementados principalmente utilizando o **JUnit 5**, através do módulo **Jupiter**.

O JUnit 5 utiliza anotações e assertions para facilitar a criação e organização dos testes.

Um exemplo básico de teste é:

```java
@Test
void depositar() {

    double saldo = account.depositar(500, true);

    assertEquals(1500, saldo, 0.00);
}
```

Nesse exemplo, o método `depositar` é executado e o resultado obtido é comparado com o resultado esperado através do `assertEquals`.

---

# 📊 Assertions

As assertions são utilizadas para verificar se o resultado obtido durante a execução do teste corresponde ao resultado esperado.

O JUnit disponibiliza diferentes tipos de assertions para diferentes situações.

---

## `assertEquals`

Verifica se dois valores são iguais.

```java
assertEquals(1500, saldo, 0.00);
```

No exemplo, o teste verifica se o saldo obtido é igual a `1500`.

---

## `assertNotEquals`

Verifica se dois valores são diferentes.

```java
assertNotEquals(1000, account.getSaldo());
```

Nesse caso, o teste verifica se o saldo atual é diferente de `1000`.

---

## `assertTrue`

Verifica se uma condição é verdadeira.

```java
assertTrue(account.isContaCorrente());
```

O teste verifica se a conta é identificada como uma conta corrente.

---

## `assertFalse`

Verifica se uma condição é falsa.

```java
assertFalse(poupanca.isContaCorrente());
```

Nesse exemplo, o teste verifica se uma conta poupança não é identificada como conta corrente.

---

## `assertNull`

Verifica se uma referência possui valor `null`.

```java
DigitalAccount conta = null;

assertNull(conta);
```

---

## `assertNotNull`

Verifica se uma referência não possui valor `null`.

```java
assertNotNull(account);
```

---

## `assertSame`

Verifica se duas referências apontam para o mesmo objeto.

```java
DigitalAccount outraReferencia = account;

assertSame(account, outraReferencia);
```

As duas variáveis apontam para a mesma instância de `DigitalAccount`.

---

## `assertNotSame`

Verifica se duas referências apontam para objetos diferentes.

```java
DigitalAccount outraConta = new DigitalAccount(
        "João",
        500,
        DigitalAccount.TIPO_CORRENTE
);

assertNotSame(account, outraConta);
```

Nesse caso, `account` e `outraConta` representam instâncias diferentes.

---

## `assertArrayEquals`

Verifica se dois arrays possuem os mesmos elementos.

```java
char[] esperado = {'4', '2'};

char[] resultado =
        DigitalAccount.extrairDigitos("CZ-4291-2");

assertArrayEquals(esperado, resultado);
```

---

# ⚠️ Testes de Exceções

O projeto também aborda testes relacionados ao lançamento de exceções.

Na classe `DigitalAccount`, existe uma regra para o saque:

- Saques acima de R$ 500,00 realizados sem atendimento da agência devem lançar uma `IllegalArgumentException`.

Esse comportamento pode ser testado utilizando o `assertThrows`.

```java
assertThrows(
        IllegalArgumentException.class,
        () -> account.sacar(600, false)
);
```

Dessa forma, o teste verifica se a exceção esperada realmente foi lançada.

---

# 📝 Mensagem da Exceção

Também é possível verificar a mensagem associada à exceção.

Para isso, o resultado do `assertThrows` é armazenado em uma variável:

```java
IllegalArgumentException excecao = assertThrows(
        IllegalArgumentException.class,
        () -> account.sacar(600, false)
);
```

Depois, a mensagem pode ser validada:

```java
assertEquals(
        "Saque acima do limite exige atendimento da agência",
        excecao.getMessage()
);
```

Dessa forma, o teste verifica:

1. Se a exceção correta foi lançada.
2. Se a mensagem da exceção está correta.

---

# 🏦 DigitalAccount

A classe `DigitalAccount` é utilizada como exemplo principal para a criação dos testes.

Ela representa uma conta digital e possui informações como:

- **Titular**
- **Saldo**
- **Tipo da conta**

A classe possui dois tipos de conta:

- `TIPO_CORRENTE`
- `TIPO_POUPANCA`

A implementação contém operações relacionadas ao comportamento de uma conta digital.

Entre os principais métodos estão:

- `depositar`
- `getSaldo`
- `sacar`
- `isContaCorrente`
- `extrairDigitos`

---

# 💰 Depósito

O método `depositar` adiciona um valor ao saldo atual da conta.

Exemplo:

```java
double saldo = account.depositar(500, true);

assertEquals(1500, saldo, 0.00);
```

Considerando uma conta com saldo inicial de R$ 1.000,00:

```text
Saldo inicial: R$ 1.000,00
Depósito:      R$   500,00
Saldo final:   R$ 1.500,00
```

O teste verifica se o resultado da operação corresponde ao saldo esperado.

---

# 💳 Consulta de Saldo

O método `getSaldo` permite consultar o saldo atual da conta.

O teste pode realizar um depósito e posteriormente verificar o saldo:

```java
account.depositar(500, true);

assertEquals(1500, account.getSaldo(), 0.00);
```

Esse teste permite verificar se o saldo foi corretamente atualizado após uma operação de depósito.

---

# 🏦 Tipo da Conta

A classe `DigitalAccount` possui dois tipos de conta:

```java
public static final int TIPO_CORRENTE = 1;
public static final int TIPO_POUPANCA = 2;
```

O método `isContaCorrente()` permite verificar se a conta é do tipo corrente.

Um teste positivo pode ser realizado através do `assertTrue`:

```java
assertTrue(account.isContaCorrente());
```

Enquanto uma conta poupança pode ser validada utilizando `assertFalse`:

```java
DigitalAccount poupanca = new DigitalAccount(
        "Marina",
        1000,
        DigitalAccount.TIPO_POUPANCA
);

assertFalse(poupanca.isContaCorrente());
```

---

# 💸 Saque

O método `sacar` é utilizado para retirar valores do saldo da conta.

Um saque realizado dentro do limite pode ser testado normalmente:

```java
double saldo = account.sacar(300, false);

assertEquals(700, saldo, 0.00);
```

Considerando uma conta com saldo inicial de R$ 1.000,00:

```text
Saldo inicial: R$ 1.000,00
Saque:         R$   300,00
Saldo final:   R$   700,00
```

---

# 🚨 Limite de Saque

A aplicação possui uma regra para saques superiores a R$ 500,00.

Quando o saque ultrapassa esse valor e não é realizado através da agência, uma `IllegalArgumentException` é lançada.

O comportamento é validado utilizando `assertThrows`:

```java
@Test
void sacar_acimaDoLimite_semAgencia() {

    assertThrows(
            IllegalArgumentException.class,
            () -> account.sacar(600, false)
    );
}
```

Também é possível verificar a mensagem retornada pela exceção:

```java
@Test
void sacar_acimaDoLimite_deveInformarMensagem() {

    IllegalArgumentException excecao = assertThrows(
            IllegalArgumentException.class,
            () -> account.sacar(600, false)
    );

    assertEquals(
            "Saque acima do limite exige atendimento da agência",
            excecao.getMessage()
    );
}
```

---

# 🔢 Extração de Dígitos Verificadores

A classe também possui o método:

```java
DigitalAccount.extrairDigitos("CZ-4291-2");
```

Esse método retorna um array contendo os caracteres correspondentes aos dígitos esperados.

O teste utiliza `assertArrayEquals`:

```java
@Test
void extrairDigitosVerificadores() {

    char[] esperado = {'4', '2'};

    char[] resultado =
            DigitalAccount.extrairDigitos("CZ-4291-2");

    assertArrayEquals(esperado, resultado);
}
```

O teste compara o resultado obtido com o array esperado.

---

# 🔄 BeforeEach

O `@BeforeEach` é executado antes de cada método de teste.

No projeto, ele é utilizado para criar uma nova conta antes da execução de cada teste:

```java
@BeforeEach
void setUp() {

    account = new DigitalAccount(
            "Marina",
            1000,
            DigitalAccount.TIPO_CORRENTE
    );
}
```

Isso permite que cada teste comece com uma conta em um estado conhecido.

---

# 🧹 AfterEach

O `@AfterEach` é executado depois de cada teste.

No projeto, ele é utilizado para remover a referência da conta utilizada:

```java
@AfterEach
void tearDown() {

    account = null;
}
```

Esse recurso ajuda a manter uma estrutura organizada para preparação e finalização dos testes.

---

# 🔬 Independência dos Testes

Um dos conceitos importantes trabalhados no projeto é a independência entre os testes.

Cada teste deve possuir seu próprio cenário e não depender do resultado de outro teste.

Por exemplo, o teste de depósito não deve depender da execução anterior de um teste de saque.

Para isso, o `@BeforeEach` cria uma nova instância de `DigitalAccount` antes de cada teste.

Dessa maneira, cada teste começa novamente com:

```text
Titular:       Marina
Saldo inicial: R$ 1.000,00
Tipo:          Conta corrente
```

---

# 🧪 Estrutura dos Testes

A classe `DigitalAccountTest` utiliza uma estrutura organizada para os testes.

Exemplo:

```java
class DigitalAccountTest {

    private DigitalAccount account;

    @BeforeEach
    void setUp() {
        account = new DigitalAccount(
                "Marina",
                1000,
                DigitalAccount.TIPO_CORRENTE
        );
    }

    @AfterEach
    void tearDown() {
        account = null;
    }

    @Test
    void depositar() {

        double saldo = account.depositar(500, true);

        assertEquals(1500, saldo, 0.00);
    }
}
```

Essa estrutura separa:

- Preparação do cenário
- Execução do comportamento
- Validação do resultado
- Finalização do teste

---

# 📂 Estrutura do Projeto

A estrutura do projeto está organizada da seguinte forma:

- `materiais_de_estudo` — contém os materiais utilizados durante os estudos.
- `praticas` — contém os exercícios e desafios realizados durante o módulo.
- `DigitalAccount` — classe utilizada nos exemplos práticos.
- `DigitalAccountTest` — classe responsável pelos testes automatizados.

---

# 🛠️ Tecnologias Utilizadas

- **Java**
- **JUnit 4**
- **JUnit 5**
- **JUnit Jupiter**

---

# 💡 Conceitos-Chave Aprendidos

Durante o desenvolvimento do projeto foram praticados conceitos como:

- Testes unitários
- JUnit
- JUnit 4
- JUnit 5
- Jupiter
- Assertions
- `assertEquals`
- `assertNotEquals`
- `assertTrue`
- `assertFalse`
- `assertNull`
- `assertNotNull`
- `assertSame`
- `assertNotSame`
- `assertArrayEquals`
- `assertThrows`
- Testes de exceções
- Mensagens de exceção
- `@Test`
- `@BeforeEach`
- `@AfterEach`
- Independência entre testes
- Organização de testes
- Validação de resultados

---

# 📖 Boas Práticas Trabalhadas

Durante o desenvolvimento dos testes, também são praticadas algumas boas práticas importantes:

- Criar testes independentes.
- Utilizar nomes que descrevam o comportamento testado.
- Evitar que um teste dependa de outro.
- Preparar o cenário antes de cada teste.
- Utilizar assertions adequadas para cada situação.
- Testar tanto comportamentos positivos quanto comportamentos que devem gerar exceções.
- Validar mensagens de exceção quando necessário.
- Manter os testes simples e fáceis de entender.
- Organizar os testes de acordo com o comportamento da aplicação.

---

# 🎓 Resumo de Aprendizagem

O projeto foi desenvolvido como uma forma prática de consolidar os conhecimentos estudados sobre **Testes Unitários com JUnit**.

Durante sua construção, foram estudadas diferentes formas de validar o comportamento de uma aplicação Java através de testes automatizados.

Foram utilizados diferentes tipos de assertions para validar valores, condições, objetos, arrays e exceções.

Também foram trabalhados recursos como `@BeforeEach` e `@AfterEach`, permitindo compreender como preparar e finalizar os cenários de teste.

O projeto também demonstra a importância da independência entre os testes, garantindo que cada teste possua seu próprio cenário e possa ser executado de forma isolada.

Além disso, os testes de exceções permitem validar não apenas se uma exceção foi lançada, mas também se ela corresponde ao tipo esperado e possui a mensagem correta.

---

# 🚀 Objetivo Final

O objetivo final do projeto é servir como uma demonstração prática dos conhecimentos adquiridos em **Testes Unitários com Java e JUnit**.

O projeto faz parte dos estudos de Java e tem como foco principal:

- **Aprendizado**
- **Prática**
- **Testes automatizados**
- **Validação de comportamento**
- **Qualidade de código**
- **Demonstração de conhecimento**

Através do desenvolvimento dos testes, o projeto busca consolidar os fundamentos necessários para criar, organizar e executar testes unitários em aplicações Java.

O conhecimento adquirido neste módulo também serve como base para estudos posteriores relacionados a testes automatizados, qualidade de software e desenvolvimento orientado por testes.
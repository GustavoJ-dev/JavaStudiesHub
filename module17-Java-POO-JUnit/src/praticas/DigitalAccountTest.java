package praticas;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Classe responsável por testar as funcionalidades da classe {@link DigitalAccount}.
 *
 * <p>
 * Os testes utilizam JUnit 5 (Jupiter) e verificam operações como:
 * depósito, consulta de saldo, tipo de conta, saque e diferentes asserções.
 * </p>
 */
class DigitalAccountTest {

    /**
     * Conta utilizada pelos testes.
     *
     * <p>
     * Uma nova conta é criada antes da execução de cada teste
     * através do método {@link #setUp()}.
     * </p>
     */
    private DigitalAccount account;

    /**
     * Prepara o cenário antes de cada teste.
     *
     * <p>
     * Cada teste recebe uma nova conta com saldo inicial de R$ 1.000,00.
     * Isso garante que os testes sejam independentes uns dos outros.
     * </p>
     */
    @BeforeEach
    void setUp() {account = new DigitalAccount(
                "Marina",
                1000,
                DigitalAccount.TIPO_CORRENTE);
    }

    /**
     * Executado após cada teste.
     *
     * <p>
     * Remove a referência da conta utilizada pelo teste.
     * </p>
     */
    @AfterEach
    void tearDown() {
        account = null;
    }

    /**
     * Testa o depósito de dinheiro na conta.
     *
     * <p>
     * Uma conta com R$ 1.000,00 recebe um depósito de R$ 500,00.
     * O saldo esperado é R$ 1.500,00.
     * </p>
     */
    @Test
    void depositar() {

        double saldo = account.depositar(500, true);

        assertEquals(1500, saldo, 0.00);
    }

    /**
     * Testa a consulta do saldo após realizar um depósito.
     *
     * <p>
     * O saldo inicial é de R$ 1.000,00.
     * Após depositar R$ 500,00, o saldo esperado é R$ 1.500,00.
     * </p>
     */
    @Test
    void getSaldo_aposDeposito() {

        account.depositar(500, true);

        assertEquals(1500, account.getSaldo(), 0.00);
    }

    /**
     * Verifica se a conta criada é uma conta corrente.
     */
    @Test
    void deveSerContaCorrente() {

        assertTrue(account.isContaCorrente());
    }

    /**
     * Verifica se uma conta poupança não é identificada como conta corrente.
     */
    @Test
    void naoDeveSerContaCorrente() {

        DigitalAccount poupanca = new DigitalAccount(
                "Marina",
                1000,
                DigitalAccount.TIPO_POUPANCA);

        assertFalse(poupanca.isContaCorrente());
    }

    /**
     * Testa um saque realizado dentro do limite permitido.
     *
     * <p>
     * A conta possui R$ 1.000,00 e realiza um saque de R$ 300,00.
     * O saldo esperado após o saque é R$ 700,00.
     * </p>
     */
    @Test
    void sacar_dentroDoLimite() {

        double saldo = account.sacar(300, false);

        assertEquals(700, saldo, 0.00);
    }

    /**
     * Verifica se um saque acima do limite, realizado sem atendimento
     * em agência, lança uma {@link IllegalArgumentException}.
     *
     * <p>
     * O saque de R$ 600,00 ultrapassa o limite permitido para uma operação
     * realizada fora da agência.
     * </p>
     */
    @Test
    void sacar_acimaDoLimite_semAgencia() {

        assertThrows(
                IllegalArgumentException.class,
                () -> account.sacar(600, false));
    }

    /**
     * Verifica se a exceção lançada ao realizar um saque acima do limite
     * possui a mensagem esperada.
     *
     * <p>
     * Além de verificar o tipo da exceção, este teste verifica o conteúdo
     * da mensagem retornada pela exceção.
     * </p>
     */
    @Test
    void sacar_acimaDoLimite_deveInformarMensagem() {

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> account.sacar(600, false));

        assertEquals(
                "Saque acima do limite exige atendimento da agência",
                excecao.getMessage());
    }

    /**
     * Verifica se o saldo após o depósito é diferente do saldo inicial.
     */
    @Test
    void saldoNaoDeveSerDiferenteDoEsperado() {

        account.depositar(500, true);

        assertNotEquals(1000, account.getSaldo());
    }

    /**
     * Testa a extração dos dígitos verificadores.
     *
     * <p>
     * Para o código "CZ-4291-2", os dígitos verificadores esperados são
     * '4' e '2'.
     * </p>
     */
    @Test
    void extrairDigitosVerificadores() {

        char[] esperado = {'4', '2'};

        char[] resultado = DigitalAccount.extrairDigitos("CZ-4291-2");

        assertArrayEquals(esperado, resultado);
    }

    /**
     * Verifica se uma referência de objeto possui valor nulo.
     */
    @Test
    void objetoDeveSerNulo() {

        DigitalAccount conta = null;

        assertNull(conta);
    }

    /**
     * Verifica se a conta criada no {@link #setUp()} não é nula.
     */
    @Test
    void contaNaoDeveSerNula() {

        assertNotNull(account);
    }

    /**
     * Verifica se duas referências apontam para o mesmo objeto.
     */
    @Test
    void deveSerOMesmoObjeto() {

        DigitalAccount outraReferencia = account;

        assertSame(account, outraReferencia);
    }

    /**
     * Verifica se duas contas são objetos diferentes.
     */
    @Test
    void naoDevemSerOMesmoObjeto() {

        DigitalAccount outraConta = new DigitalAccount(
                "João",
                500,
                DigitalAccount.TIPO_CORRENTE);

        assertNotSame(account, outraConta);
    }
}
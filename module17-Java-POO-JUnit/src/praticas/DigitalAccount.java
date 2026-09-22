package praticas;

/**
 * Representa uma conta digital.
 *
 * <p>
 * A conta possui um titular, um saldo e um tipo de conta.
 * É possível realizar depósitos, saques, consultar o saldo
 * e verificar se a conta é do tipo corrente.
 * </p>
 */
public class DigitalAccount {

    /**
     * Representa o tipo de conta corrente.
     */
    public static final int TIPO_CORRENTE = 1;

    /**
     * Representa o tipo de conta poupança.
     */
    public static final int TIPO_POUPANCA = 2;

    /**
     * Nome do titular da conta.
     */
    private String titular;

    /**
     * Saldo atual da conta.
     */
    private double saldo;

    /**
     * Tipo da conta.
     *
     * <p>
     * Pode ser {@link #TIPO_CORRENTE} ou {@link #TIPO_POUPANCA}.
     * </p>
     */
    private int tipoConta;

    /**
     * Cria uma nova conta digital.
     *
     * @param titular nome do titular da conta
     * @param saldo saldo inicial da conta
     * @param tipoConta tipo da conta, podendo ser corrente ou poupança
     */
    public DigitalAccount(String titular, double saldo, int tipoConta) {
        this.titular = titular;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
    }

    /**
     * Extrai os dígitos verificadores de uma sequência.
     *
     * <p>
     * O método considera os caracteres que estão entre as posições
     * 3 e 4 da String informada.
     * </p>
     *
     * @param s sequência da qual os dígitos serão extraídos
     * @return um array de caracteres contendo os dígitos extraídos
     */
    public static char[] extrairDigitos(String s) {
        return s.substring(3, 5).toCharArray();
    }

    /**
     * Realiza um depósito na conta.
     *
     * <p>
     * O valor informado é adicionado ao saldo atual da conta.
     * </p>
     *
     * @param valor valor que será depositado
     * @param viaAgencia indica se a operação foi realizada através da agência
     * @return o novo saldo da conta após o depósito
     */
    public double depositar(double valor, boolean viaAgencia) {
        this.saldo += valor;
        return this.saldo;
    }

    /**
     * Retorna o saldo atual da conta.
     *
     * @return saldo atual da conta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Realiza um saque na conta.
     *
     * <p>
     * Quando o valor do saque é superior a R$ 500,00 e a operação
     * não é realizada através da agência, uma
     * {@link IllegalArgumentException} é lançada.
     * </p>
     *
     * @param valor valor que será sacado
     * @param viaAgencia indica se a operação foi realizada através da agência
     * @return o novo saldo da conta após o saque
     * @throws IllegalArgumentException quando o saque é superior a R$ 500,00
     *                                  e não é realizado através da agência
     */
    public double sacar(double valor, boolean viaAgencia) {

        if (valor > 500 && !viaAgencia) {

            throw new IllegalArgumentException("Saque acima do limite exige atendimento da agência");
        }

        saldo -= valor;

        return saldo;
    }

    /**
     * Verifica se a conta é uma conta corrente.
     *
     * @return {@code true} se a conta for corrente;
     *         {@code false} caso seja poupança
     */
    public boolean isContaCorrente() {
        return tipoConta == TIPO_CORRENTE;
    }
}

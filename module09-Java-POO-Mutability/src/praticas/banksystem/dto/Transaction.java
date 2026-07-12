package praticas.banksystem.dto;

/**
 * Representa uma transação bancária.
 * <p>
 * Cada transação registra o banco responsável, o cliente envolvido,
 * um identificador único e o valor movimentado.
 * </p>
 */
public class Transaction {

    /** Número de identificação do banco. */
    private int routingNumber;

    /** Identificador da transação. */
    private long transactionId;

    /** Identificador do cliente. */
    private int customerId;

    /** Valor da transação. */
    private double amount;

    /**
     * Cria uma nova transação.
     *
     * @param routingNumber número de identificação do banco.
     * @param transactionId identificador da transação.
     * @param customerId identificador do cliente.
     * @param amount valor da transação.
     */
    public Transaction(int routingNumber,
                       long transactionId,
                       int customerId,
                       double amount) {

        this.routingNumber = routingNumber;
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.amount = amount;
    }

    /**
     * Retorna o número de identificação do banco.
     *
     * @return número do banco.
     */
    public int getRoutingNumber() {
        return routingNumber;
    }

    /**
     * Define o número de identificação do banco.
     *
     * @param routingNumber novo número do banco.
     */
    public void setRoutingNumber(int routingNumber) {
        this.routingNumber = routingNumber;
    }

    /**
     * Retorna o identificador da transação.
     *
     * @return identificador da transação.
     */
    public long getTransactionId() {
        return transactionId;
    }

    /**
     * Define o identificador da transação.
     *
     * @param transactionId novo identificador da transação.
     */
    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Retorna o identificador do cliente.
     *
     * @return identificador do cliente.
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Define o identificador do cliente.
     *
     * @param customerId novo identificador do cliente.
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Retorna o valor da transação.
     *
     * @return valor da transação.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Define o valor da transação.
     *
     * @param amount novo valor da transação.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Retorna uma representação textual formatada da transação.
     *
     * @return dados formatados da transação.
     */
    @Override
    public String toString() {
        return "%015d:%020d:%015d:%012.2f".formatted(
                routingNumber,
                customerId,
                transactionId,
                amount);
    }
}

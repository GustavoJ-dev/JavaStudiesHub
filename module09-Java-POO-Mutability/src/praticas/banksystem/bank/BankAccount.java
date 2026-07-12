package praticas.banksystem.bank;

import praticas.banksystem.dto.Transaction;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Representa uma conta bancária pertencente a um cliente.
 *
 * Cada conta possui um tipo, um saldo e um histórico de transações
 * registradas pelo banco.
 *
 */
public class BankAccount {

    /**
     * Representa os tipos de contas disponíveis no banco.
     */
    public enum AccountType {

        /** Conta de verificação (corrente). */
        VERIFICACAO("VERIFICAÇÃO"),

        /** Conta poupança. */
        POUPANCA("POUPANÇA");

        /** Descrição amigável do tipo da conta. */
        private final String descricao;

        /**
         * Cria um tipo de conta.
         *
         * @param descricao descrição do tipo de conta.
         */
        AccountType(String descricao) {

            this.descricao = descricao;
        }

        /**
         * Retorna a descrição do tipo de conta.
         *
         * @return descrição do tipo da conta.
         */
        public String getDescricao() {

            return descricao;
        }

        /**
         * Retorna a descrição do tipo de conta.
         *
         * @return descrição formatada do tipo da conta.
         */
        @Override
        public String toString() {

            return descricao;
        }
    }

    /** Tipo da conta bancária. */
    private final AccountType accountType;

    /** Saldo atual da conta. */
    private double balance;

    /** Histórico de transações da conta. */
    private final Map<Long, Transaction> transactions = new LinkedHashMap<>();

    /**
     * Cria uma nova conta bancária.
     *
     * @param accountType tipo da conta.
     * @param balance saldo inicial da conta.
     */
    BankAccount(AccountType accountType, double balance) {

        this.accountType = accountType;
        this.balance = balance;
    }

    /**
     * Retorna o tipo da conta.
     *
     * @return tipo da conta.
     */
    public AccountType getAccountType() {

        return accountType;
    }

    /**
     * Retorna o saldo atual da conta.
     *
     * @return saldo da conta.
     */
    public double getBalance() {

        return balance;
    }

    /**
     * Retorna o histórico de transações da conta.
     * <p>
     * O mapa retornado contém o identificador da transação como chave
     * e sua representação textual como valor.
     * </p>
     *
     * @return mapa contendo as transações registradas.
     */
    public Map<Long, String> getTransactions() {

        Map<Long, String> txMap = new LinkedHashMap<>();

        for (var tx : transactions.entrySet()) {

            txMap.put(tx.getKey(), tx.getValue().toString());
        }

        return txMap;
    }

    /**
     * Retorna uma representação textual da conta.
     *
     * @return tipo da conta e saldo atual.
     */
    @Override
    public String toString() {

        return "%s $%.2f".formatted(accountType, balance);
    }

    /**
     * Registra uma transação na conta e atualiza o saldo.
     *
     * @param routingNumber número de identificação do banco.
     * @param transactionId identificador da transação.
     * @param customerId identificador do cliente.
     * @param amount valor da transação.
     */
    void commitTransaction(int routingNumber, long transactionId, String customerId,
                           double amount) {

        balance += amount;

        transactions.put(transactionId, new Transaction(routingNumber, transactionId,
                        Integer.parseInt(customerId), amount));
    }
}


package praticas.banksystem.bank;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa um banco responsável por gerenciar clientes e suas transações.
 *
 * Cada cliente possui contas bancárias cadastradas, e o banco é responsável
 * por localizar clientes, adicionar novos clientes e registrar transações
 * em suas contas.
 *
 */
public class Bank {

    /** Número de roteamento (identificação) do banco. */
    private final int routingNumber;

    /** Identificador da próxima transação a ser registrada. */
    private long lastTransactionId = 1;

    /** Mapa contendo os clientes cadastrados, indexados pelo ID do cliente. */
    private final Map<String, BankCustomer> customers;

    /**
     * Cria um novo banco.
     *
     * @param routingNumber número de identificação do banco.
     */
    public Bank(int routingNumber) {

        this.routingNumber = routingNumber;
        customers = new HashMap<>();
    }

    /**
     * Retorna um cliente a partir do seu identificador.
     *
     * @param id identificador do cliente.
     * @return o cliente correspondente ou {@code null} caso não exista.
     */
    public BankCustomer getBankCostumer(String id) {

        BankCustomer costumer = customers.get(id);
        return costumer;
    }

    /**
     * Adiciona um novo cliente ao banco.
     *
     * @param name nome do cliente.
     * @param checkingInitialDeposit depósito inicial da conta corrente.
     * @param savingsInitialDeposit depósito inicial da conta poupança.
     */
    public void addCustomer(String name,
                            double checkingInitialDeposit,
                            double savingsInitialDeposit) {

        BankCustomer customer = new BankCustomer(
                name,
                checkingInitialDeposit,
                savingsInitialDeposit);

        customers.put(customer.getCustomerId(), customer);
    }

    /**
     * Realiza uma transação em uma das contas do cliente.
     *
     * Valores positivos representam depósitos e valores negativos representam
     * saques. Caso o saldo seja insuficiente ou o cliente/conta não exista,
     * a transação não será realizada.
     *
     *
     * @param id identificador do cliente.
     * @param accountType tipo da conta que receberá a transação.
     * @param amount valor da transação.
     * @return {@code true} se a transação foi realizada com sucesso;
     *         {@code false} caso contrário.
     */
    public boolean doTransaction(String id,
                                 BankAccount.AccountType accountType,
                                 double amount) {

        BankCustomer customer = customers.get(id);

        if (customer != null) {

            BankAccount account = customer.getAccount(accountType);

            if (account != null) {

                if ((account.getBalance() + amount) < 0) {

                    System.out.println("Fundos Insuficientes");

                } else {

                    account.commitTransaction(
                            routingNumber,
                            lastTransactionId++,
                            id,
                            amount);

                    return true;
                }
            }

        } else {

            System.out.println("Id do cliente Inválido");
        }

        return false;
    }
}
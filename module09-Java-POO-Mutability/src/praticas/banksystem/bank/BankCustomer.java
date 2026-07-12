package praticas.banksystem.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Representa um cliente do banco.
 *
 * Cada cliente possui um identificador único, um nome e duas contas
 * bancárias criadas automaticamente no momento do cadastro:
 * uma conta de verificação e uma conta poupança.
 *
 */
public class BankCustomer {

    /** Próximo identificador disponível para novos clientes. */
    private static int lastCustomerId = 10_000_000;

    /** Nome do cliente. */
    private final String name;

    /** Identificador único do cliente. */
    private final int customerId;

    /** Lista de contas pertencentes ao cliente. */
    private final List<BankAccount> accounts = new ArrayList<>();

    /**
     * Cria um novo cliente e inicializa suas contas bancárias.
     *
     * @param name nome do cliente.
     * @param checkingAmount depósito inicial da conta de verificação.
     * @param savingsAmount depósito inicial da conta poupança.
     */
    BankCustomer(String name,
                 double checkingAmount,
                 double savingsAmount) {

        this.name = name;
        this.customerId = lastCustomerId++;

        accounts.add(new BankAccount(
                BankAccount.AccountType.VERIFICACAO,
                checkingAmount));

        accounts.add(new BankAccount(
                BankAccount.AccountType.POUPANCA,
                savingsAmount));
    }

    /**
     * Retorna o nome do cliente.
     *
     * @return nome do cliente.
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna o identificador do cliente formatado com quinze dígitos.
     *
     * @return identificador formatado do cliente.
     */
    public String getCustomerId() {
        return "%015d".formatted(customerId);
    }

    /**
     * Retorna uma cópia imutável da lista de contas do cliente.
     *
     * @return lista de contas bancárias.
     */
    public List<BankAccount> getAccounts() {
        return List.copyOf(accounts);
    }

    /**
     * Retorna uma conta de acordo com o tipo informado.
     *
     * @param type tipo da conta desejada.
     * @return a conta correspondente ou {@code null} caso não exista.
     */
    public BankAccount getAccount(BankAccount.AccountType type) {

        for (var account : accounts) {
            if (account.getAccountType() == type) {
                return account;
            }
        }
        return null;
    }

    /**
     * Retorna uma representação textual do cliente e de suas contas.
     *
     * @return informações formatadas do cliente e suas contas.
     */
    @Override
    public String toString() {

        String[] accountStrings = new String[accounts.size()];
        Arrays.setAll(accountStrings, i -> accounts.get(i).toString());

        return "Cliente: %s (id:%015d)%n\t%s%n".formatted(
                name,
                customerId,
                String.join("\n\t", accountStrings));
    }
}

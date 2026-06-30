package pratices.javaLists.challenges.banking.bank.customer;

import java.util.ArrayList;

/**
 * Record que representa um cliente bancário.
 * Armazena o nome do cliente e seu histórico de transações.
 *
 * @param name Nome do cliente (convertido para maiúsculas automaticamente)
 * @param transactions Lista de transações do cliente (créditos e débitos)
 */
public record Customer(String name, ArrayList<Double> transactions) {

    /**
     * Construtor compacto para criar um novo cliente com depósito inicial.
     * O nome é automaticamente convertido para maiúsculas.
     * Uma lista de transações é criada com capacidade inicial de 500 itens.
     *
     * @param name Nome do cliente
     * @param initialDeposit Valor do depósito inicial (primeira transação)
     */
    public Customer(String name, double initialDeposit) {
        this(name.toUpperCase(),
                new ArrayList<Double>(500));
        transactions.add(initialDeposit);
    }

    /**
     * Retorna a representação em string do cliente.
     *
     * @return O nome do cliente
     */
    @Override
    public String toString() {
        return name;
    }
}

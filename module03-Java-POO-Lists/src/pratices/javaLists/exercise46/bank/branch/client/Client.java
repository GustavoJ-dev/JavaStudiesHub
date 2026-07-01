package pratices.javaLists.exercise46.bank.branch.client;

import java.util.ArrayList;

/**
 * Representa um cliente de um banco.
 * 
 * Cada cliente possui um nome único e mantém um histórico de transações
 * (depósitos ou saques). A primeira transação é definida no momento da
 * criação do cliente.
 *
 */
public class Client {

    /** Nome do cliente */
    private String name;
    
    /** Lista de todas as transações do cliente */
    private ArrayList<Double> transactions;

    /**
     * Constrói um novo cliente com um depósito inicial.
     * 
     * @param name Nome do cliente
     * @param initialTransactions Valor do depósito inicial
     */
    public Client(String name, double initialTransactions) {
        this.name = name;
        this.transactions = new ArrayList<>();
        this.transactions.add(initialTransactions);
    }

    /**
     * Retorna o nome do cliente.
     * 
     * @return Nome do cliente
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna a lista de todas as transações do cliente.
     * 
     * @return ArrayList contendo os valores das transações
     */
    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    /**
     * Adiciona uma nova transação ao histórico do cliente.
     * 
     * @param transaction Valor da transação a ser adicionada
     */
    public void addTransaction(double transaction){
        this.transactions.add(transaction);
    }
}

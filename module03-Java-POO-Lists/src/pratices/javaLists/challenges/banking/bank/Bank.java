package pratices.javaLists.challenges.banking.bank;

import pratices.javaLists.challenges.banking.bank.customer.Customer;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Classe que representa um banco.
 * Gerencia uma lista de clientes, permitindo adicionar novos clientes,
 * registrar transações e exibir extratos bancários.
 *
 */
public class Bank {

    private String name;
    private ArrayList<Customer> customers = new ArrayList<>(5000);

    /**
     * Construtor que inicializa um novo banco com o nome especificado.
     *
     * @param name Nome do banco
     */
    public Bank(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }

    /**
     * Busca um cliente pelo nome (case-insensitive).
     *
     * @param customerName Nome do cliente a ser buscado
     * @return O cliente encontrado ou {@code null} se não encontrado
     */
    private Customer getCustomer(String customerName) {

        for (var customer : customers) {
            if (customer.name().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }

        return null;
    }

    /**
     * Adiciona um novo cliente ao banco se o cliente ainda não existir.
     * O cliente será criado com o nome especificado e um depósito inicial.
     *
     * @param customerName Nome do cliente a ser cadastrado
     * @param initialDeposit Valor do depósito inicial (pode ser negativo)
     */
    public void addNewCustomer(String customerName, double initialDeposit){

        if (getCustomer(customerName) == null){
            Customer customer = new Customer(customerName, initialDeposit);
            customers.add(customer);
            System.out.println("Novo cliente registrado: " + customer);
        }
    }

    /**
     * Registra uma transação para um cliente existente.
     * A transação é adicionada à lista de transações do cliente.
     * Valores positivos representam créditos e valores negativos representam débitos.
     *
     * @param name Nome do cliente que realizará a transação
     * @param transaction Valor da transação (positivo para crédito, negativo para débito)
     */
    public void addTransaction(String name, double transaction){

        Customer customer = getCustomer(name);
        if (customer != null){
            customer.transactions()
                            .add(transaction);

            System.out.printf("O cliente (%s) moveu o valor de (%.2f)!", name, transaction);
        }else {
            System.out.printf("O cliente (%s) não foi encontrado%n", name);
        }

    }

    /**
     * Exibe o extrato bancário de um cliente.
     * Mostra o nome do cliente e todas as suas transações (créditos e débitos).
     * Se o cliente não for encontrado, o metodo retorna sem exibir nada.
     *
     * @param customerName Nome do cliente cujo extrato será exibido
     */
    public void printStatement(String customerName){

       Customer customer = getCustomer(customerName);

       if (customer == null){
           return;
       }
        System.out.println("_".repeat(30));
        System.out.println("Nome do cliente: " + customer.name());
        System.out.println("Transações:");

        for (double d : customer.transactions()){
            System.out.printf("$%10.2f (%s)%n", d, d < 0 ? "Debit" : "Credit");
        }
    }

}

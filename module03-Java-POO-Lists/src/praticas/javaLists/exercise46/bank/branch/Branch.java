package praticas.javaLists.exercise46.bank.branch;

import praticas.javaLists.exercise46.bank.branch.client.Client;

import java.util.ArrayList;

/**
 * Representa uma agência de um banco.
 * 
 * Uma agência gerencia uma coleção de clientes e permite operações como
 * cadastro de novos clientes, adição de transações e busca de clientes
 * pelo nome.
 *
 */
public class Branch {

    /** Nome da agência */
    private String name;
    
    /** Lista de clientes cadastrados na agência */
    private ArrayList<Client> customers;

    /**
     * Constrói uma nova agência com um nome específico.
     * 
     * @param name Nome da agência
     */
    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    /**
     * Retorna o nome da agência.
     * 
     * @return Nome da agência
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna a lista de clientes da agência.
     * 
     * @return ArrayList contendo todos os clientes
     */
    public ArrayList<Client> getCustomers() {
        return customers;
    }

    /**
     * Cadastra um novo cliente na agência com um depósito inicial.
     * 
     * Não permite cadastrar clientes com nomes duplicados.
     * 
     * @param name Nome do cliente
     * @param initialTransaction Valor do depósito inicial
     * @return true se o cliente foi cadastrado com sucesso, false caso contrário
     */
    public boolean addNewClient(String name, double initialTransaction){
        if (findClient(name) == null){
            this.customers.add(new Client(name, initialTransaction));
            return true;
        }
        return false;
    }

    /**
     * Adiciona uma transação ao histórico de um cliente específico.
     * 
     * @param name Nome do cliente
     * @param transaction Valor da transação
     * @return true se a transação foi adicionada com sucesso, false se o cliente não foi encontrado
     */
    public boolean addClientTransaction (String name, double transaction){
        Client client = findClient(name);
        if (client != null){
            client.addTransaction(transaction);
            return true;
        }
        return false;
    }

    /**
     * Busca um cliente pelo nome na agência.
     * 
     * @param name Nome do cliente a ser procurado
     * @return O cliente encontrado, ou null se não existir cliente com esse nome
     */
    public Client findClient(String name){
        for (int i = 0; i < customers.size(); i++){
            Client client = customers.get(i);
            if (client.getName().equals(name)){
                return client;
            }
        }
        return null;
    }
}

package praticas.javaLists.exercise46.bank;

import praticas.javaLists.exercise46.bank.branch.Branch;
import praticas.javaLists.exercise46.bank.branch.client.Client;

import java.util.ArrayList;

/**
 * Representa um banco com múltiplas agências.
 * 
 * A classe Bank gerencia um conjunto de agências e oferece funcionalidades para
 * cadastrar agências, adicionar clientes, registrar transações e listar informações.
 *
 */
public class Bank {

    /** Nome do banco */
    private String name;
    
    /** Lista de agências do banco */
    private ArrayList<Branch> branches;

    /**
     * Constrói um novo banco com um nome específico.
     * 
     * @param name Nome do banco
     */
    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    /**
     * Cadastra uma nova agência no banco.
     * 
     * Não permite cadastrar agências com nomes duplicados.
     * 
     * @param bankName Nome da agência a ser cadastrada
     * @return true se a agência foi cadastrada com sucesso, false se já existe uma agência com esse nome
     */
    public boolean addBranch(String bankName){

        if (findBranch(bankName) == null){
            this.branches.add(new Branch(bankName));
            return true;
        }
        return false;
    }

    /**
     * Adiciona um cliente a uma agência específica do banco.
     * 
     * @param bankName Nome da agência
     * @param clientName Nome do cliente
     * @param initialDeposit Valor do depósito inicial
     * @return true se o cliente foi adicionado com sucesso, false se a agência não foi encontrada
     */
    public boolean addClient(String bankName, String clientName,
                             double initialDeposit) {

        Branch branch = findBranch(bankName);
        if (branch != null) {
            return branch.addNewClient(clientName, initialDeposit);
        }
        return false;
    }

    /**
     * Busca uma agência pelo nome.
     * 
     * @param filialName Nome da agência a ser procurada
     * @return A agência encontrada, ou null se não existir agência com esse nome
     */
    public Branch findBranch(String filialName){

        for (int i =0; i < branches.size(); i++){
            Branch branch = branches.get(i);
            if (branch.getName().equals(filialName)){
                return branch;
            }
        }
        return null;
    }

    /**
     * Adiciona uma transação a um cliente específico de uma agência.
     * 
     * @param AgencyName Nome da agência
     * @param nameClient Nome do cliente
     * @param transaction Valor da transação
     * @return true se a transação foi adicionada com sucesso, false caso contrário
     */
    public boolean addClientTransaction(String AgencyName, String nameClient, double transaction){
       Branch branch = findBranch(AgencyName);
       if (branch != null){
           return branch.addClientTransaction(nameClient, transaction);
       }
       return false;
    }

    /**
     * Lista todos os clientes de uma agência específica.
     * 
     * Opcionalmente exibe também o histórico de transações de cada cliente.
     * 
     * @param branchName Nome da agência
     * @param showTransactions true para exibir transações dos clientes, false caso contrário
     * @return true se a agência foi encontrada, false caso contrário
     */
    public boolean listClients(String branchName, boolean showTransactions){

        Branch branch = findBranch(branchName);
        if (branch != null){
            System.out.println("Detalhes da Agência do cliente: " + branch.getName());

            ArrayList<Client> branchClients = branch.getCustomers();
            for (int i = 0; i < branchClients.size(); i++){

                Client branchClient = branchClients.get(i);
                System.out.println("Cliente: " + branchClient.getName() + "[" + (i + 1) + "]");


                if (showTransactions){

                    System.out.println("Transações:");
                    ArrayList<Double> transactions = branchClient.getTransactions();

                    for (int j = 0; j < transactions.size(); j++){

                        System.out.println("[" + (j + 1) + "] Valor: " + transactions.get(j));

                    }
                }
            }
            return true;
        }
        return false;
    }

}

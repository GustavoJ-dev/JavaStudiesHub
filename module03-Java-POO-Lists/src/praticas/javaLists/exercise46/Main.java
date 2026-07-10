package praticas.javaLists.exercise46;

import praticas.javaLists.exercise46.bank.Bank;
import praticas.javaLists.exercise46.bank.branch.Branch;

import java.util.Scanner;

/**
 * Classe principal que implementa o menu interativo do sistema bancário global.
 * 
 * Fornece uma interface para o usuário gerenciar bancos, agências, clientes
 * e transações através de um menu de linhas de comando.
 *
 */
public class Main {
    
    /** Scanner para leitura de entrada do usuário */
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        globalBankAgency();

    }

    /**
     * Executa o menu interativo do banco global.
     * 
     * Oferece as seguintes operações:
     *
     *   1 - Cadastrar um novo banco
     *   2 - Cadastrar uma nova agência
     *   3 - Cadastrar um novo cliente
     *   4 - Adicionar uma transação
     *   5 - Listar clientes
     *   6 - Sair
     *
     */
    public static void globalBankAgency(){
        Bank bank = null;
        boolean flag = true;

        while (flag) {

            System.out.println("\n===== BANCO GLOBAL =====");
            System.out.println("""
                1 - Cadastrar um novo Banco
                2 - Cadastrar uma nova Agência
                3 - Cadastrar um novo Cliente
                4 - Adicionar Transação
                5 - Listar Clientes
                6 - Sair
                """);

            System.out.print("Escolha uma opção: ");
            int inputUser = scanner.nextInt();
            scanner.nextLine();

            switch (inputUser) {

                case 1 -> {
                    System.out.print("Digite o nome do banco: ");
                    String bankName = scanner.nextLine();

                    bank = new Bank(bankName);

                    System.out.println("Banco \"" + bankName + "\" cadastrado com sucesso!");
                }

                case 2 -> {

                    if (bank == null) {
                        System.out.println("Primeiro cadastre um banco!");
                        break;
                    }

                    System.out.print("Digite o nome da agência: ");
                    String agencyName = scanner.nextLine();

                    bank.addBranch(agencyName);

                    System.out.println("Agência \"" + agencyName + "\" cadastrada com sucesso!");
                }

                case 3 -> {

                    if (bank == null) {
                        System.out.println("Primeiro cadastre um banco!");
                        break;
                    }

                    System.out.print("Digite o nome da agência: ");
                    String agencyName = scanner.nextLine();

                    Branch branch = bank.findBranch(agencyName);

                    if (branch == null) {
                        System.out.println("Agência não encontrada.");
                        break;
                    }

                    System.out.print("Digite o nome do cliente: ");
                    String clientName = scanner.nextLine();

                    System.out.print("Digite o depósito inicial: ");
                    double deposit = scanner.nextDouble();
                    scanner.nextLine();

                    branch.addNewClient(clientName, deposit);

                    System.out.println("Cliente cadastrado com sucesso!");
                }

                case 4 -> {
                    if (bank == null) {
                        System.out.println("Cadastre um banco primeiro!");
                        break;
                    }

                    System.out.print("Nome da agência: ");
                    String agencyName = scanner.nextLine();

                    System.out.print("Nome do cliente: ");
                    String clientName = scanner.nextLine();

                    System.out.print("Valor da transação: ");
                    double transaction = scanner.nextDouble();
                    scanner.nextLine();

                    if (bank.addClientTransaction(agencyName, clientName, transaction)) {
                        System.out.println("Transação adicionada!");
                    } else {
                        System.out.println("Erro ao adicionar transação.");
                    }
                }

                case 5 -> {

                    if (bank == null) {
                        System.out.println("Cadastre um banco primeiro!");
                        break;
                    }

                    System.out.print("Nome da agência: ");
                    String agencyName = scanner.nextLine();

                    System.out.print("Mostrar transações? (S/N): ");
                    boolean showTransactions =
                            scanner.nextLine().equalsIgnoreCase("S");

                    if (!bank.listClients(agencyName, showTransactions)) {
                        System.out.println("Agência não encontrada.");
                    }
                }

                case 6 -> {
                    System.out.println("Obrigado por usar o sistema!");
                    flag = false;
                }

                default -> System.out.println("Opção inválida!");

            }
        }


    }

}



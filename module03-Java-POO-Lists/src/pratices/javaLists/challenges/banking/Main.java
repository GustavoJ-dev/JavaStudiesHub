package pratices.javaLists.challenges.banking;

import pratices.javaLists.challenges.banking.bank.Bank;
import pratices.javaLists.challenges.banking.bank.customer.Customer;

import java.util.Scanner;

/**
 * Classe principal que gerencia a aplicação bancária.
 * Fornece um menu interativo para o usuário realizar operações bancárias,
 * como cadastrar clientes, adicionar transações, imprimir extratos e listar clientes.
 *
 */
public class Main {
    /**
     * Metodo principal da aplicação.
     * Demonstra o funcionamento do sistema bancário e inicializa o menu interativo.
     *
     */
    public static void main(String[] args) {
        client();
        Bank bancoDoBradesco = new Bank("Banco do Bradesco");
        menu(bancoDoBradesco);

    }

    /**
     * Metodo demonstrativo que cria um banco com clientes pré-cadastrados
     * e exibe seus extratos.
     */
    public static void client(){

        Bank bancoDoBrasil = new Bank("Banco do Brasil");

        bancoDoBrasil.addNewCustomer("Gustavo J", 0);
        bancoDoBrasil.addNewCustomer("Ana A", 600);
        bancoDoBrasil.addNewCustomer("Lara L", -200);

        System.out.println(bancoDoBrasil);

        bancoDoBrasil.printStatement("gustavo j");
        bancoDoBrasil.printStatement("Ana A");
        bancoDoBrasil.printStatement("lara L");
    }

    /**
     * Exibe um menu interativo que permite ao usuário realizar operações bancárias.
     * Oferece opções para:
     * 1 - Cadastrar novo cliente
     * 2 - Adicionar transação
     * 3 - Imprimir extrato
     * 4 - Listar todos os clientes
     * 0 - Sair da aplicação
     *
     * @param bank O banco onde as operações serão realizadas
     */
    public static void menu(Bank bank) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("""
                
                ===== BANCO =====
                1 - Cadastrar cliente
                2 - Adicionar transação
                3 - Imprimir extrato
                4 - Listar clientes
                0 - Sair
                """);

            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o Enter

            switch (opcao) {

                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Depósito inicial: ");
                    double deposito = scanner.nextDouble();
                    scanner.nextLine();

                    bank.addNewCustomer(nome, deposito);
                }

                case 2 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Valor da transação: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    bank.addTransaction(nome, valor);
                }

                case 3 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    bank.printStatement(nome);
                }

                case 4 -> System.out.println(bank);

                case 0 -> {
                    System.out.println("Encerrando...");
                    running = false;
                }

                default -> System.out.println("Opção inválida!");
            }
        }
    }
}

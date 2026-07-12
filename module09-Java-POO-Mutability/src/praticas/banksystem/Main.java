package praticas.banksystem;

import praticas.banksystem.bank.Bank;
import praticas.banksystem.bank.BankAccount;
import praticas.banksystem.bank.BankCustomer;

public class Main {

    public static void main(String[] args) {

        // Cria o banco
        Bank bank = new Bank(123456789);

        // Cadastra clientes
        bank.addCustomer("Gustavo", 1000.00, 5000.00);
        bank.addCustomer("Maria", 2000.00, 3000.00);

        // Recupera os clientes
        BankCustomer gustavo = bank.getBankCostumer("000000010000000");
        BankCustomer maria = bank.getBankCostumer("000000010000001");

        // Exibe os clientes
        System.out.println("=== CLIENTES CADASTRADOS ===");
        System.out.println(gustavo);
        System.out.println(maria);

        // Transações do Gustavo
        System.out.println("\n=== TRANSAÇÕES DO GUSTAVO ===");

        bank.doTransaction(gustavo.getCustomerId(), BankAccount.AccountType.VERIFICACAO, 500.00);

        bank.doTransaction(gustavo.getCustomerId(),
                BankAccount.AccountType.VERIFICACAO,
                -250.00);     // saque

        bank.doTransaction(
                gustavo.getCustomerId(),
                BankAccount.AccountType.POUPANCA,
                1200.00);     // depósito

        // Tentativa de saque acima do saldo
        bank.doTransaction(
                gustavo.getCustomerId(),
                BankAccount.AccountType.VERIFICACAO,
                -5000.00);

        // Transações da Maria
        System.out.println("\n=== TRANSAÇÕES DA MARIA ===");

        bank.doTransaction(
                maria.getCustomerId(),
                BankAccount.AccountType.POUPANCA,
                -1000.00);

        bank.doTransaction(
                maria.getCustomerId(),
                BankAccount.AccountType.VERIFICACAO,
                750.00);

        // Exibe situação final
        System.out.println("\n=== SALDOS FINAIS ===");
        System.out.println(gustavo);
        System.out.println(maria);

        // Histórico de transações do Gustavo
        System.out.println("\n=== HISTÓRICO - GUSTAVO ===");

        for (BankAccount account : gustavo.getAccounts()) {

            System.out.println("\nConta: " + account.getAccountType());

            account.getTransactions().forEach((id, transaction) ->
                    System.out.println(id + " -> " + transaction));
        }

        // Histórico de transações da Maria
        System.out.println("\n=== HISTÓRICO - MARIA ===");

        for (BankAccount account : maria.getAccounts()) {

            System.out.println("\nConta: " + account.getAccountType());

            account.getTransactions().forEach((id, transaction) ->
                    System.out.println(id + " -> " + transaction));
        }
    }
}

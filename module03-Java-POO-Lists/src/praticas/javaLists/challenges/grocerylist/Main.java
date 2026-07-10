package praticas.javaLists.challenges.grocerylist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Aplicação de gerenciamento de lista de compras.
 *
 * Esta aplicação permite ao usuário adicionar e remover itens de uma lista de compras.
 * Os itens são mantidos em ordem alfabética e exibidos após cada operação.
 *
 */
public class Main {

    /** Scanner para ler entrada do usuário do console */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Ponto de entrada principal da aplicação.
     * Inicia um loop interativo que permite ao usuário adicionar ou remover itens
     * da lista de compras até que opte por encerrar a aplicação.
     */
    public static void main(String[] args) {
        boolean flag = true;
        ArrayList<String> groceries = new ArrayList<>();
        while (flag){
            printActions();
            switch (Integer.parseInt(scanner.nextLine())){
                case 1 -> addItems(groceries);
                case 2 -> removeItens(groceries);
                default -> flag = false;
            }
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);
        }
    }

    /**
     * Adiciona um ou mais itens à lista de compras.
     * Os itens devem ser separados por vírgula e são adicionados apenas
     * se ainda não existirem na lista.
     *
     * @param groceries a lista de compras onde os itens serão adicionados
     */
    private static void addItems(ArrayList<String> groceries){
        System.out.println("Add item(s) [separate items by comma]:");
        String[] items = scanner.nextLine().split(",");
        for(String i : items){
            String trimmed = i.trim();
            if (groceries.indexOf(trimmed) < 0){
                groceries.add(trimmed);
            }
        }
    }

    /**
     * Remove um ou mais itens da lista de compras.
     * Os itens devem ser separados por vírgula.
     *
     * @param groceries a lista de compras de onde os itens serão removidos
     */
    private static void removeItens(ArrayList<String> groceries){
        System.out.println("Remove item(s) [separate items by comma]:");
        String[] items = scanner.nextLine().split(",");

        for (String i : items){
            String trimmed = i.trim();
            groceries.remove(trimmed);
        }
    }

    /**
     * Exibe as ações disponíveis no menu da aplicação.
     * Mostra as opções para adicionar itens, remover itens ou encerrar a aplicação.
     */
    private static void printActions(){

        String text = """
                Available actions:
                                
                0 - to shutdown
                                
                1 - to add item(s) to list (comma delimited list)
                                
                2 - to remove any items (comma delimited list)
                                
                Enter a number for which action you want to do: """;
        System.out.println(text);
    }
}

package praticas.Section04_flow_control.challenge21;

/**
 * Classe que contém uma atividade prática sobre o flow control.
 * Focada na impressão de todos os fatores positivos de um número inteiro.
 */
public class FactorsDigit {

    /**
     * Metodo principal para testar a funcionalidade de impressão de fatores.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("Fatores de 6:");
        printFactors(6); // 1, 2, 3, 6
        System.out.println("\nFatores de 32:");
        printFactors(32); // 1, 2, 4, 8, 16, 32
        System.out.println("\nFatores de -1:");
        printFactors(-1); // Invalid Value
        System.out.println("\nFatores de 1:");
        printFactors(1); // 1
    }

    /**
     * Imprime todos os fatores positivos de um número inteiro.
     * Um fator é um número que divide outro número exatamente, sem deixar resto.
     * Se o número for menor que 1, imprime "Invalid Value".
     *
     * @param number O número inteiro para o qual os fatores serão encontrados.
     */
    public static void printFactors(int number){
        if (number < 1) {
            System.out.println("Invalid Value");
            return; // Adicionado 'return' para sair do método após imprimir a mensagem de erro
        }
        for (int i = 1; i <= number; i++) {
            if(number % i == 0){ // Se o resto da divisão for 0, 'i' é um fator
                System.out.println(i);
            }
        }
    }
}

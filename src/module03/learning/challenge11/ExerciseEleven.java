package module03.learning.challenge11;

/**
 * Classe que contém a resolução do Exercício Onze do Módulo 03.
 * Focada na comparação de três números inteiros para determinar
 * se são todos iguais, todos diferentes, ou uma combinação.
 */
public class ExerciseEleven {

    /**
     * Metodo principal para testar a funcionalidade de comparação de números.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        printEqual(1, 1, 1); // All numbers are equal
        printEqual(1, 2, 1); // Neither all are equal or different
        printEqual(1, 2, 3); // All numbers are different
        printEqual(-1, -1, -1); // All numbers are equal
        printEqual(1, 1, 2); // Neither all are equal or different
    }

    /**
     * Compara três números inteiros e imprime uma mensagem indicando
     * se são todos iguais, todos diferentes, ou uma combinação.
     *
     * @param a O primeiro número inteiro.
     * @param b O segundo número inteiro.
     * @param c O terceiro número inteiro.
     */
    public static void printEqual(int a, int b, int c){
        // Verifica se todos os números são iguais
        if (a == b && b == c) {
            System.out.println("All numbers are equal");
        }
        // Verifica se todos os números são diferentes
        else if (a != b && b != c && a != c) {
            System.out.println("All numbers are different");
        }
        // Caso contrário, alguns são iguais e outros diferentes
        else {
            System.out.println("Neither all are equal or different");
        }
    }
}

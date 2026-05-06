package module04.learning.challenge26;

/**
 * Classe que contém a resolução do Exercício Vinte e Seis do Módulo 04.
 * Focada em encontrar o maior fator primo de um número inteiro.
 */
public class ExerciseTwentySix {

    /**
     * Método principal para testar a funcionalidade de encontrar o maior fator primo.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("Maior fator primo de 21: " + getLargestPrime(21));   // 7
        System.out.println("Maior fator primo de 217: " + getLargestPrime(217)); // 31
        System.out.println("Maior fator primo de 0: " + getLargestPrime(0));     // -1 (valor inválido)
        System.out.println("Maior fator primo de 45: " + getLargestPrime(45));   // 5
        System.out.println("Maior fator primo de -1: " + getLargestPrime(-1));   // -1 (valor inválido)
        System.out.println("Maior fator primo de 7: " + getLargestPrime(7));     // 7
    }

    /**
     * Encontra o maior fator primo de um número inteiro.
     * Se o número for menor que 2, retorna -1 (pois números primos são maiores ou iguais a 2).
     *
     * @param number O número inteiro para o qual o maior fator primo será encontrado.
     * @return O maior fator primo do número, ou -1 se o número for inválido (menor que 2).
     */
    public static int getLargestPrime(int number){
        if (number < 2){
            return -1; // Números primos são maiores ou iguais a 2
        }

        int largestPrimeFactor = 2; // Começa com o menor número primo
        int tempNumber = number;    // Variável temporária para não alterar o 'number' original

        // Itera para encontrar os fatores primos
        while (tempNumber > 1){
            // Se o número atual é divisível pelo largestPrimeFactor
            if (tempNumber % largestPrimeFactor == 0){
                tempNumber /= largestPrimeFactor; // Divide o número pelo fator primo
            } else {
                largestPrimeFactor++; // Se não for divisível, tenta o próximo número
            }
        }
        return largestPrimeFactor; // O último fator primo encontrado será o maior
    }
}

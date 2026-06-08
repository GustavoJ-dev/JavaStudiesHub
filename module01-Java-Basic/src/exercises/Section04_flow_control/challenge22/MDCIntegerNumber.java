package exercises.Section04_flow_control.challenge22;

/**
 * Classe que contém uma atividade prática sobre flow control.
 * Focada no cálculo do Maior Divisor Comum (MDC) entre dois números inteiros,
 * utilizando o algoritmo de Euclides.
 */
public class MDCIntegerNumber {

    /**
     * Método principal para testar a funcionalidade de cálculo do MDC.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("MDC de 25 e 15: " + getGreatestCommonDivisor(25, 15)); // 5
        System.out.println("MDC de 12 e 30: " + getGreatestCommonDivisor(12, 30)); // 6
        System.out.println("MDC de 100 e 25: " + getGreatestCommonDivisor(100, 25)); // 25
        System.out.println("MDC de 9 e 18: " + getGreatestCommonDivisor(9, 18)); // -1 (números < 10)
        System.out.println("MDC de 81 e 153: " + getGreatestCommonDivisor(81, 153)); // 9
    }

    /**
     * Calcula o Maior Divisor Comum (MDC) entre dois números inteiros.
     * Utiliza o algoritmo de Euclides para encontrar o MDC.
     * Os números de entrada devem ser maiores ou iguais a 10.
     *
     * @param first O primeiro número inteiro (deve ser >= 10).
     * @param second O segundo número inteiro (deve ser >= 10).
     * @return O Maior Divisor Comum entre os dois números, ou -1 se qualquer
     *         um dos números for menor que 10.
     */
    public static int getGreatestCommonDivisor(int first, int second){
        if (first < 10 || second < 10){
            return -1; // Valores inválidos
        }

        // Algoritmo de Euclides
        // Enquanto o segundo número não for zero
        while(second != 0){
            int temp = second;          // Armazena o valor atual de 'second'
            second = first % second;    // 'second' se torna o resto da divisão de 'first' por 'second'
            first = temp;               // 'first' se torna o valor antigo de 'second'
        }
        // Quando 'second' se torna 0, 'first' contém o MDC
        return first; // Corrigido para retornar 'first' que é o MDC final
    }
}

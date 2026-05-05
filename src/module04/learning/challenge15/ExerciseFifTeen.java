package module04.learning.challenge15;

/**
 * Classe que contém a resolução do Exercício Quinze do Módulo 04.
 * Focada no cálculo da soma de todos os números ímpares dentro de um
 * determinado intervalo, utilizando um loop `for` e validação de entrada.
 */
public class ExerciseFifTeen {

    /**
     * Método principal para testar a funcionalidade de soma de números ímpares.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("Soma ímpares de 1 a 100: " + sumOdd(1, 100)); // Esperado: 2500
        System.out.println("Soma ímpares de 10 a 50: " + sumOdd(10, 50)); // Esperado: 600
        System.out.println("Soma ímpares de 100 a 100: " + sumOdd(100, 100)); // Esperado: 0
        System.out.println("Soma ímpares de 13 a 13: " + sumOdd(13, 13)); // Esperado: 13
        System.out.println("Soma ímpares (intervalo inválido): " + sumOdd(-1, 100)); // Esperado: -1
        System.out.println("Soma ímpares (início > fim): " + sumOdd(100, 10)); // Esperado: -1
    }

    /**
     * Calcula a soma de todos os números ímpares dentro de um intervalo especificado.
     * O intervalo é inclusivo (start e end são considerados).
     *
     * @param start O número inicial do intervalo (deve ser não negativo).
     * @param end O número final do intervalo (deve ser não negativo e maior ou igual a `start`).
     * @return A soma dos números ímpares no intervalo, ou -1 se os parâmetros forem inválidos.
     */
    public static int sumOdd(int start, int end){
        // Validação de entrada: start e end devem ser não negativos, e start não pode ser maior que end.
        if (start < 0 || end < 0 || start > end){
            return -1;
        }

        int total = 0;
        // Itera sobre o intervalo, verificando se cada número é ímpar
        for(int i = start; i <= end; i++){
            if (i % 2 != 0){ // Se o resto da divisão por 2 não for 0, o número é ímpar
                total += i;
            }
        }
        return total;
    }
}

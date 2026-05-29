package exercises.Section04.challenge19;

/**
 * Classe que contém a resolução do Exercício Dezenove do Módulo 04.
 * Focada na verificação se dois números de dois dígitos compartilham
 * pelo menos um dígito em comum.
 */
public class ExerciseNineteen {

    /**
     * Método principal para testar a funcionalidade de verificação de dígitos compartilhados.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("10 e 11 compartilham? " + hasSharedDigit(10, 11)); // true (1)
        System.out.println("12 e 43 compartilham? " + hasSharedDigit(12, 43)); // false
        System.out.println("9 e 99 compartilham? " + hasSharedDigit(9, 99));   // false (números inválidos)
        System.out.println("15 e 55 compartilham? " + hasSharedDigit(15, 55)); // true (5)
        System.out.println("23 e 32 compartilham? " + hasSharedDigit(23, 32)); // true (2 e 3)
        System.out.println("12 e 21 compartilham? " + hasSharedDigit(12, 21)); // true (1 e 2)
    }

    /**
     * Verifica se dois números inteiros (cada um entre 10 e 99, inclusive)
     * compartilham pelo menos um dígito em comum.
     *
     * @param numberA O primeiro número (deve estar entre 10 e 99).
     * @param numberB O segundo número (deve estar entre 10 e 99).
     * @return {@code true} se os números compartilharem um dígito, {@code false} caso contrário
     *         ou se os números estiverem fora do intervalo válido.
     */
    public static boolean hasSharedDigit(int numberA, int numberB) {
        // Validação de entrada: ambos os números devem estar entre 10 e 99
        if (numberA < 10 || numberA > 99 || numberB < 10 || numberB > 99) {
            return false;
        }

        // Extrai os dígitos do primeiro número
        int digitARight = numberA % 10; // Dígito da direita
        int digitALeft = numberA / 10;  // Dígito da esquerda

        // Extrai os dígitos do segundo número
        int digitBRight = numberB % 10; // Dígito da direita
        int digitBLeft = numberB / 10;  // Dígito da esquerda

        // Verifica se algum dígito do primeiro número corresponde a algum dígito do segundo número
        // Comparação do dígito da direita de A com ambos os dígitos de B
        boolean rightMatch = (digitARight == digitBRight || digitARight == digitBLeft);
        // Comparação do dígito da esquerda de A com ambos os dígitos de B
        boolean leftMatch = (digitALeft == digitBRight || digitALeft == digitBLeft);

        // Retorna true se houver qualquer correspondência
        return rightMatch || leftMatch;
    }
}

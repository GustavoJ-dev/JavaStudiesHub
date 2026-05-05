package module04.learning.challenge16;

/**
 * Classe que contém a resolução do Exercício Dezesseis do Módulo 04.
 * Focada na verificação se um número inteiro é um palíndromo,
 * ou seja, se ele lê o mesmo de trás para frente.
 */
public class ExerciseSixteen {

    /**
     * Método principal para testar a funcionalidade de verificação de palíndromo.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("123 é palíndromo? " + isPalindrome(123));   // false
        System.out.println("121 é palíndromo? " + isPalindrome(121));   // true
        System.out.println("-121 é palíndromo? " + isPalindrome(-121)); // true (considerando o valor absoluto)
        System.out.println("707 é palíndromo? " + isPalindrome(707));   // true
        System.out.println("1 é palíndromo? " + isPalindrome(1));     // true
        System.out.println("12345 é palíndromo? " + isPalindrome(12345)); // false
    }

    /**
     * Verifica se um número inteiro é um palíndromo.
     * Um número é palíndromo se ele lê o mesmo de trás para frente.
     * A verificação é feita considerando o valor absoluto do número.
     *
     * @param number O número inteiro a ser verificado.
     * @return {@code true} se o número for um palíndromo, {@code false} caso contrário.
     */
    public static boolean isPalindrome(int number){
        // Pega o valor absoluto do número para lidar com negativos
        int originalNumber = Math.abs(number);
        int reversedNumber = 0;
        int tempNumber = originalNumber; // Variável temporária para manipular o número

        // Inverte o número
        while (tempNumber != 0){
            int lastDigit = tempNumber % 10; // Pega o último dígito
            reversedNumber = (reversedNumber * 10) + lastDigit; // Adiciona ao número invertido
            tempNumber /= 10; // Remove o último dígito do número temporário
        }

        // Compara o número original (absoluto) com o número invertido
        return originalNumber == reversedNumber;
    }
}

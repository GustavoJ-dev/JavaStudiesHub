package exercises.Section04_flow_control.challenge18;

/**
 * Classe que contém uma atividade prática sobre o flow control.
 * Focada no cálculo da soma de todos os dígitos pares de um número inteiro.
 */
public class SumEvenDigit {

    /**
     * Método principal para testar a funcionalidade de soma de dígitos pares.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("Soma dos dígitos pares de 252: " + getEvenDigitSum(252)); // 2 + 2 = 4
        System.out.println("Soma dos dígitos pares de 123456789: " + getEvenDigitSum(123456789)); // 2 + 4 + 6 + 8 = 20
        System.out.println("Soma dos dígitos pares de 10: " + getEvenDigitSum(10)); // 0
        System.out.println("Soma dos dígitos pares de 5: " + getEvenDigitSum(5)); // 0
        System.out.println("Soma dos dígitos pares de -10: " + getEvenDigitSum(-10)); // -1 (valor inválido)
        System.out.println("Soma dos dígitos pares de 0: " + getEvenDigitSum(0)); // 0
    }

    /**
     * Calcula a soma de todos os dígitos pares de um número inteiro.
     * Se o número for negativo, retorna -1.
     *
     * @param number O número inteiro a ser processado.
     * @return A soma dos dígitos pares do número, ou -1 se o número for negativo.
     */
    public static int getEvenDigitSum(int number){
        if (number < 0){
            return -1; // Valor inválido
        }

        int sum = 0;
        int tempNumber = number; // Usamos uma variável temporária para não alterar o 'number' original

        // Itera sobre cada dígito do número
        while (tempNumber != 0){
            int digit = tempNumber % 10; // Pega o último dígito
            if (digit % 2 == 0){ // Verifica se o dígito é par
                sum += digit;    // Adiciona à soma se for par
            }
            tempNumber /= 10; // Remove o último dígito
        }
        return sum;
    }
}

package exercises.Section04_flow_control.challenge17;

/**
 * Classe que contém uma atividade prática sobre o flow control.
 * Focada no cálculo da soma do primeiro e do último dígito de um número inteiro.
 */
public class SumFirstAndLastDigit {

    /**
     * Método principal para testar a funcionalidade de soma do primeiro e último dígito.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("Soma de 1002: " + sumFirstAndLastDigit(1002)); // 1 + 2 = 3
        System.out.println("Soma de 252: " + sumFirstAndLastDigit(252));  // 2 + 2 = 4
        System.out.println("Soma de 257: " + sumFirstAndLastDigit(257));  // 2 + 7 = 9
        System.out.println("Soma de 5: " + sumFirstAndLastDigit(5));    // 5 + 5 = 10
        System.out.println("Soma de -10: " + sumFirstAndLastDigit(-10)); // -1 (valor inválido)
        System.out.println("Soma de 0: " + sumFirstAndLastDigit(0));    // 0 + 0 = 0
    }

    /**
     * Calcula a soma do primeiro e do último dígito de um número inteiro.
     * Se o número for negativo, retorna -1.
     * Para números de um único dígito, o primeiro e o último dígito são o próprio número.
     *
     * @param number O número inteiro a ser processado.
     * @return A soma do primeiro e do último dígito, ou -1 se o número for negativo.
     */
    public static int sumFirstAndLastDigit(int number){
        if (number < 0){
            return -1; // Valor inválido
        }

        int lastDigit = number % 10; // O último dígito é fácil de obter

        // Para encontrar o primeiro dígito, dividimos o número por 10 repetidamente
        // até que ele se torne um número de um único dígito.
        while(number >= 10){
            number = number / 10;
        }
        // O 'number' restante é o primeiro dígito
        return number + lastDigit;
    }
}

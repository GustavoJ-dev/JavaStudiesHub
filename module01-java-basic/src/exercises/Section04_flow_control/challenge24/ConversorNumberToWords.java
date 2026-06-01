package exercises.Section04_flow_control.challenge24;

/**
 * Classe que contém uma atividade prática sobre flow control.
 * Focada na conversão de um número inteiro para sua representação textual em inglês,
 * lidando com a inversão do número e contagem de dígitos.
 */
public class ConversorNumberToWords {

    /**
     * Metodo principal para testar as funcionalidades de conversão de número para palavras.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.print("100 -> "); numberToWords(100); // One Zero Zero
        System.out.println();
        System.out.print("257 -> "); numberToWords(257); // Seven Five Two
        System.out.println();
        System.out.print("0 -> "); numberToWords(0);   // Zero
        System.out.println();
        System.out.print("-15 -> "); numberToWords(-15); // Invalid Value
        System.out.println();
        System.out.print("1010 -> "); numberToWords(1010); // One Zero One Zero
        System.out.println();
        System.out.print("1000 -> "); numberToWords(1000); // One Zero Zero Zero
        System.out.println();
    }

    /**
     * Inverte um número inteiro. Por exemplo, 123 se torna 321.
     * Números negativos são invertidos como se fossem positivos (ex: -121 se torna -121, mas o processo interno é 121 -> 121).
     *
     * @param number O número inteiro a ser invertido.
     * @return O número invertido.
     */
    public static int reverse(int number){
        int reversedNumber = 0;
        int tempNumber = Math.abs(number); // Trabalha com o valor absoluto para a inversão

        while (tempNumber != 0){
            int lastDigit = tempNumber % 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;
            tempNumber /= 10;
        }
        // Retorna o número invertido com o sinal original
        return (number < 0) ? -reversedNumber : reversedNumber;
    }

    /**
     * Conta o número de dígitos em um número inteiro.
     *
     * @param number O número inteiro.
     * @return O número de dígitos, ou -1 se o número for negativo.
     */
    public static int getDigitCount(int number){
        if (number < 0){
            return -1; // Valor inválido
        }
        if (number == 0){
            return 1; // O número 0 tem 1 dígito
        }

        int count = 0;
        int tempNumber = number;
        while (tempNumber != 0){
            tempNumber /= 10;
            count++;
        }
        return count;
    }

    /**
     * Converte um número inteiro para sua representação textual em inglês,
     * imprimindo cada dígito por extenso. Lida com zeros à esquerda que podem
     * ser perdidos na inversão do número.
     *
     * @param number O número inteiro a ser convertido.
     */
    public static void numberToWords(int number){
        if (number < 0){
            System.out.println("Invalid Value");
            return;
        }

        if (number == 0){
            System.out.print("Zero ");
            return;
        }

        int reversedNumber = reverse(number);
        int originalDigitCount = getDigitCount(number);
        int reversedDigitCount = getDigitCount(reversedNumber);

        // Imprime cada dígito do número invertido
        while (reversedNumber != 0){
            int lastDigit = reversedNumber % 10;
            switch (lastDigit){
                case 0 -> System.out.print("Zero ");
                case 1 -> System.out.print("One ");
                case 2 -> System.out.print("Two ");
                case 3 -> System.out.print("Three ");
                case 4 -> System.out.print("Four ");
                case 5 -> System.out.print("Five ");
                case 6 -> System.out.print("Six ");
                case 7 -> System.out.print("Seven ");
                case 8 -> System.out.print("Eight ");
                case 9 -> System.out.print("Nine ");
            }
            reversedNumber /= 10;
        }

        // Adiciona "Zero" para os zeros à esquerda que foram perdidos na inversão
        // Ex: 100 -> reverse(100) = 1. getDigitCount(100) = 3, getDigitCount(1) = 1. Diferença = 2.
        // Imprime "One" e depois dois "Zero"s.
        for (int i = 0; i < (originalDigitCount - reversedDigitCount); i++){
            System.out.print("Zero ");
        }
    }
}

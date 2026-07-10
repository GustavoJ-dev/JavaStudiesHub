package praticas.Section04_flow_control.challenge20;

/**
 * Classe que contém uma atividade prática sobre flow control.
 * Focada na verificação se pelo menos dois de três números inteiros
 * compartilham o mesmo último dígito. Inclui um método auxiliar para
 * validar se um número está dentro de um intervalo específico.
 */
public class ValidDigit {

    /**
     * Metodo principal para testar a funcionalidade de verificação de último dígito.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("41, 22, 71 têm o mesmo último dígito? " + hasSameLastDigit(41, 22, 71)); // true (1)
        System.out.println("23, 32, 42 têm o mesmo último dígito? " + hasSameLastDigit(23, 32, 42)); // true (2)
        System.out.println("9, 99, 19 têm o mesmo último dígito? " + hasSameLastDigit(9, 99, 19));   // false (números inválidos)
        System.out.println("10, 20, 30 têm o mesmo último dígito? " + hasSameLastDigit(10, 20, 30)); // true (0)
        System.out.println("11, 22, 33 têm o mesmo último dígito? " + hasSameLastDigit(11, 22, 33)); // false
    }

    /**
     * Verifica se um número está dentro do intervalo válido (entre 10 e 1000, exclusive).
     *
     * @param number O número a ser validado.
     * @return {@code true} se o número estiver no intervalo (10 < number < 1000), {@code false} caso contrário.
     */
    public static boolean isValid(int number){
        return number > 10 && number < 1000;
    }

    /**
     * Verifica se pelo menos dois de três números inteiros fornecidos
     * compartilham o mesmo último dígito.
     * Todos os números devem ser válidos (entre 10 e 1000, exclusive).
     *
     * @param one O primeiro número.
     * @param two O segundo número.
     * @param three O terceiro número.
     * @return {@code true} se pelo menos dois números válidos tiverem o mesmo último dígito,
     *         {@code false} caso contrário ou se algum número for inválido.
     */
    public static boolean hasSameLastDigit(int one, int two, int three){
        // Valida se todos os números estão dentro do intervalo permitido
        if (!isValid(one) || !isValid(two) || !isValid(three)){
            return false;
        }

        // Obtém o último dígito de cada número
        int lastDigitOne = one % 10;
        int lastDigitTwo = two % 10;
        int lastDigitThree = three % 10;

        // Verifica se há pelo menos dois últimos dígitos iguais
        return (lastDigitOne == lastDigitTwo) || (lastDigitOne == lastDigitThree) || (lastDigitTwo == lastDigitThree);
    }
}

package exercises.Section03_statements_and_methods.exercise06;

/**
 * Classe que contém uma atividade prática sobre statements e methods.
 * Focada na comparação de números de ponto flutuante com uma precisão
 * de três casas decimais.
 */
public class PrecisionFloatNumber {

    /**
     * Método principal para testar a funcionalidade de comparação de números.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("Comparando -3.1756 e -3.175: " + areEqualByThreeDecimalPlaces(-3.1756, -3.175)); // true
        System.out.println("Comparando 3.175234 e 3.176234: " + areEqualByThreeDecimalPlaces(3.175234, 3.176234)); // false
        System.out.println("Comparando 3.0 e 3.0: " + areEqualByThreeDecimalPlaces(3.0, 3.0)); // true
        System.out.println("Comparando -3.123 e -3.123: " + areEqualByThreeDecimalPlaces(-3.123, -3.123)); // true
        System.out.println("Comparando 3.175 e 3.176: " + areEqualByThreeDecimalPlaces(3.175, 3.176)); // false
    }

    /**
     * Verifica se dois números de ponto flutuante são iguais até a terceira casa decimal.
     * A comparação é feita multiplicando os números por 1000 e então comparando suas partes inteiras.
     *
     * @param numberOne O primeiro número double a ser comparado.
     * @param numberTwo O segundo número double a ser comparado.
     * @return {@code true} se os números forem iguais até a terceira casa decimal, {@code false} caso contrário.
     */
    public static boolean areEqualByThreeDecimalPlaces(double numberOne, double numberTwo){
        // Multiplica por 1000 para "mover" as três primeiras casas decimais para a parte inteira
        numberOne = numberOne * 1000;
        numberTwo = numberTwo * 1000;

        // Converte para int para truncar as casas decimais restantes e compara as partes inteiras
        return (int) numberOne == (int) numberTwo;
    }
}

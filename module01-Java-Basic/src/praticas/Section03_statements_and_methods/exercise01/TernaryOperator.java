package praticas.Section03_statements_and_methods.exercise01;

/**
 * Classe que contém uma atividade prática sobre statements e methods.
 * Focada em lógica simples de verificação numérica e uso de operadores ternários.
 */
public class TernaryOperator {

    /**
     * Metodo principal para testar a funcionalidade de verificação de números negativos.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println(isNegative(10));
        System.out.println(isNegative(-20));
        System.out.println(isNegative(637));
    }

    /**
     * Verifica se um número inteiro é negativo.
     * Utiliza um operador ternário para retornar o resultado booleano.
     *
     * @param number O número a ser verificado.
     * @return {@code true} se o número for menor que zero, {@code false} caso contrário.
     */
    public static boolean isNegative(int number){
        return number < 0 ? true : false;
    }
}

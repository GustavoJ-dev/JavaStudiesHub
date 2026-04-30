package module03.learning.challenge7;

/**
 * Classe que contém a resolução do Exercício Sete do Módulo 03.
 * Focada na verificação se a soma de dois números é igual a um terceiro número.
 */
public class ExerciseSeven {

    /**
     * Método principal para testar a funcionalidade de verificação de soma igual.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("1 + 1 == 1? " + hasEqualSum(1, 1, 1));   // false
        System.out.println("1 + (-1) == 0? " + hasEqualSum(1, -1, 0)); // true
        System.out.println("1 + 1 == 2? " + hasEqualSum(1, 1, 2));   // true
        System.out.println("3 + 5 == 9? " + hasEqualSum(3, 5, 9));   // false
    }

    /**
     * Verifica se a soma de dois números inteiros é igual a um terceiro número inteiro.
     *
     * @param a O primeiro número inteiro.
     * @param b O segundo número inteiro.
     * @param c O terceiro número inteiro, que será comparado com a soma de 'a' e 'b'.
     * @return {@code true} se (a + b) for igual a c, {@code false} caso contrário.
     */
    public static boolean hasEqualSum(int a, int b, int c){
        return (a + b) == c;
    }
}

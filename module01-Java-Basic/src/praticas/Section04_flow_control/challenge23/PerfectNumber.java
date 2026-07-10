package praticas.Section04_flow_control.challenge23;

/**
 * Classe que contém uma atividade prática sobre flow control.
 * Focada na verificação se um número inteiro é um "Número Perfeito".
 * Um número perfeito é um inteiro positivo que é igual à soma de seus divisores positivos,
 * excluindo o próprio número.
 */
public class PerfectNumber {

    /**
     * Metodo principal para testar a funcionalidade de verificação de número perfeito.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("6 é um número perfeito? " + isPerfectNumber(6));   // true (1+2+3=6)
        System.out.println("28 é um número perfeito? " + isPerfectNumber(28)); // true (1+2+4+7+14=28)
        System.out.println("5 é um número perfeito? " + isPerfectNumber(5));   // false
        System.out.println("-1 é um número perfeito? " + isPerfectNumber(-1)); // false (valor inválido)
        System.out.println("1 é um número perfeito? " + isPerfectNumber(1));   // false
    }

    /**
     * Verifica se um número inteiro é um número perfeito.
     * Um número perfeito é um inteiro positivo que é igual à soma de seus divisores positivos,
     * excluindo o próprio número.
     *
     * @param number O número inteiro a ser verificado. Deve ser um valor positivo.
     * @return {@code true} se o número for perfeito, {@code false} caso contrário ou se o número for inválido (menor que 1).
     */
    public static boolean isPerfectNumber(int number){
        if (number < 1){
            return false; // Números perfeitos são inteiros positivos
        }

        int sumOfDivisors = 0;
        // Itera de 1 até (number - 1) para encontrar os divisores
        for (int i = 1; i < number; i++){ // Corrigido para i < number, pois o próprio número não é um divisor a ser somado
            if (number % i == 0){ // Se 'i' é um divisor
                sumOfDivisors += i; // Adiciona à soma
            }
        }
        // Compara a soma dos divisores com o número original
        return sumOfDivisors == number;
    }
}

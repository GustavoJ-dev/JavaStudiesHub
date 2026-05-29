package exercises.Section04.challenge25;

/**
 * Classe que contém a resolução do Exercício Vinte e Cinco do Módulo 04.
 * Focada na lógica para determinar se é possível empacotar uma quantidade
 * `goal` de farinha usando sacos grandes (5kg) e pequenos (1kg).
 */
public class ExerciseTwentyFive {

    /**
     * Metodo principal para testar a funcionalidade de empacotamento.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("canPack(1, 0, 4)? " + canPack(1, 0, 4));   // false (precisa de 4kg, tem 5kg)
        System.out.println("canPack(1, 0, 5)? " + canPack(1, 0, 5));   // true
        System.out.println("canPack(0, 4, 3)? " + canPack(0, 4, 3));   // true
        System.out.println("canPack(2, 2, 11)? " + canPack(2, 2, 11)); // true (2*5kg + 1*1kg)
        System.out.println("canPack(-3, 2, 12)? " + canPack(-3, 2, 12)); // false (valores inválidos)
        System.out.println("canPack(2, 1, 5)? " + canPack(2, 1, 5));   // true (1*5kg + 0*1kg)
        System.out.println("canPack(2, 1, 9)? " + canPack(2, 1, 9));   // false (2*5kg = 10kg, 1*1kg = 1kg. Não dá 9kg exato)
        System.out.println("canPack(0, 5, 4)? " + canPack(0, 5, 4));   // true
        System.out.println("canPack(2, 10, 18)? " + canPack(2, 10, 18)); // true (2*5kg + 8*1kg)
    }

    /**
     * Verifica se é possível empacotar uma quantidade `goal` de farinha
     * usando uma determinada quantidade de sacos grandes (5kg) e pequenos (1kg).
     *
     * @param bigCount O número de sacos grandes de 5kg disponíveis.
     * @param smallCount O número de sacos pequenos de 1kg disponíveis.
     * @param goal A quantidade total de farinha em kg que precisa ser empacotada.
     * @return {@code true} se for possível empacotar a quantidade `goal`, {@code false} caso contrário
     *         ou se algum dos parâmetros for negativo.
     */
    public static boolean canPack (int bigCount, int smallCount, int goal){
        // Validação de entrada: nenhum parâmetro pode ser negativo
        if (bigCount < 0 || smallCount < 0 || goal < 0){
            return false;
        }

        int bigWeight = 5; // Peso de um saco grande

        // Calcula quantos sacos grandes podem ser usados para atingir o 'goal'
        // Não podemos usar mais sacos grandes do que temos disponíveis (bigCount)
        // nem mais do que o necessário para o 'goal' (goal / bigWeight)
        int numBigBagsToUse = Math.min(bigCount, goal / bigWeight);

        // Calcula o peso total que os sacos grandes usados podem cobrir
        int weightCoveredByBigBags = numBigBagsToUse * bigWeight;

        // Calcula a quantidade restante que precisa ser coberta pelos sacos pequenos
        int remainingWeight = goal - weightCoveredByBigBags;

        // Verifica se os sacos pequenos disponíveis são suficientes para cobrir o peso restante
        return smallCount >= remainingWeight;
    }
}

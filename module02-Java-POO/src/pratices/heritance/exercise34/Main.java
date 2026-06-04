package pratices.heritance.exercise34;

/**
 * Classe principal para demonstrar o uso das classes {@link CarpetCost}, {@link Floor} e {@link Calculator}.
 * Este é o ponto de entrada para o Exercício 34 do Módulo 05,
 * que calcula o custo total de um carpete para um determinado piso.
 */
public class Main {
    /**
     * Método principal que inicia a demonstração do cálculo do custo do carpete.
     * Chama o método {@code printCarpetValue} com diferentes dimensões de piso e custo por metro quadrado
     * para exibir o custo total.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        printCarpetValue(2.75, 4.00, 2.25); // Exemplo 1
        printCarpetValue(2.45, 1.88, 2.42); // Exemplo 2
        printCarpetValue(5.4, 4.5, 3.3);    // Exemplo 3
        printCarpetValue(-2.75, 4.00, 2.25); // Teste com largura inválida
        printCarpetValue(2.75, -4.00, 2.25); // Teste com altura inválida
        printCarpetValue(2.75, 4.00, -2.25); // Teste com custo inválido
    }

    /**
     * Cria instâncias das classes {@link CarpetCost}, {@link Floor} e {@link Calculator},
     * e imprime o custo total do carpete para o piso especificado.
     *
     * @param width A largura do piso.
     * @param height A altura do piso.
     * @param cost O custo por metro quadrado do carpete.
     */
    public static void printCarpetValue(double width, double height, double cost){
        System.out.println("--- Cálculo para Piso (" + width + "x" + height + ") e Custo " + cost + " ---");

        CarpetCost carpet = new CarpetCost(cost);
        Floor floor = new Floor(width, height);
        Calculator calculator = new Calculator(carpet, floor);

        System.out.println("Custo Total = " + calculator.getTotalCost());
        System.out.println("=".repeat(30)); // Separador para melhor visualização
    }
}

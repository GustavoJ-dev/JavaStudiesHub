package module05.learning.exercise32;

/**
 * Classe principal para demonstrar o uso da classe {@link Wall}.
 * Este é o ponto de entrada para o Exercício 32 do Módulo 05,
 * que cria objetos {@link Wall} e calcula suas áreas.
 */
public class Main {
    /**
     * Método principal que inicia a demonstração da criação e manipulação de objetos {@link Wall}.
     * Chama o método {@code printArea} com diferentes dimensões para exibir a área de paredes.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        printArea(5.5, 10);
        printArea(3.5, 6.9);
        printArea(2.8, 15);
        printArea(-1.0, 5.0); // Teste com largura inválida
        printArea(5.0, -1.0); // Teste com altura inválida
    }

    /**
     * Cria instâncias da classe {@link Wall} usando diferentes construtores e setters,
     * e imprime a área calculada de cada parede no console.
     *
     * @param width A largura da parede.
     * @param height A altura da parede.
     */
    public static void printArea(double width, double height){
        // Cria uma parede usando o construtor com parâmetros
        Wall wall = new Wall(width, height);

        // Cria uma parede usando o construtor padrão e setters
        Wall wall2 = new Wall();
        wall2.setWidth(width);
        wall2.setHeight(height);

        System.out.println("--- Área da Parede (" + width + "x" + height + ") ---");
        System.out.println("Área (Construtor): " + wall.getArea());
        System.out.println("Área (Setters): " + wall2.getArea());
        System.out.println("=".repeat(30)); // Separador para melhor visualização
    }
}

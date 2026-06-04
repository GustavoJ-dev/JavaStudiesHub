package pratices.heritance.exercise33;

/**
 * Classe principal para demonstrar o uso da classe {@link Point}.
 * Este é o ponto de entrada para o Exercício 33 do Módulo 05,
 * que cria objetos {@link Point} e calcula distâncias entre eles.
 */
public class Main {
    /**
     * Método principal que inicia a demonstração da criação e manipulação de objetos {@link Point}.
     * Chama o método {@code printPoint} com diferentes coordenadas para exibir
     * as distâncias calculadas.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        printPoint(6, 5);
        printPoint(3, 1);
        printPoint(0, 0); // Teste com a origem
        printPoint(-1, -1); // Teste com coordenadas negativas
    }

    /**
     * Cria instâncias da classe {@link Point} e demonstra o cálculo de distâncias
     * para diferentes cenários: da origem (0,0), de outro ponto e de coordenadas específicas.
     *
     * @param x A coordenada X do primeiro ponto.
     * @param y A coordenada Y do primeiro ponto.
     */
    public static void printPoint(int x, int y){
        System.out.println("--- Testando Ponto (" + x + "," + y + ") ---");

        Point firstPoint = new Point(x, y);
        Point secondPoint = new Point(); // Ponto (0,0) por padrão
        secondPoint.setX(3);
        secondPoint.setY(1);

        System.out.println("Distância de (" + x + "," + y + ") até (0,0) = " + firstPoint.distance());
        System.out.println("Distância de (" + x + "," + y + ") até (3,1) = " + firstPoint.distance(secondPoint));
        System.out.println("Distância de (" + x + "," + y + ") até (2,2) = " + firstPoint.distance(2, 2));

        Point point = new Point(); // Ponto (0,0)
        System.out.println("Distância de (0,0) até (0,0) = " + point.distance()); // Deve ser 0.0
        System.out.println("=".repeat(30)); // Separador para melhor visualização
    }
}

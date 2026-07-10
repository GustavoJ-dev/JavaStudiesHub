package praticas.heritance.exercise36;

/**
 * Classe principal para demonstrar o uso das classes {@link Circle} e {@link Cylinder}.
 * Este é o ponto de entrada para o Exercício 36 do Módulo 05,
 * que calcula e exibe propriedades geométricas de círculos e cilindros.
 */
public class Main {
    /**
     * Metodo principal que inicia a demonstração da criação e manipulação de objetos
     * {@link Circle} e {@link Cylinder}. Calcula e imprime o raio, altura, área e volume
     * para as formas geométricas.
     *
     */
    public static void main(String[] args) {
        // Demonstração da classe Circle
        System.out.println("--- Demonstração do Círculo ---");
        Circle circle = new Circle(3.75);
        System.out.printf("Raio do círculo = %.2f%n", circle.getRadius());
        System.out.printf("Área do círculo = %.2f%n", circle.getArea());
        System.out.println("=".repeat(30));

        // Demonstração da classe Cylinder
        System.out.println("\n--- Demonstração do Cilindro ---");
        Cylinder cylinder = new Cylinder(5.55, 7.25);
        System.out.printf("Raio do cilindro = %.2f%n", cylinder.getRadius());
        System.out.printf("Altura do cilindro = %.2f%n", cylinder.getHeight());
        System.out.printf("Área do cilindro = %.2f%n", cylinder.getArea()); // Área da base
        System.out.printf("Volume do cilindro = %.2f%n", cylinder.getVolume());
        System.out.println("=".repeat(30));

        // Teste com valores inválidos
        System.out.println("\n--- Teste com Valores Inválidos ---");
        Circle invalidCircle = new Circle(-1.0);
        System.out.printf("Raio do círculo inválido = %.2f%n", invalidCircle.getRadius()); // Deve ser 0.00
        System.out.printf("Área do círculo inválido = %.2f%n", invalidCircle.getArea());   // Deve ser 0.00

        Cylinder invalidCylinder = new Cylinder(1.0, -5.0);
        System.out.printf("Altura do cilindro inválido = %.2f%n", invalidCylinder.getHeight()); // Deve ser 0.00
    }
}

package module05.learning.exercise36;

/**
 * Representa um círculo com um determinado raio.
 * Esta classe faz parte do Exercício 36 do Módulo 05,
 * demonstrando encapsulamento e cálculo de área.
 */
public class Circle {
    /**
     * O raio do círculo.
     * O valor é sempre não negativo.
     */
    private double radius;

    /**
     * Construtor que inicializa um círculo com o raio especificado.
     * Se o raio fornecido for negativo, ele é definido como 0.
     *
     * @param radius O raio do círculo.
     */
    public Circle(double radius) {
        // Validação: se o raio for negativo, define como 0
        this.radius = radius < 0 ? 0 : radius;
    }

    /**
     * Retorna o raio atual do círculo.
     * @return O raio do círculo.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Calcula e retorna a área do círculo.
     * A área é calculada pela fórmula: `PI * raio * raio`.
     *
     * @return A área do círculo.
     */
    public double getArea(){
        return Math.PI * radius * radius;
    }
}

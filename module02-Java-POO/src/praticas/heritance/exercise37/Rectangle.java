package praticas.heritance.exercise37;

/**
 * Representa um retângulo básico com largura e comprimento.
 * Esta classe serve como a classe base (superclasse) para o cálculo de formas 2D.
 */
public class Rectangle {
    private double width;
    private double length;

    /**
     * Construtor para inicializar a largura e o comprimento.
     * Se os valores passados forem negativos, eles serão automaticamente ajustados para 0.
     * 
     * @param width  A largura do retângulo.
     * @param length O comprimento do retângulo.
     */
    public Rectangle(double width, double length) {
        this.width = width < 0 ? 0 : width;
        this.length = length < 0 ? 0 : length;
    }

    /**
     * Retorna a largura do retângulo.
     * 
     * @return largura (double).
     */
    public double getWidth() {
        return width;
    }

    /**
     * Retorna o comprimento do retângulo.
     * 
     * @return comprimento (double).
     */
    public double getLength() {
        return length;
    }

    /**
     * Calcula e retorna a área do retângulo.
     * A área é obtida multiplicando a largura pelo comprimento.
     * 
     * @return A área resultante (double).
     */
    public double getArea(){
        return width * length;
    }
}

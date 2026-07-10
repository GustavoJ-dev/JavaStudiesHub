package praticas.polymorphism.exercise38;

/**
 * Representa o teto de um cômodo, contendo informações sobre sua altura e cor.
 */
public class Ceiling {
    private int height;
    private String paintedColor;

    /**
     * Constrói um novo objeto Ceiling com uma altura e cor específicas.
     *
     * @param height       A altura do teto (ex: em metros).
     * @param paintedColor A cor com a qual o teto está pintado.
     */
    public Ceiling(int height, String paintedColor) {
        this.height = height;
        this.paintedColor = paintedColor;
    }

    /**
     * Obtém a altura do teto.
     *
     * @return A altura como um valor inteiro.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Obtém a cor do teto.
     *
     * @return Uma string representando a cor da pintura.
     */
    public String getPaintedColor() {
        return paintedColor;
    }

    /**
     * Retorna uma representação em string do teto, 
     * incluindo sua altura e cor.
     *
     * @return Uma string formatada com os atributos do teto.
     */
    @Override
    public String toString() {
        return getHeight() + "M, " + getPaintedColor();
    }
}

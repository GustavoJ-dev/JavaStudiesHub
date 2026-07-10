package praticas.heritance.exercise33;

/**
 * Representa um ponto em um plano cartesiano 2D com coordenadas X e Y.
 * Esta classe faz parte do Exercício 33 do Módulo 05,
 * demonstrando encapsulamento, construtores, métodos de acesso (getters e setters)
 * e cálculo de distância entre pontos.
 */
public class Point {
    /**
     * A coordenada X do ponto.
     */
    private int x;
    /**
     * A coordenada Y do ponto.
     */
    private int y;

    /**
     * Construtor padrão que inicializa um ponto na origem (0,0).
     */
    public Point(){
        this(0, 0); // Chama o construtor parametrizado com valores padrão
    }

    /**
     * Construtor que inicializa um ponto com as coordenadas X e Y especificadas.
     *
     * @param x A coordenada X do ponto.
     * @param y A coordenada Y do ponto.
     */
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Retorna a coordenada X do ponto.
     * @return A coordenada X.
     */
    public int getX() {
        return x;
    }

    /**
     * Define a coordenada X do ponto.
     * @param x A nova coordenada X.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Retorna a coordenada Y do ponto.
     * @return A coordenada Y.
     */
    public int getY() {
        return y;
    }

    /**
     * Define a coordenada Y do ponto.
     * @param y A nova coordenada Y.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Calcula a distância deste ponto até a origem (0,0).
     * Reutiliza o método {@link #distance(int, int)}.
     *
     * @return A distância euclidiana até a origem.
     */
    public double distance(){
        return distance(0, 0);
    }

    /**
     * Calcula a distância deste ponto até outro ponto especificado.
     * Reutiliza o método {@link #distance(int, int)}.
     *
     * @param another O outro ponto para o qual a distância será calculada.
     * @return A distância euclidiana até o ponto {@code another}.
     */
    public double distance(Point another){
        return distance(another.x, another.y);
    }

    /**
     * Calcula a distância deste ponto até um ponto com as coordenadas (x, y) especificadas.
     * Utiliza a fórmula da distância euclidiana: `sqrt((x2-x1)^2 + (y2-y1)^2)`.
     *
     * @param x A coordenada X do ponto de destino.
     * @param y A coordenada Y do ponto de destino.
     * @return A distância euclidiana até o ponto (x, y).
     */
    public double distance(int x, int y){
        int xDiff = this.x - x;
        int yDiff = this.y - y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}

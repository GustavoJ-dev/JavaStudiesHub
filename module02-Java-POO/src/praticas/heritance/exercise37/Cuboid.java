package praticas.heritance.exercise37;

/**
 * Representa um Cuboide (um paralelepípedo retângulo).
 * Esta classe estende {@link Rectangle}, adicionando a dimensão de altura
 * para permitir cálculos de volume em um espaço tridimensional.
 */
public class Cuboid extends Rectangle{
    private double height;

    /**
     * Construtor para inicializar as dimensões do cuboide.
     * A largura e o comprimento são passados para a superclasse {@link Rectangle}.
     * Se a altura for negativa, ela será ajustada para 0.
     *
     * @param width  A largura da base do cuboide.
     * @param length O comprimento da base do cuboide.
     * @param height A altura do cuboide.
     */
    public Cuboid(double width, double length, double height) {
        super(width, length);
        this.height = height < 0 ? 0 : height;
    }

    /**
     * Retorna a altura do cuboide.
     *
     * @return A altura (double).
     */
    public double getHeight() {
        return height;
    }

    /**
     * Calcula o volume total do cuboide.
     * O cálculo é realizado multiplicando a área da base (obtida através de 
     * {@link #getArea()}) pela altura do objeto.
     *
     * @return O volume resultante (double).
     */
    public double getVolume(){
        return getArea() * height;
    }
}

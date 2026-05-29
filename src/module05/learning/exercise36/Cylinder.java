package module05.learning.exercise36;

/**
 * Representa um cilindro, estendendo a classe {@link Circle} para herdar o raio.
 * Esta classe faz parte do Exercício 36 do Módulo 05,
 * demonstrando herança, encapsulamento e cálculo de volume.
 */
public class Cylinder extends Circle {
    /**
     * A altura do cilindro.
     * O valor é sempre não negativo.
     */
    private double height;

    /**
     * Construtor que inicializa um cilindro com o raio e altura especificados.
     * O raio é tratado pela classe pai {@link Circle}.
     * Se a altura fornecida for negativa, ela é definida como 0.
     *
     * @param radius O raio da base do cilindro.
     * @param height A altura do cilindro.
     */
    public Cylinder(double radius, double height) {
        super(radius); // Chama o construtor da classe pai (Circle)
        // Validação: se a altura for negativa, define como 0
        this.height = height < 0 ? 0 : height;
    }

    /**
     * Retorna a altura atual do cilindro.
     * @return A altura do cilindro.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Calcula e retorna o volume do cilindro.
     * O volume é calculado como a área da base (herdada de {@link Circle})
     * multiplicada pela altura.
     *
     * @return O volume do cilindro.
     */
    public double getVolume(){
        return getArea() * height; // Reutiliza o método getArea() da classe Circle
    }
}

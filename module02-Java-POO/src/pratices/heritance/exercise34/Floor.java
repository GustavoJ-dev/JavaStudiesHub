package pratices.heritance.exercise34;

/**
 * Representa um piso com largura e altura.
 * Esta classe faz parte do Exercício 34 do Módulo 05,
 * demonstrando encapsulamento e cálculo de área.
 */
public class Floor {

    /**
     * A largura do piso.
     * O valor é sempre não negativo.
     */
    private double width;
    /**
     * A altura (ou comprimento) do piso.
     * O valor é sempre não negativo.
     */
    private double height;

    /**
     * Construtor que inicializa um piso com a largura e altura especificadas.
     * Se a largura ou altura forem negativas, elas são definidas como 0.
     *
     * @param width A largura do piso.
     * @param height A altura (ou comprimento) do piso.
     */
    public Floor(double width, double height) {
        // Validação: se a largura for negativa, define como 0
        this.width = (width < 0) ? 0 : width;
        // Validação: se a altura for negativa, define como 0
        this.height = (height < 0) ? 0 : height;
    }

    /**
     * Retorna a largura atual do piso.
     * @return A largura do piso.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Define a largura do piso.
     * Se o valor fornecido for negativo, a largura é definida como 0.
     * @param width A nova largura do piso.
     */
    public void setWidth(double width) {
        this.width = (width < 0) ? 0 : width;
    }

    /**
     * Retorna a altura (ou comprimento) atual do piso.
     * @return A altura do piso.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Define a altura (ou comprimento) do piso.
     * Se o valor fornecido for negativo, a altura é definida como 0.
     * @param height A nova altura do piso.
     */
    public void setHeight(double height) {
        this.height = (height < 0) ? 0 : height;
    }

    /**
     * Calcula e retorna a área do piso.
     * A área é calculada como largura * altura.
     *
     * @return A área do piso.
     */
    public double getArea(){
        return width * height;
    }
}

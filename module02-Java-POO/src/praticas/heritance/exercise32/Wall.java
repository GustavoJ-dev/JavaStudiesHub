package praticas.heritance.exercise32;

/**
 * Representa uma parede com largura e altura.
 * Esta classe faz parte do Exercício 32 do Módulo 05,
 * demonstrando encapsulamento, construtores e métodos de acesso (getters e setters).
 */
public class Wall {
    /**
     * A largura da parede.
     * O valor é sempre não negativo.
     */
    private double width;
    /**
     * A altura da parede.
     * O valor é sempre não negativo.
     */
    private double height;

    /**
     * Construtor padrão que inicializa uma parede com largura e altura zero.
     */
    public Wall(){
        this(0.0, 0.0); // Chama o construtor parametrizado com valores padrão
    }

    /**
     * Construtor que inicializa uma parede com a largura e altura especificadas.
     * Se a largura ou altura forem negativas, elas são definidas como 0.
     *
     * @param width A largura da parede.
     * @param height A altura da parede.
     */
    public Wall(double width, double height) {
        // Validação: se a largura for negativa, define como 0
        this.width = (width > 0) ? width : 0;
        // Validação: se a altura for negativa, define como 0
        this.height = (height > 0) ? height : 0;
    }

    /**
     * Retorna a largura atual da parede.
     * @return A largura da parede.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Define a largura da parede.
     * Se o valor fornecido for negativo, a largura é definida como 0.
     * @param width A nova largura da parede.
     */
    public void setWidth(double width) {
        this.width = (width > 0) ? width : 0;
    }

    /**
     * Retorna a altura atual da parede.
     * @return A altura da parede.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Define a altura da parede.
     * Se o valor fornecido for negativo, a altura é definida como 0.
     * @param height A nova altura da parede.
     */
    public void setHeight(double height) {
        this.height = (height > 0) ? height : 0;
    }

    /**
     * Calcula e retorna a área da parede.
     * A área é calculada como largura * altura e arredondada para o inteiro mais próximo.
     *
     * @return A área da parede.
     */
    public double getArea(){
        // A área é calculada como largura * altura.
        // O Math.round() foi removido para manter a precisão double,
        // a menos que haja um requisito específico para arredondar para inteiro.
        // Se o requisito for arredondar para o inteiro mais próximo, o Math.round() deve ser mantido.
        return width * height;
    }
}

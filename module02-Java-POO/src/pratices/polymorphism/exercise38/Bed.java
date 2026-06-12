package pratices.polymorphism.exercise38;

/**
 * Representa uma cama, com características como estilo, número de travesseiros,
 * altura, quantidade de lençóis e colcha.
 * Esta classe faz parte do Exercício 38 do Módulo 02, demonstrando composição.
 */
public class Bed {

    /**
     * O estilo da cama (ex: "King", "Queen", "Solteiro").
     */
    private String style;
    /**
     * O número de travesseiros na cama.
     */
    private int pillows;
    /**
     * A altura da cama em alguma unidade de medida.
     */
    private int height;
    /**
     * O número de lençóis na cama.
     */
    private int sheets;
    /**
     * O número de colchas na cama.
     */
    private int quilt;

    /**
     * Construtor para criar uma nova instância de Bed com os detalhes especificados.
     *
     * @param style O estilo da cama.
     * @param pillows O número de travesseiros.
     * @param height A altura da cama.
     * @param sheets O número de lençóis.
     * @param quilt O número de colchas.
     */
    public Bed(String style, int pillows, int height, int sheets, int quilt) {
        this.style = style;
        this.pillows = pillows;
        this.height = height;
        this.sheets = sheets;
        this.quilt = quilt;
    }

    /**
     * Simula a ação de arrumar a cama, imprimindo uma mensagem no console.
     */
    public void make(){
        System.out.println("Bed -> Making");
    }

    /**
     * Retorna o estilo da cama.
     * @return O estilo da cama.
     */
    public String getStyle() {
        return style;
    }

    /**
     * Retorna o número de travesseiros na cama.
     * @return O número de travesseiros.
     */
    public int getPillows() {
        return pillows;
    }

    /**
     * Retorna a altura da cama.
     * @return A altura da cama.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Retorna o número de lençóis na cama.
     * @return O número de lençóis.
     */
    public int getSheets() {
        return sheets;
    }

    /**
     * Retorna o número de colchas na cama.
     * @return O número de colchas.
     */
    public int getQuilt() {
        return quilt;
    }

    /**
     * Retorna uma representação em string do objeto Bed, incluindo seu estilo,
     * altura, número de travesseiros, lençóis e colchas.
     *
     * @return Uma string formatada com os detalhes da cama.
     */
    @Override
    public String toString() {
        return getStyle() + ", Altura: " + getHeight() + "M, Travesseiros: " + getPillows() +
                ", Lençol: " + getSheets() + ", Colcha: " + getQuilt();
    }
}

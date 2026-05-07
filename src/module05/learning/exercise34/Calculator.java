package module05.learning.exercise34;

/**
 * Classe que calcula o custo total de um carpete para um determinado piso.
 * Esta classe faz parte do Exercício 34 do Módulo 05,
 * demonstrando composição de objetos.
 */
public class Calculator {
    /**
     * A instância de {@link CarpetCost} que contém o custo por metro quadrado do carpete.
     */
    private CarpetCost carpet;
    /**
     * A instância de {@link Floor} que contém as dimensões do piso.
     */
    private Floor floor;

    /**
     * Construtor que inicializa a calculadora com as instâncias de carpete e piso.
     *
     * @param carpet O objeto {@link CarpetCost} que representa o custo do carpete.
     * @param floor O objeto {@link Floor} que representa as dimensões do piso.
     */
    public Calculator(CarpetCost carpet, Floor floor) {
        this.carpet = carpet;
        this.floor = floor;
    }

    /**
     * Retorna a instância de {@link CarpetCost} associada a esta calculadora.
     * @return O objeto CarpetCost.
     */
    public CarpetCost getCarpet() {
        return carpet;
    }

    /**
     * Define a instância de {@link CarpetCost} para esta calculadora.
     * @param carpet O novo objeto CarpetCost.
     */
    public void setCarpet(CarpetCost carpet) {
        this.carpet = carpet;
    }

    /**
     * Retorna a instância de {@link Floor} associada a esta calculadora.
     * @return O objeto Floor.
     */
    public Floor getFloor() {
        return floor;
    }

    /**
     * Define a instância de {@link Floor} para esta calculadora.
     * @param floor O novo objeto Floor.
     */
    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    /**
     * Calcula e retorna o custo total do carpete para o piso.
     * O custo total é a área do piso multiplicada pelo custo por metro quadrado do carpete.
     *
     * @return O custo total do carpete.
     */
    public double getTotalCost(){
        return floor.getArea() * carpet.getCost();
    }
}

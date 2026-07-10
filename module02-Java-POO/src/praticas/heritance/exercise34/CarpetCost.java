package praticas.heritance.exercise34;

/**
 * Representa o custo por metro quadrado de um carpete.
 * Esta classe faz parte do Exercício 34 do Módulo 05,
 * demonstrando encapsulamento e validação de dados.
 */
public class CarpetCost {
    /**
     * O custo por metro quadrado do carpete.
     * O valor é sempre não negativo.
     */
    private double cost;

    /**
     * Construtor que inicializa o custo do carpete por metro quadrado.
     * Se o custo fornecido for negativo, ele é definido como 0.
     *
     * @param cost O custo por metro quadrado do carpete.
     */
    public CarpetCost(double cost){
        // Validação: se o custo for negativo, define como 0
        this.cost = (cost < 0) ? 0 : cost;
    }

    /**
     * Retorna o custo atual por metro quadrado do carpete.
     * @return O custo por metro quadrado.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Define o custo por metro quadrado do carpete.
     * Se o valor fornecido for negativo, o custo é definido como 0.
     * @param cost O novo custo por metro quadrado.
     */
    public void setCost(double cost) {
        this.cost = (cost < 0) ? 0 : cost;
    }
}

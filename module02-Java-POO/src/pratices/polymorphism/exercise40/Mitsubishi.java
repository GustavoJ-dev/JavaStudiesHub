package pratices.polymorphism.exercise40;

/**
 * Classe que representa um carro Mitsubishi.
 * 
 * Estende a classe Car e implementa comportamentos específicos de um Mitsubishi,
 * sobrescrevendo os métodos de iniciar motor, acelerar e frear.
 * 
 * @author Exercício 40 - Polimorfismo
 * @version 1.0
 */
public class Mitsubishi extends Car {
    
    /**
     * Constrói um carro Mitsubishi com o número de cilindros e nome especificados.
     * 
     * @param cylinders número de cilindros do motor
     * @param name nome ou modelo do Mitsubishi
     */
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    /**
     * Inicia o motor do Mitsubishi com comportamento específico da marca.
     * 
     * @return mensagem de inicialização específica do Mitsubishi
     */
    @Override
    public String startEngine() {
        return "Mitsubishi -> startEngine()";
    }
    
    /**
     * Acelera o Mitsubishi com comportamento específico da marca.
     * 
     * @return mensagem de aceleração específica do Mitsubishi
     */
    @Override
    public String accelerate() {
        return "Mitsubishi -> accelerate()";
    }
    
    /**
     * Freia o Mitsubishi com comportamento específico da marca.
     * 
     * @return mensagem de frenagem específica do Mitsubishi
     */
    @Override
    public String brake() {
        return "Mitsubishi -> brake()";
    }
}

package pratices.polymorphism.exercise40;

/**
 * Classe que representa um carro Ford.
 * 
 * Estende a classe Car e implementa comportamentos específicos de um Ford,
 * sobrescrevendo os métodos de iniciar motor, acelerar e frear.
 */
public class Ford extends Car {
    
    /**
     * Constrói um carro Ford com o número de cilindros e nome especificados.
     * 
     * @param cylinders número de cilindros do motor
     * @param name nome ou modelo do Ford
     */
    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }

    /**
     * Inicia o motor do Ford com comportamento específico da marca.
     * 
     * @return mensagem de inicialização específica do Ford
     */
    @Override
    public String startEngine() {
        return "Ford -> startEngine()";
    }

    /**
     * Acelera o Ford com comportamento específico da marca.
     * 
     * @return mensagem de aceleração específica do Ford
     */
    @Override
    public String accelerate() {
        return "Ford -> accelerate()";
    }

    /**
     * Freia o Ford com comportamento específico da marca.
     * 
     * @return mensagem de frenagem específica do Ford
     */
    @Override
    public String brake() {
        return "Ford -> brake()";
    }
}

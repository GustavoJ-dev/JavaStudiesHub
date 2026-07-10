package praticas.polymorphism.exercise40;

/**
 * Classe que representa um carro Holden.
 * 
 * Estende a classe Car e implementa comportamentos específicos de um Holden,
 * sobrescrevendo os métodos de iniciar motor, acelerar e frear.
 * Utiliza getClass().getSimpleName() para identificar dinamicamente a marca do veículo.
 */
public class Holden extends Car{
    
    /**
     * Constrói um carro Holden com o número de cilindros e nome especificados.
     * 
     * @param cylinders número de cilindros do motor
     * @param name nome ou modelo do Holden
     */
    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }

    /**
     * Inicia o motor do Holden com comportamento específico da marca.
     * 
     * @return mensagem de inicialização específica do Holden
     */
    @Override
    public String startEngine() {
        return getClass().getSimpleName() + " -> startEngine()";
    }

    /**
     * Acelera o Holden com comportamento específico da marca.
     * 
     * @return mensagem de aceleração específica do Holden
     */
    @Override
    public String accelerate() {
        return getClass().getSimpleName() + " -> accelerate()";
    }

    /**
     * Freia o Holden com comportamento específico da marca.
     * 
     * @return mensagem de frenagem específica do Holden
     */
    @Override
    public String brake() {
        return getClass().getSimpleName() + " -> brake()";
    }
}

package praticas.polymorphism.exercise40;

/**
 * Classe base que representa um automóvel genérico.
 * 
 * Define as características e comportamentos básicos de um carro,
 * incluindo motor, cilindros, nome e rodas. Serve como classe base
 * para diferentes marcas de carros que herdam e implementam seus próprios comportamentos.
 */
public class Car {
    /** Indica se o motor está ligado ou desligado */
    private boolean engine;
    
    /** Número de cilindros do motor */
    private int cylinders;
    
    /** Nome/modelo do carro */
    private String name;
    
    /** Número de rodas (padrão: 4) */
    private int wheels;

    /**
     * Constrói um carro com o número de cilindros e nome especificados.
     * 
     * @param cylinders número de cilindros do motor
     * @param name nome ou modelo do carro
     */
    public Car( int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
        this.engine = true;
    }

    /**
     * Obtém o número de cilindros do carro.
     * 
     * @return número de cilindros do motor
     */
    public int getCylinders() {
        return cylinders;
    }

    /**
     * Obtém o nome ou modelo do carro.
     * 
     * @return nome do carro
     */
    public String getName() {
        return name;
    }

    /**
     * Inicia o motor do carro.
     * 
     * @return mensagem indicando que o motor foi iniciado
     */
    public String startEngine(){
        return "Car-> startEngine";
    }

    /**
     * Acelera o carro.
     * 
     * @return mensagem indicando que o carro está acelerado
     */
    public String accelerate(){
        return "Car-> accelerate";
    }

    /**
     * Freia o carro.
     * 
     * @return mensagem indicando que o carro está freando
     */
    public String brake(){
        return "Car-> brake";
    }
}


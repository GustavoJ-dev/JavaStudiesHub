package pratices.polymorphism.mini_project;

/**
 * Classe que representa um hambúrguer no menu.
 * 
 * Estende a classe Item e permite adicionar até 3 coberturas (toppings) ao hambúrguer.
 * Cada cobertura tem um preço específico que é adicionado ao preço base do hambúrguer.
 * 
 * @author Mini Project - Polimorfismo
 * @version 1.0
 */
public class Burger extends Item{
    
    /** Primeira cobertura adicional do hambúrguer */
    private Item extra1;
    
    /** Segunda cobertura adicional do hambúrguer */
    private Item extra2;
    
    /** Terceira cobertura adicional do hambúrguer */
    private Item extra3;

    /**
     * Constrói um hambúrguer com nome e preço especificados.
     * 
     * @param name nome ou tipo do hambúrguer
     * @param price preço base do hambúrguer
     */
    public Burger(String name, double price) {
        super(name, "Burger", price);
    }

    /**
     * Obtém o nome do hambúrguer com o sufixo " BURGER" adicionado.
     * 
     * @return nome do hambúrguer com sufixo
     */
    @Override
    public String getName() {
        return super.getName() + " BURGER";
    }

    /**
     * Calcula o preço ajustado do hambúrguer incluindo os preços das coberturas.
     * 
     * O preço final é a soma do preço base do hambúrguer e o preço de cada cobertura
     * adicionada (se não for nula).
     * 
     * @return preço total do hambúrguer com coberturas
     */
    @Override
    public double getAdjustedPrice() {
        return getBasePrice() +
                ((extra1 == null) ? 0 : extra1.getAdjustedPrice()) +
                ((extra2 == null) ? 0 : extra2.getAdjustedPrice()) +
                ((extra3 == null) ? 0 : extra3.getAdjustedPrice());
    }

    /**
     * Obtém o preço de uma cobertura específica.
     * 
     * Preços:
     * - ABACATE, CHEESE: R$ 1.00
     * - BACON, HAM, SALAMI: R$ 1.50
     * - Outras coberturas: R$ 0.00 (grátis)
     * 
     * @param toppingName nome da cobertura
     * @return preço da cobertura
     */
    public double getExtraPrice(String toppingName){
        return switch (toppingName.toUpperCase()){
            case "ABACATE", "CHEESE" -> 1;
            case "BACON", "HAM", "SALAMI"  -> 1.5;
            default -> 0.0;
        };
    }

    /**
     * Adiciona até três coberturas ao hambúrguer.
     * 
     * @param extra1 primeira cobertura
     * @param extra2 segunda cobertura
     * @param extra3 terceira cobertura
     */
    public void addToppings(String extra1, String extra2, String extra3){
        this.extra1 = new Item("TOPPING", extra1, getExtraPrice(extra1));
        this.extra2 = new Item("TOPPING", extra2, getExtraPrice(extra2));
        this.extra3 = new Item("TOPPING", extra3, getExtraPrice(extra3));
    }

    /**
     * Imprime uma lista detalhada com cada componente do hambúrguer.
     * 
     * Mostra o preço base do hambúrguer e depois cada cobertura adicionada.
     */
    public void printItemizedList(){
        printItem("BASE BURGER", getBasePrice());
        if (extra1 != null) {
            extra1.printItem();
        }
        if (extra2 != null) {
            extra2.printItem();
        }
        if (extra3 != null) {
            extra3.printItem();
        }
    }

    /**
     * Imprime o hambúrguer com lista detalhada de componentes e preço total.
     */
    @Override
    public void printItem() {
        printItemizedList();
        System.out.println("_".repeat(30));
        super.printItem();
    }
}

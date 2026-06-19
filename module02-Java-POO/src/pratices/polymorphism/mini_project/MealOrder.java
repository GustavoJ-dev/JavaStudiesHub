package pratices.polymorphism.mini_project;

/**
 * Classe que representa um pedido de refeição completa.
 * 
 * Encapsula um hambúrguer, uma bebida e um acompanhamento (lado).
 * Fornece funcionalidades para personalizar o pedido e calcular o preço total.
 * 
 * @author Mini Project - Polimorfismo
 * @version 1.0
 */
public class MealOrder {
    
    /** Hambúrguer da refeição */
    private Burger burger;
    
    /** Bebida da refeição */
    private Item drink;
    
    /** Acompanhamento da refeição */
    private Item side;

    /**
     * Constrói uma refeição com valores padrão.
     * 
     * Padrão: Hambúrguer regular, Coca-Cola, Batata Frita
     */
    public MealOrder(){
        this("regular", "coke", "fries");
    }

    /**
     * Constrói uma refeição com tipos específicos de hambúrguer, bebida e acompanhamento.
     * 
     * @param burgerType tipo de hambúrguer
     * @param drinkType tipo de bebida
     * @param sideType tipo de acompanhamento
     */
    public MealOrder(String burgerType, String drinkType, String sideType) {
        this.burger = new Burger(burgerType, 4.0);
        this.drink = new Item("drink", drinkType, 1.00);
        this.side = new Item("side", sideType, 1.50);
    }

    /**
     * Calcula o preço total da refeição.
     * 
     * Soma o preço ajustado do acompanhamento, bebida e hambúrguer.
     * 
     * @return preço total da refeição
     */
    public double getTotalPrice(){
        return side.getAdjustedPrice() + drink.getAdjustedPrice() +
                burger.getAdjustedPrice();
    }

    /**
     * Imprime uma lista detalhada de todos os componentes da refeição com preço total.
     * 
     * Mostra hambúrguer, bebida, acompanhamento e calcula o preço final.
     */
    public void printItemizedList(){
        burger.printItem();
        drink.printItem();
        side.printItem();
        System.out.println("_".repeat(30));
        Item.printItem("TOTAL PRICE", getTotalPrice());
    }

    /**
     * Adiciona coberturas ao hambúrguer da refeição.
     * 
     * @param extra1 primeira cobertura
     * @param extra2 segunda cobertura
     * @param extra3 terceira cobertura
     * @param extra4 quarta cobertura (não utilizada neste método)
     * @param extra5 quinta cobertura (não utilizada neste método)
     */
    public void addBurgerToppings(String extra1, String extra2, String extra3,
                                  String extra4, String extra5){
        burger.addToppings(extra1, extra2, extra3);
    }

    /**
     * Define o tamanho da bebida da refeição.
     * 
     * @param size tamanho desejado (SMALL, MEDIUM, LARGE)
     */
    public void setDrinkSize(String size){
        drink.setSize(size);
    }
}

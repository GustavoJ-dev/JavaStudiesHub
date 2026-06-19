package pratices.polymorphism.mini_project;

/**
 * Classe que representa um hambúrguer deluxe (premium).
 * 
 * Estende a classe Burger e permite adicionar até 5 coberturas no total.
 * As 2 coberturas extras (além das 3 do hambúrguer normal) são oferecidas gratuitamente.
 * 
 * @author Mini Project - Polimorfismo
 * @version 1.0
 */
public class DeluxeBurger extends Burger{
    
    /** Quarta cobertura (deluxe) - oferecida gratuitamente */
    Item deluxe1;
    
    /** Quinta cobertura (deluxe) - oferecida gratuitamente */
    Item deluxe2;

    /**
     * Constrói um hambúrguer deluxe com nome e preço especificados.
     * 
     * @param name nome ou tipo do hambúrguer deluxe
     * @param price preço base do hambúrguer deluxe
     */
    public DeluxeBurger(String name, double price) {
        super(name, price);
    }

    /**
     * Adiciona até 5 coberturas ao hambúrguer deluxe.
     * 
     * As 3 primeiras coberturas têm preço normal, enquanto as 2 últimas
     * são oferecidas gratuitamente como parte do pacote deluxe.
     * 
     * @param extra1 primeira cobertura (com preço)
     * @param extra2 segunda cobertura (com preço)
     * @param extra3 terceira cobertura (com preço)
     * @param extra4 quarta cobertura (grátis)
     * @param extra5 quinta cobertura (grátis)
     */
    public void addToppings(String extra1, String extra2, String extra3,
                            String extra4, String extra5){
        super.addToppings(extra1, extra2, extra3);
        deluxe1 = new Item("TOPPING", extra4, 0);
        deluxe2 = new Item("TOPPING", extra5, 0);
    }

    /**
     * Imprime a lista detalhada incluindo as coberturas deluxe.
     * 
     * Sobrescreve o método da classe pai para incluir as 2 coberturas extras
     * oferecidas gratuitamente.
     */
    @Override
    public void printItemizedList() {
        super.printItemizedList();
        if (deluxe1 != null){
            deluxe1.printItem();
        }
        if (deluxe2 != null){
            deluxe2.printItem();
        }
    }

    /**
     * Retorna preço 0 para todas as coberturas no hambúrguer deluxe.
     * 
     * Sobrescreve o método da classe pai para que as coberturas extras
     * não tenham custo adicional.
     * 
     * @param toppingName nome da cobertura (não utilizado)
     * @return sempre retorna 0.0 (grátis)
     */
    @Override
    public double getExtraPrice(String toppingName) {
        return 0;
    }
}

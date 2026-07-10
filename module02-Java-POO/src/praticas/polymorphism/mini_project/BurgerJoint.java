package praticas.polymorphism.mini_project;

/**
 * Classe principal que demonstra o funcionamento de um sistema de pedidos de hambúrgueres.
 * 
 * Exemplifica o uso de polimorfismo através de itens de menu, hambúrgueres com coberturas
 * personalizadas e refeições completas. Simula diferentes cenários de pedidos em um restaurante.
 */
public class BurgerJoint {
    public static void main(String[] args) {
        pedido();
    }

    /**
     * Metodo que demonstra o funcionamento do sistema de pedidos.
     * 
     * Simula:
     * - Criação de um item (Coca-Cola) e ajuste de tamanho
     * - Criação de uma cobertura (Abacate)
     * - Criação de um hambúrguer com coberturas personalizadas
     * - Criação de 3 refeições diferentes:
     *   1. Refeição regular com bacon, queijo e maionese
     *   2. Refeição de peru com alface, queijo e maionese
     *   3. Refeição deluxe com 5 coberturas
     */
    public static void pedido(){

        Item coke = new Item("drink", "coke", 1.50);
        coke.printItem();
        coke.setSize("LARGE");
        coke.printItem();

        Item avocado = new Item("Topping", "avocado", 1.50);
        avocado.printItem();

        Burger burger = new Burger("regular", 4.00);
        burger.addToppings("BACON", "CHEESE", "MAYO");
        burger.printItem();

        MealOrder regularMeal = new MealOrder();
        regularMeal.addBurgerToppings("BACON", "CHEESE", "MAYO", null, null);
        regularMeal.setDrinkSize("LARGE");
        regularMeal.printItemizedList();

        MealOrder secondMeal = new MealOrder("turkey", "7-up",
                "chili");
        secondMeal.addBurgerToppings("LETTUCE", "CHEESE", "MAYO", null, null);
        secondMeal.setDrinkSize("SMALL");
        secondMeal.printItemizedList();

        MealOrder deluxeMeal = new MealOrder("deluxe", "7-up",
                "chili");
        deluxeMeal.addBurgerToppings("AVOCADO", "BACON", "LETTUCE",
                "CHEESE", "MAYO");
        deluxeMeal.setDrinkSize("SMALL");
        deluxeMeal.printItemizedList();
    }
}

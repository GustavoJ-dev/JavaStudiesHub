package pratices.polymorphism.mini_project;

/**
 * Classe que representa um item genérico em um menu de restaurante.
 * 
 * Define as características básicas de um item como bebida, acompanhamento ou cobertura,
 * incluindo tipo, nome, preço base e tamanho. Fornece métodos para ajustar preços de
 * acordo com o tamanho selecionado.
 *
 */
public class Item {

    /** Tipo do item (DRINK, SIDE, TOPPING, etc.) */
    private String type;
    
    /** Nome do item */
    private String name;
    
    /** Preço base do item */
    private double price;
    
    /** Tamanho do item (padrão: MEDIUM) */
    private String size = "MEDIUM";

    /**
     * Constrói um item com nome, tipo e preço especificados.
     * 
     * @param name nome do item (será convertido para maiúsculas)
     * @param type tipo do item (será convertido para maiúsculas)
     * @param price preço base do item
     */
    public Item(String name, String type, double price) {
        this.type = type.toUpperCase();
        this.name = name.toUpperCase();
        this.price = price;
    }

    /**
     * Obtém o nome do item, incluindo tamanho se aplicável.
     * 
     * Itens do tipo SIDE ou DRINK incluem o tamanho no nome retornado.
     * 
     * @return nome do item, possivelmente com tamanho incluído
     */
    public String getName(){

        if (type.equals("SIDE") || type.equals("DRIN")){
            return size + " " + name;
        }
        return name;
    }

    /**
     * Obtém o preço base do item sem ajustes.
     * 
     * @return preço base do item
     */
    public double getBasePrice(){
        return price;
    }

    /**
     * Define o tamanho do item.
     * 
     * @param size tamanho do item (SMALL, MEDIUM, LARGE)
     */
    public void setSize(String size){
        this.size = size;

    }

    /**
     * Obtém o preço ajustado de acordo com o tamanho do item.
     * 
     * SMALL reduz o preço em R$ 0.50
     * LARGE aumenta o preço em R$ 1.00
     * MEDIUM mantém o preço base
     * 
     * @return preço ajustado do item
     */
    public double getAdjustedPrice(){
        return switch (size){
            case "SMALL" -> getBasePrice() - 0.5;
            case "LARGE" -> getBasePrice() + 1;
            default -> getBasePrice();
        };
    }

    /**
     * Imprime um item formatado com nome e preço.
     * 
     * @param name nome do item a ser impresso
     * @param price preço do item a ser impresso
     */
    public static void printItem(String name, double price) {
        System.out.printf("%20s:%6.2f%n", name, price);
    }

    /**
     * Imprime este item com seu nome e preço ajustado.
     */
    public void printItem() {
        printItem(getName(), getAdjustedPrice());
    }
}

package pratices.abstraction.store.product;

/**
 * Representa um móvel (furniture) como um tipo específico de produto à venda.
 * 
 * Furniture é uma implementação concreta de ProductForSale que especializa
 * a estrutura para produtos de mobiliário. Herda as propriedades básicas de
 * um produto e implementa o metodo showDetails() para exibir informações
 * específicas de móveis.
 */
public class Furniture extends ProductForSale{

    /**
     * Constrói um novo móvel com tipo, preço e descrição especificados.
     * 
     * Inicializa um produto de mobiliário que pode ser vendido normalmente.
     *
     * @param type a categoria ou tipo do móvel
     * @param price o preço unitário em dólares
     * @param description a descrição detalhada do móvel
     */
    public Furniture(String type, double price, String description) {
        super(type, price, description);
    }

    /**
     * Exibe os detalhes específicos do móvel.
     * 
     * Apresenta informações detalhadas do móvel incluindo tipo, preço formatado
     * e descrição completa. Utiliza formatação de saída para apresentar o preço
     * em moeda (dólares).
     */
    @Override
    public void showDetails() {

        System.out.println("Esse " + type + " é uma obra de arte espetacular");
        System.out.printf("O preço da peça é $%6.2f %n", price);
        System.out.println(description);
    }
}

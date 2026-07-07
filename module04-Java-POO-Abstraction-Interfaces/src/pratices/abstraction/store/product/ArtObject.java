package pratices.abstraction.store.product;

/**
 * Representa um objeto de arte (art object) como um tipo específico de produto à venda.
 * 
 * ArtObject é uma implementação concreta de ProductForSale que especializa
 * a estrutura para produtos artísticos. Herda as propriedades básicas de um produto
 * e implementa o metodo showDetails() para exibir informações específicas de objetos de arte.
 */
public class ArtObject extends ProductForSale{

    /**
     * Constrói um novo objeto de arte com tipo, preço e descrição especificados.
     * 
     * Inicializa um produto artístico que pode ser vendido normalmente.
     *
     * @param type a categoria ou tipo do objeto de arte
     * @param price o preço unitário em dólares
     * @param description a descrição detalhada do objeto de arte
     */
    public ArtObject(String type, double price, String description) {
        super(type, price, description);
    }

    /**
     * Exibe os detalhes específicos do objeto de arte.
     * 
     * Apresenta informações detalhadas do objeto de arte incluindo tipo, preço formatado
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

package pratices.abstraction.store.product;

/**
 * Classe abstrata que define a estrutura base para produtos à venda.
 * 
 * ProductForSale é uma classe abstrata que estabelece o contrato para todos os produtos
 * que podem ser vendidos em uma loja. Define propriedades comuns como tipo, preço e
 * descrição, além de métodos para cálculo de preço de venda e exibição de informações.
 * Subclasses devem implementar o metodo showDetails() para exibir detalhes específicos
 * de cada tipo de produto.
 */
public abstract class ProductForSale {

    /**
     * O tipo ou categoria do produto.
     */
    protected String type;

    /**
     * O preço unitário do produto.
     */
    protected double price;

    /**
     * A descrição detalhada do produto.
     */
    protected String description;

    /**
     * Constrói um novo produto com tipo, preço e descrição especificados.
     * 
     * Inicializa um produto com suas informações básicas. O produto pode ser
     * vendido em quantidades, com preço calculado dinamicamente.
     *
     * @param type a categoria ou tipo do produto
     * @param price o preço unitário em dólares
     * @param description a descrição detalhada do produto
     */
    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    /**
     * Calcula o preço total de venda para uma quantidade especificada.
     * 
     * Multiplica o preço unitário pela quantidade desejada para obter o valor
     * total da transação.
     *
     * @param qty a quantidade de unidades do produto
     * @return o preço total (preço unitário × quantidade)
     */
    public double getSalesPrice(int qty){
        return qty * price;
    }

    /**
     * Exibe o preço formatado e informações do item para venda.
     * 
     * Imprime uma linha formatada contendo a quantidade, preço unitário, tipo
     * e descrição do produto em um formato padronizado para relatórios de vendas.
     * O formato segue: quantidade | preço cada | tipo | descrição
     *
     * @param qty a quantidade de unidades a ser exibida
     */
    public void printPricedItem(int qty){
        System.out.printf("%2d quantidade em $%8.2f cada,   %-15s %-35s %n",
                qty, price, type, description);
    }

    /**
     * Exibe detalhes específicos do produto.
     * 
     * Método abstrato que deve ser implementado pelas subclasses para exibir
     * informações detalhadas e características particulares de cada tipo de produto.
     * Cada subclasse é responsável por definir como seus detalhes devem ser apresentados.
     */
    public abstract void showDetails();

}

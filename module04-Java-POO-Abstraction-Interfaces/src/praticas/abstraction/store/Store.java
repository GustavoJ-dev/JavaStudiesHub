package praticas.abstraction.store;

import praticas.abstraction.store.product.ArtObject;
import praticas.abstraction.store.product.Furniture;
import praticas.abstraction.store.product.ProductForSale;

import java.util.ArrayList;

/**
 * Record que representa um item em um pedido.
 * 
 * OrderItem encapsula a quantidade e o produto associado a um item de pedido.
 * Utiliza a sintaxe record do Java para criar uma estrutura imutável de dados.
 * 
 * @param qty a quantidade de unidades do produto no pedido
 * @param product o produto sendo pedido
 */
record OrderItem(int qty, ProductForSale product) {}

/**
 * Classe que simula uma loja com gerenciamento de produtos e pedidos.
 * 
 * Store é uma classe de demonstração que gerencia um catálogo de produtos
 * (objetos de arte e móveis) e permite criar e processar pedidos. Ela utiliza
 * abstrações para manter a flexibilidade e permitir novos tipos de produtos.
 */
public class Store {

    /**
     * Lista estática de produtos disponíveis na loja.
     */
    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();

    /**
     * Metodo principal que demonstra o funcionamento da loja.
     * 
     * Executa uma simulação completa incluindo:
     * - Adição de produtos ao catálogo (obras de arte e móveis);
     * - Listagem de todos os produtos com seus detalhes;
     * - Criação de dois pedidos com diferentes quantidades;
     * - Processamento e exibição de cada pedido com total.
     *
     */
    public static void main(String[] args) {

        storeProducts.add(new ArtObject("Pintura a óleo", 1350,
                "Obra impressionista de ABF pintada em 2010."));

        storeProducts.add(new ArtObject("Escultura", 2000,
                "Obra em bronze de JKF, produzida em 1950"));

        storeProducts.add(new Furniture("Mesa", 500,
                "Mesa de mogno"));

        storeProducts.add(new Furniture("Lâmpada", 200,
                "Lâmpada Tiffany com colibrinhos"));

        listProducts();

        System.out.println("\nOrder 1");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);

        System.out.println("\nOrder 2");
        var order2 = new ArrayList<OrderItem>();
        addItemToOrder(order2, 3, 5);
        addItemToOrder(order2, 0, 1);
        addItemToOrder(order2, 2, 1);
        printOrder(order2);



    }

    /**
     * Lista todos os produtos disponíveis na loja.
     * 
     * Percorre a lista de produtos e exibe os detalhes de cada um, separados
     * por um delimitador visual (linha de hífens) para melhor legibilidade.
     */
    public static void listProducts() {

        for (var item : storeProducts) {
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    /**
     * Adiciona um item ao pedido.
     * 
     * Recupera um produto do catálogo pelo índice e cria um novo OrderItem
     * com a quantidade especificada, adicionando-o ao pedido.
     *
     * @param order a lista de itens do pedido
     * @param orderIndex o índice do produto no catálogo
     * @param qty a quantidade de unidades a adicionar
     */
    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex,
                                    int qty){
        order.add(new OrderItem(qty, storeProducts.get(orderIndex)));
    }

    /**
     * Imprime um pedido completo com o total da venda.
     * 
     * Exibe cada item do pedido com sua quantidade, preço unitário e descrição,
     * em seguida calcula e exibe o total da venda somando o preço de todos os itens.
     * O formato segue padrão de relatório de vendas.
     *
     * @param order a lista de itens do pedido a ser impresso
     */
    public static void printOrder(ArrayList<OrderItem> order) {

        double salesTotal = 0;
        for (var item : order) {
            item.product().printPricedItem(item.qty());
            salesTotal += item.product().getSalesPrice(item.qty());
        }
        System.out.printf("Total da venda: $%8.2f %n", salesTotal);
    }
}

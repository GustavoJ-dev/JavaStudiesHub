package praticas.store;
/**
 * Representa um item do estoque.
 *
 * Cada item possui um produto associado, seu preço, a quantidade
 * disponível em estoque, a quantidade reservada e os limites para
 * reposição automática.
 *
 *
 */
public class InventoryItem {

    /** Produto armazenado no estoque. */
    private Product product;

    /** Preço unitário do produto. */
    private double price;

    /** Quantidade total disponível em estoque. */
    private int qtyTotal;

    /** Quantidade atualmente reservada. */
    private int qtyReserved;

    /** Quantidade solicitada quando uma reposição é realizada. */
    private int qtyReorder;

    /** Quantidade mínima antes de solicitar reposição. */
    private int qtyLow;

    /**
     * Cria um novo item de estoque.
     *
     * @param product produto associado ao item
     * @param price preço unitário do produto
     * @param qtyTotal quantidade inicial em estoque
     * @param qtyLow quantidade mínima antes da reposição automática
     */
    public InventoryItem(Product product, double price,
                         int qtyTotal, int qtyLow) {

        this.product = product;
        this.price = price;
        this.qtyTotal = qtyTotal;
        this.qtyLow = qtyLow;
        this.qtyReorder = qtyTotal;
    }

    /**
     * Retorna o produto associado ao item.
     *
     * @return produto do estoque
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Retorna o preço unitário do produto.
     *
     * @return preço do produto
     */
    public double getPrice() {
        return price;
    }

    /**
     * Reserva uma quantidade do produto.
     *
     * A reserva será realizada apenas se houver quantidade disponível
     * suficiente, desconsiderando os itens já reservados.
     *
     *
     * @param qty quantidade a ser reservada
     * @return {@code true} se a reserva foi realizada com sucesso;
     * caso contrário, {@code false}
     */
    public boolean reserveItem(int qty) {

        if ((qtyTotal - qtyReserved) >= qty) {

            qtyReserved += qty;
            return true;
        }

        return false;
    }

    /**
     * Libera uma quantidade previamente reservada.
     *
     * @param qty quantidade a ser liberada
     */
    public void releaseItem(int qty) {

        qtyReserved -= qty;
    }

    /**
     * Efetua a venda de uma quantidade do produto.
     *
     * Caso a venda seja concluída, o estoque e a quantidade reservada
     * são atualizados. Se a quantidade disponível atingir o limite
     * mínimo, uma solicitação de reposição é emitida.
     *
     *
     * @param qty quantidade vendida
     * @return {@code true} se a venda foi realizada;
     * caso contrário, {@code false}
     */
    public boolean sellItem(int qty) {

        if (qtyTotal >= qty) {

            qtyTotal -= qty;
            qtyReserved -= qty;

            if (qtyTotal <= qtyLow) {
                placeInventoryOrder();
            }

            return true;
        }

        return false;
    }

    /**
     * Solicita a reposição automática do estoque.
     */
    private void placeInventoryOrder() {

        System.out.printf("Ordenando qty %d : %s%n",
                qtyReorder, product);
    }

    /**
     * Retorna uma representação textual do item de estoque,
     * contendo o produto, preço, quantidade disponível
     * e quantidade reservada.
     *
     * @return representação formatada do item
     */
    @Override
    public String toString() {

        return "%s, $%.2f : [%04d,% 2d]".formatted(
                product,
                price,
                qtyTotal,
                qtyReserved);
    }
}
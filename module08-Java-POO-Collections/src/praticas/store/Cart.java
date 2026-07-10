package praticas.store;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Representa um carrinho de compras.
 * <p>
 * Um carrinho armazena os produtos selecionados pelo cliente,
 * suas respectivas quantidades e a data de criação, permitindo
 * adicionar, remover e listar os itens adquiridos.
 * </p>
 *
 * @author Gustavo
 * @version 1.0
 */
public class Cart {

    /**
     * Representa os tipos de carrinho disponíveis.
     */
    enum CartType {

        /** Carrinho utilizado em compras realizadas em loja física. */
        FISICO,

        /** Carrinho utilizado em compras realizadas pela loja virtual. */
        VIRTUAL
    }

    /** Identificador utilizado para gerar novos carrinhos. */
    private static int lastId = 1;

    /** Identificador único do carrinho. */
    private int id;

    /** Data de criação do carrinho. */
    private LocalDate cartDate;

    /** Tipo do carrinho. */
    private CartType type;

    /** Produtos adicionados ao carrinho e suas respectivas quantidades. */
    private Map<String, Integer> products;

    /**
     * Cria um novo carrinho.
     *
     * @param type tipo do carrinho
     * @param days quantidade de dias subtraída da data atual para definir
     *             a data de criação do carrinho
     */
    public Cart(CartType type, int days) {

        this.type = type;
        id = lastId++;
        cartDate = LocalDate.now().minusDays(days);
        products = new HashMap<>();
    }


    /**
     * Retorna os produtos atualmente armazenados no carrinho.
     *
     * O mapa associa o SKU de cada produto à quantidade correspondente
     * adicionada ao carrinho.
     *
     * @return mapa contendo os produtos do carrinho e suas quantidades
     */
    public Map<String, Integer> getProducts() {
        return products;
    }


    /**
     * Cria uma referência para um carrinho existente.
     *
     * @param id identificador do carrinho
     */
    public Cart(int id) {
        this.id = id;
    }

    /**
     * Retorna o identificador do carrinho.
     *
     * @return identificador do carrinho
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna a data de criação do carrinho.
     *
     * @return data de criação
     */
    public LocalDate getCartDate() {
        return cartDate;
    }

    /**
     * Adiciona um produto ao carrinho.
     * <p>
     * Caso o produto já exista no carrinho, sua quantidade será
     * incrementada. O item também é reservado no estoque.
     * </p>
     *
     * @param item item de estoque a ser adicionado
     * @param qty quantidade do produto
     */
    public void addItem(InventoryItem item, int qty) {

        products.merge(item.getProduct().sku(), qty, Integer::sum);

        if (!item.reserveItem(qty)) {
            System.out.println(
                    "Ops, algo deu errado, não foi possivel adcionar o item");
        }
    }

    /**
     * Remove uma quantidade de um produto do carrinho.
     * <p>
     * Caso a quantidade removida seja igual ou superior à existente,
     * o produto será removido completamente do carrinho.
     * </p>
     *
     * @param item item a ser removido
     * @param qty quantidade a ser removida
     */
    public void removeItem(InventoryItem item, int qty) {

        int current = products.get(item.getProduct().sku());

        if (current <= qty) {

            qty = current;
            products.remove(item.getProduct().sku());

            System.out.printf(
                    "Item [%s] removido do carrinho%n",
                    item.getProduct().name());

        } else {

            products.merge(item.getProduct().sku(), qty,
                    (oldVal, newVal) -> oldVal - newVal);

            System.out.printf(
                    "%d [%s]s removido%n",
                    qty,
                    item.getProduct().name());
        }

        item.releaseItem(qty);
    }

    /**
     * Imprime o comprovante da compra.
     *
     * O comprovante apresenta todos os produtos do carrinho,
     * suas quantidades, preços unitários, subtotal por item
     * e o valor total da compra.

     *
     * @param inventory mapa contendo os itens disponíveis no estoque
     */
    public void printSalesSlip(
            Map<String, InventoryItem> inventory) {

        double total = 0;

        System.out.println("-----------------------------------");
        System.out.println("Obrigado por comprar");

        for (var cartItem : products.entrySet()) {

            var item = inventory.get(cartItem.getKey());

            int qty = cartItem.getValue();
            double itemizedPrice = item.getPrice() * qty;

            total += itemizedPrice;

            System.out.printf(
                    "\t%s %-10s (%d)@ $%.2f = $%.2f%n",
                    cartItem.getKey(),
                    item.getProduct().name(),
                    qty,
                    item.getPrice(),
                    itemizedPrice);
        }

        System.out.printf("Total da compra: $%.2f%n", total);
        System.out.println("-----------------------------------");
    }

    /**
     * Retorna uma representação textual do carrinho.
     *
     * @return representação do carrinho
     */
    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cartDate=" + cartDate +
                ", products=" + products +
                '}';
    }
}

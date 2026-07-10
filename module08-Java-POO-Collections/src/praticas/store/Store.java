package praticas.store;


import praticas.store.enums.Category;

import java.time.LocalDate;
import java.util.*;

/**
 * Representa uma loja responsável pelo gerenciamento de estoque,
 * carrinhos de compras e organização dos produtos por categoria.
 *
 * A classe demonstra operações como abastecimento do estoque,
 * criação de carrinhos, adição e remoção de produtos,
 * finalização de compras e tratamento de carrinhos abandonados.
 *
 */
public class Store {

    /**
     * Gerador de números aleatórios utilizado para definir os preços dos produtos.
     */
    private static Random random = new Random();

    /**
     * Estoque principal da loja, indexado pelo SKU dos produtos.
     */
    private Map<String, InventoryItem> inventory;

    /**
     * Conjunto de carrinhos ativos da loja.
     */
    private NavigableSet<Cart> carts =
            new TreeSet<>(Comparator.comparing(Cart::getId));

    /**
     * Produtos organizados por categoria.
     */
    private Map<Category, Map<String, InventoryItem>> aisleInventory;

    /**
     * Ponto de entrada da aplicação.
     *
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        Store store = new Store();

        store.stockStore();
        store.stockAisles();

        System.out.println("\n========== ESTOQUE INICIAL ==========");
        store.listInventory();

        store.demoAddItems();
        store.demoRemoveItems();
        store.demoCheckout();
        store.demoAbandonedCart();

        System.out.println("\n========== ESTOQUE FINAL ==========");
        store.listProductsByCategory(false, true);
    }

    /**
     * Demonstra a adição de produtos a um carrinho de compras.
     */
    private void demoAddItems() {

        System.out.println("\n========== ADICIONANDO PRODUTOS ==========");

        Cart cart = new Cart(Cart.CartType.FISICO, 1);
        carts.add(cart);

        cart.addItem(getItem(Category.HORTIFRUTI, "Maçã"), 6);
        cart.addItem(getItem(Category.HORTIFRUTI, "Pera"), 5);
        cart.addItem(getItem(Category.BEBIDAS, "Café"), 1);

        System.out.println("\nCarrinho após adicionar os produtos:");
        System.out.println(cart);
    }

    /**
     * Demonstra a remoção de produtos de um carrinho.
     */
    private void demoRemoveItems() {

        System.out.println("\n========== REMOVENDO PRODUTOS ==========");

        Cart cart = carts.first();

        cart.removeItem(getItem(Category.HORTIFRUTI, "Pera"), 2);

        System.out.println("\nCarrinho atualizado:");
        System.out.println(cart);
    }

    /**
     * Demonstra a finalização da compra de um carrinho.
     */
    private void demoCheckout() {

        System.out.println("\n========== FINALIZANDO COMPRA ==========");

        Cart cart = carts.first();

        if (!checkOutCart(cart)) {

            System.out.println("Não foi possível concluir a compra.");
        }
    }

    /**
     * Demonstra o tratamento de carrinhos abandonados.
     * <p>
     * Os itens reservados em carrinhos antigos são devolvidos
     * ao estoque.
     *
     */
    private void demoAbandonedCart() {

        System.out.println("\n========== CARRINHOS ABANDONADOS ==========");

        Cart cart = new Cart(Cart.CartType.VIRTUAL, 2);
        carts.add(cart);

        cart.addItem(getItem(Category.CEREAL, "Cereal de Arroz"), 10);
        cart.addItem(getItem(Category.BEBIDAS, "Chá"), 2);

        System.out.println("\nCarrinho criado:");
        System.out.println(cart);

        System.out.print("\nCarrinho Abandonado:");
        abandonCarts();

        System.out.println("\nCarrinhos restantes na loja:");
        carts.forEach(System.out::println);
    }

    /**
     * Retorna um item do estoque pertencente à categoria informada.
     *
     * @param category categoria do produto
     * @param productName nome do produto
     * @return item correspondente ou {@code null} caso não exista
     */
    private InventoryItem getItem(
            Category category,
            String productName) {

        return aisleInventory.get(category)
                .get(productName);
    }

    /**
     * Finaliza a compra de um carrinho.
     * <p>
     * Todos os itens são removidos do estoque, o comprovante
     * da compra é impresso e o carrinho é removido da lista
     * de carrinhos ativos.
     * </p>
     *
     * @param cart carrinho a ser finalizado
     * @return {@code true} caso a compra seja concluída com sucesso;
     * caso contrário, {@code false}
     */
    private boolean checkOutCart(Cart cart) {

        for (var cartItem : cart.getProducts().entrySet()) {

            var item = inventory.get(cartItem.getKey());
            int qty = cartItem.getValue();

            if (!item.sellItem(qty)) {

                return false;
            }
        }

        cart.printSalesSlip(inventory);
        carts.remove(cart);

        System.out.println("\nCompra finalizada com sucesso!");

        return true;
    }

    /**
     * Remove os carrinhos abandonados da loja.
     * <p>
     * Todos os produtos reservados nesses carrinhos são
     * devolvidos ao estoque.
     * </p>
     */
    private void abandonCarts() {

        int dayOfYear = LocalDate.now().getDayOfYear();

        Cart lastCart = null;

        for (Cart cart : carts) {

            if (cart.getCartDate().getDayOfYear() == dayOfYear) {

                break;
            }

            lastCart = cart;
        }

        if (lastCart == null) {

            System.out.println("\nNenhum carrinho abandonado encontrado.");
            return;
        }

        var oldCarts = carts.headSet(lastCart, true);

        Cart abandonedCart;

        while ((abandonedCart = oldCarts.pollFirst()) != null) {

            for (String sku : abandonedCart.getProducts().keySet()) {

                InventoryItem item = inventory.get(sku);

                item.releaseItem(
                        abandonedCart.getProducts().get(sku));
            }
        }

        System.out.println("\nCarrinhos abandonados removidos com sucesso.");
    }

    /**
     * Exibe os produtos organizados por categoria.
     */
    private void listProductsByCategory() {

        listProductsByCategory(true, false);
    }

    /**
     * Exibe os produtos agrupados por categoria.
     *
     * @param includeHeader indica se o nome da categoria deve ser exibido
     * @param includeDetail indica se serão exibidos os detalhes completos
     *                      dos produtos ou apenas seus nomes
     */
    private void listProductsByCategory(boolean includeHeader, boolean includeDetail) {

        aisleInventory.keySet().forEach(category -> {

            if (includeHeader) {

                System.out.println("\n========== " + category + " ==========");
            }

            if (!includeDetail) {

                aisleInventory.get(category).keySet()
                        .forEach(System.out::println);

            } else {

                aisleInventory.get(category).values()
                        .forEach(System.out::println);
            }
        });
    }

    /**
     * Abastece o estoque inicial da loja.
     *
     * Cria todos os produtos disponíveis e seus respectivos
     * itens de estoque com preços e quantidades iniciais.
     *
     */
    private void stockStore() {

        inventory = new HashMap<>();

        List<Product> products = List.of(

                new Product("A100", "Maçã",
                        "Produtor Local", Category.HORTIFRUTI),

                new Product("B100", "Banana",
                        "Produtor Local", Category.HORTIFRUTI),

                new Product("P100", "Pera",
                        "Produtor Local", Category.HORTIFRUTI),

                new Product("L103", "Limão",
                        "Produtor Local", Category.HORTIFRUTI),

                new Product("M201", "Leite",
                        "Fazenda Bela Vista", Category.LATICINIO),

                new Product("Y001", "Iogurte",
                        "Fazenda Bela Vista", Category.LATICINIO),

                new Product("C333", "Queijo",
                        "Fazenda Bela Vista", Category.LATICINIO),

                new Product("R777", "Cereal de Arroz",
                        "Nabisco", Category.CEREAL),

                new Product("G111", "Granola",
                        "Vale Natural", Category.CEREAL),

                new Product("BB11", "Carne Moída",
                        "Açougue Central", Category.CARNES),

                new Product("CC11", "Frango",
                        "Açougue Central", Category.CARNES),

                new Product("BC11", "Bacon",
                        "Açougue Central", Category.CARNES),

                new Product("BC77", "Refrigerante de Cola",
                        "Coca-Cola", Category.BEBIDAS),

                new Product("BC88", "Café",
                        "Marca Valor", Category.BEBIDAS),

                new Product("BC99", "Chá",
                        "Ervas Naturais", Category.BEBIDAS)
        );

        products.forEach(product -> inventory.put(product.sku(),
                        new InventoryItem(product,
                                random.nextDouble(0, 1.25), 1000, 5)));
    }

    /**
     * Organiza os produtos do estoque por categoria.
     */
    private void stockAisles() {

        aisleInventory = new EnumMap<>(Category.class);

        for (InventoryItem item : inventory.values()) {

            Category aisle = item.getProduct().category();

            Map<String, InventoryItem> productMap = aisleInventory.get(aisle);

            if (productMap == null) {

                productMap = new TreeMap<>();
            }

            productMap.put(item.getProduct().name(), item);

            aisleInventory.putIfAbsent(aisle, productMap);
        }
    }

    /**
     * Exibe todos os itens atualmente presentes no estoque.
     */
    private void listInventory() {

        System.out.println("--------------------------------------------");
        System.out.println("ESTOQUE DA LOJA");
        System.out.println("--------------------------------------------");

        inventory.values().forEach(System.out::println);
    }
}


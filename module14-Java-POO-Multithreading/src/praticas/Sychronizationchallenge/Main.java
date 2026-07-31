package praticas.Sychronizationchallenge;

import java.util.Random;

/**
 * Representa um pedido realizado ao armazém de calçados.
 * <p>
 * Cada pedido possui um identificador único, o produto
 * solicitado e a quantidade desejada.
 * </p>
 *
 * @param orderId identificador único do pedido
 * @param item produto solicitado
 * @param qty quantidade de unidades solicitadas
 */
record Order(long orderId, String item, int qty) {}

/**
 * Classe responsável por simular o padrão Produtor-Consumidor.
 * <p>
 * A aplicação cria uma thread produtora responsável por gerar
 * pedidos aleatórios e duas threads consumidoras encarregadas
 * de processá-los a partir do armazém de calçados.
 * </p>
 */
public class Main {

    /**
     * Gerador de números aleatórios utilizado para criar
     * identificadores, produtos e quantidades dos pedidos.
     */
    private static final Random random = new Random();

    /**
     * Ponto de entrada da aplicação.
     * <p>
     * Inicializa o armazém, cria uma thread produtora para gerar
     * pedidos e duas threads consumidoras para processá-los,
     * demonstrando a comunicação entre produtores e consumidores
     * utilizando sincronização.
     * </p>
     *
     */
    public static void main(String[] args) {

        ShoeWareHouse wareHouse = new ShoeWareHouse();

        Thread producerThread = new Thread(() -> {

            for (int j = 0; j < 10; j++) {

                wareHouse.receiveOrder(new Order(
                        random.nextLong(1_000_000, 9_999_999),
                        ShoeWareHouse.PRODUCT_LIST[random.nextInt(0, 5)],
                        random.nextInt(1, 4)));
            }
        });

        producerThread.start();

        for (int i = 0; i < 2; i++) {

            Thread consumerThread = new Thread(() -> {

                for (int j = 0; j < 5; j++) {

                    Order item = wareHouse.fulfillOrder();
                }
            });

            consumerThread.start();
        }
    }
}

package praticas.executorchallenge;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Representa um pedido realizado ao armazém de calçados.
 * <p>
 * Cada pedido possui um identificador único, o nome do produto
 * solicitado e a quantidade desejada.
 * </p>
 *
 * @param orderId identificador único do pedido
 * @param item nome do produto solicitado
 * @param qty quantidade de unidades solicitadas
 */
record Order(long orderId, String item, int qty){};

/**
 * Classe responsável por simular a geração e o processamento
 * concorrente de pedidos em um centro de distribuição de calçados.
 * <p>
 * Os pedidos são criados por múltiplas tarefas executadas por um
 * {@link ExecutorService} e enviados ao {@code ShoeWareHouse},
 * demonstrando o uso de programação concorrente em Java.
 * </p>
 */
public class Main {

    /**
     * Gerador de números aleatórios utilizado para criar pedidos
     * com identificadores, produtos e quantidades aleatórias.
     */
    private static final Random random = new Random();

    /**
     * Ponto de entrada da aplicação.
     * <p>
     * Inicializa o armazém, cria um conjunto de tarefas responsáveis
     * por gerar pedidos simultaneamente e aguarda a conclusão de todas
     * as tarefas antes de encerrar o processamento.
     * </p>
     */
    public static void main(String[] args) {

        ShoeWareHouse wareHouse = new ShoeWareHouse();

        ExecutorService orderingService = Executors.newCachedThreadPool();

        Callable<Order> orderingTask = () -> {

            Order newOrder = generateOrder();

            try {

                Thread.sleep(random.nextInt(500, 5000));
                wareHouse.receiveOrder(newOrder);

            } catch (InterruptedException e) {

                throw new RuntimeException(e);
            }

            return newOrder;
        };

        List<Callable<Order>> tasks =
                Collections.nCopies(15, orderingTask);

        try {

            orderingService.invokeAll(tasks);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }

        orderingService.shutdown();

        try {

            orderingService.awaitTermination(6, TimeUnit.SECONDS);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }

        wareHouse.shutDown();
    }

    /**
     * Gera um pedido com dados aleatórios.
     * <p>
     * O pedido recebe um identificador único, um produto da lista
     * disponível no armazém e uma quantidade aleatória entre
     * uma e três unidades.
     * </p>
     *
     * @return um novo pedido gerado aleatoriamente
     */
    private static Order generateOrder() {

        return new Order(
                random.nextLong(1_000_000, 9_999_999),
                ShoeWareHouse.PRODUCT_LIST[random.nextInt(0, 5)],
                random.nextInt(1, 4));
    }
}

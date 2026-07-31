package praticas.executorchallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Representa um centro de distribuição de calçados responsável
 * por receber e processar pedidos de forma concorrente.
 * <p>
 * A classe implementa o padrão Produtor-Consumidor, onde pedidos
 * são adicionados à fila por produtores e processados por um grupo
 * de consumidores executados por um {@link ExecutorService}.
 * A sincronização é realizada utilizando os métodos
 * {@code wait()} e {@code notifyAll()}.
 * </p>
 */
public class ShoeWareHouse {

    /**
     * Fila de pedidos aguardando processamento.
     */
    private List<Order> shippingItems;

    /**
     * Executor responsável por processar os pedidos recebidos.
     */
    private final ExecutorService fulfillmentService;

    /**
     * Lista de produtos disponíveis para realização dos pedidos.
     */
    public static final String[] PRODUCT_LIST = {
            "Tênis de Corrida",
            "Sandálias",
            "Botas",
            "Chinelos",
            "Tênis Cano Alto"
    };

    /**
     * Cria um novo centro de distribuição.
     * <p>
     * Inicializa a fila de pedidos e configura um pool fixo
     * com três consumidores responsáveis pelo processamento
     * dos pedidos.
     * </p>
     */
    public ShoeWareHouse() {

        this.shippingItems = new ArrayList<>();
        fulfillmentService = Executors.newFixedThreadPool(3);
    }

    /**
     * Encerra o executor responsável pelo processamento dos pedidos.
     */
    public void shutDown() {

        fulfillmentService.shutdown();
    }

    /**
     * Recebe um novo pedido e o adiciona à fila de processamento.
     * <p>
     * Caso a fila esteja cheia, a thread produtora aguarda até que
     * haja espaço disponível. Após adicionar o pedido, uma tarefa
     * é enviada ao executor para processá-lo.
     * </p>
     *
     * @param item pedido recebido pelo armazém
     */
    public synchronized void receiveOrder(Order item) {

        while (shippingItems.size() > 20) {

            try {

                wait();

            } catch (InterruptedException e) {

                throw new RuntimeException(e);
            }
        }

        shippingItems.add(item);

        System.out.println(
                Thread.currentThread().getName() +
                        " Entrada: " + item);

        fulfillmentService.submit(this::fulfillOrder);

        notifyAll();
    }

    /**
     * Processa o próximo pedido disponível na fila.
     * <p>
     * Caso não existam pedidos pendentes, a thread consumidora
     * permanece aguardando até que um novo pedido seja recebido.
     * </p>
     *
     * @return o pedido processado
     */
    public synchronized Order fulfillOrder() {

        while (shippingItems.isEmpty()) {

            try {

                wait();

            } catch (InterruptedException e) {

                throw new RuntimeException(e);
            }
        }

        Order item = shippingItems.remove(0);

        System.out.println(
                Thread.currentThread().getName() +
                        " Processado: " + item);

        notifyAll();

        return item;
    }
}

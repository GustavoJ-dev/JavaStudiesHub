package praticas.Sychronizationchallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um centro de distribuição de calçados responsável
 * por receber e processar pedidos utilizando o padrão
 * Produtor-Consumidor.
 * <p>
 * Os pedidos são armazenados em uma fila compartilhada.
 * Threads produtoras adicionam novos pedidos, enquanto
 * threads consumidoras os processam de forma sincronizada
 * utilizando os métodos {@code wait()} e {@code notifyAll()}.
 * </p>
 */
public class ShoeWareHouse {

    /**
     * Fila de pedidos aguardando processamento.
     */
    private List<Order> shippingItems;

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
     * Inicializa a fila responsável por armazenar os pedidos
     * recebidos.
     * </p>
     */
    public ShoeWareHouse() {

        this.shippingItems = new ArrayList<>();
    }

    /**
     * Recebe um novo pedido e o adiciona à fila de processamento.
     * <p>
     * Caso a fila esteja cheia, a thread produtora permanece
     * aguardando até que haja espaço disponível.
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

        System.out.println("Produtor adicionou: " + item);

        notifyAll();
    }

    /**
     * Processa o próximo pedido disponível na fila.
     * <p>
     * Caso não existam pedidos pendentes, a thread consumidora
     * aguarda até que um novo pedido seja recebido.
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
                Thread.currentThread().getName()
                        + " processou o pedido: " + item);

        notifyAll();

        return item;
    }
}

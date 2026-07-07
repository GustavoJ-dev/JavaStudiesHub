package pratices.interfaces.exercise47.linkedList;

import pratices.interfaces.exercise47.util.ListItem;
import pratices.interfaces.exercise47.util.NodeList;

/**
 * Implementação de uma lista encadeada ordenada que mantém os elementos
 * em ordem através de comparação. A lista permite adição, remoção e
 * percurso de elementos.
 *
 */
public class MyLinkedList implements NodeList {

    /**
     * O nó raiz da lista encadeada.
     */
    private ListItem root = null;

    /**
     * Constrói uma nova lista encadeada com um item raiz.
     *
     * @param root o primeiro item da lista
     */
    public MyLinkedList(ListItem root) {

        this.root = root;
    }


    /**
     * Retorna o nó raiz da lista.
     * 
     * Este metodo fornece acesso ao primeiro elemento da lista encadeada.
     * A raiz é o ponto de partida para qualquer operação que precise percorrer
     * ou acessar os elementos da lista.
     *
     * @return o primeiro item da lista, ou null se a lista estiver vazia
     */
    @Override
    public ListItem getRoot() {

        return this.root;
    }

    /**
     * Adiciona um item à lista mantendo a ordem através de comparação.
     * 
     * O funcionamento do metodo é o seguinte:
     * - Se a lista está vazia, o item se torna a raiz;
     * - Percorre a lista comparando o item a ser adicionado com cada elemento existente;
     * - Se o item deve ficar antes do elemento atual (compareTo maior que 0), insere antes
     *   e ajusta os links anterior/próximo;
     * - Se o item deve ficar depois (compareTo menor que 0), continua percorrendo;
     * - Se elementos são iguais (compareTo == 0), a adição é recusada (não permite duplicatas);
     * - Todos os links bidirecionais (anterior e próximo) são mantidos corretamente.
     *
     * @param item o item a ser adicionado
     * @return true se o item foi adicionado com sucesso, false se já existe um item igual
     */
    @Override
    public boolean addItem(ListItem item) {

        if (this.root == null) {

            this.root = item;
            return true;
        }
        ListItem currentItem = this.root;

        while (currentItem != null) {

            int comparison = (currentItem.compareTo(item));

            if (comparison < 0) {

                if (currentItem.next() != null) {

                    currentItem = currentItem.next();

                } else {

                    currentItem.setNext(item).setPrevious(currentItem);

                    return true;
                }
            } else if (comparison > 0) {

                if (currentItem.previous() != null){

                    currentItem.previous()
                            .setNext(item).
                            setPrevious(currentItem.previous());

                    item.setNext(currentItem).setPrevious(item);

                }else{

                    item.setNext(this.root).setPrevious(item);

                    this.root = item;
                }

                return true;

            }else{

                return false;
            }
        }
        return false;
    }

    /**
     * Remove um item da lista baseado no critério de comparação.
     * 
     * O funcionamento do metodo é o seguinte:
     * - Percorre toda a lista buscando um elemento que seja igual ao item a remover;
     * - Durante a busca, usa compareTo() para navegar: se o item procurado é menor,
     *   continua percorrendo; se é maior, item não existe na lista;
     * - Quando encontra (compareTo == 0), remove o nó desligando seus links;
     * - Se o item a remover é a raiz, atualiza a raiz para o próximo nó;
     * - Se é um item do meio, conecta o nó anterior ao próximo, mantendo a integridade
     *   dos links bidirecionais;
     * - Se é o último item, o nó anterior aponta para null como próximo;
     * - Imprime mensagem informando qual item foi deletado.
     *
     * @param item o item a ser removido
     * @return true se o item foi removido com sucesso, false se não foi encontrado
     */
    @Override
    public boolean removeItem(ListItem item) {

        if(item == null){

            return false;
        }

        System.out.println("Deletando item " + item.getValue());

        ListItem currentItem = this.root;

        while(currentItem != null){

            int comparison = currentItem.compareTo(item);

            if(comparison == 0){

                if (currentItem == this.root){

                    this.root = currentItem.next();

                    if(this.root != null){

                        this.root.setPrevious(null);
                    }

                }else{

                    currentItem.previous()
                            .setNext(currentItem.next());

                    if(currentItem.next() != null){

                        currentItem.next().setPrevious(currentItem.previous());
                    }

                }
                return true;

            } else if (comparison < 0) {

                currentItem = currentItem.next();

            } else {

                return false;
            }
        }
        return false;
    }

    /**
     * Percorre e exibe todos os elementos da lista a partir de um nó inicial.
     * 
     * O funcionamento do metodo é o seguinte:
     * - Verifica se a lista está vazia (root == null);
     * - Se vazia, exibe mensagem informando que a lista está vazia;
     * - Se não está vazia, começa do nó raiz (ou outro nó inicial fornecido);
     * - Itera através de cada nó usando o metodo next() para ir ao próximo elemento;
     * - Para cada nó, exibe o valor do elemento usando getValue();
     * - O percurso continua até encontrar um nó nulo (fim da lista);
     * - Este é um metodo útil para debugging e visualização da lista.
     *
     * @param root o nó inicial para começar o percurso (geralmente a raiz)
     */
    @Override
    public void traverse(ListItem root) {

        if (root == null){

            System.out.println("A lista esta vazia");

        }else {
            while (root != null){

                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }

    /**
     * Exibe a lista encadeada em formato visual de ligações.
     * 
     * Este metodo exibe a lista de forma visual mostrando como os nós estão ligados.
     * O funcionamento é o seguinte:
     * - Se a lista está vazia (root == null), exibe apenas "null";
     * - Se não está vazia, começa com "null" (representando antes da raiz);
     * - Para cada nó, exibe seu valor entre setas: &lt;- [valor] -&gt;;
     * - Continua percorrendo até o final da lista;
     * - Termina com "null" (representando após o último nó).
     * 
     * Exemplo de saída: null &lt;- [3] -&gt; &lt;- [5] -&gt; &lt;- [7] -&gt; null
     */
    public void printLinkedList() {

        if (root == null) {
            System.out.println("null");
            return;
        }

        ListItem current = root;

        System.out.print("null");

        while (current != null) {

            System.out.print(" <- [" + current.getValue() + "] ->");

            current = current.next();
        }

        System.out.println(" null");
    }
}

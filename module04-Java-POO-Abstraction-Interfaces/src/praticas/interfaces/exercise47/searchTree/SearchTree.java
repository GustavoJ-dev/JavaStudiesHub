package praticas.interfaces.exercise47.searchTree;

import praticas.interfaces.exercise47.util.ListItem;
import praticas.interfaces.exercise47.util.NodeList;

/**
 * Implementação de uma Árvore de Busca Binária que mantém elementos ordenados.
 * 
 * A SearchTree é uma estrutura de dados que implementa a interface NodeList e mantém
 * seus elementos em uma ordem específica usando comparação entre nós. Cada nó pode ter
 * referências para elementos anteriores (menores à esquerda) e próximos (maiores à direita),
 * formando uma estrutura de árvore binária de busca.
 * A árvore permite operações eficientes de busca, inserção e remoção de elementos.
 *
 * @author JavaStudiesHub
 * @version 1.0
 */
public class SearchTree implements NodeList{

    /**
     * A raiz da árvore, ponto de entrada para todas as operações.
     * É null quando a árvore está vazia.
     */
    private ListItem root = null;

    /**
     * Constrói uma SearchTree com um nó raiz inicial.
     * 
     * Inicializa a árvore de busca com um nó raiz fornecido. Se null for passado,
     * a árvore começará vazia e o primeiro elemento adicionado se tornará a raiz.
     *
     * @param root o nó que será definido como raiz da árvore
     */
    public SearchTree(ListItem root) {

        this.root = root;
    }
    /**
     * Retorna o nó raiz da árvore de busca.
     * 
     * Este metodo fornece acesso ao primeiro nó da estrutura, que é necessário
     * para iniciar qualquer operação de traversal ou busca na árvore.
     * Se a árvore está vazia, retorna null.
     *
     * @return o nó raiz da árvore, ou null se a árvore está vazia
     */
    @Override
    public ListItem getRoot() {
        return this.root;
    }

    /**
     * Adiciona um novo item à árvore de busca, mantendo a ordem de inserção.
     * 
     * O funcionamento do metodo é o seguinte:
     * - Se item é null, retorna false (não permite items nulos);
     * - Se a árvore está vazia (root == null), define o item como raiz e retorna true;
     * - Caso contrário, inicializa currentItem como a raiz para começar a busca;
     * - Enquanto currentItem não for null:
     *   * Compara o item atual com o novo item usando compareTo();
     *   * Se item atual é maior (comparison > 0):
     *     - Se há nó anterior, move para o anterior (currentItem = currentItem.previous());
     *     - Caso contrário, define item como anterior e retorna true;
     *   * Se item atual é menor (comparison &lt; 0):
     *     - Se há próximo nó, move para o próximo (currentItem = currentItem.next());
     *     - Caso contrário, define item como próximo e retorna true;
     *   * Se items são iguais (comparison == 0):
     *     - Exibe mensagem informando duplicata e retorna false (não permite duplicatas).
     *
     * @param item o item a ser adicionado à árvore. Não deve ser null
     * @return true se o item foi adicionado com sucesso;
     *         false se o item já existia e não foi adicionado (duplicata)
     */
    @Override
    public boolean addItem(ListItem item) {

        if (item == null){
            return false;
        }

        if (this.root == null){
            this.root = item;
            return true;
        }

        ListItem currentItem = this.root;

        while(currentItem != null){

            int comparison = currentItem.compareTo(item);

            System.out.printf(
                    "Atual: %s | Inserindo: %s | comparison: %d%n",
                    currentItem.getValue(),
                    item.getValue(),
                    comparison
            );

            if (comparison > 0){

                if (currentItem.previous() != null){

                    currentItem = currentItem.previous();

                } else {

                    currentItem.setPrevious(item);
                    return true;
                }
            }else if (comparison < 0){

                if (currentItem.next() != null){

                    currentItem = currentItem.next();

                }else {

                    currentItem.setNext(item);
                    return true;
                }

            }else {
                System.out.println(item.getValue() + " já existe. Não foi adicionado.");
                return false;
            }
        }
        return false;
    }

    /**
     * Remove um item da árvore de busca e reorganiza a estrutura.
     * 
     * O funcionamento do metodo é o seguinte:
     * - Se item é null, retorna false (não há item para remover);
     * - Inicializa currentItem como raiz e parentItem como null (para rastrear o nó pai);
     * - Enquanto currentItem não for null:
     *   * Compara currentItem com o item a ser removido usando compareTo();
     *   * Se item atual é maior (comparison > 0):
     *     - Salva currentItem em parentItem e move para o anterior (currentItem = currentItem.previous());
     *   * Se item atual é menor (comparison &lt; 0):
     *     - Salva currentItem em parentItem e move para o próximo (currentItem = currentItem.next());
     *   * Se items são iguais (comparison == 0):
     *     - Item encontrado! Chama performRemoval(currentItem, parentItem) para remover e retorna true;
     * - Se o loop termina sem encontrar, retorna false.
     * 
     * O metodo performRemoval() lida com três casos de remoção:
     * - Nó sem filho direito: redireciona para o filho esquerdo;
     * - Nó sem filho esquerdo: redireciona para o filho direito;
     * - Nó com ambos os filhos: encontra o sucessor e faz a substituição.
     *
     * @param item o item a ser removido da árvore
     * @return true se o item foi encontrado e removido com sucesso;
     *         false se o item não foi encontrado na árvore
     */
    @Override
    public boolean removeItem(ListItem item) {

        if (item == null){
            return false;
        }

        ListItem currentItem = this.root;
        ListItem parentItem = null;

        while (currentItem != null){

            int comparison = currentItem.compareTo(item);

            if (comparison > 0){

                parentItem = currentItem;
                currentItem = currentItem.previous();

            } else if (comparison < 0) {

                parentItem = currentItem;
                currentItem = currentItem.next();

            } else {

                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    /**
     * Percorre recursivamente toda a árvore em ordem (in-order) exibindo os valores.
     * 
     * O funcionamento do metodo é o seguinte:
     * - Caso base: Se root == null, a recursão termina (folha atingida ou árvore vazia);
     * - Passo recursivo: Para cada nó não-nulo:
     *   * Primeira chamada recursiva: traverse(root.previous()) para percorrer toda a
     *     sub-árvore esquerda (nós menores);
     *   * Processamento do nó: Exibe o valor do nó atual com System.out.println(root.getValue());
     *   * Segunda chamada recursiva: traverse(root.next()) para percorrer toda a sub-árvore
     *     direita (nós maiores).
     * 
     * Ordem de saída: Esta travessia em ordem (esquerda-raiz-direita) exibe os
     * elementos da árvore em ordem crescente.
     * 
     * Exemplo: Para uma árvore com valores [5, 3, 7, 2, 4, 6, 8],
     * a saída será: 2, 3, 4, 5, 6, 7, 8
     *
     * @param root o nó raiz a partir do qual iniciar a traversal. Se null, apenas
     *             termina a recursão sem fazer nada
     */
    @Override
    public void traverse(ListItem root) {

        if (root != null){

            traverse(root.previous());

            System.out.println(root.getValue());

            traverse(root.next());
        }

    }

    /**
     * Executa a remoção real de um nó da árvore e reorganiza a estrutura mantendo a ordem.
     * 
     * Este metodo privado lida com três casos distintos:
     * 
     * Caso 1 - Nó sem filho direito (item.next() == null):
     * - Verifica se item é o filho direito do pai: parent.next() == item.
     *   Se verdadeiro, redireciona parent.next() para o filho esquerdo do nó
     *   removido (parent.setNext(item.previous()));
     * - Verifica se item é o filho esquerdo do pai: parent.previous() == item.
     *   Se verdadeiro, redireciona parent.previous() para o filho esquerdo do nó
     *   removido (parent.setPrevious(item.previous()));
     * - Caso contrário, item é a raiz: atualiza this.root = item.previous();
     * 
     * Caso 2 - Nó sem filho esquerdo (item.previous() == null):
     * - Similar ao Caso 1, mas substitui o nó removido por seu filho direito
     *   (parent.setNext(item.next()) ou parent.setPrevious(item.next())
     *   ou this.root = item.next());
     * 
     * Caso 3 - Nó com ambos os filhos:
     * - Busca do sucessor: Inicializa current = item.next() e percorre para a
     *   esquerda enquanto há nós anteriores para encontrar o sucessor (menor nó
     *   da sub-árvore direita) e seu pai (leftMostParent);
     * - Iteração: Enquanto current.previous() != null:
     *   * Salva current em leftMostParent
     *   * Move para o anterior: current = current.previous();
     * - Substituição: Copia o valor do sucessor para o nó a ser removido:
     *   item.setValue(current.getValue());
     * - Reorganização:
     *   * Se o sucessor é o filho direito do nó removido (leftMostParent == item),
     *     redireciona: item.setNext(current.next());
     *   * Caso contrário, redireciona: leftMostParent.setNext(current.next());
     * 
     * Garantia de correção: Após a execução, a estrutura de árvore binária
     * de busca é mantida intacta com todos os invariantes preservados.
     *
     * @param item o nó a ser removido da árvore
     * @param parent o nó pai do item a ser removido (necessário para reorganização)
     */

    private void performRemoval(ListItem item, ListItem parent){

        System.out.println("Removendo item: " + item.getValue());

        // Caso 1: não possui filho direito
        if (item.next() == null) {

            if (parent == null) {
                this.root = item.previous();

            } else if (parent.previous() == item) {
                parent.setPrevious(item.previous());

            } else {
                parent.setNext(item.previous());
            }

            return;
        }

        // Caso 2: não possui filho esquerdo
        if (item.previous() == null) {

            if (parent == null) {
                this.root = item.next();

            } else if (parent.previous() == item) {
                parent.setPrevious(item.next());

            } else {
                parent.setNext(item.next());
            }

            return;
        }

        // Caso 3: possui dois filhos
        ListItem successorParent = item;
        ListItem successor = item.next();

        while (successor.previous() != null) {
            successorParent = successor;
            successor = successor.previous();
        }

        item.setValue(successor.getValue());

        if (successorParent == item) {
            successorParent.setNext(successor.next());
        } else {
            successorParent.setPrevious(successor.next());
        }
    }

    /**
     * Exibe a árvore de busca em formato visual de árvore.
     * 
     * Este metodo público inicia a visualização da árvore chamando printTree()
     * com os parâmetros iniciais apropriados (raiz, prefixo vazio e isTail = true).
     */
    public void printTree() {
        System.out.println("_".repeat(50));
        printTree(this.root, "", true);
    }

    /**
     * Exibe recursivamente os nós da árvore em formato de árvore visual.
     * 
     * O funcionamento do metodo é o seguinte:
     * - Caso base: Se node é null, retorna (encerra a recursão);
     * - Exibe o nó atual: Imprime o valor do nó com prefixo visual (├── ou └──);
     * - Verifica se há filhos: Se o nó tem anterior ou próximo;
     * - Recursão para filhos:
     *   * Chama printTree() para o filho esquerdo (anterior) com isTail = false;
     *   * Chama printTree() para o filho direito (próximo) com isTail = true;
     * - O parâmetro prefix mantém o indentation correto para visualização em árvore.
     *
     * @param node o nó a ser exibido
     * @param prefix o prefixo para indentação (construído recursivamente)
     * @param isTail indica se este é o último filho do pai (afeta o símbolo desenhado)
     */
    public void printTree(ListItem node, String prefix, boolean isTail){

        if (node == null){

            return;
        }

        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.getValue());

        if (node.previous() != null || node.next() != null) {

            printTree(node.previous(), prefix + (isTail ? "    " : "│   "), false);
            printTree(node.next(), prefix + (isTail ? "    " : "│   "), true);
        }
    }
}

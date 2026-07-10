package praticas.interfaces.exercise47.util;

/**
 * Interface que define o contrato para operações em uma lista encadeada ou árvore de busca.
 * 
 * Esta interface estabelece as operações básicas necessárias para gerenciar uma
 * estrutura de dados ordenada, incluindo acesso à raiz, adição de elementos,
 * remoção de elementos e percurso pela estrutura. Qualquer implementação desta
 * interface deve manter os elementos ordenados e gerenciar corretamente os
 * links entre os nós.
 *
 */
public interface NodeList {

    /**
     * Obtém o nó raiz (primeiro elemento) da lista encadeada.
     * 
     * Retorna o primeiro nó da lista, que é o ponto de partida para qualquer
     * operação de navegação ou percurso. Se a lista está vazia, deve retornar null.
     *
     * @return o primeiro nó da lista, ou null se vazia
     */
    ListItem getRoot();

    /**
     * Adiciona um novo item à lista mantendo a ordem.
     * 
     * Insere um item na posição correta de acordo com a ordem natural dos elementos.
     * A implementação deve garantir que não haja elementos duplicados e que a
     * lista permaneça ordenada após cada inserção. O funcionamento específico
     * depende da implementação (ordenação ascendente, descendente, etc).
     *
     * @param item o item a ser adicionado
     * @return true se o item foi adicionado com sucesso, false se não foi possível
     *         (por exemplo, item duplicado ou inválido)
     */
    boolean addItem(ListItem item);

    /**
     * Remove um item da lista.
     * 
     * Localiza e remove um item específico da lista. A implementação deve garantir
     * que após a remoção, os links entre os nós permaneçam corretos, mantendo
     * a integridade da lista encadeada. Se o item não for encontrado, a lista
     * permanece inalterada e o metodo retorna false.
     *
     * @param item o item a ser removido
     * @return true se o item foi removido com sucesso, false se não foi encontrado
     */
    boolean removeItem(ListItem item);

    /**
     * Percorre e exibe todos os elementos da lista.
     * 
     * Inicia um percurso a partir de um nó específico (geralmente a raiz) e
     * exibe ou processa cada elemento da lista até o final. Esta operação é
     * útil para debugging, visualização e verificação do conteúdo da lista.
     * A saída específica depende da implementação (pode ser um print, arquivo, etc).
     *
     * @param root o nó inicial para começar o percurso
     */
    void traverse(ListItem root);

}

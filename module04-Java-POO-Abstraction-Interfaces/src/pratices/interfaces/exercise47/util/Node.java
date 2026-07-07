package pratices.interfaces.exercise47.util;

/**
 * Implementação concreta de um nó para uma lista encadeada duplamente ligada.
 * 
 * Esta classe estende ListItem e implementa todos os métodos abstratos, fornecendo
 * uma implementação específica para navegação entre nós (próximo e anterior) e
 * comparação de elementos. Os valores armazenados são do tipo String e a comparação
 * segue a ordem lexicográfica. Os métodos utilizam rightLink para próximos (maiores)
 * e leftLink para anteriores (menores).
 *
 */
public class Node extends ListItem {

    /**
     * Constrói um novo nó com um valor específico.
     * 
     * Inicializa um nó que será parte de uma lista encadeada. O nó começa sem
     * links para anterior ou próximo (serão definidos quando inserido na lista).
     *
     * @param value o valor a ser armazenado neste nó
     */
    public Node(Object value) {
        super(value);
    }

    /**
     * Retorna o próximo nó na lista encadeada.
     * 
     * Implementação que retorna o link para direita (rightLink), que aponta
     * para o próximo elemento na sequência ordenada da lista.
     *
     * @return o próximo nó, ou null se este for o último elemento
     */
    @Override
    public ListItem next() {
        return this.rightLink;
    }

    /**
     * Define o próximo nó na lista encadeada.
     * 
     * Armazena a referência do próximo nó no atributo rightLink e retorna
     * esse nó, permitindo encadeamento de chamadas para configurações fluentes.
     *
     * @param item o nó a ser definido como próximo
     * @return o nó que foi definido como próximo (item.rightLink)
     */
    @Override
    public ListItem setNext(ListItem item) {
        this.rightLink = item;
        return this.rightLink;
    }

    /**
     * Retorna o nó anterior na lista encadeada.
     * 
     * Implementação que retorna o link para esquerda (leftLink), que aponta
     * para o elemento anterior na sequência ordenada da lista.
     *
     * @return o nó anterior, ou null se este for o primeiro elemento
     */
    @Override
    public ListItem previous() {
        return this.leftLink;
    }

    /**
     * Define o nó anterior na lista encadeada.
     * 
     * Armazena a referência do nó anterior no atributo leftLink e retorna
     * esse nó, permitindo encadeamento de chamadas para configurações fluentes.
     *
     * @param item o nó a ser definido como anterior
     * @return o nó que foi definido como anterior (item.leftLink)
     */
    @Override
    public ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return this.leftLink;
    }

    /**
     * Compara este nó com outro nó para determinar a ordem lexicográfica.
     * 
     * O funcionamento do metodo é o seguinte:
     * - Verifica se o item a comparar não é null;
     * - Se válido, converte os valores para String e compara lexicograficamente;
     * - Retorna um valor negativo se este nó é menor (vem antes alfabeticamente);
     * - Retorna zero se os valores são iguais;
     * - Retorna um valor positivo se este nó é maior (vem depois alfabeticamente);
     * - Se o item é null, retorna -1 para indicar que este nó é menor.
     *
     * @param item o nó a ser comparado com este
     * @return um valor negativo se este nó é menor, zero se iguais,
     *         ou um valor positivo se este nó é maior
     */
    @Override
    public int compareTo(ListItem item) {
        if (item != null){
            return ((String) super.getValue()).compareTo((String) item.getValue());
        }else {
            return -1;
        }
    }
}

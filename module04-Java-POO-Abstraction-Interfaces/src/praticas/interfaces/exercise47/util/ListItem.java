package praticas.interfaces.exercise47.util;

/**
 * Classe abstrata que representa um elemento (nó) em uma estrutura de dados encadeada.
 * 
 * Esta classe define a estrutura base para todos os itens que podem ser inseridos
 * em estruturas de dados como listas encadeadas duplamente ligadas ou árvores de busca.
 * Fornece os links para os nós anterior e próximo, além de armazenar um valor.
 * Subclasses devem implementar os métodos abstratos para navegação e comparação entre elementos.
 * 
 * A estrutura mantém referências bidirecionais (anterior e próximo) permitindo navegação
 * em ambas as direções e facilitando operações de inserção e remoção.
 *
 */
public abstract class ListItem {

    /**
     * Referência para o nó anterior na lista encadeada (link para esquerda).
     * É null se este for o primeiro elemento.
     */
    protected ListItem rightLink = null;

    /**
     * Referência para o próximo nó na lista encadeada (link para direita).
     * É null se este for o último elemento.
     */
    protected ListItem leftLink = null;

    /**
     * O valor armazenado neste nó da lista.
     * Pode ser qualquer tipo de objeto.
     */
    protected Object value;

    /**
     * Constrói um novo elemento de lista com um valor específico.
     * 
     * Inicializa um nó que pode ser inserido em uma lista encadeada. Os links
     * para anterior e próximo começam como null e serão configurados quando o
     * nó for adicionado à lista.
     *
     * @param value o valor a ser armazenado neste nó
     */
    public ListItem(Object value){
        this.value = value;
    }

    /**
     * Retorna o próximo nó na lista encadeada.
     * 
     * Este é um metodo abstrato que deve ser implementado pelas subclasses
     * para retornar a referência do nó seguinte (link para direita/próximo).
     *
     * @return o próximo nó na sequência, ou null se este for o último elemento
     */
    public abstract ListItem next();

    /**
     * Define o próximo nó na lista encadeada e retorna este nó.
     * 
     * Permite encadeamento de chamadas para configurar o próximo nó em uma
     * operação fluente. A implementação deve armazenar a referência do próximo
     * nó e retornar this para permitir chamadas encadeadas.
     *
     * @param item o nó a ser definido como próximo
     * @return this, permitindo encadeamento de chamadas
     */
    public abstract ListItem setNext(ListItem item);

    /**
     * Retorna o nó anterior na lista encadeada.
     * 
     * Este é um metodo abstrato que deve ser implementado pelas subclasses
     * para retornar a referência do nó anterior (link para esquerda/anterior).
     *
     * @return o nó anterior na sequência, ou null se este for o primeiro elemento
     */
    public abstract ListItem previous();

    /**
     * Define o nó anterior na lista encadeada e retorna este nó.
     * 
     * Permite encadeamento de chamadas para configurar o nó anterior em uma
     * operação fluente. A implementação deve armazenar a referência do nó anterior
     * e retornar this para permitir chamadas encadeadas.
     *
     * @param item o nó a ser definido como anterior
     * @return this, permitindo encadeamento de chamadas
     */
    public abstract ListItem setPrevious(ListItem item);

    /**
     * Compara este nó com outro nó para determinar a ordem entre eles.
     * 
     * Este é um metodo abstrato que deve ser implementado pelas subclasses.
     * A comparação é usada para manter a lista ordenada durante inserções e
     * para localizar elementos durante buscas e remoções.
     *
     * @param item o nó a ser comparado com este
     * @return um valor negativo se este nó é menor que o parâmetro,
     *         zero se são iguais, ou um valor positivo se este nó é maior
     */
    public abstract int compareTo(ListItem item);

    /**
     * Obtém o valor armazenado neste nó.
     * 
     * Retorna o objeto que foi armazenado quando este nó foi criado ou
     * modificado através do metodo setValue().
     *
     * @return o valor armazenado neste nó
     */
    public Object getValue() {
        return value;
    }

    /**
     * Define um novo valor para este nó.
     * 
     * Permite alterar o valor armazenado neste nó após sua criação.
     * Este metodo é útil quando o conteúdo do nó precisa ser atualizado.
     *
     * @param value o novo valor a ser armazenado
     */
    public void setValue(Object value){
        this.value = value;
    }

}

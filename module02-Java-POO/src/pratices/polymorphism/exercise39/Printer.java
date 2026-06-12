package pratices.polymorphism.exercise39;

/**
 * Representa uma impressora física com controle de nível de toner e contador de páginas.
 * Demonstra conceitos de encapsulamento ao proteger o estado do toner e das páginas impressas.
 */
public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    /**
     * Inicializa uma nova impressora.
     * 
     * @param duplex Define se a impressora possui funcionalidade de impressão frente e verso.
     * @param tonerLevel O nível inicial de toner. Valores fora do intervalo [0-100] resultam em -1.
     */
    public Printer(boolean duplex, int tonerLevel) {
        this.duplex = duplex;
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
        this.pagesPrinted = 0;
    }

    /**
     * Adiciona toner ao reservatório da impressora, respeitando o limite máximo de 100%.
     * 
     * @param tonerAmount Quantidade de toner a ser adicionada (1-100).
     * @return O novo nível de toner, ou -1 se a quantidade for inválida ou exceder a capacidade.
     */
    public int addToner(int tonerAmount){
        if (tonerAmount > 0 && tonerAmount <= 100){
            if(this.tonerLevel + tonerAmount > 100){
                return -1;
            }
            this.tonerLevel += tonerAmount;
            return this.tonerLevel;
        }
        return -1;
    }

    /**
     * Realiza a impressão de páginas. Se o modo duplex estiver ativo, o número de folhas
     * físicas utilizadas é reduzido pela metade (arredondado para cima).
     * 
     * @param pages Quantidade de páginas de conteúdo a imprimir.
     * @return O total de folhas físicas impressas.
     */
    public int printPages(int pages){
        int pagesToPrint = (this.duplex) ? (pages / 2) + (pages % 2) : pages;
        this.pagesPrinted += pagesToPrint;
        return pagesToPrint;
    }

    /**
     * @return O nível atual do toner.
     */
    public int getTonerLevel() {
        return tonerLevel;
    }

    /**
     * @return O total acumulado de páginas físicas impressas desde a criação do objeto.
     */
    public int getPagesPrinted() {
        return pagesPrinted;
    }

    /**
     * Verifica se a impressora está operando em modo duplex.
     * @return true se for duplex, false caso contrário.
     */
    public boolean isDuplex() {
        return duplex;
    }
}

package praticas.gameconsole.player.pirate;

/**
 * Representa os diferentes tipos de saque que podem ser encontrados
 * durante a exploração do jogo.
 *
 * <p>Cada item de saque possui um valor associado, utilizado para
 * determinar a quantidade de pontos concedida ao jogador ao encontrar
 * o item.</p>
 *
 */
public enum Loot {

    /**
     * Moeda de prata com valor de 5 pontos.
     */
    MOEDA_DE_PRATA(5),

    /**
     * Moeda de ouro com valor de 10 pontos.
     */
    MOEDA_DE_OURO(10),

    /**
     * Anel de ouro com valor de 125 pontos.
     */
    ANEL_DE_OURO(125),

    /**
     * Pérola com valor de 250 pontos.
     */
    PEROLA(250),

    /**
     * Barra de ouro com valor de 500 pontos.
     */
    BARRA_DE_OURO(500);

    /**
     * Valor em pontos associado ao item de saque.
     */
    private final int valor;

    /**
     * Cria um tipo de saque com o valor em pontos especificado.
     *
     * @param valor valor em pontos do item
     */
    Loot(int valor) {
        this.valor = valor;
    }

    /**
     * Retorna o valor em pontos associado ao item de saque.
     *
     * @return valor em pontos do item
     */
    public int getValue() {
        return valor;
    }
}
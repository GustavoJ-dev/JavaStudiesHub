package praticas.collections.cardgame.game.poker;


/**
 * Representa as possíveis classificações de uma mão de cartas.
 *
 * Os valores deste enum podem ser utilizados para identificar a força
 * de uma combinação durante a avaliação de uma partida.
 *
 */
public enum Ranking {

    /** Nenhuma combinação encontrada. */
    NONE,

    /** Um único par de cartas de mesmo valor. */
    ONE_PAIR,

    /** Dois pares distintos. */
    TWO_PAIR,

    /** Três cartas de mesmo valor. */
    THREE_OF_A_KIND,

    /** Uma trinca e um par. */
    FULL_HOUSE,

    /** Quatro cartas de mesmo valor. */
    FOUR_OF_A_KIND;


    /**
     * Retorna uma representação legível do ranking.
     * Os caracteres de sublinhado ('_') são substituídos por espaços,
     * tornando o texto mais apropriado para exibição ao usuário.
     *
     * Exemplo:
     *
     * Ranking.THREE_OF_A_KIND.toString()
     * // Retorna: "THREE OF A KIND"
     *
     * @return nome formatado do ranking
     */
    @Override
    public String toString() {
        return this.name().replace('_', ' ');
    }
}

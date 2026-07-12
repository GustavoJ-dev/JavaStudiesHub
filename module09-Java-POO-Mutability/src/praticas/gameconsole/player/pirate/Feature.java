package praticas.gameconsole.player.pirate;

/**
 * Representa características, elementos e eventos encontrados
 * durante a exploração das cidades no jogo.
 *
 * <p>Cada característica possui uma quantidade de pontos de vida
 * associada, podendo causar dano ou recuperar a vida do jogador.</p>
 *
 * <p>Valores negativos representam perda de vida, enquanto valores
 * positivos representam recuperação de pontos de vida.</p>
 */
public enum Feature {

    /**
     * Jacaré que causa a perda de 45 pontos de vida.
     */
    JACARE(-45),

    /**
     * Aloe que recupera 5 pontos de vida.
     */
    BABOSA(5),

    /**
     * Água-viva que causa a perda de 10 pontos de vida.
     */
    AGUA_VIVA(-10),

    /**
     * Abacaxi que recupera 10 pontos de vida.
     */
    ABACAXI(10),

    /**
     * Cobra que causa a perda de 25 pontos de vida.
     */
    COBRA(-25),

    /**
     * Nascente que recupera 25 pontos de vida.
     */
    NASCENTE(25),

    /**
     * Insolação que causa a perda de 15 pontos de vida.
     */
    INSOLACAO(-15);

    /**
     * Quantidade de pontos de vida associada à característica.
     */
    private final int healthPoints;

    /**
     * Cria uma característica com a quantidade de pontos de vida
     * especificada.
     *
     * @param healthPoints pontos de vida aplicados ao jogador
     */
    Feature(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * Retorna a quantidade de pontos de vida associada à característica.
     *
     * @return pontos de vida aplicados ao jogador
     */
    public int getHealthPoints() {
        return healthPoints;
    }
}
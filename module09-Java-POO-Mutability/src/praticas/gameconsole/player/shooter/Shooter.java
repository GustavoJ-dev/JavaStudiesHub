package praticas.gameconsole.player.shooter;

import praticas.gameconsole.player.interfaces.Player;

/**
 * Representa um jogador do tipo atirador utilizado no jogo.
 *
 * <p>O atirador possui um nome de identificação e implementa
 * o contrato definido pela interface {@link Player}.</p>
 *
 * <p>Além das características básicas de um jogador, esta implementação
 * fornece ações específicas, como procurar prêmios e utilizar armas
 * durante a execução do jogo.</p>
 *
 * @param name nome do jogador
 */
public record Shooter(String name) implements Player {

    /**
     * Simula a descoberta de um prêmio pelo jogador.
     *
     * <p>Ao encontrar um prêmio, uma mensagem informando o ajuste
     * da pontuação é exibida.</p>
     *
     * @return sempre {@code false}, indicando que o jogo deve continuar
     */
    boolean findPrize() {

        System.out.println(
                "Prêmio encontrado, a pontuação foi ajustada."
        );

        return false;
    }

    /**
     * Simula a utilização de uma arma pelo jogador.
     *
     * @param weapon arma utilizada pelo jogador
     * @return sempre {@code false}, indicando que o jogo deve continuar
     */
    boolean useWeapon(String weapon) {

        System.out.println("Você usou sua " + weapon);

        return false;
    }
}

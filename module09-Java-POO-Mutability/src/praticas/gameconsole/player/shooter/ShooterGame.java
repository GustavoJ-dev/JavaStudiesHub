package praticas.gameconsole.player.shooter;

import praticas.gameconsole.game.Game;
import praticas.gameconsole.game.GameAction;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Representa uma implementação de jogo de tiro baseada na estrutura
 * genérica definida pela classe {@link Game}.
 *
 * <p>Esta classe utiliza jogadores do tipo {@link Shooter} e define
 * ações específicas do jogo, como procurar prêmios e utilizar armas.</p>
 *
 * <p>Além das ações específicas, o jogo também incorpora as ações
 * padrão definidas pela classe base.</p>
 */
public class ShooterGame extends Game<Shooter> {

    /**
     * Cria uma nova instância do jogo de tiro.
     *
     * @param gameName nome do jogo
     */
    public ShooterGame(String gameName) {
        super(gameName);
    }

    /**
     * Cria um novo jogador do tipo {@link Shooter}.
     *
     * @param name nome do jogador
     * @return nova instância de {@code Shooter}
     */
    @Override
    public Shooter createNewPlayer(String name) {

        return new Shooter(name);
    }

    /**
     * Retorna as ações disponíveis no jogo para o jogador informado.
     *
     * <p>O mapa contém ações específicas do jogo de tiro e também
     * incorpora as ações padrão definidas pela classe {@link Game}.</p>
     *
     * @param playerIndex índice do jogador
     * @return mapa contendo as ações disponíveis no jogo
     */
    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {

        var map = new LinkedHashMap<>(Map.of(
                'F', new GameAction(
                        'F',
                        "Encontrar Prêmio",
                        this::findPrize
                ),
                'S', new GameAction(
                        'S',
                        "Use sua Arma",
                        this::useWeapon
                )
        ));

        map.putAll(getStandardActions());

        return map;
    }

    /**
     * Executa a ação de procurar um prêmio para o jogador informado.
     *
     * @param playerIndex índice do jogador
     * @return resultado da execução da ação
     */
    public boolean findPrize(int playerIndex) {

        return getPlayer(playerIndex).findPrize();
    }

    /**
     * Executa a ação de utilizar uma arma para o jogador informado.
     *
     * <p>Nesta implementação, o jogador utiliza uma pistola.</p>
     *
     * @param playerIndex índice do jogador
     * @return resultado da execução da ação
     */
    public boolean useWeapon(int playerIndex) {

        return getPlayer(playerIndex).useWeapon("Pistola");
    }
}

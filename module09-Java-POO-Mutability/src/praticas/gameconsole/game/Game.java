package praticas.gameconsole.game;

import praticas.gameconsole.player.interfaces.Player;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Representa a estrutura base para implementação de jogos.
 *
 * Esta classe abstrata gerencia os jogadores participantes e define
 * ações padrão disponíveis durante a execução do jogo.
 *
 * <p>O tipo genérico {@code T} deve representar uma implementação ou
 * especialização de {@link Player}.
 *
 * @param <T> tipo de jogador utilizado pelo jogo
 */
public abstract class Game<T extends Player> {

    private final String gameName;
    private final List<T> players = new ArrayList<>();
    private Map<Character, GameAction> standardActions = null;

    /**
     * Cria uma nova instância de jogo.
     *
     * @param gameName nome do jogo
     */
    public Game(String gameName) {
        this.gameName = gameName;
    }

    /**
     * Retorna o nome do jogo.
     *
     * @return nome do jogo
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * Retorna as ações padrão disponíveis no jogo.
     *
     * As ações são inicializadas apenas na primeira chamada deste metodo.
     * Entre as ações padrão estão a exibição das informações do jogador
     * e a opção de encerrar o jogo.
     *
     * @return mapa contendo as ações padrão do jogo
     */
    public Map<Character, GameAction> getStandardActions() {

        if (standardActions == null) {

            standardActions = new LinkedHashMap<>(Map.of(
                    'I',
                    new GameAction(
                            'I',
                            "Imprimir informações do Jogador",
                            i -> this.printPlayer(i)
                    ),
                    'Q',
                    new GameAction(
                            'Q',
                            "Sair do Jogo",
                            this::quitGame
                    )
            ));
        }

        return standardActions;
    }

    /**
     * Cria um novo jogador específico para a implementação do jogo.
     *
     * @param name nome do jogador
     * @return jogador criado
     */
    public abstract T createNewPlayer(String name);

    /**
     * Retorna as ações disponíveis para determinado jogador.
     *
     * @param playerIndex índice do jogador
     * @return mapa contendo as ações disponíveis
     */
    public abstract Map<Character, GameAction> getGameActions(int playerIndex);

    /**
     * Cria e adiciona um novo jogador à lista de participantes.
     *
     * @param name nome do jogador
     * @return índice do jogador adicionado ou {@code -1} caso
     *         o jogador não seja criado
     */
    final int addPlayer(String name) {

        T player = createNewPlayer(name);

        if (player != null) {
            players.add(player);
            return players.size() - 1;
        }

        return -1;
    }

    /**
     * Retorna o jogador localizado no índice informado.
     *
     * @param playerIndex índice do jogador
     * @return jogador correspondente ao índice
     */
    protected final T getPlayer(int playerIndex) {
        return players.get(playerIndex);
    }

    /**
     * Executa uma ação do jogo para o jogador informado.
     *
     * @param player índice do jogador
     * @param action ação que será executada
     * @return {@code true} caso a ação indique o encerramento da execução;
     *         {@code false} caso contrário
     */
    public boolean executeGameAction(int player, GameAction action) {
        return action.action().test(player);
    }

    /**
     * Exibe as informações do jogador.
     *
     * @param playerIndex índice do jogador
     * @return sempre {@code false}
     */
    public boolean printPlayer(int playerIndex) {

        T player = players.get(playerIndex);
        System.out.println(player);

        return false;
    }

    /**
     * Encerra a participação do jogador no jogo e exibe
     * uma mensagem de despedida.
     *
     * @param playerIndex índice do jogador
     * @return sempre {@code true}, indicando o encerramento do jogo
     */
    public boolean quitGame(int playerIndex) {

        T player = players.get(playerIndex);
        System.out.println("Adeus" + player.name());

        return true;
    }
}

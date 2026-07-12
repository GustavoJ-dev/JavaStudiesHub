package praticas.gameconsole.player.pirate;

import praticas.gameconsole.game.Game;
import praticas.gameconsole.game.GameAction;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Representa a implementação principal do jogo de piratas.
 *
 * <p>A classe gerencia o mapa de níveis, as cidades disponíveis,
 * as ações executadas pelos jogadores e a interação entre o
 * {@link Pirate} e os diferentes elementos presentes no jogo.</p>
 *
 * <p>Cada nível possui uma lista de {@link Town} que representa
 * as cidades disponíveis durante a progressão do jogador.</p>
 */
public class PirateGame extends Game<Pirate> {

    /**
     * Mapa contendo as cidades organizadas por nível.
     *
     * <p>Cada posição da lista principal representa um nível,
     * enquanto a lista interna contém as cidades disponíveis
     * naquele nível.</p>
     */
    private static final List<List<Town>> levelMap;

    //------------------------------------------------------------
    static {

        levelMap = new ArrayList<>();

        System.out.println("Carregando dados...");

        loadData();

        if (levelMap.size() == 0) {

            throw new RuntimeException(
                    "Não foi possível carregar os dados. Tente novamente mais tarde."
            );
        }

        System.out.println("Carregamento de dados concluído.");
    }
    //------------------------------------------------------------

    /**
     * Cria um novo jogo de piratas.
     *
     * @param gameName nome do jogo
     */
    public PirateGame(String gameName) {

        super(gameName);
    }

    /**
     * Cria um novo jogador do tipo {@link Pirate}.
     *
     * @param name nome do jogador
     * @return novo pirata criado
     */
    @Override
    public Pirate createNewPlayer(String name) {

        return new Pirate(name);
    }

    /**
     * Retorna as ações disponíveis para o jogador.
     *
     * <p>As ações são definidas dinamicamente de acordo com o
     * estado atual do pirata. Caso existam oponentes, as armas
     * disponíveis para o nível atual são adicionadas ao menu.</p>
     *
     * <p>Também são adicionadas ações relacionadas à procura de
     * saques e à exploração das características da cidade.</p>
     *
     * @param playerIndex índice do jogador
     * @return mapa contendo as ações disponíveis
     */
    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {

        Pirate pirate = getPlayer(playerIndex);

        System.out.println(pirate);

        List<Weapon> weapons =
                Weapon.getWeaponsByLevel(pirate.value("Nível"));

        Map<Character, GameAction> map = new LinkedHashMap<>();

        if (pirate.hasOpponents()) {

            for (Weapon weapon : weapons) {

                char init = weapon.name().charAt(0);

                map.put(
                        init,
                        new GameAction(
                                init,
                                "Usar " + weapon,
                                this::useWeapon
                        )
                );
            }
        }

        map.put(
                'F',
                new GameAction(
                        'F',
                        "Procurar saque",
                        this::findLoot
                )
        );

        if (pirate.hasExperiences()) {

            map.put(
                    'X',
                    new GameAction(
                            'X',
                            "Explorar característica da cidade",
                            this::experienceFeature
                    )
            );
        }

        map.putAll(getStandardActions());

        return map;
    }

    /**
     * Carrega os dados iniciais do mapa do jogo.
     *
     * <p>As cidades são organizadas em listas de acordo com
     * o nível necessário para acessá-las.</p>
     */
    private static void loadData() {

        // Cidades do nível 0
        levelMap.add(new ArrayList<Town>(List.of(
                new Town("Bridgetown", "Barbados", 0),
                new Town("Fitts Village", "Barbados", 0),
                new Town("Holetown", "Barbados", 0)
        )));

        // Cidades do nível 1
        levelMap.add(new ArrayList<Town>(List.of(
                new Town("Fort-de-France", "Martinica", 1),
                new Town("Sainte-Anne", "Martinica", 1),
                new Town("Le Vauclin", "Martinica", 1)
        )));
    }

    /**
     * Retorna as cidades disponíveis para o nível informado.
     *
     * @param level nível atual do jogo
     * @return lista de cidades disponíveis para o nível ou
     * {@code null} caso o nível não exista
     */
    public static List<Town> getTowns(int level) {

        if (level <= (levelMap.size() - 1)) {

            return levelMap.get(level);
        }

        return null;
    }

    /**
     * Executa a ação de utilizar uma arma.
     *
     * @param playerIndex índice do jogador
     * @return resultado da ação executada pelo pirata
     */
    private boolean useWeapon(int playerIndex) {

        return getPlayer(playerIndex).useWeapon();
    }

    /**
     * Executa uma ação selecionada pelo jogador.
     *
     * <p>Antes da execução da ação, a arma atual do pirata é
     * definida utilizando a tecla associada à ação selecionada.</p>
     *
     * @param player índice do jogador
     * @param action ação que será executada
     * @return {@code true} caso a ação finalize o jogo;
     * {@code false} caso contrário
     */
    @Override
    public boolean executeGameAction(int player, GameAction action) {

        getPlayer(player).setCurrentWeapon(
                Weapon.getWeaponByChar(action.key())
        );

        return super.executeGameAction(player, action);
    }

    /**
     * Exibe as informações detalhadas do jogador.
     *
     * @param playerIndex índice do jogador
     * @return sempre {@code false}, mantendo o jogo em execução
     */
    @Override
    public boolean printPlayer(int playerIndex) {

        System.out.println(
                getPlayer(playerIndex).information()
        );

        return false;
    }

    /**
     * Executa a ação de procurar um saque na cidade atual.
     *
     * @param playerIndex índice do jogador
     * @return resultado da procura pelo saque
     */
    private boolean findLoot(int playerIndex) {

        return getPlayer(playerIndex).findLoot();
    }

    /**
     * Executa uma interação com uma característica da cidade atual.
     *
     * @param playerIndex índice do jogador
     * @return resultado da interação
     */
    private boolean experienceFeature(int playerIndex) {

        return getPlayer(playerIndex).experienceFeature();
    }
}

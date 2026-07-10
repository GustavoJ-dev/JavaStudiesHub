package praticas.maps.adventuregame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Representa um jogo de aventura baseado em texto.
 *
 * O jogador pode explorar diferentes locais conectados entre si,
 * navegando pelos pontos cardeais (Norte, Sul, Leste e Oeste).
 * Cada localização possui uma descrição e um conjunto de destinos
 * que podem ser alcançados a partir dela.
 *
 */
public class AdventureGame {

    /**
     * Dados padrão contendo todas as localizações do jogo e suas conexões.
     */
    private static final String GAME_LOCATIONS = """
            ...
            """;

    /**
     * Representa as direções da bússola utilizadas para navegação.
     */
    private enum Compass {

        /** Leste. */
        L,

        /** Norte. */
        N,

        /** Sul. */
        S,

        /** Oeste. */
        O;

        /** Nome completo de cada direção. */
        private static final String[] directions = {
                "Leste",
                "Norte",
                "Sul",
                "Oeste"
        };

        /**
         * Retorna o nome completo da direção.
         *
         * @return nome da direção
         */
        public String getString() {
            return directions[this.ordinal()];
        }
    }

    /**
     * Representa uma localização do mapa.
     *
     * @param description descrição do local
     * @param nextPlaces destinos acessíveis a partir da localização
     */
    private record Location(String description,
                            Map<Compass, String> nextPlaces) {
    }

    /** Última localização visitada pelo jogador. */
    private String lastPlace;

    /** Mapa contendo todas as localizações do jogo. */
    private Map<String, Location> adventureMap = new HashMap<>();

    /**
     * Cria um jogo utilizando apenas o mapa padrão.
     */
    public AdventureGame() {
        this(null);
    }

    /**
     * Cria um jogo permitindo adicionar localizações personalizadas.
     *
     * As localizações informadas são carregadas após o mapa padrão,
     * podendo adicionar ou substituir locais existentes.
     *
     *
     * @param customLocations dados das localizações adicionais;
     *                        pode ser {@code null}
     */
    public AdventureGame(String customLocations) {

        loadLocations(GAME_LOCATIONS);

        if (customLocations != null) {
            loadLocations(customLocations);
        }
    }

    /**
     * Carrega as localizações contidas na representação textual do mapa.
     *
     * @param data texto contendo as localizações e suas conexões
     */
    private void loadLocations(String data) {

        for (String s : data.split("\\R")) {

            String[] parts = s.split(",", 3);
            Arrays.asList(parts).replaceAll(String::trim);

            Map<Compass, String> nextPlaces =
                    loadDirections(parts[2]);

            Location location =
                    new Location(parts[1], nextPlaces);

            adventureMap.put(parts[0], location);
        }
    }

    /**
     * Converte a descrição textual das direções em um mapa de destinos.
     *
     * @param nextPlaces texto contendo as direções e seus destinos
     * @return mapa associando cada direção ao respectivo destino
     */
    private Map<Compass, String> loadDirections(String nextPlaces) {

        Map<Compass, String> directions = new HashMap<>();

        List<String> nextSteps =
                Arrays.asList(nextPlaces.split(","));

        nextSteps.replaceAll(String::trim);

        for (String nextPlace : nextSteps) {

            String[] splits = nextPlace.split(":");

            Compass compass =
                    Compass.valueOf(splits[0].trim());

            String destination = splits[1].trim();

            directions.put(compass, destination);
        }

        return directions;
    }

    /**
     * Exibe ao jogador a localização atual e os caminhos disponíveis.
     *
     * @param location localização a ser visitada
     */
    private void visit(Location location) {

        System.out.printf("*** Você está de pé %s *** %n",
                location.description);

        System.out.println("\tDaqui, Você pode ver:");

        location.nextPlaces.forEach((k, v) ->
                System.out.printf(
                        "\t• Um %s para o %s (%S) %n",
                        v,
                        k.getString(),
                        k));

        System.out.print(
                "Selecione a Bússola ou (Q para Sair) >> ");
    }

    /**
     * Move o jogador para uma nova localização de acordo com a direção
     * informada.
     *
     * Caso a direção seja válida e exista um destino correspondente,
     * o jogador será deslocado automaticamente.
     *
     *
     * @param direction direção escolhida pelo jogador
     */
    public void move(String direction) {

        var nextPlaces = adventureMap.get(lastPlace).nextPlaces;

        String nextPlace = null;

        if ("LNSO".contains(direction)) {

            nextPlace =
                    nextPlaces.get(Compass.valueOf(direction));

            if (nextPlace != null) {
                play(nextPlace);
            }

        } else {

            System.out.println(
                    "Direção inválida, tente de novo!");
        }
    }

    /**
     * Inicia ou continua o jogo a partir de uma localização.
     *
     * Caso a localização exista no mapa, ela passa a ser a posição
     * atual do jogador e suas informações são exibidas.
     *
     *
     * @param location nome da localização a ser visitada
     */
    public void play(String location) {

        if (adventureMap.containsKey(location)) {

            Location next = adventureMap.get(location);

            lastPlace = location;

            visit(next);

        } else {

            System.out.println(
                    location + " não é uma localização válida!");
        }
    }
}
package praticas.gameconsole.player.pirate;

import java.util.*;

/**
 * Representa um jogador do tipo pirata utilizado no jogo.
 *
 * <p>Esta classe especializa {@link Combatant} e implementa os
 * comportamentos específicos relacionados à exploração de cidades,
 * combate contra oponentes, coleta de saques e interação com
 * características encontradas durante a jornada.</p>
 *
 * <p>Por ser uma classe {@code final}, esta implementação não pode
 * ser estendida por outras classes.</p>
 */
public final class Pirate extends Combatant {

    private final List<Town> townsVisited = new LinkedList<Town>();
    private List<Loot> loot;
    private List<Combatant> opponents;
    private List<Feature> features;

    /**
     * Cria um novo pirata com o nome informado.
     *
     * <p>O jogador inicia no nível e na cidade inicial do jogo.
     * Após sua criação, a primeira cidade é visitada automaticamente.</p>
     *
     * @param name nome do pirata
     */
    public Pirate(String name) {

        super(name, Map.of("Nível", 0, "CidadeIndex", 0));
        visitTown();
    }

    /**
     * Executa um ataque contra um dos oponentes presentes
     * na cidade atual.
     *
     * <p>Caso existam múltiplos oponentes, um deles é selecionado
     * aleatoriamente. Quando o adversário é derrotado, ele é removido
     * da lista de oponentes.</p>
     *
     * <p>Se o ataque do pirata não derrotar o adversário,
     * o oponente realiza um contra-ataque.</p>
     *
     * @return {@code true} caso o contra-ataque derrote o pirata;
     *         {@code false} caso contrário
     */
    boolean useWeapon() {

        int count = opponents.size();

        if (count > 0) {

            int opponentIndex = count - 1;

            if (count > 1) {
                opponentIndex = new Random().nextInt(count);
            }

            Combatant combatant = opponents.get(opponentIndex);

            if (super.useWeapon(combatant)) {

                opponents.remove(opponentIndex);

            } else {

                return combatant.useWeapon(this);
            }
        }

        return false;
    }

    /**
     * Visita a cidade correspondente ao nível e índice atual
     * armazenados nos dados do jogador.
     *
     * <p>Ao visitar uma cidade, seus saques, oponentes e características
     * são carregados para utilização durante a exploração.</p>
     *
     * @return {@code true} caso não existam cidades disponíveis;
     *         {@code false} quando a cidade é visitada com sucesso
     */
    boolean visitTown() {

        List<Town> levelTowns = PirateGame.getTowns(value("Nível"));

        if (levelTowns == null) {
            return true;
        }

        Town town = levelTowns.get(value("CidadeIndex"));

        if (town != null) {

            townsVisited.add(town);
            loot = town.loot();
            opponents = town.opponents();
            features = town.features();

            return false;
        }

        return true;
    }

    /**
     * Verifica se existem características disponíveis para
     * serem exploradas na cidade atual.
     *
     * @return {@code true} caso existam características disponíveis;
     *         {@code false} caso contrário
     */
    boolean hasExperiences() {

        return features != null && features.size() > 0;
    }

    /**
     * Verifica se existem oponentes na cidade atual.
     *
     * @return {@code true} caso existam oponentes;
     *         {@code false} caso contrário
     */
    boolean hasOpponents() {

        return opponents != null && opponents.size() > 0;
    }

    /**
     * Retorna as informações atuais do pirata.
     *
     * <p>Além dos dados básicos herdados de {@link Combatant},
     * são exibidas a cidade atual e todas as cidades visitadas
     * durante a jornada.</p>
     *
     * @return informações atuais do pirata
     */
    @Override
    public String information() {

        var current = ((LinkedList<Town>) townsVisited).getLast();

        String[] simpleNames = new String[townsVisited.size()];

        Arrays.setAll(
                simpleNames,
                i -> townsVisited.get(i).name()
        );

        return "---> " + current +
                "\n" + super.information() +
                "\n\tcidadesVisitadas=" + Arrays.toString(simpleNames);
    }

    /**
     * Procura e coleta um saque disponível na cidade atual.
     *
     * <p>O valor do saque encontrado é adicionado aos pontos
     * do jogador. Quando todos os saques da cidade são coletados,
     * o pirata avança automaticamente para a próxima cidade.</p>
     *
     * @return resultado da tentativa de avançar para a próxima cidade
     */
    boolean findLoot() {

        if (loot.size() > 0) {

            Loot item = loot.remove(0);

            System.out.println("Encontrado " + item + "!");

            adjustValue("pontos", item.getValue());

            System.out.println(
                    name() + "'s pontos agora: " + value("pontos")
            );
        }

        if (loot.size() == 0) {
            return visitNextTown();
        }

        return false;
    }

    /**
     * Interage com uma característica disponível na cidade atual.
     *
     * <p>Os pontos de vida associados à característica são aplicados
     * à vida do jogador.</p>
     *
     * @return {@code true} caso a vida do pirata chegue a zero;
     *         {@code false} caso contrário
     */
    boolean experienceFeature() {

        if (features.size() > 0) {

            Feature item = features.remove(0);

            System.out.println("Encontrei " + item + "!");

            adjustHealth(item.getHealthPoints());

            System.out.println(
                    name() + "'s vida agora: " + value("vida")
            );
        }

        return value("vida") <= 0;
    }

    /**
     * Avança o jogador para a próxima cidade disponível.
     *
     * <p>Caso a cidade atual seja a última do nível, o jogador
     * avança para o próximo nível, recebe {@code 500} pontos
     * de bônus e retorna ao índice inicial de cidades.</p>
     *
     * <p>Caso contrário, o jogador avança para a próxima cidade
     * e recebe {@code 50} pontos de bônus.</p>
     *
     * @return resultado da visita à próxima cidade
     */
    private boolean visitNextTown() {

        int townIndex = value("CidadeIndex");

        List<Town> towns = PirateGame.getTowns(value("Nível"));

        if (towns == null) {
            return true;
        }

        if (townIndex >= towns.size() - 1) {

            System.out.println(
                    "Subiu de nível! Bonus: 500 pontos!"
            );

            adjustValue("pontos", 500);
            adjustValue("Nível", 1);
            setValue("CidadeIndex", 0);

        } else {

            System.out.println(
                    "Indo a próxima cidade! Bonus: 50 pontos!"
            );

            adjustValue("CidadeIndex", 1);
            adjustValue("pontos", 50);
        }

        return visitTown();
    }
}

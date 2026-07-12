package praticas.gameconsole.player.pirate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

/**
 * Representa uma cidade disponível para exploração durante o jogo.
 *
 * <p>Cada cidade possui um nome, uma ilha de localização e um nível
 * associado. Além disso, contém saques, características especiais
 * e oponentes que podem ser encontrados pelo jogador.</p>
 *
 * <p>Os elementos disponíveis na cidade são gerados de forma
 * parcialmente aleatória com base no nível informado.</p>
 *
 * @param name nome da cidade
 * @param island ilha onde a cidade está localizada
 * @param level nível associado à cidade
 * @param loot lista de saques disponíveis
 * @param features lista de características disponíveis
 * @param opponents lista de oponentes presentes na cidade
 */
public record Town(String name, String island, int level,
                   List<Loot> loot,
                   List<Feature> features,
                   List<Combatant> opponents) {

    /**
     * Inicializa os dados da cidade.
     *
     * <p>Os saques e características são selecionados aleatoriamente
     * a partir dos valores disponíveis em seus respectivos enums.</p>
     *
     * <p>Os oponentes são definidos de acordo com o nível da cidade.
     * Cidades de nível inicial possuem adversários mais simples,
     * enquanto níveis superiores apresentam combatentes adicionais
     * e armas mais poderosas.</p>
     */
    public Town {

        loot = randomReduced(
                new ArrayList<>(EnumSet.allOf(Loot.class)), level + 2);

        features = randomReduced(
                new ArrayList<>(EnumSet.allOf(Feature.class)), level + 3);

        opponents = new ArrayList<>();

        if (level == 0) {

            opponents.add(new Islander("Joe", Weapon.FACA));

        } else {

            opponents.add(new Islander("Joe", Weapon.MACHETE));

            opponents.add(new Soldier("John", Weapon.PISTOLA));
        }
    }

    /**
     * Cria uma nova cidade utilizando nome, ilha e nível.
     *
     * <p>Os saques, características e oponentes são definidos
     * automaticamente durante a inicialização da cidade.</p>
     *
     * @param name nome da cidade
     * @param island ilha onde a cidade está localizada
     * @param level nível associado à cidade
     */
    public Town(String name, String island, int level) {

        this(name, island, level, null, null, null);
    }

    /**
     * Embaralha uma lista e retorna uma quantidade reduzida
     * de seus elementos.
     *
     * <p>Os elementos são reorganizados aleatoriamente antes
     * da criação da sublista.</p>
     *
     * @param list lista que será processada
     * @param size quantidade de elementos retornados
     * @param <T> tipo dos elementos da lista
     * @return sublista contendo elementos selecionados aleatoriamente
     */
    private <T> List<T> randomReduced(List<T> list, int size) {

        Collections.shuffle(list);

        return list.subList(0, size);
    }

    /**
     * Retorna uma representação textual simplificada da cidade.
     *
     * @return nome da cidade e ilha de localização
     */
    @Override
    public String toString() {

        return name + ", " + island;
    }

    /**
     * Retorna as informações detalhadas da cidade.
     *
     * <p>As informações incluem os saques, características
     * e oponentes disponíveis.</p>
     *
     * @return informações detalhadas da cidade
     */
    public String information() {

        return "Cidade: " + this +
                "\n\tSaques=" + loot +
                "\n\tCaracterísticas=" + features +
                "\n\tOponentes=" + opponents;
    }

    /**
     * Retorna uma cópia da lista de saques disponíveis.
     *
     * @return cópia da lista de saques ou {@code null}
     *         caso a lista não esteja disponível
     */
    public List<Loot> loot() {

        return (loot == null) ? null : new ArrayList<>(loot);
    }

    /**
     * Retorna uma cópia da lista de oponentes presentes na cidade.
     *
     * @return cópia da lista de oponentes ou {@code null}
     *         caso a lista não esteja disponível
     */
    public List<Combatant> opponents() {

        return (opponents == null) ? null : new ArrayList<>(opponents);
    }

    /**
     * Retorna uma cópia da lista de características disponíveis.
     *
     * @return cópia da lista de características ou {@code null}
     *         caso a lista não esteja disponível
     */
    public List<Feature> features() {

        return (features == null) ? null : new ArrayList<>(features);
    }
}

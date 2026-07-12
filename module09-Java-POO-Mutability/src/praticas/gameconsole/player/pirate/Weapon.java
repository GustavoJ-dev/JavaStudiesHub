package praticas.gameconsole.player.pirate;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Representa as armas disponíveis no jogo.
 *
 * <p>Cada arma possui um nível mínimo necessário para utilização
 * e uma quantidade de pontos de dano aplicada ao atingir outro
 * {@link Combatant}.</p>
 *
 * <p>O enum também fornece métodos utilitários para localizar armas
 * por sua inicial e filtrar as armas disponíveis de acordo com o
 * nível atual do jogador.</p>
 *
 */
public enum Weapon {

    /**
     * Faca disponível desde o nível inicial e com 10 pontos de dano.
     */
    FACA(0, 10),

    /**
     * Machado disponível desde o nível inicial e com 30 pontos de dano.
     */
    ADAGA(0, 10),

    /**
     * Machete disponível a partir do nível 1 e com 40 pontos de dano.
     */
    MACHETE(1, 40),

    /**
     * Pistola disponível a partir do nível 1 e com 50 pontos de dano.
     */
    PISTOLA(1, 50);

    /**
     * Nível mínimo necessário para utilizar a arma.
     */
    private final int minLevel;

    /**
     * Quantidade de pontos de dano causados pela arma.
     */
    private final int hitPoints;

    /**
     * Cria uma arma com o nível mínimo e os pontos de dano especificados.
     *
     * @param minLevel nível mínimo necessário para utilizar a arma
     * @param hitPoints quantidade de pontos de dano causados pela arma
     */
    Weapon(int minLevel, int hitPoints) {

        this.minLevel = minLevel;
        this.hitPoints = hitPoints;
    }

    /**
     * Retorna o nível mínimo necessário para utilizar a arma.
     *
     * @return nível mínimo da arma
     */
    public int getMinLevel() {

        return minLevel;
    }

    /**
     * Retorna a quantidade de pontos de dano causados pela arma.
     *
     * @return pontos de dano da arma
     */
    public int getHitPoints() {

        return hitPoints;
    }

    /**
     * Localiza uma arma utilizando a primeira letra de seu nome.
     *
     * <p>O mEtodo percorre todas as armas disponíveis e compara
     * a primeira letra do nome de cada constante com o caractere
     * informado.</p>
     *
     * <p>Caso nenhuma arma seja encontrada, a primeira arma declarada
     * no enum será retornada como valor padrão.</p>
     *
     * @param firstInitial inicial da arma procurada
     * @return arma correspondente à inicial informada ou a primeira
     * arma do enum caso nenhuma correspondência seja encontrada
     */
    public static Weapon getWeaponByChar(char firstInitial) {

        for (Weapon w : values()) {

            if (w.name().charAt(0) == firstInitial) {

                return w;
            }
        }

        return values()[0];
    }

    /**
     * Retorna uma lista contendo as armas disponíveis para o nível
     * de jogo informado.
     *
     * <p>Inicialmente, uma lista é criada com todas as constantes
     * do enum utilizando {@link EnumSet}. Em seguida, são removidas
     * as armas cujo nível mínimo seja superior ao nível atual
     * do jogador.</p>
     *
     * @param levelOfPlay nível atual do jogador
     * @return lista de armas disponíveis para o nível informado
     */
    public static List<Weapon> getWeaponsByLevel(int levelOfPlay) {

        List<Weapon> weapons = new ArrayList<>(EnumSet.allOf(Weapon.class));

        weapons.removeIf(w -> (w.minLevel > levelOfPlay));

        return weapons;
    }
}

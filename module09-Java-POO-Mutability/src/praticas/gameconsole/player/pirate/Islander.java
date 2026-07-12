package praticas.gameconsole.player.pirate;

/**
 * Representa um habitante de uma ilha no jogo.
 *
 * <p>Um {@code Islander} é um tipo específico de {@link Combatant}
 * que possui uma arma definida no momento de sua criação.</p>
 *
 * <p>Por ser uma classe {@code final}, não pode ser utilizada como
 * superclasse para criação de novos tipos de combatentes.</p>
 *
 */
public final class Islander extends Combatant {

    /**
     * Cria um novo habitante da ilha com o nome e a arma especificados.
     *
     * <p>O nome do combatente é inicializado pela superclasse
     * {@link Combatant}, enquanto a arma atual é definida após
     * a inicialização do objeto.</p>
     *
     * @param name nome do habitante da ilha
     * @param weapon arma inicial utilizada pelo combatente
     */
    public Islander(String name, Weapon weapon) {

        super(name);
        setCurrentWeapon(weapon);
    }
}
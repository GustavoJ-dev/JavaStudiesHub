package praticas.gameconsole.player.pirate;

import praticas.gameconsole.player.interfaces.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Representa a estrutura base de um combatente utilizado no jogo.
 *
 * <p>Esta classe abstrata implementa o contrato definido por
 * {@link Player} e concentra os dados e comportamentos compartilhados
 * pelos diferentes tipos de combatentes.</p>
 *
 * <p>Por ser uma classe {@code sealed}, somente {@link Islander},
 * {@link Pirate} e {@link Soldier} podem estender diretamente
 * esta classe.</p>
 *
 * <p>Cada combatente possui informações de jogo, como vida e pontos,
 * além de uma arma atualmente equipada.</p>
 */
public sealed abstract class Combatant implements Player
        permits Islander, Pirate, Soldier {

    private final String name;
    private final Map<String, Integer> gameData;
    private Weapon currentWeapon;

    /**
     * Cria um novo combatente com o nome informado.
     *
     * @param name nome do combatente
     */
    public Combatant(String name) {
        this.name = name;
    }

    /**
     * Cria um novo combatente utilizando dados de jogo previamente
     * definidos.
     *
     * <p>Os dados informados são adicionados aos valores padrão
     * inicialmente configurados para o combatente.</p>
     *
     * @param name nome do combatente
     * @param gameData dados iniciais do jogo
     */
    public Combatant(String name, Map<String, Integer> gameData) {

        this.name = name;

        if (gameData != null) {
            this.gameData.putAll(gameData);
        }
    }

    /**
     * Inicializa os dados padrão de cada combatente.
     */
    {
        gameData = new HashMap<>(Map.of(
                "vida", 100,
                "pontos", 0
        ));
    }

    /**
     * Retorna a arma atualmente equipada pelo combatente.
     *
     * @return arma atualmente equipada
     */
    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    /**
     * Define a arma utilizada pelo combatente.
     *
     * @param currentWeapon nova arma do combatente
     */
    void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    /**
     * Retorna o valor associado ao dado de jogo informado.
     *
     * @param name nome do dado
     * @return valor associado ao dado
     */
    int value(String name) {
        return gameData.get(name);
    }

    /**
     * Define um novo valor para determinado dado do jogo.
     *
     * @param name nome do dado
     * @param value novo valor
     */
    protected void setValue(String name, int value) {
        gameData.put(name, value);
    }

    /**
     * Ajusta o valor de determinado dado do jogo.
     *
     * <p>O valor informado é somado ao valor atualmente armazenado.</p>
     *
     * @param name nome do dado
     * @param adj valor utilizado no ajuste
     */
    protected void adjustValue(String name, int adj) {
        gameData.compute(name, (k, v) -> v += adj);
    }

    /**
     * Ajusta a vida do combatente.
     *
     * <p>O valor da vida permanece limitado entre {@code 0} e
     * {@code 100}, independentemente do valor utilizado no ajuste.</p>
     *
     * @param adj valor utilizado no ajuste da vida
     */
    protected void adjustHealth(int adj) {

        int health = value("vida");

        health += adj;
        health = (health < 0)
                ? 0
                : ((health > 100) ? 100 : health);

        setValue("vida", health);
    }

    /**
     * Executa um ataque utilizando a arma atualmente equipada.
     *
     * <p>O ataque possui um resultado aleatório. Caso o combatente
     * acerte o adversário, os pontos de dano da arma são removidos
     * da vida do oponente e o atacante recebe pontos.</p>
     *
     * @param opponent combatente que receberá o ataque
     * @return {@code true} caso a vida do oponente chegue a zero;
     *         {@code false} caso contrário
     */
    boolean useWeapon(Combatant opponent) {

        System.out.print(name + "Usou " + currentWeapon);

        if (new Random().nextBoolean()) {

            System.out.println(
                    " e ACERTOU *** " + opponent.name + "! ***"
            );

            opponent.adjustHealth(-currentWeapon.getHitPoints());

            System.out.printf(
                    "%s's vida=%d, %s's vida=",
                    name,
                    value("vida"),
                    opponent.name(),
                    opponent.value("vida")
            );

            adjustValue("pontos", 50);

        } else {

            System.out.println(" E ERROU!");
        }

        return opponent.value("vida") <= 0;
    }

    /**
     * Retorna o nome do combatente.
     *
     * @return nome do combatente
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * Retorna a representação textual do combatente.
     *
     * @return nome do combatente
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Retorna as informações atuais do combatente.
     *
     * @return nome e dados atuais do jogo
     */
    public String information() {
        return name + " " + gameData;
    }
}

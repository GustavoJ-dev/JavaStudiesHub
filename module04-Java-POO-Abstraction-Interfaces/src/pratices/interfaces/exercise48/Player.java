package pratices.interfaces.exercise48;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um jogador no jogo.
 * Implementa ISaveable para permitir salvamento e carregamento do estado do jogador.
 * 
 * Um jogador possui nome, pontos de vida e nível de experiência.
 * 
 * @author Sistema de Jogo
 * @version 1.0
 */
public class Player implements ISaveable {

    /** Nome do jogador */
    private String name;
    
    /** Pontos de vida do jogador */
    private int hitPoints;
    
    /** Nível de experiência do jogador */
    private int level;

    /**
     * Constrói um jogador com nome, pontos de vida e nível especificados.
     * 
     * @param name nome do jogador
     * @param hitPoints pontos de vida iniciais
     * @param level nível de experiência inicial
     */
    public Player(String name, int hitPoints, int level) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.level = level;
    }

    /**
     * Obtém o nome do jogador.
     * 
     * @return nome do jogador
     */
    public String getName() {
        return name;
    }

    /**
     * Obtém os pontos de vida do jogador.
     * 
     * @return pontos de vida
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Obtém o nível de experiência do jogador.
     * 
     * @return nível de experiência
     */
    public int getLevel() {
        return level;
    }

    /**
     * Retorna uma representação em string do jogador.
     * 
     * @return string formatada com os dados do jogador
     */
    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + name + '\'' +
                ", pontos_vida=" + hitPoints +
                ", nivel=" + level +
                '}';
    }

    /**
     * Serializa os dados do jogador para uma lista de strings.
     * Utilizado para salvamento de jogo.
     * 
     * @return lista contendo [nome, hitPoints, level]
     */
    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0, name);
        values.add(1, "" + hitPoints);
        values.add(2, "" + level);
        return values;
    }

    /**
     * Deserializa os dados do jogador a partir de uma lista de strings.
     * Utilizado para carregamento de jogo.
     * 
     * @param savedValues lista contendo [nome, hitPoints, level]
     */
    @Override
    public void read(List<String> savedValues) {
        if (savedValues != null && savedValues.size() > 0) {
            name = savedValues.get(0);
            hitPoints = Integer.parseInt(savedValues.get(1));
            level = Integer.parseInt(savedValues.get(2));
        }
    }
}

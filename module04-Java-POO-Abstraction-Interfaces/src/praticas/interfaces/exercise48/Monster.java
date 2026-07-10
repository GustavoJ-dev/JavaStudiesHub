package praticas.interfaces.exercise48;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um monstro no jogo.
 * Implementa ISaveable para permitir salvamento e carregamento do estado do monstro.
 * 
 * Um monstro possui nome, pontos de vida e força de ataque.
 * 
 * @author Sistema de Jogo
 * @version 1.0
 */
public class Monster implements ISaveable {

    /** Nome do monstro */
    private String name;
    
    /** Pontos de vida do monstro */
    private int hitPoints;
    
    /** Força de ataque do monstro */
    private int strength;

    /**
     * Constrói um monstro com nome, pontos de vida e força especificados.
     * 
     * @param name nome do monstro
     * @param hitPoints pontos de vida iniciais
     * @param strength força de ataque inicial
     */
    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    /**
     * Obtém o nome do monstro.
     * 
     * @return nome do monstro
     */
    public String getName() {
        return name;
    }

    /**
     * Obtém os pontos de vida do monstro.
     * 
     * @return pontos de vida
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Obtém a força de ataque do monstro.
     * 
     * @return força de ataque
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Retorna uma representação em string do monstro.
     * 
     * @return string formatada com os dados do monstro
     */
    @Override
    public String toString() {
        return "Monstro{" +
                "nome='" + name + '\'' +
                ", pontos_vida=" + hitPoints +
                ", forca=" + strength +
                '}';
    }

    /**
     * Serializa os dados do monstro para uma lista de strings.
     * Utilizado para salvamento de jogo.
     * 
     * @return lista contendo [nome, hitPoints, strength]
     */
    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0, name);
        values.add(1, "" + hitPoints);
        values.add(2, "" + strength);
        return values;
    }

    /**
     * Deserializa os dados do monstro a partir de uma lista de strings.
     * Utilizado para carregamento de jogo.
     * 
     * @param savedValues lista contendo [nome, hitPoints, strength]
     */
    @Override
    public void read(List<String> savedValues) {
        if (savedValues != null && savedValues.size() > 0) {
            name = savedValues.get(0);
            hitPoints = Integer.parseInt(savedValues.get(1));
            strength = Integer.parseInt(savedValues.get(2));
        }
    }
}

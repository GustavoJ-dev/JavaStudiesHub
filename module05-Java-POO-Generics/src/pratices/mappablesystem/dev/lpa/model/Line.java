package pratices.mappablesystem.dev.lpa.model;

import pratices.mappablesystem.dev.lpa.util.Mappable;

import java.util.Arrays;

/**
 * Representa uma forma geográfica do tipo linha (Line).
 * Implementa {@link Mappable} para permitir a renderização de múltiplos pontos conectados.
 */
public abstract class Line implements Mappable {

    /**
     * Matriz que armazena as coordenadas (latitude e longitude) dos pontos que compõem a linha.
     */
    private double[][] locations;

    /**
     * Construtor que inicializa a linha a partir de uma série de strings de localização.
     *
     * @param location Strings no formato "latitude, longitude".
     */
    protected Line(String... location) {
        this.locations = new double[location.length][];
        int index = 0;
        for (var loc : location) {
            this.locations[index++] = Mappable.location(loc);
        }
    }

    /**
     * Formata as coordenadas das localizações para exibição.
     *
     * @return Uma representação em string da matriz de coordenadas.
     */
    private String locations() {
        return Arrays.deepToString(locations);
    }

    /**
     * Renderiza a linha no console, exibindo seu tipo e as coordenadas que a compõem.
     */
    @Override
    public void render() {
        System.out.println("Render " + this + " as LINE (" + locations() + ")");
    }
}

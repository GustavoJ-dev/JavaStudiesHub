package module10.learning.mappablesystem.dev.lpa.model;

import module10.learning.mappablesystem.dev.lpa.util.Mappable;

import java.util.Arrays;

/**
 * Representa uma forma geográfica do tipo ponto (Point).
 * Implementa {@link Mappable} para permitir a renderização de uma única coordenada geográfica.
 */
public abstract class Point implements Mappable {
    /**
     * Array que armazena a coordenada (latitude e longitude) do ponto.
     */
    private double[] location = new double[2];

    /**
     * Construtor que inicializa o ponto a partir de uma string de localização.
     *
     * @param location String no formato "latitude, longitude".
     */
    public Point(String location) {
        this.location = Mappable.location(location);
    }

    /**
     * Formata a coordenada da localização para exibição.
     *
     * @return Uma representação em string do array de coordenadas.
     */
    private String location() {
        return Arrays.toString(location);
    }

    /**
     * Renderiza o ponto no console, exibindo seu tipo e sua coordenada.
     */
    @Override
    public void render() {
        System.out.println("Render " + this + " as POINT (" + location() + ")");
    }
}

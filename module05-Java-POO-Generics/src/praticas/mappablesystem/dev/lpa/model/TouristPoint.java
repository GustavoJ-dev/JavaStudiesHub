package praticas.mappablesystem.dev.lpa.model;

/**
 * Representa um ponto turístico no sistema de mapeamento.
 * Estende a classe {@link Point}, pois um ponto turístico é visualizado geograficamente como uma coordenada única.
 */
public class TouristPoint extends Point {

    /**
     * O nome do ponto turístico.
     */
    private String name;

    /**
     * Construtor que inicializa um ponto turístico com sua localização e nome.
     *
     * @param location String da coordenada no formato "latitude, longitude".
     * @param name     O nome do ponto turístico (ex: "Cristo Redentor").
     */
    public TouristPoint(String name, String location) {
        super(location);
        this.name = name;
    }

    /**
     * Retorna uma representação textual amigável do ponto turístico.
     *
     * @return O nome do ponto turístico seguido do sufixo " Tourist Point".
     */
    @Override
    public String toString() {
        return name + " Tourist Point";
    }
}

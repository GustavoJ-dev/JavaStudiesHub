package pratices.mappablesystem.dev.lpa.model;

/**
 * Representa um rio no sistema de mapeamento.
 * Estende a classe {@link Line}, pois um rio é visualizado geograficamente como uma linha composta por múltiplos pontos.
 */
public class Rivers extends Line {

    /**
     * O nome do rio.
     */
    private String name;

    /**
     * Construtor que inicializa um rio com nome e suas coordenadas geográficas.
     *
     * @param name      O nome do rio (ex: "Amazonas").
     * @param locations Sequência de strings de coordenadas no formato "latitude, longitude".
     */
    public Rivers(String name, String... locations) {
        super(locations);
        this.name = name;
    }

    /**
     * Retorna uma representação textual amigável do rio.
     *
     * @return O nome do rio seguido do sufixo " River".
     */
    @Override
    public String toString() {
        return name + " River";
    }
}

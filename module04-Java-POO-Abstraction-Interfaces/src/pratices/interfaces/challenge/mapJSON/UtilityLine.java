package pratices.interfaces.challenge.mapJSON;

/**
 * Enumeração que define os tipos de linhas de utilidade.
 */
enum TipoUtilidade {ELETRICIDADE, FIBRA_OPTICA, GAS, AGUA}

/**
 * Classe que representa uma linha de utilidade/infraestrutura mapeável.
 * Uma linha de utilidade representa redes como água, gás, energia elétrica
 * ou fibra óptica no mapa.
 * 
 * @author Sistema de Mapeamento
 * @version 1.0
 */
public class UtilityLine implements Mappable {

    /** Nome/identificação da linha de utilidade */
    private String name;
    
    /** Tipo de utilidade que a linha transporta */
    private TipoUtilidade tipo;

    /**
     * Constrói uma linha de utilidade com nome e tipo especificados.
     * 
     * @param nome o nome ou identificação da linha
     * @param tipo o tipo de utilidade (AGUA, GAS, ELETRICIDADE, FIBRA_OPTICA)
     */
    public UtilityLine(String nome, TipoUtilidade tipo) {
        this.name = nome;
        this.tipo = tipo;
    }

    /**
     * Obtém o rótulo da linha de utilidade incluindo seu nome e tipo.
     * 
     * @return string no formato "nome (TIPO_UTILIDADE)"
     */
    @Override
    public String getLabel() {
        return name + " (" + tipo + ")";
    }

    /**
     * Retorna a geometria como LINE já que uma linha de utilidade é representada por uma linha.
     * 
     * @return Geometry.LINE
     */
    @Override
    public Geometria getShape() {
        return Geometria.LINHA;
    }

    /**
     * Obtém o marcador visual baseado no tipo de utilidade.
     * Diferentes tipos de utilidade possuem diferentes cores e estilos de linha:
     * - ELETRICIDADE: Vermelho com linha tracejada
     * - FIBRA_OPTICA: Verde com linha pontilhada
     * - GAS: Laranja com linha sólida
     * - AGUA: Azul com linha sólida
     * - Padrão: Preto com linha sólida
     * 
     * @return string com cor e estilo de linha
     */
    @Override
    public String getMarker() {
        return switch (tipo) {
            case ELETRICIDADE -> Cor.VERMELHO + " " + MarcadorLinha.TRACEJADA;
            case FIBRA_OPTICA -> Cor.VERDE + " " + MarcadorLinha.PONTILHADA;
            case GAS -> Cor.LARANJA + " " + MarcadorLinha.SOLIDA;
            case AGUA -> Cor.AZUL + " " + MarcadorLinha.SOLIDA;
            default -> Cor.PRETO + " " + MarcadorLinha.SOLIDA;
        };
    }

    /**
     * Converte a linha de utilidade para formato JSON com propriedades específicas.
     * 
     * @return representação JSON da linha incluindo nome e tipo de utilidade
     */
    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "nome": "%s", "utilidade": "%s" """.formatted(name, tipo);
    }
}

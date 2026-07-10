package praticas.interfaces.challenge.mapJSON;

/**
 * Enumeração que define os tipos de uso/função de uma construção.
 */
enum TipoUso {ENTRETENIMENTO, GOVERNO, RESIDENCIAL, ESPORTES}

/**
 * Classe que representa um edifício/construção mapeável.
 * Um edifício é um ponto no mapa com propriedades como nome e tipo de uso.

 */
public class Building implements Mappable{

    /** Nome/descrição do edifício */
    private String name;
    
    /** Tipo de uso/função do edifício */
    private TipoUso uso;

    /**
     * Constrói um edifício com nome e tipo de uso especificados.
     * 
     * @param nome o nome do edifício
     * @param uso o tipo de uso do edifício
     */
    public Building(String nome, TipoUso uso) {
        this.name = nome;
        this.uso = uso;
    }

    /**
     * Obtém o rótulo do edifício incluindo seu nome e tipo de uso.
     * 
     * @return string no formato "nome (TIPO_USO)"
     */
    @Override
    public String getLabel() {
        return name + " (" + uso + ")";
    }

    /**
     * Retorna a geometria como POINT já que um edifício é representado por um ponto.
     * 
     * @return Geometry.POINT
     */
    @Override
    public Geometria getShape() {
        return Geometria.PONTO;
    }

    /**
     * Obtém o marcador visual baseado no tipo de uso.
     * Diferentes tipos de uso possuem diferentes cores e símbolos:
     * - ENTRETENIMENTO: Verde com triângulo
     * - GOVERNO: Vermelho com estrela
     * - RESIDENCIAL: Azul com quadrado
     * - ESPORTES: Laranja com alfinete
     * - Padrão: Preto com círculo
     * 
     * @return string com cor e tipo de marcador
     */
    @Override
    public String getMarker() {
        return switch (uso) {
            case ENTRETENIMENTO -> Cor.VERDE + " " + MarcadorPonto.TRIANGULO;
            case GOVERNO -> Cor.VERMELHO + " " + MarcadorPonto.ESTRELA;
            case RESIDENCIAL -> Cor.AZUL + " " + MarcadorPonto.QUADRADO;
            case ESPORTES -> Cor.LARANJA + " " + MarcadorPonto.ALFINETE;
            default -> Cor.PRETO + " " + MarcadorPonto.CIRCULO;
        };
    }

    /**
     * Converte o edifício para formato JSON com propriedades específicas.
     * 
     * @return representação JSON do edifício incluindo nome e tipo de uso
     */
    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "nome": "%s", "uso": "%s" """.formatted(name, uso);
    }
}

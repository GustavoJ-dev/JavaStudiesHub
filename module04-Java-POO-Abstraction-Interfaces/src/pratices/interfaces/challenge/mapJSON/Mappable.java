package pratices.interfaces.challenge.mapJSON;

/**
 * Enumeração que define os tipos de geometria suportados pelo mapa.
 * Pode representar ponto único, linha ou polígono.
 */
enum Geometria {LINHA, PONTO, POLIGONO}

/**
 * Enumeração que define as cores disponíveis para marcadores no mapa.
 */
enum Cor {PRETO, AZUL, VERDE, LARANJA, VERMELHO}

/**
 * Enumeração que define os tipos de marcadores de ponto disponíveis no mapa.
 */
enum MarcadorPonto {CIRCULO, ALFINETE, ESTRELA, QUADRADO, TRIANGULO}

/**
 * Enumeração que define os estilos de linha disponíveis no mapa.
 */
enum MarcadorLinha {TRACEJADA, PONTILHADA, SOLIDA}

/**
 * Interface que define o contrato para objetos que podem ser mapeáveis.
 * Implementadores desta interface podem ser representados em formato JSON
 * e exibidos em um mapa com propriedades específicas como geometria,
 * rótulo e marcador visual.
 * 
 * @author Sistema de Mapeamento
 * @version 1.0
 */
public interface Mappable {

    /**
     * Template para a propriedade JSON que encapsula as propriedades do objeto mapeável.
     */
    String JSON_PROPERTY = """
            "propriedades": {%s}""";

    /**
     * Obtém o rótulo/nome do objeto mapeável.
     * 
     * @return o rótulo que será exibido no mapa
     */
    String getLabel();

    /**
     * Obtém o tipo de geometria deste objeto no mapa.
     * 
     * @return a geometria (PONTO, LINHA ou POLIGONO)
     */
    Geometria getShape();

    /**
     * Obtém a descrição do marcador visual (cor e tipo).
     * 
     * @return string representando a cor e o tipo de marcador
     */
    String getMarker();

    /**
     * Converte o objeto mapeável para formato JSON com informações básicas.
     * Este metodo pode ser sobrescrito por subclasses para adicionar
     * propriedades específicas.
     * 
     * @return representação JSON do objeto
     */
    default String toJSON() {

        return """
                "tipo": "%s", "rótulo": "%s", "marcador": "%s" """
                .formatted(getShape(), getLabel(), getMarker());
    }

    /**
     * Metodo estático que exibe o objeto mapeável em formato JSON no console.
     * 
     * @param mappable o objeto mapeável a ser exibido
     */
    static void mapIt(Mappable mappable) {
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }
}

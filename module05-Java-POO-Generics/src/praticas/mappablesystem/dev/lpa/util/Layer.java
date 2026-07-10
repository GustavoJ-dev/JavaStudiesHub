package praticas.mappablesystem.dev.lpa.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma camada (Layer) no sistema de mapeamento que contém elementos mapeáveis.
 * Utiliza Generics para garantir que todos os elementos na camada implementem {@link Mappable}.
 *
 * @param <T> O tipo de elementos mapeáveis nesta camada.
 */
public class Layer<T extends Mappable> {
    /**
     * Lista de elementos que compõem esta camada.
     */
    private List<T> layerElements;

    /**
     * Construtor que inicializa a camada com um conjunto inicial de elementos.
     *
     * @param elements Array de elementos mapeáveis.
     */
    public Layer(T[] elements){
        this.layerElements = new ArrayList<T>(List.of(elements));
    }

    /**
     * Adiciona um ou mais elementos à camada.
     *
     * @param elements Elementos a serem adicionados.
     */
    public void addElement(T... elements){
        layerElements.addAll(List.of(elements));
    }

    /**
     * Renderiza todos os elementos presentes nesta camada chamando o método render de cada um.
     */
    public void renderLayer(){
        for (var element : layerElements){
            element.render();
        }
    }
}

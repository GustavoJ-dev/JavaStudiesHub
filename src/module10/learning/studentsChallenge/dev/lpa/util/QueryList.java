package module10.learning.studentsChallenge.dev.lpa.util;


import module10.learning.studentsChallenge.dev.lpa.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Uma lista especializada para armazenar objetos que estendem {@link Student} e implementam {@link QueryItem}.
 * Fornece métodos utilitários para filtrar itens da lista com base em critérios de busca.
 *
 * @param <T> O tipo de elementos nesta lista, que deve ser uma subclasse de Student e implementar QueryItem.
 */
public class QueryList <T extends Student & QueryItem> extends ArrayList<T> {

    /**
     * Construtor padrão que cria uma QueryList vazia.
     */
    public QueryList(){}

    /**
     * Construtor que inicializa a QueryList com os itens de uma lista existente.
     *
     * @param items A lista de itens a serem adicionados a esta QueryList.
     */
    public QueryList(List<T> items) {
        super(items);
    }

    /**
     * Metodo estático que filtra uma lista de itens que implementam {@link QueryItem}.
     *
     * @param items A lista de itens a serem filtrados.
     * @param field O nome do campo para filtrar.
     * @param value O valor que o campo deve corresponder.
     * @param <S> O tipo dos itens, que deve implementar QueryItem.
     * @return Uma nova lista contendo apenas os itens que correspondem ao critério.
     */
    public static <S extends QueryItem> List<S> getMatches(List<S> items,
                                                           String field, String value){
        List<S> matches = new ArrayList<>();
        for (var item : items){
            if (item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }

    /**
     * Filtra os itens desta QueryList com base em um critério e retorna uma nova QueryList com os resultados.
     * Permite encadeamento de chamadas (Fluent API style).
     *
     * @param field O nome do campo para filtrar.
     * @param value O valor que o campo deve corresponder.
     * @return Uma nova QueryList contendo os itens que correspondem ao critério.
     */
    public QueryList<T> getMatches(String field, String value){
        QueryList<T> matches = new QueryList<>();
        for (var item : this){
            if (item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }
}

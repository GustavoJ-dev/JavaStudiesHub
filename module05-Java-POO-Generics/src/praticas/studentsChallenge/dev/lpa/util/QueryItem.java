package praticas.studentsChallenge.dev.lpa.util;

/**
 * Interface para itens que podem ser consultados por campos e valores.
 * Classes que implementam esta interface devem fornecer uma lógica para
 * verificar se um campo específico corresponde a um determinado valor.
 */
public interface QueryItem {
    /**
     * Verifica se o valor de um campo específico do objeto corresponde ao valor fornecido.
     *
     * @param fieldName O nome do campo a ser verificado.
     * @param value O valor a ser comparado com o campo.
     * @return {@code true} se o campo corresponder ao valor, {@code false} caso contrário.
     */
    public boolean matchFieldValue(String fieldName, String value);
}

package praticas.JSONchallenge.student;

import java.util.StringJoiner;

/**
 * Representa um curso identificado por um código e um título.
 * <p>
 * Além das informações básicas do curso, fornece métodos para
 * consultar a quantidade de aulas, gerar uma representação textual
 * e converter o objeto para o formato JSON.
 * </p>
 *
 * @param courseCode código identificador do curso
 * @param title título do curso
 *
 */
public record Course(String courseCode, String title) {

    /**
     * Retorna a quantidade de aulas do curso.
     *
     * @return número de aulas do curso
     */
    public int getLectureCount() {
        return 15;
    }

    /**
     * Retorna uma representação textual do curso.
     *
     * @return código e título do curso formatados
     */
    @Override
    public String toString() {
        return "%s %s".formatted(courseCode, title);
    }

    /**
     * Converte o curso para uma representação no formato JSON.
     *
     * @return uma String contendo o curso em formato JSON
     */
    public String toJSON() {

        return new StringJoiner(", ", "{", "}")
                .add("\"courseCode\":\"" + courseCode + "\"")
                .add("\"title\":\"" + title + "\"")
                .toString();
    }
}

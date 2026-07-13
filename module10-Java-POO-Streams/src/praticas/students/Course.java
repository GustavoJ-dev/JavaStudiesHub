package praticas.students;

/**
 * Representa um curso disponível no sistema.
 * <p>
 * Este record armazena as principais informações de um curso,
 * incluindo seu código de identificação, título e quantidade
 * total de aulas.
 * </p>
 *
 * @param courseCode  código de identificação do curso
 * @param title        título do curso
 * @param lectureCount quantidade total de aulas do curso
 *
 */
public record Course(String courseCode, String title, int lectureCount) {

    /**
     * Construtor compacto responsável por validar os dados do curso.
     * <p>
     * Caso a quantidade de aulas seja menor ou igual a zero,
     * o valor será ajustado para {@code 1}.
     * </p>
     */
    public Course {

        if (lectureCount <= 0) {

            lectureCount = 1;
        }
    }

    /**
     * Cria um curso utilizando a quantidade padrão de {@code 40} aulas.
     *
     * @param courseCode código de identificação do curso
     * @param title      título do curso
     */
    public Course(String courseCode, String title) {

        this(courseCode, title, 40);
    }

    /**
     * Retorna uma representação textual do curso contendo
     * seu código e título.
     *
     * @return informações formatadas do curso
     */
    @Override
    public String toString() {

        return "%s %s".formatted(courseCode, title);
    }
}
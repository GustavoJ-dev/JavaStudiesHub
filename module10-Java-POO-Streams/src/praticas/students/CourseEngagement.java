package praticas.students;

import java.time.LocalDate;
import java.time.Period;

/**
 * Representa o engajamento de um estudante em um curso.
 * <p>
 * Esta classe mantém informações relacionadas à inscrição no curso,
 * ao tipo de atividade realizada, à última aula assistida e à data
 * da última atividade do estudante.
 * </p>
 *
 */
public class CourseEngagement {

    private final Course course;
    private final LocalDate enrollmentDate;
    private String engagementType;
    private int lastLecture;
    private LocalDate lastActivityDate;

    /**
     * Cria um novo registro de engajamento para um curso.
     *
     * @param course         curso associado ao engajamento
     * @param enrollmentDate data de inscrição no curso
     * @param engagementType tipo inicial de engajamento
     */
    public CourseEngagement(Course course, LocalDate enrollmentDate,
                            String engagementType) {

        this.course = course;
        this.enrollmentDate = this.lastActivityDate = enrollmentDate;
        this.engagementType = engagementType;
    }

    /**
     * Retorna o código do curso associado.
     *
     * @return código do curso
     */
    public String getCourseCode() {
        return course.courseCode();
    }

    /**
     * Retorna o ano em que ocorreu a inscrição no curso.
     *
     * @return ano da inscrição
     */
    public int getEnrollmentYear() {
        return enrollmentDate.getYear();
    }

    /**
     * Retorna o tipo atual de engajamento.
     *
     * @return tipo de engajamento
     */
    public String getEngagementType() {
        return engagementType;
    }

    /**
     * Retorna o número da última aula assistida.
     *
     * @return número da última aula
     */
    public int getLastLecture() {
        return lastLecture;
    }

    /**
     * Retorna o ano da última atividade realizada.
     *
     * @return ano da última atividade
     */
    public int getLastActivityYear() {
        return lastActivityDate.getYear();
    }

    /**
     * Retorna a abreviação do mês da última atividade.
     *
     * @return mês abreviado da última atividade
     */
    public String getLastActivityMonth() {
        return "%tb".formatted(lastActivityDate);
    }

    /**
     * Calcula o percentual de conclusão do curso.
     *
     * @return percentual concluído do curso
     */
    public double getPercentComplete() {
        return lastLecture * 100.0 / course.lectureCount();
    }

    /**
     * Calcula a quantidade de meses desde a última atividade
     * registrada até a data atual.
     *
     * @return número de meses desde a última atividade
     */
    public int getMonthsSinceActive() {

        LocalDate now = LocalDate.now();
        var months = Period.between(lastActivityDate, now).toTotalMonths();
        return (int) months;
    }

    /**
     * Registra uma aula assistida pelo estudante.
     * <p>
     * Atualiza a última aula assistida, a data da última atividade
     * e o tipo de engajamento do curso.
     * </p>
     *
     * @param lectureNumber número da aula assistida
     * @param currentDate   data em que a aula foi assistida
     */
    void watchLecture(int lectureNumber, LocalDate currentDate) {

        lastLecture = Math.max(lectureNumber, lastLecture);
        lastActivityDate = currentDate;
        engagementType = "Lecture " + lastLecture;
    }

    /**
     * Retorna uma representação textual do engajamento no curso.
     *
     * @return informações formatadas sobre o engajamento
     */
    @Override
    public String toString() {
        return "%s: %s %d %s [%d]".formatted(
                course.courseCode(),
                getLastActivityMonth(),
                getLastActivityYear(),
                engagementType,
                getMonthsSinceActive()
        );
    }
}
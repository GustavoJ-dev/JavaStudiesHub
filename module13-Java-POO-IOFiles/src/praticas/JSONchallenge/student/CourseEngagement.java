package praticas.JSONchallenge.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.StringJoiner;

/**
 * Representa o engajamento de um aluno em um curso.
 * <p>
 * Armazena informações sobre a matrícula, o progresso realizado,
 * a última atividade registrada e o tipo de engajamento do aluno.
 * </p>
 *
 */
public class CourseEngagement {

    /** Código do curso. */
    private final String courseCode;

    /** Tipo de engajamento mais recente do aluno. */
    private String engagementType;

    /** Mês em que o aluno se matriculou. */
    private final int enrollmentMonth;

    /** Ano em que o aluno se matriculou. */
    private final int enrollmentYear;

    /** Última aula concluída. */
    private int lastLecture;

    /** Mês da última atividade registrada. */
    private int lastActiveMonth;

    /** Ano da última atividade registrada. */
    private int lastActiveYear;

    /**
     * Cria um novo registro de engajamento.
     *
     * @param courseCode código do curso
     * @param month mês da matrícula
     * @param year ano da matrícula
     * @param engagementType tipo inicial de engajamento
     */
    public CourseEngagement(String courseCode, int month,
                            int year, String engagementType) {

        this.courseCode = courseCode;
        enrollmentMonth = lastActiveMonth = month;
        enrollmentYear = lastActiveYear = year;
        this.engagementType = engagementType;
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
     * Retorna o mês da matrícula.
     *
     * @return mês da matrícula
     */
    public int getEnrollmentMonth() {
        return enrollmentMonth;
    }

    /**
     * Retorna o ano da matrícula.
     *
     * @return ano da matrícula
     */
    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    /**
     * Retorna a última aula concluída.
     *
     * @return número da última aula
     */
    public int getLastLecture() {
        return lastLecture;
    }

    /**
     * Retorna o mês da última atividade.
     *
     * @return mês da última atividade
     */
    public int getLastActiveMonth() {
        return lastActiveMonth;
    }

    /**
     * Retorna o ano da última atividade.
     *
     * @return ano da última atividade
     */
    public int getLastActiveYear() {
        return lastActiveYear;
    }

    /**
     * Calcula o percentual de conclusão do curso.
     *
     * @param lectureCount quantidade total de aulas
     * @return percentual concluído
     */
    public double getPercentComplete(int lectureCount) {
        return lastLecture * 100.0 / lectureCount;
    }

    /**
     * Calcula quantos meses o aluno está inativo.
     *
     * @return quantidade de meses sem atividade
     */
    public int getInactiveMonths() {

        LocalDate now = LocalDate.now();
        int currentMonth = now.getMonthValue();

        int months = (now.getYear() - lastActiveYear) * 12;

        if (currentMonth > lastActiveMonth) {
            months += currentMonth - lastActiveMonth;
        } else {
            months -= lastActiveMonth - currentMonth;
        }

        return months;
    }

    /**
     * Retorna uma representação textual do progresso do aluno.
     *
     * @return informações resumidas do engajamento
     */
    @Override
    public String toString() {

        return "%s,%s,%d,%s".formatted(
                courseCode,
                Month.of(lastActiveMonth),
                lastActiveYear,
                engagementType);
    }

    /**
     * Converte o registro de engajamento para o formato JSON.
     *
     * @return representação em JSON
     */
    public String toJSON() {

        return new StringJoiner(", ", "{", "}")
                .add("\"courseCode\":\"" + courseCode + "\"")
                .add("\"engagementType\":\"" + engagementType + "\"")
                .add("\"enrollmentMonth\":" + enrollmentMonth)
                .add("\"enrollmentYear\":" + enrollmentYear)
                .add("\"lastLecture\":" + lastLecture)
                .add("\"lastActiveMonth\":" + lastActiveMonth)
                .add("\"lastActiveYear\":" + lastActiveYear)
                .toString();
    }

    /**
     * Registra uma nova atividade realizada pelo aluno.
     * <p>
     * Atualiza a última aula concluída, a data da atividade
     * e o tipo de engajamento.
     * </p>
     *
     * @param lectureNumber número da aula concluída
     * @param month mês da atividade
     * @param year ano da atividade
     */
    void recordLastActivity(int lectureNumber,
                            int month,
                            int year) {

        if (lectureNumber > lastLecture) {
            lastLecture = lectureNumber;
        }

        lastActiveMonth = month;
        lastActiveYear = year;

        engagementType = "Aula " + lastLecture;
    }
}

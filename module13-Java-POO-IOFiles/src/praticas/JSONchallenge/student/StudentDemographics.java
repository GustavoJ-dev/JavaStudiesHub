package praticas.JSONchallenge.student;

import java.util.StringJoiner;

/**
 * Armazena os dados demográficos de um estudante no momento da matrícula.
 * <p>
 * Essas informações permanecem imutáveis durante todo o ciclo de vida
 * do objeto, por se tratar de um {@code record}.
 * </p>
 *
 * @param countryCode código do país do estudante
 * @param enrolledMonth mês em que a matrícula foi realizada
 * @param enrolledYear ano em que a matrícula foi realizada
 * @param ageAtEnrollment idade do estudante no momento da matrícula
 * @param gender gênero do estudante
 * @param previousProgrammingExperience indica se o estudante possuía
 *                                       experiência prévia em programação
 *
 * @author Gustavo
 * @version 1.0
 */
public record StudentDemographics(String countryCode, int enrolledMonth, int enrolledYear, int ageAtEnrollment,
                                  String gender, boolean previousProgrammingExperience) {

    /**
     * Retorna uma representação textual dos dados demográficos.
     *
     * @return informações demográficas formatadas
     */
    @Override
    public String toString() {

        return "%s,%d,%d,%d,%s,%b".formatted(
                countryCode,
                enrolledMonth,
                enrolledYear,
                ageAtEnrollment,
                gender,
                previousProgrammingExperience);
    }

    /**
     * Converte os dados demográficos para uma representação
     * no formato JSON.
     *
     * @return dados demográficos em formato JSON
     */
    public String toJSON() {

        return new StringJoiner(", ", "{", "}")
                .add("\"countryCode\":\"" + countryCode + "\"")
                .add("\"enrolledMonth\":" + enrolledMonth)
                .add("\"enrolledYear\":" + enrolledYear)
                .add("\"ageAtEnrollment\":" + ageAtEnrollment)
                .add("\"gender\":\"" + gender + "\"")
                .add("\"previousProgrammingExperience\":" + previousProgrammingExperience)
                .toString();
    }
}

package pratices.studentsChallenge.dev.lpa.model;

import java.util.Comparator;

/**
 * Comparador para objetos {@link LPAStudent} baseado no percentual de conclusão do curso.
 * Realiza uma comparação crescente.
 */
public class LPAStudentComparator implements Comparator<LPAStudent> {
    /**
     * Compara dois estudantes LPA pelo percentual de conclusão.
     *
     * @param o1 O primeiro estudante.
     * @param o2 O segundo estudante.
     * @return A diferença entre as partes inteiras dos percentuais de conclusão.
     */
    @Override
    public int compare(LPAStudent o1, LPAStudent o2) {
        return (int) o1.getPercentComplete() - (int) o2.getPercentComplete();
    }
}

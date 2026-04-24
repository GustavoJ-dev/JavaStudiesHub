package module10.learning.studentsChallenge.dev.lpa;



import module10.learning.studentsChallenge.dev.lpa.model.LPAStudent;
import module10.learning.studentsChallenge.dev.lpa.model.LPAStudentComparator;
import module10.learning.studentsChallenge.dev.lpa.util.QueryList;

import java.util.Comparator;
import java.util.List;

/**
 * Classe principal para demonstrar a funcionalidade de consulta e ordenação de estudantes.
 */
public class Main {
    /**
     * Ponto de entrada do programa.
     * Cria uma lista de estudantes, filtra e ordena os resultados.
     */
    public static void main(String[] args) {
        QueryList<LPAStudent> queryList = new QueryList<>();
        for (int i = 0; i < 25; i++) {
            queryList.add(new LPAStudent());
        }
        System.out.println("Ordered");
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);

        System.out.println();

        System.out.println("Matches");
        var matches = queryList
                .getMatches("PercentComplete", "50")
                .getMatches("Course", "Java");

        matches.sort(new LPAStudentComparator());
        printList(matches);

        System.out.println();


        System.out.println("Ordered");
        matches.sort(null);
        printList(matches);
    }

    /**
     * Imprime uma lista de objetos no console.
     *
     * @param students A lista de objetos a ser impressa.
     */
    public static void printList(List<?> students) {
        for (var student : students) {
            System.out.println(student);
        }
    }
}

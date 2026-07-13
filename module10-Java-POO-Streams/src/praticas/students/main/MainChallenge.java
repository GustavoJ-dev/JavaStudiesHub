package praticas.students.main;

import praticas.students.Course;
import praticas.students.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Classe principal responsável por executar um desafio prático
 * utilizando a Stream API para processar uma grande coleção
 * de estudantes.
 * <p>
 * O desafio realiza operações de geração de dados, cálculo de médias,
 * filtragem, ordenação, limitação de resultados e processamento
 * de estudantes com melhor desempenho.
 * </p>
 *
 */
public class MainChallenge {

    /**
     * Executa o desafio de processamento de estudantes
     * utilizando Streams e operações funcionais.
     *
     */
    public static void main(String[] args) {

        // ============================================================
        // CRIAÇÃO DOS CURSOS
        // ============================================================

        Course pymc = new Course(
                "PYMC",
                "Python Masterclass",
                50
        );

        Course jmc = new Course(
                "JMC",
                "Java Masterclass",
                100
        );

        Course jgames = new Course(
                "JGAME",
                "Creating Games in Java"
        );


        // ============================================================
        // GERAÇÃO DOS ESTUDANTES
        // ============================================================

        List<Student> students = IntStream
                .rangeClosed(1, 5000)
                .mapToObj(value ->
                        Student.getRandomStudent(jmc, pymc)
                )
                .toList();


        // ============================================================
        // CÁLCULO DO PERCENTUAL MÉDIO DE CONCLUSÃO
        // ============================================================

        double totalPercent = students.stream()
                .mapToDouble(student ->
                        student.getPercentComplete("JMC")
                )
                .reduce(0, Double::sum);

        double averagePercent = totalPercent / students.size();

        System.out.printf(
                "Percentual médio de conclusão = %.2f%%%n",
                averagePercent
        );


        // ============================================================
        // DEFINIÇÃO DO PERCENTUAL DE MELHOR DESEMPENHO
        // ============================================================

        int topPercent = (int) (1.25 * averagePercent);

        System.out.printf(
                "Percentual de melhor desempenho = %d%%%n",
                topPercent
        );


        // ============================================================
        // COMPARATOR POR ANO DE MATRÍCULA
        // ============================================================

        Comparator<Student> longTermStudent =
                Comparator.comparing(Student::getYearEnrolled);


        // ============================================================
        // FILTRAGEM DOS ESTUDANTES COM MELHOR DESEMPENHO
        // ============================================================

        List<Student> hardWorkers = students.stream()
                .filter(student ->
                        student.getMonthsSinceActive("JMC") == 0
                )
                .filter(student ->
                        student.getPercentComplete("JMC") >= topPercent
                )
                .sorted(longTermStudent)
                .limit(10)
                .toList();


        // ============================================================
        // ADIÇÃO DE UM NOVO CURSO
        // ============================================================

        hardWorkers.forEach(student -> {

            student.addCourse(jgames);

            System.out.print(
                    student.getStudentId() + " "
            );
        });

        System.out.println();


        // ============================================================
        // COMPARATOR COM CRITÉRIO SECUNDÁRIO
        // ============================================================

        Comparator<Student> uniqueSorted =
                longTermStudent.thenComparing(
                        Student::getStudentId
                );


        // ============================================================
        // PROCESSAMENTO DIRETO DO STREAM
        // ============================================================

        students.stream()
                .filter(student ->
                        student.getMonthsSinceActive("JMC") == 0
                )
                .filter(student ->
                        student.getPercentComplete("JMC") >= topPercent
                )
                .sorted(longTermStudent)
                .limit(10)

                // ====================================================
                // DIFERENTES FORMAS DE COLETAR O STREAM
                // ====================================================

//                .toList()

//                .collect(Collectors.toList())

//                .collect(Collectors.toSet())

//                .collect(
//                        () -> new TreeSet<>(uniqueSorted),
//                        TreeSet::add,
//                        TreeSet::addAll
//                )

                .forEach(student -> {

                    student.addCourse(jgames);

                    System.out.print(
                            student.getStudentId() + " "
                    );
                });
    }
}

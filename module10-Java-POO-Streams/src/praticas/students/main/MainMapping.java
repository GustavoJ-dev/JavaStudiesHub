package praticas.students.main;

import praticas.students.Course;
import praticas.students.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/**
 * Classe principal responsável por demonstrar operações avançadas
 * de mapeamento e agrupamento utilizando a Stream API.
 * <p>
 * Os exemplos exploram recursos da classe {@link Collectors},
 * incluindo agrupamento, filtragem, particionamento, contagem
 * e transformação de estruturas aninhadas utilizando {@code flatMap}.
 * </p>
 *
 */
public class MainMapping {

    /**
     * Executa exemplos de processamento e mapeamento de estudantes
     * utilizando Streams e Collectors.
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
        // AGRUPAMENTO POR PAÍS
        // ============================================================

        var mappedStudents = students.stream()
                .collect(
                        groupingBy(Student::getCountryCode)
                );

        mappedStudents.forEach((country, studentList) ->
                System.out.println(
                        country + " " + studentList.size()
                )
        );


        // ============================================================
        // AGRUPAMENTO COM FILTRAGEM
        // ============================================================

        System.out.println("-----------------------");

        int minAge = 25;

        var youngerSet = students.stream()
                .collect(
                        groupingBy(
                                Student::getCountryCode,
                                filtering(
                                        student ->
                                                student.getAge() <= minAge,
                                        toList()
                                )
                        )
                );

        youngerSet.forEach((country, studentList) ->
                System.out.println(
                        country + " " + studentList.size()
                )
        );


        // ============================================================
        // PARTICIONAMENTO POR EXPERIÊNCIA EM PROGRAMAÇÃO
        // ============================================================

        var experienced = students.stream()
                .collect(
                        partitioningBy(
                                Student::hasProgrammingExperience
                        )
                );

        System.out.println(
                "Estudantes com experiência = "
                        + experienced.get(true).size()
        );


        // ============================================================
        // PARTICIONAMENTO COM CONTAGEM
        // ============================================================

        var experienceCount = students.stream()
                .collect(
                        partitioningBy(
                                Student::hasProgrammingExperience,
                                counting()
                        )
                );

        System.out.println(
                "Estudantes com experiência = "
                        + experienceCount.get(true)
        );


        // ============================================================
        // PARTICIONAMENTO POR EXPERIÊNCIA E ATIVIDADE
        // ============================================================

        var experiencedAndActive = students.stream()
                .collect(
                        partitioningBy(
                                student ->
                                        student.hasProgrammingExperience()
                                                && student.getMonthsSinceActive() == 0,
                                counting()
                        )
                );

        System.out.println(
                "Estudantes experientes e ativos = "
                        + experiencedAndActive.get(true)
        );


        // ============================================================
        // AGRUPAMENTO EM MÚLTIPLOS NÍVEIS
        // ============================================================

        var multiLevel = students.stream()
                .collect(
                        groupingBy(
                                Student::getCountryCode,
                                groupingBy(Student::getGender)
                        )
                );

        multiLevel.forEach((country, genderMap) -> {

            System.out.println(country);

            genderMap.forEach((gender, studentList) ->
                    System.out.println(
                            "\t" + gender + " " + studentList.size()
                    )
            );
        });


        // ============================================================
        // CONTAGEM UTILIZANDO LOOP TRADICIONAL
        // ============================================================

        long studentBodyCount = 0;

        for (var studentList : experienced.values()) {

            studentBodyCount += studentList.size();
        }

        System.out.println(
                "Total de estudantes = " + studentBodyCount
        );


        // ============================================================
        // CONTAGEM UTILIZANDO STREAM
        // ============================================================

        studentBodyCount = experienced.values()
                .stream()
                .mapToInt(List::size)
                .sum();

        System.out.println(
                "Total de estudantes = " + studentBodyCount
        );


        // ============================================================
        // CONTAGEM DE ESTUDANTES ATIVOS COM STREAMS ANINHADAS
        // ============================================================

        studentBodyCount = experienced.values()
                .stream()
                .map(studentList ->
                        studentList.stream()
                                .filter(student ->
                                        student.getMonthsSinceActive() <= 3
                                )
                                .count()
                )
                .mapToLong(value -> value)
                .sum();

        System.out.println(
                "Total de estudantes ativos = " + studentBodyCount
        );


        // ============================================================
        // FLATMAP PARA ACHATAR LISTAS DE ESTUDANTES
        // ============================================================

        long activeStudentCount = experienced.values()
                .stream()
                .flatMap(List::stream)
                .filter(student ->
                        student.getMonthsSinceActive() <= 3
                )
                .count();

        System.out.println(
                "Estudantes ativos = " + activeStudentCount
        );


        // ============================================================
        // FLATMAP EM ESTRUTURA MULTINÍVEL
        // ============================================================

        activeStudentCount = multiLevel.values()
                .stream()
                .flatMap(genderMap ->
                        genderMap.values()
                                .stream()
                                .flatMap(List::stream)
                )
                .filter(student ->
                        student.getMonthsSinceActive() <= 3
                )
                .count();

        System.out.println(
                "Estudantes ativos no agrupamento multinível = "
                        + activeStudentCount
        );


        // ============================================================
        // FLATMAP ENCADEADO
        // ============================================================

        activeStudentCount = multiLevel.values()
                .stream()
                .flatMap(genderMap ->
                        genderMap.values().stream()
                )
                .flatMap(List::stream)
                .filter(student ->
                        student.getMonthsSinceActive() <= 3
                )
                .count();

        System.out.println(
                "Estudantes ativos no agrupamento multinível = "
                        + activeStudentCount
        );
    }
}
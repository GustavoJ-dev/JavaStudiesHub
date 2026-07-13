package praticas.students.main;

import praticas.students.Course;
import praticas.students.CourseEngagement;
import praticas.students.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Classe principal responsável por demonstrar uma aplicação prática dos
 * recursos da API de Streams e Collectors.
 *
 * <p>O exemplo realiza análises estatísticas sobre estudantes e seus
 * engajamentos em cursos, utilizando operações como {@code flatMap()},
 * {@code groupingBy()}, {@code counting()} e
 * {@code summarizingDouble()}.</p>
 */
public class MainFinalChallenge {

    /**
     * Método principal da aplicação.
     *
     * <p>Gera uma coleção de estudantes aleatórios matriculados nos últimos
     * quatro anos e realiza diversas análises sobre os cursos e o
     * engajamento dos alunos.</p>
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {

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

        int currentYear = LocalDate.now().getYear();

        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(jmc, pymc, jgames))
                .filter(student ->
                        student.getYearEnrolled() >= (currentYear - 4))
                .limit(10_000)
                .toList();

        // ============================================================
        // ESTATÍSTICAS DOS ANOS DE MATRÍCULA
        // ============================================================

        System.out.println("Estatísticas dos anos de matrícula:");

        System.out.println(
                students.stream()
                        .mapToInt(Student::getYearEnrolled)
                        .summaryStatistics()
        );

        // ============================================================
        // AMOSTRA DOS PRIMEIROS ESTUDANTES
        // ============================================================

        System.out.println("\nPrimeiros estudantes gerados:");

        students.subList(0, 10)
                .forEach(System.out::println);

        // ============================================================
        // QUANTIDADE DE CURSOS POR ESTUDANTE
        // ============================================================

        System.out.println("\nQuantidade de cursos por estudante:");

        System.out.println(
                students.stream()
                        .mapToInt(student ->
                                student.getEngagementMap().size())
                        .summaryStatistics()
        );

        // ============================================================
        // TOTAL DE MATRÍCULAS POR CURSO
        // ============================================================

        var mappedActivity = students.stream()
                .flatMap(student ->
                        student.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(
                        CourseEngagement::getCourseCode,
                        Collectors.counting()
                ));

        System.out.println("\nQuantidade de matrículas por curso:");

        mappedActivity.forEach(
                (course, total) ->
                        System.out.println(course + " = " + total)
        );

        // ============================================================
        // ESTUDANTES AGRUPADOS PELA QUANTIDADE DE CURSOS
        // ============================================================

        var classCounts = students.stream()
                .collect(Collectors.groupingBy(
                        student -> student.getEngagementMap().size(),
                        Collectors.counting()
                ));

        System.out.println("\nQuantidade de estudantes por número de cursos:");

        classCounts.forEach(
                (courseCount, totalStudents) ->
                        System.out.println(courseCount + " cursos = " + totalStudents)
        );

        // ============================================================
        // ESTATÍSTICAS DE PROGRESSO POR CURSO
        // ============================================================

        var percentages = students.stream()
                .flatMap(student ->
                        student.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(
                        CourseEngagement::getCourseCode,
                        Collectors.summarizingDouble(
                                CourseEngagement::getPercentComplete)
                ));

        System.out.println("\nEstatísticas de progresso por curso:");

        percentages.forEach(
                (course, statistics) ->
                        System.out.println(course + " = " + statistics)
        );

        // ============================================================
        // ÚLTIMA ATIVIDADE POR ANO
        // ============================================================

        var yearMap = students.stream()
                .flatMap(student ->
                        student.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(
                        CourseEngagement::getCourseCode,
                        Collectors.groupingBy(
                                CourseEngagement::getLastActivityYear,
                                Collectors.counting()
                        )
                ));

        System.out.println("\nÚltima atividade por curso e ano:");

        yearMap.forEach(
                (course, data) ->
                        System.out.println(course + " = " + data)
        );

        // ============================================================
        // MATRÍCULAS AGRUPADAS POR ANO E CURSO
        // ============================================================

        System.out.println("\nMatrículas agrupadas por ano e curso:");

        students.stream()
                .flatMap(student ->
                        student.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(
                        CourseEngagement::getEnrollmentYear,
                        Collectors.groupingBy(
                                CourseEngagement::getCourseCode,
                                Collectors.counting()
                        )
                ))
                .forEach(
                        (year, data) ->
                                System.out.println(year + ": " + data)
                );
    }
}

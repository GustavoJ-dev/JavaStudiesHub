package praticas.students.main;

import praticas.students.Course;
import praticas.students.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Classe principal responsável por demonstrar operações com Streams
 * aplicadas a uma coleção de estudantes.
 * <p>
 * Os exemplos incluem filtragem, contagem, uso de {@link Predicate},
 * transformação para streams primitivas, geração de estatísticas,
 * remoção de duplicatas, ordenação e operações de correspondência.
 * </p>
 *
 */
public class Main {

    /**
     * Método principal responsável por executar os exemplos
     * de processamento de estudantes utilizando a Stream API.
     *
     */
    public static void main(String[] args) {

        // ============================================================
        // CRIAÇÃO DOS CURSOS
        // ============================================================

        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");


        // ============================================================
        // GERAÇÃO DOS ESTUDANTES
        // ============================================================

        Student[] students = new Student[1000];

        Arrays.setAll(
                students,
                i -> Student.getRandomStudent(jmc, pymc)
        );


        // ============================================================
        // FILTRAGEM E CONTAGEM POR GÊNERO
        // ============================================================

        var maleStudents = Arrays.stream(students)
                .filter(student -> student.getGender().equals("M"));

        System.out.println(
                "# de estudantes do gênero masculino: "
                        + maleStudents.count()
        );

        for (String gender : List.of("M", "F", "U")) {

            var myStudents = Arrays.stream(students)
                    .filter(student -> student.getGender().equals(gender));

            System.out.println(
                    "# de estudantes [" + gender + "]: "
                            + myStudents.count()
            );
        }


        // ============================================================
        // FILTRAGEM UTILIZANDO PREDICATE
        // ============================================================

        List<Predicate<Student>> agePredicates = List.of(

                student -> student.getAge() < 30,

                student -> student.getAge() >= 30
                        && student.getAge() < 60
        );

        long total = 0;

        for (int i = 0; i < agePredicates.size(); i++) {

            var filteredStudents = Arrays.stream(students)
                    .filter(agePredicates.get(i));

            long count = filteredStudents.count();

            total += count;

            System.out.printf(
                    "# de estudantes (%s) = %d%n",
                    i == 0 ? "< 30" : ">= 30 e < 60",
                    count
            );
        }

        System.out.println(
                "# de estudantes >= 60 = "
                        + (students.length - total)
        );


        // ============================================================
        // ESTATÍSTICAS DE IDADE NA MATRÍCULA
        // ============================================================

        var enrollmentAgeStream = Arrays.stream(students)
                .mapToInt(Student::getAgeEnrolled);

        System.out.println(
                "Estatísticas da idade de matrícula = "
                        + enrollmentAgeStream.summaryStatistics()
        );


        // ============================================================
        // ESTATÍSTICAS DA IDADE ATUAL
        // ============================================================

        var currentAgeStream = Arrays.stream(students)
                .mapToInt(Student::getAge);

        System.out.println(
                "Estatísticas da idade atual = "
                        + currentAgeStream.summaryStatistics()
        );


        // ============================================================
        // PAÍSES DOS ESTUDANTES
        // ============================================================

        Arrays.stream(students)
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .forEach(country ->
                        System.out.print(country + " ")
                );

        System.out.println();


        // ============================================================
        // VERIFICAÇÃO DE ESTUDANTES DE LONGO PRAZO
        // ============================================================

        boolean hasLongTermStudents = Arrays.stream(students)
                .anyMatch(student ->
                        student.getAge() - student.getAgeEnrolled() >= 7
                                && student.getMonthsSinceActive() < 12
                );

        System.out.println(
                "Existem estudantes de longo prazo? "
                        + hasLongTermStudents
        );


        // ============================================================
        // CONTAGEM DE ESTUDANTES DE LONGO PRAZO
        // ============================================================

        long longTermStudentCount = Arrays.stream(students)
                .filter(student ->
                        student.getAge() - student.getAgeEnrolled() >= 7
                                && student.getMonthsSinceActive() < 12
                )
                .count();

        System.out.println(
                "# de estudantes de longo prazo: "
                        + longTermStudentCount
        );


        // ============================================================
        // CONVERSÃO DO STREAM PARA ARRAY
        // ============================================================

        var longTimeLearners = Arrays.stream(students)
                .filter(student ->
                        student.getAge() - student.getAgeEnrolled() >= 7
                                && student.getMonthsSinceActive() < 12
                )
                .filter(student ->
                        !student.hasProgrammingExperience()
                )
                .limit(5)
                .toArray(Student[]::new);


        // ============================================================
        // COLETA DO STREAM PARA LIST
        // ============================================================

        var learners = Arrays.stream(students)
                .filter(student ->
                        student.getAge() - student.getAgeEnrolled() >= 7
                                && student.getMonthsSinceActive() < 12
                )
                .filter(student ->
                        !student.hasProgrammingExperience()
                )
                .limit(5)
                .collect(Collectors.toList());


        // ============================================================
        // EMBARALHAMENTO DA LISTA
        // ============================================================

        Collections.shuffle(learners);
    }
}

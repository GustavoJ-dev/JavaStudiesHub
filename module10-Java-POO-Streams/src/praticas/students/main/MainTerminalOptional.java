package praticas.students.main;


import praticas.students.Course;
import praticas.students.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Classe principal responsável por demonstrar operações terminais
 * de Streams que retornam valores opcionais.
 *
 * <p>Este exemplo utiliza métodos como {@code findAny()},
 * {@code findFirst()}, {@code min()}, {@code max()},
 * {@code average()} e {@code reduce()}.</p>
 *
 * <p>Os resultados são tratados utilizando {@link Optional}
 * e {@code ifPresentOrElse()}.</p>
 */
public class MainTerminalOptional {

    /**
     * Método principal da aplicação.
     *
     * <p>Gera uma coleção de estudantes aleatórios e demonstra
     * diferentes operações terminais da API de Streams.</p>
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {

        Course pymc = new Course(
                "PYMC",
                "Python Masterclass"
        );

        Course jmc = new Course(
                "JMC",
                "Java Masterclass"
        );

        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(1000)
                .toList();

        int minAge = 18;

        // ============================================================
        // FIND ANY
        // ============================================================

        students.stream()
                .filter(student -> student.getAge() <= minAge)
                .findAny()
                .ifPresentOrElse(
                        student -> System.out.printf(
                                "Estudante %d de %s possui %d anos%n",
                                student.getStudentId(),
                                student.getCountryCode(),
                                student.getAge()
                        ),
                        () -> System.out.println(
                                "Nenhum estudante encontrado com idade até "
                                        + minAge
                        )
                );

        // ============================================================
        // FIND FIRST
        // ============================================================

        students.stream()
                .filter(student -> student.getAge() <= minAge)
                .findFirst()
                .ifPresentOrElse(
                        student -> System.out.printf(
                                "Estudante %d de %s possui %d anos%n",
                                student.getStudentId(),
                                student.getCountryCode(),
                                student.getAge()
                        ),
                        () -> System.out.println(
                                "Nenhum estudante encontrado com idade até "
                                        + minAge
                        )
                );

        // ============================================================
        // MIN
        // ============================================================

        students.stream()
                .filter(student -> student.getAge() <= minAge)
                .min(Comparator.comparing(Student::getAge))
                .ifPresentOrElse(
                        student -> System.out.printf(
                                "Estudante mais jovem: %d de %s possui %d anos%n",
                                student.getStudentId(),
                                student.getCountryCode(),
                                student.getAge()
                        ),
                        () -> System.out.println(
                                "Nenhum estudante encontrado com idade até "
                                        + minAge
                        )
                );

        // ============================================================
        // MAX
        // ============================================================

        students.stream()
                .filter(student -> student.getAge() <= minAge)
                .max(Comparator.comparing(Student::getAge))
                .ifPresentOrElse(
                        student -> System.out.printf(
                                "Estudante mais velho: %d de %s possui %d anos%n",
                                student.getStudentId(),
                                student.getCountryCode(),
                                student.getAge()
                        ),
                        () -> System.out.println(
                                "Nenhum estudante encontrado com idade até "
                                        + minAge
                        )
                );

        // ============================================================
        // AVERAGE
        // ============================================================

        students.stream()
                .filter(student -> student.getAge() <= minAge)
                .mapToInt(Student::getAge)
                .average()
                .ifPresentOrElse(
                        average -> System.out.printf(
                                "Média de idade até %d anos: %.2f%n",
                                minAge,
                                average
                        ),
                        () -> System.out.println(
                                "Nenhum estudante encontrado com idade até "
                                        + minAge
                        )
                );

        // ============================================================
        // REDUCE
        // ============================================================

        students.stream()
                .filter(student -> student.getAge() <= minAge)
                .map(Student::getCountryCode)
                .distinct()
                .reduce((countryA, countryB) ->
                        String.join(",", countryA, countryB)
                )
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(
                                "Nenhum país encontrado"
                        )
                );

        // ============================================================
        // BUSCA POR PAÍS
        // ============================================================

        students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .filter(country -> country.contains("AU"))
                .findAny()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(
                                "Código de país AU não encontrado"
                        )
                );
    }
}
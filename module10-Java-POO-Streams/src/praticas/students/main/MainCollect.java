package praticas.students.main;

import praticas.students.Course;
import praticas.students.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Classe principal responsável por demonstrar diferentes formas de
 * coletar elementos utilizando o método {@code collect()} da API de Streams.
 *
 * <p>O exemplo apresenta a criação de coleções do tipo {@link Set},
 * operações entre conjuntos e o uso de coletores personalizados.</p>
 */
public class MainCollect {

    /**
     * Método principal da aplicação.
     *
     * <p>Gera uma lista de estudantes aleatórios e demonstra diferentes
     * estratégias para coletar, combinar e organizar dados utilizando
     * a API de Streams.</p>
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

        // ============================================================
        // ESTUDANTES AUSTRALIANOS
        // ============================================================

        Set<Student> australianStudents = students.stream()
                .filter(student -> student.getCountryCode().equals("AU"))
                .collect(Collectors.toSet());

        System.out.println(
                "Quantidade de estudantes australianos = "
                        + australianStudents.size()
        );

        // ============================================================
        // ESTUDANTES MATRICULADOS COM MENOS DE 30 ANOS
        // ============================================================

        Set<Student> underThirty = students.stream()
                .filter(student -> student.getAgeEnrolled() < 30)
                .collect(Collectors.toSet());

        System.out.println(
                "Quantidade de estudantes matriculados antes dos 30 anos = "
                        + underThirty.size()
        );

        // ============================================================
        // INTERSEÇÃO ENTRE CONJUNTOS
        // ============================================================

        Set<Student> youngAussies1 = new TreeSet<>(
                Comparator.comparing(Student::getStudentId)
        );

        youngAussies1.addAll(australianStudents);
        youngAussies1.retainAll(underThirty);

        System.out.println(
                "\nEstudantes australianos matriculados antes dos 30 anos:"
        );

        youngAussies1.forEach(
                student -> System.out.print(student.getStudentId() + " ")
        );

        System.out.println();

        // ============================================================
        // COLETOR PERSONALIZADO
        // ============================================================

        Set<Student> youngAussies2 = students.stream()
                .filter(student -> student.getAgeEnrolled() < 30)
                .filter(student -> student.getCountryCode().equals("AU"))
                .collect(
                        () -> new TreeSet<>(
                                Comparator.comparing(Student::getStudentId)
                        ),
                        TreeSet::add,
                        TreeSet::addAll
                );

        System.out.println(
                "\nMesmo resultado utilizando um coletor personalizado:"
        );

        youngAussies2.forEach(
                student -> System.out.print(student.getStudentId() + " ")
        );

        System.out.println();

        // ============================================================
        // REDUCE
        // ============================================================

        String countryList = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .reduce("", (result, country) -> result + " " + country);

        System.out.println(
                "\nPaíses presentes na coleção:" + countryList
        );
    }
}
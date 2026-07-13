package praticas.students.main;

import praticas.students.Course;
import praticas.students.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Classe principal responsável por demonstrar o uso da classe {@link Optional}
 * em conjunto com Streams e objetos do tipo {@link Student}.
 *
 * <p>Este exemplo apresenta operações como verificação de valores,
 * execução condicional, valores alternativos e transformação de dados
 * utilizando métodos da API {@code Optional}.</p>
 */
public class MainOptional {

    /**
     * Método principal da aplicação.
     *
     * <p>Gera uma lista de estudantes aleatórios e demonstra diferentes
     * operações disponíveis na classe {@link Optional}.</p>
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
                .collect(Collectors.toList());

        // ============================================================
        // OPTIONAL VAZIO
        // ============================================================

        Optional<Student> o1 = getStudent(
                new ArrayList<>(),
                "first"
        );

        System.out.println(
                "Vazio = " + o1.isEmpty()
                        + ", Presente = " + o1.isPresent()
        );

        System.out.println(o1);

        o1.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("---> Vazio")
        );

        // ============================================================
        // OPTIONAL COM VALOR
        // ============================================================

        Optional<Student> o2 = getStudent(
                students,
                "first"
        );

        System.out.println(
                "Vazio = " + o2.isEmpty()
                        + ", Presente = " + o2.isPresent()
        );

        System.out.println(o2);

        o2.ifPresent(System.out::println);

        // ============================================================
        // OR ELSE GET
        // ============================================================

        Student firstStudent = o2.orElseGet(
                () -> getDummyStudent(jmc)
        );

        long id = firstStudent.getStudentId();

        System.out.println(
                "O ID do primeiro estudante é " + id
        );

        // ============================================================
        // OPTIONAL COM STREAM
        // ============================================================

        List<String> countries = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .toList();

        Optional.of(countries)
                .map(list -> String.join(",", list))
                .filter(countryList -> countryList.contains("FR"))
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(
                                "Código de país FR não encontrado"
                        )
                );
    }

    /**
     * Retorna um estudante da lista de acordo com o tipo de busca informado.
     *
     * <p>O metodo pode retornar o primeiro estudante, o último estudante
     * ou um estudante aleatório da lista.</p>
     *
     * @param list lista de estudantes
     * @param type tipo de busca a ser realizada
     * @return um {@link Optional} contendo o estudante encontrado
     * ou vazio caso a lista seja nula ou não possua elementos
     */
    private static Optional<Student> getStudent(
            List<Student> list,
            String type
    ) {

        if (list == null || list.isEmpty()) {

            return Optional.empty();
        }

        if (type.equals("first")) {

            return Optional.ofNullable(list.get(0));
        }

        if (type.equals("last")) {

            return Optional.ofNullable(
                    list.get(list.size() - 1)
            );
        }

        int randomIndex = new Random()
                .nextInt(list.size());

        return Optional.ofNullable(
                list.get(randomIndex)
        );
    }

    /**
     * Cria um estudante fictício utilizado como valor alternativo
     * quando nenhum estudante está presente em um {@link Optional}.
     *
     * @param courses cursos associados ao estudante fictício
     * @return estudante fictício criado
     */
    private static Student getDummyStudent(Course... courses) {

        System.out.println(
                "Criando estudante fictício"
        );

        return new Student(
                "NO",
                1,
                1,
                "U",
                false,
                courses
        );
    }
}

package praticas.JSONchallenge;

import praticas.JSONchallenge.student.Course;
import praticas.JSONchallenge.student.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Classe responsável por gerar uma base de estudantes fictícios
 * e exportá-la para um arquivo no formato JSON.
 * <p>
 * O programa cria dois cursos, gera 1000 estudantes aleatórios,
 * converte seus dados para JSON e grava o resultado no arquivo
 * {@code students.json}.
 * </p>
 *
 * @author Gustavo
 * @version 1.0
 */
public class Challenge {

    /**
     * Ponto de entrada da aplicação.
     * <p>
     * Gera estudantes aleatórios, exibe o JSON no console e
     * salva os dados no arquivo {@code students.json}.
     * </p>
     *
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        String delimiter = "," + System.lineSeparator();

        Course jmc = new Course("JMC", "Java Masterclass");
        Course pymc = new Course("PYC", "Python Masterclass");

        String students = Stream
                .generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(1000)
                .map(Student::toJSON)
                .collect(Collectors.joining(delimiter, "[", "]"));

        System.out.println(students);

        try {
            Path path = Path.of(
                    "module13-Java-POO-IOFiles", "src", "praticas", "JSONchallenge", "files",
                    "students.json");

            Files.writeString(path, students);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

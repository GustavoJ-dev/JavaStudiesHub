package pratices.studentsChallenge.dev.lpa.model;

import pratices.studentsChallenge.dev.lpa.util.QueryItem;

import java.util.Random;

/**
 * Representa um estudante genérico com informações básicas como ID, nome, curso e ano de início.
 * Implementa {@link QueryItem} para permitir consultas baseadas em campos
 * e {@link Comparable} para ordenação natural por ID de estudante.
 */
public class Student implements QueryItem, Comparable<Student> {

    /**
     * O último ID de estudante atribuído, usado para gerar IDs únicos.
     */
    private static int LAST_ID = 10_000;

    /**
     * O ID único do estudante.
     */
    private int studentId;

    /**
     * O nome do estudante.
     */
    private String name;
    /**
     * O curso em que o estudante está matriculado.
     */
    private String course;
    /**
     * O ano em que o estudante iniciou o curso.
     */
    private int yearStarted;

    /**
     * Gerador de números aleatórios para inicialização de dados de estudantes.
     */
    protected static Random random = new Random();

    /**
     * Array de nomes próprios para geração de estudantes.
     */
    private static String[] firstNames ={ "Ann", "Bill", "Cathy", "John", "Gusta"};
    /**
     * Array de cursos disponíveis para geração de estudantes.
     */
    private static String[] courses = {"C++", "Java", "Python"};

    /**
     * Construtor padrão que cria um novo estudante com dados gerados aleatoriamente.
     * O ID do estudante é incrementado automaticamente.
     */
    public Student(){
        studentId = LAST_ID++;
        int lastNameIndex = random.nextInt(65,91); // Gera um caractere aleatório para o sobrenome
        name = firstNames[random.nextInt(5)] + " " + (char) lastNameIndex;
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2018, 2023);

    }

    /**
     * Retorna uma representação em string formatada do estudante.
     *
     * @return Uma string contendo o ID, nome, curso e ano de início do estudante.
     */
    @Override
    public String toString() {
        return "%d %-15s %-15s %d".formatted(studentId, name, course, yearStarted);
    }

    /**
     * Retorna o ano em que o estudante iniciou o curso.
     *
     * @return O ano de início do estudante.
     */
    public int getYearStarted(){
        return yearStarted;
    }

    /**
     * Verifica se um campo específico do estudante corresponde a um determinado valor.
     *
     * @param fieldName O nome do campo a ser verificado (ex: "NAME", "COURSE", "YEARSTARTED").
     * @param value O valor a ser comparado com o campo.
     * @return {@code true} se o campo corresponder ao valor, {@code false} caso contrário.
     */
    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fName = fieldName.toUpperCase();
        return switch (fName){
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted==(Integer.parseInt(value));
            default -> false;
        };
    }

    /**
     * Compara este estudante com outro estudante com base no ID do estudante.
     *
     * @param o O outro estudante a ser comparado.
     * @return Um valor negativo, zero ou positivo se este estudante for menor, igual ou maior que o objeto especificado.
     */
    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(studentId).compareTo(o.studentId);
    }
}

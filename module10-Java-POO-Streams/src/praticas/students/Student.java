package praticas.students;

import java.time.LocalDate;
import java.util.*;

/**
 * Representa um estudante matriculado em um ou mais cursos.
 *
 * <p>A classe armazena informações pessoais e acadêmicas do estudante,
 * além de gerenciar seu engajamento e progresso nos cursos.</p>
 *
 * <p>Também fornece métodos utilitários para gerar estudantes aleatórios,
 * utilizados nas demonstrações e exercícios com Streams.</p>
 */
public class Student {

    private static long lastStudentId = 1;
    private static final Random random = new Random();

    private final long studentId;
    private final String countryCode;
    private final int yearEnrolled;
    private final int ageEnrolled;
    private final String gender;
    private final boolean programmingExperience;

    private final Map<String, CourseEngagement> engagementMap = new HashMap<>();

    /**
     * Cria um novo estudante e o matricula nos cursos informados.
     *
     * @param countryCode código do país do estudante
     * @param yearEnrolled ano de matrícula
     * @param ageEnrolled idade do estudante no momento da matrícula
     * @param gender gênero do estudante
     * @param programmingExperience indica se possui experiência em programação
     * @param courses cursos iniciais do estudante
     */
    public Student(String countryCode, int yearEnrolled,
                   int ageEnrolled, String gender,
                   boolean programmingExperience,
                   Course... courses) {

        studentId = lastStudentId++;

        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.ageEnrolled = ageEnrolled;
        this.gender = gender;
        this.programmingExperience = programmingExperience;

        for (Course course : courses) {
            addCourse(
                    course,
                    LocalDate.of(yearEnrolled, 1, 1)
            );
        }
    }

    /**
     * Adiciona um novo curso ao estudante utilizando a data atual
     * como data de matrícula.
     *
     * @param newCourse curso a ser adicionado
     */
    public void addCourse(Course newCourse) {

        addCourse(newCourse, LocalDate.now());
    }

    /**
     * Adiciona um novo curso ao estudante.
     *
     * @param newCourse curso a ser adicionado
     * @param enrollDate data de matrícula no curso
     */
    public void addCourse(Course newCourse, LocalDate enrollDate) {

        engagementMap.put(
                newCourse.courseCode(),
                new CourseEngagement(
                        newCourse,
                        enrollDate,
                        "Matrícula"
                )
        );
    }

    /**
     * Retorna o identificador do estudante.
     *
     * @return identificador do estudante
     */
    public long getStudentId() {

        return studentId;
    }

    /**
     * Retorna o código do país do estudante.
     *
     * @return código do país
     */
    public String getCountryCode() {

        return countryCode;
    }

    /**
     * Retorna o ano de matrícula do estudante.
     *
     * @return ano de matrícula
     */
    public int getYearEnrolled() {

        return yearEnrolled;
    }

    /**
     * Retorna a idade do estudante no momento da matrícula.
     *
     * @return idade na matrícula
     */
    public int getAgeEnrolled() {

        return ageEnrolled;
    }

    /**
     * Retorna o gênero do estudante.
     *
     * @return gênero do estudante
     */
    public String getGender() {

        return gender;
    }

    /**
     * Verifica se o estudante possui experiência em programação.
     *
     * @return {@code true} caso possua experiência em programação,
     * caso contrário {@code false}
     */
    public boolean hasProgrammingExperience() {

        return programmingExperience;
    }

    /**
     * Retorna uma cópia não modificável do mapa de engajamentos.
     *
     * @return mapa contendo os engajamentos do estudante
     */
    public Map<String, CourseEngagement> getEngagementMap() {

        return Map.copyOf(engagementMap);
    }

    /**
     * Calcula quantos anos se passaram desde a matrícula.
     *
     * @return quantidade de anos desde a matrícula
     */
    public int getYearsSinceEnrolled() {

        return LocalDate.now().getYear() - yearEnrolled;
    }

    /**
     * Calcula a idade atual do estudante.
     *
     * @return idade atual do estudante
     */
    public int getAge() {

        return ageEnrolled + getYearsSinceEnrolled();
    }

    /**
     * Retorna a quantidade de meses desde a última atividade
     * em um curso específico.
     *
     * @param courseCode código do curso
     * @return meses desde a última atividade
     */
    public int getMonthsSinceActive(String courseCode) {

        CourseEngagement info = engagementMap.get(courseCode);

        return info == null
                ? 0
                : info.getMonthsSinceActive();
    }

    /**
     * Retorna a menor quantidade de meses de inatividade entre
     * todos os cursos do estudante.
     *
     * @return meses desde a atividade mais recente
     */
    public int getMonthsSinceActive() {

        int inactiveMonths =
                (LocalDate.now().getYear() - 2014) * 12;

        for (String key : engagementMap.keySet()) {

            inactiveMonths = Math.min(
                    inactiveMonths,
                    getMonthsSinceActive(key)
            );
        }

        return inactiveMonths;
    }

    /**
     * Retorna o percentual concluído de um curso.
     *
     * @param courseCode código do curso
     * @return percentual de conclusão do curso
     */
    public double getPercentComplete(String courseCode) {

        CourseEngagement info = engagementMap.get(courseCode);

        return info == null
                ? 0
                : info.getPercentComplete();
    }

    /**
     * Registra uma aula assistida pelo estudante.
     *
     * @param courseCode código do curso
     * @param lectureNumber número da aula
     * @param month mês da atividade
     * @param year ano da atividade
     */
    public void watchLecture(String courseCode,
                             int lectureNumber,
                             int month,
                             int year) {

        CourseEngagement activity =
                engagementMap.get(courseCode);

        if (activity != null) {

            activity.watchLecture(
                    lectureNumber,
                    LocalDate.of(year, month, 1)
            );
        }
    }

    /**
     * Retorna aleatoriamente um dos valores informados.
     *
     * @param data valores disponíveis
     * @return valor selecionado aleatoriamente
     */
    private static String getRandomVal(String... data) {

        return data[random.nextInt(data.length)];
    }

    /**
     * Seleciona aleatoriamente um ou mais cursos.
     *
     * @param courses cursos disponíveis
     * @return array contendo os cursos selecionados
     */
    private static Course[] getRandomSelection(Course... courses) {

        int courseCount = random.nextInt(
                1,
                courses.length + 1
        );

        List<Course> courseList =
                new ArrayList<>(Arrays.asList(courses));

        Collections.shuffle(courseList);

        List<Course> selectedCourses =
                courseList.subList(0, courseCount);

        return selectedCourses.toArray(new Course[0]);
    }

    /**
     * Cria um estudante com informações geradas aleatoriamente.
     *
     * <p>O estudante recebe dados como país, idade, gênero,
     * experiência em programação e cursos aleatórios.</p>
     *
     * <p>Também são simuladas atividades em diferentes aulas
     * dos cursos selecionados.</p>
     *
     * @param courses cursos disponíveis para seleção
     * @return estudante gerado aleatoriamente
     */
    public static Student getRandomStudent(Course... courses) {

        int maxYear = LocalDate.now().getYear() + 1;

        Course[] randomCourses =
                getRandomSelection(courses);

        Student student = new Student(
                getRandomVal(
                        "AU",
                        "CA",
                        "CN",
                        "GB",
                        "IN",
                        "UA",
                        "US"
                ),
                random.nextInt(2015, maxYear),
                random.nextInt(18, 90),
                getRandomVal("M", "F", "U"),
                random.nextBoolean(),
                randomCourses
        );

        for (Course course : randomCourses) {

            int lecture = random.nextInt(
                    30,
                    course.lectureCount()
            );

            int year = random.nextInt(
                    student.getYearEnrolled(),
                    maxYear
            );

            int month = random.nextInt(1, 13);

            if (year == (maxYear - 1)
                    && month > LocalDate.now().getMonthValue()) {

                month = LocalDate.now().getMonthValue();
            }

            student.watchLecture(
                    course.courseCode(),
                    lecture,
                    month,
                    year
            );
        }

        return student;
    }

    /**
     * Retorna uma representação textual do estudante.
     *
     * @return informações do estudante
     */
    @Override
    public String toString() {

        return "Estudante{" +
                "idEstudante=" + studentId +
                ", codigoPais='" + countryCode + '\'' +
                ", anoMatricula=" + yearEnrolled +
                ", idadeMatricula=" + ageEnrolled +
                ", genero='" + gender + '\'' +
                ", experienciaProgramacao=" + programmingExperience +
                ", mapaEngajamento=" + engagementMap +
                '}';
    }
}

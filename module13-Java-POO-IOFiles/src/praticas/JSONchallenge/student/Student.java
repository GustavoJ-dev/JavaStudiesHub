package praticas.JSONchallenge.student;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Representa um estudante matriculado em um ou mais cursos.
 * <p>
 * A classe armazena os dados demográficos do aluno, os cursos em que
 * está matriculado e o progresso de aprendizado em cada curso.
 * Também fornece operações para consultar o progresso, adicionar
 * novos cursos e gerar representações em texto e JSON.
 * </p>
 *
 */
public class Student {

    /**
     * Identificador sequencial utilizado para gerar os IDs dos estudantes.
     */
    private static long lastStudentId = 1;

    /**
     * Identificador único do estudante.
     */
    private final long studentId;

    /**
     * Informações demográficas do estudante.
     */
    private final StudentDemographics demographics;

    /**
     * Lista de cursos nos quais o estudante está matriculado.
     */
    private final List<Course> coursesEnrolled;

    /**
     * Mapeia o código de cada curso para suas informações de engajamento.
     */
    private final Map<String, CourseEngagement> engagementMap;

    /**
     * Cria um novo estudante e realiza sua matrícula nos cursos informados.
     *
     * @param country país do estudante
     * @param month mês da matrícula
     * @param year ano da matrícula
     * @param age idade no momento da matrícula
     * @param gender gênero do estudante
     * @param hasExperience indica se possui experiência prévia em programação
     * @param courses cursos nos quais o estudante será matriculado
     */
    public Student(String country, int month, int year, int age, String gender,
                   boolean hasExperience, Course... courses){

        studentId = lastStudentId++;
        demographics = new StudentDemographics(country, month, year, age, gender,
                hasExperience);
        coursesEnrolled = new ArrayList<>(Arrays.asList(courses));
        engagementMap = new HashMap<>();

        for (Course course : courses){

            engagementMap.put(course.courseCode(),
                    new CourseEngagement(course.courseCode(), month, year, "Matrícula"));
        }
    }

    /**
     * Retorna o identificador do estudante.
     *
     * @return ID do estudante
     */
    public long getStudentId(){

        return studentId;
    }

    /**
     * Retorna a idade atual do estudante.
     *
     * @return idade atual
     */
    public int getAge(){

        int currentYear = LocalDate.now().getYear();
        int enrolledYear = demographics.enrolledYear();
        int age = demographics.ageAtEnrollment();

        return age + (currentYear - enrolledYear);
    }

    /**
     * Retorna a idade do estudante no momento da matrícula.
     *
     * @return idade na matrícula
     */
    public int getEnrollmentAge() {
        return demographics.ageAtEnrollment();
    }

    /**
     * Retorna o gênero do estudante.
     *
     * @return gênero
     */
    public String getGender() {
        return demographics.gender();
    }

    /**
     * Retorna o ano da matrícula.
     *
     * @return ano da matrícula
     */
    public int getEnrollmentYear() {
        return demographics.enrolledYear();
    }

    /**
     * Retorna o mês da matrícula.
     *
     * @return mês da matrícula
     */
    public int getEnrollmentMonth() {
        return demographics.enrolledMonth();
    }

    /**
     * Retorna o país do estudante.
     *
     * @return código do país
     */
    public String getCountry() {
        return demographics.countryCode();
    }

    /**
     * Informa se o estudante possuía experiência prévia em programação.
     *
     * @return {@code true} se possuía experiência; caso contrário {@code false}
     */
    public boolean hasExperience() {
        return demographics.previousProgrammingExperience();
    }

    /**
     * Retorna o número de meses de inatividade em um curso.
     *
     * @param courseCode código do curso
     * @return quantidade de meses sem atividade
     */
    public int getInactiveMonths(String courseCode){

        CourseEngagement info = engagementMap.get(courseCode);

        return info.getInactiveMonths();
    }

    /**
     * Retorna o menor período de inatividade entre todos os cursos.
     *
     * @return quantidade de meses de inatividade
     */
    public int getInactiveMonths(){

        int inactiveMonths = 300;

        for (String key : engagementMap.keySet()){

            int mos = getInactiveMonths(key);

            if (mos < inactiveMonths){

                inactiveMonths = mos;
            }
        }

        return inactiveMonths;
    }

    /**
     * Retorna o percentual de conclusão de um curso.
     *
     * @param courseCode código do curso
     * @return percentual concluído
     */
    public double getPercentComplete(String courseCode){

        var info = engagementMap.get(courseCode);

        for (var c : coursesEnrolled){

            if (c.courseCode().equals(courseCode)) {

                return info.getPercentComplete(c.getLectureCount());
            }
        }

        System.out.println("Curso não encontrado: " + courseCode);

        return 0;
    }

    /**
     * Matricula o estudante em um novo curso.
     *
     * @param newCourse curso a ser adicionado
     */
    public void addCourse(Course newCourse){

        LocalDate now = LocalDate.now();

        engagementMap.put(newCourse.courseCode(),
                new CourseEngagement(newCourse.courseCode(), now.getMonthValue(),
                        now.getYear(), "Matrícula"));

        coursesEnrolled.add(newCourse);
    }

    /**
     * Registra a visualização de uma aula.
     *
     * @param courseCode código do curso
     * @param lectureNumber número da aula assistida
     * @param month mês da atividade
     * @param year ano da atividade
     */
    public void startVideo(String courseCode, int lectureNumber, int month, int year){

        var activity = engagementMap.get(courseCode);

        activity.recordLastActivity(lectureNumber, month, year);
    }

    /**
     * Retorna uma representação textual do estudante.
     *
     * @return informações do estudante, cursos e progresso
     */
    @Override
    public String toString() {

        String engagementData = "";

        for (var engagement : engagementMap.values()) {

            engagementData += engagement.toString();
        }

        return "Aluno = %s%n%s%nCursos: %s%n%s".formatted(
                studentId, demographics, coursesEnrolled, engagementData);
    }

    /**
     * Converte o estudante para uma representação em JSON.
     *
     * @return estudante no formato JSON
     */
    public String toJSON() {

        StringJoiner courses = new StringJoiner(",", "[", "]");

        for (Course c : coursesEnrolled) {

            courses.add(c.toJSON());
        }

        String engagement = engagementMap.values().stream()
                .map(CourseEngagement::toJSON)
                .collect(Collectors.joining(",", "[", "]"));

        return new StringJoiner(", ", "{", "}")
                .add("\"studentId\":" + studentId)
                .add("\"demographics\":" + demographics.toJSON())
                .add("\"coursesEnrolled\":" + courses)
                .add("\"engagementMap\":" + engagement)
                .toString();
    }

    /**
     * Retorna os registros de engajamento do estudante.
     *
     * @return lista contendo os registros de engajamento
     */
    public List<String> getEngagementRecords() {

        int i = 0;

        List<String> engagementData = new ArrayList<>();

        for (var engagement : engagementMap.values()) {
            engagementData.add("%s,%s,%s".formatted(
                    studentId,
                    demographics,
                    engagement));
        }

        return engagementData;
    }

    /**
     * Gera um estudante com dados aleatórios.
     * <p>
     * O estudante é matriculado nos cursos informados e recebe
     * um progresso aleatório em cada um deles.
     * </p>
     *
     * @param courses cursos em que o estudante será matriculado
     * @return um estudante gerado aleatoriamente
     */
    public static Student getRandomStudent(Course... courses) {

        Random random = new Random();
        String countryCode = List.of("AU", "CN", "GB", "IN", "US")
                .get(random.nextInt(5));

        String gender = List.of("M", "F", "U").get(random.nextInt(3));

        int minYear = 2015;

        int maxYear = LocalDate.now().getYear() + 1;

        Student student = new Student(countryCode,
                random.nextInt(1, 13),
                random.nextInt(minYear, maxYear),
                random.nextInt(18, 90),
                gender, random.nextBoolean(), courses);

        int yearEnrolled = student.getEnrollmentYear();

        List.of(courses).forEach(c ->
                student.startVideo(c.courseCode(),
                        random.nextInt(1, c.getLectureCount()),
                        random.nextInt(1, 13),
                        random.nextInt(yearEnrolled, maxYear))
        );

        return student;
    }
}

package praticas.employeereunion;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.zone.ZoneRules;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.time.format.DateTimeFormatter.*;

/**
 * Classe principal responsável por demonstrar o uso da API de Data e Hora do Java
 * ({@code java.time}) juntamente com a Streams API para agendar reuniões entre
 * funcionários localizados em diferentes fusos horários.
 * <p>
 * O programa realiza as seguintes operações:
 * <ul>
 *     <li>Cria funcionários em diferentes localidades.</li>
 *     <li>Compara fusos horários.</li>
 *     <li>Verifica horário de verão (Daylight Saving Time).</li>
 *     <li>Calcula a diferença de horário entre localidades.</li>
 *     <li>Gera automaticamente horários de reunião válidos.</li>
 *     <li>Agrupa os horários disponíveis por data utilizando Streams.</li>
 * </ul>
 *
 */
public class Main {

    /**
     * Representa um funcionário contendo seu nome, localização e fuso horário.
     *
     * @param name   nome do funcionário
     * @param locale localização utilizada para formatação das datas
     * @param zone   fuso horário do funcionário
     */
    private record Employee(String name, Locale locale, ZoneId zone) {

        /**
         * Cria um funcionário utilizando códigos de idioma e fuso horário.
         *
         * @param name   nome do funcionário
         * @param locale código da localidade (ex.: {@code en-US})
         * @param zone   identificador do fuso horário
         */
        public Employee(String name, String locale, String zone) {
            this(name, Locale.forLanguageTag(locale), ZoneId.of(zone));
        }

        /**
         * Cria um funcionário utilizando um objeto {@link Locale}.
         *
         * @param name   nome do funcionário
         * @param locale localidade
         * @param zone   identificador do fuso horário
         */
        public Employee(String name, Locale locale, String zone) {
            this(name, locale, ZoneId.of(zone));
        }

        /**
         * Formata uma data e hora utilizando a localidade do funcionário.
         *
         * @param zdt data e hora
         * @param dtf formatador
         * @return informações formatadas contendo nome, fuso e data
         */
        String getDateInfo(ZonedDateTime zdt, DateTimeFormatter dtf) {
            return "%s [%s] : %s".formatted(name, zone,
                    zdt.format(dtf.localizedBy(locale)));
        }
    }

    /**
     * Executa a demonstração da aplicação.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {

        Employee jane = new Employee("Jane", Locale.US, "America/New_York");
        Employee joe = new Employee("Joe", "en-AU", "Australia/Sydney");

        ZoneRules joesRules = joe.zone.getRules();
        ZoneRules janesRules = jane.zone.getRules();

        System.out.println(jane + " " + janesRules);
        System.out.println(joe + " " + joesRules);

        ZonedDateTime janeNow = ZonedDateTime.now(jane.zone);
        ZonedDateTime joeNow = ZonedDateTime.of(janeNow.toLocalDateTime(), joe.zone);

        long hoursBetween = Duration.between(joeNow, janeNow).toHours();
        long minutesBetween = Duration.between(joeNow, janeNow).toMinutesPart();

        System.out.println("Joe está " + Math.abs(hoursBetween) +
                " horas e " + Math.abs(minutesBetween) +
                " minutos " +
                ((hoursBetween < 0) ? "atrás" : "à frente"));

        System.out.println("Joe está em horário de verão? " +
                joesRules.isDaylightSavings(joeNow.toInstant()) + " " +
                joesRules.getDaylightSavings(joeNow.toInstant()) + ": " +
                joeNow.format(ofPattern("zzzz z")));

        System.out.println("Jane está em horário de verão? " +
                janesRules.isDaylightSavings(janeNow.toInstant()) + " " +
                janesRules.getDaylightSavings(janeNow.toInstant()) + ": " +
                janeNow.format(ofPattern("zzzz z")));

        int days = 10;

        var map = schedule(joe, jane, days);

        DateTimeFormatter dtf =
                ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT);

        for (LocalDate date : map.keySet()) {

            System.out.println(date.format(ofLocalizedDate(FormatStyle.FULL)));

            for (ZonedDateTime zdt : map.get(date)) {

                System.out.println("\t"
                        + jane.getDateInfo(zdt, dtf)
                        + " <---> "
                        + joe.getDateInfo(zdt.withZoneSameInstant(joe.zone()), dtf));
            }
        }
    }

    /**
     * Gera uma agenda de horários disponíveis para reuniões entre dois
     * funcionários localizados em fusos horários diferentes.
     * <p>
     * Apenas horários que:
     * <ul>
     *     <li>não ocorram aos sábados e domingos;</li>
     *     <li>estejam entre 07:00 e 20:59;</li>
     *     <li>sejam válidos para ambos os funcionários.</li>
     * </ul>
     * são incluídos no resultado.
     *
     * @param first  primeiro funcionário
     * @param second segundo funcionário
     * @param days   quantidade de dias futuros analisados
     * @return mapa contendo as datas e seus respectivos horários disponíveis
     */
    private static Map<LocalDate, List<ZonedDateTime>> schedule(
            Employee first,
            Employee second,
            int days) {

        Predicate<ZonedDateTime> rules = zdt ->
                zdt.getDayOfWeek() != DayOfWeek.SATURDAY
                        && zdt.getDayOfWeek() != DayOfWeek.SUNDAY
                        && zdt.getHour() >= 7
                        && zdt.getHour() < 21;

        LocalDate startingDate = LocalDate.now().plusDays(2);

        return startingDate.datesUntil(startingDate.plusDays(days + 1))
                .map(date -> date.atStartOfDay(first.zone()))
                .flatMap(date -> IntStream.range(0, 24).mapToObj(date::withHour))
                .filter(rules)
                .map(date -> date.withZoneSameInstant(second.zone()))
                .filter(rules)
                .collect(Collectors.groupingBy(
                        ZonedDateTime::toLocalDate,
                        TreeMap::new,
                        Collectors.toList()));
    }
}

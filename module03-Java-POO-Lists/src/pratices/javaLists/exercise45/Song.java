package pratices.javaLists.exercise45;

/**
 * Representa uma música/canção com título e duração.
 *
 * Esta classe encapsula as informações básicas de uma canção,
 * armazenando seu título e duração em minutos.
 */
public class Song {

    private String title;
    private double duration;

    /**
     * Constrói uma nova canção com título e duração.
     *
     * @param title    O título da canção
     * @param duration A duração da canção em minutos
     */
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    /**
     * Obtém o título da canção.
     *
     * @return O título da canção
     */
    public String getTitle() {
        return title;
    }

    /**
     * Obtém a duração da canção.
     *
     * @return A duração da canção em minutos
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Retorna uma representação em string da canção.
     *
     * Formato: "Título: Duração"
     *
     * @return Uma string representando a canção
     */
    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }
}

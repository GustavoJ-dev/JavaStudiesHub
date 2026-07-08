package pratices.studentsChallenge.dev.lpa.model;

/**
 * Representa um estudante específico da plataforma LPA.
 * Estende a classe {@link Student} e adiciona informações sobre o progresso do curso.
 */
public class LPAStudent extends Student {
    /**
     * O percentual de conclusão do curso pelo estudante.
     */
    private double percentComplete;

    /**
     * Construtor padrão que inicializa um estudante LPA com dados aleatórios,
     * incluindo um percentual de conclusão aleatório entre 0 e 100.
     */
    public LPAStudent(){
        percentComplete = random.nextDouble(0,100.001);
    }

    /**
     * Retorna uma representação em string formatada do estudante LPA,
     * incluindo as informações base de {@link Student} e o percentual de conclusão.
     *
     * @return Uma string contendo os dados do estudante e seu progresso.
     */
    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(),percentComplete);
    }

    /**
     * Retorna o percentual de conclusão do curso pelo estudante.
     *
     * @return O percentual de conclusão.
     */
    public double getPercentComplete(){
        return percentComplete;
    }

    /**
     * Verifica se um campo específico do estudante LPA corresponde a um determinado valor.
     * Além dos campos herdados de {@link Student}, suporta o campo "percentComplete".
     * No caso de "percentComplete", verifica se o progresso é menor ou igual ao valor informado.
     *
     * @param fieldName O nome do campo a ser verificado.
     * @param value O valor a ser comparado.
     * @return {@code true} se o campo corresponder aos critérios, {@code false} caso contrário.
     */
    @Override
    public boolean matchFieldValue(String fieldName, String value) {

        if (fieldName.equalsIgnoreCase("percentComplete")){
            return percentComplete <= Integer.parseInt(value);
        }
        return super.matchFieldValue(fieldName, value);
    }
}

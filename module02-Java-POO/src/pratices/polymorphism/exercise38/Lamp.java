package pratices.polymorphism.exercise38;

/**
 * Representa uma lâmpada dentro do sistema de composição de um quarto.
 * @param style      O estilo de design da lâmpada (ex: Moderno, Industrial).
 * @param battery    Indica se a lâmpada é alimentada por bateria (true) ou rede elétrica (false).
 * @param globRating Representa a potência ou classificação de voltagem da lâmpada.
 */
public record Lamp(String style, boolean battery, int globRating) {

    /**
     * Executa a ação de ligar a lâmpada, enviando um log para o console.
     */
    public void turnOn(){
        System.out.println("Lamp -> Turning on");
    }

    /**
     * Retorna uma representação textual customizada da lâmpada.
     * 
     * @return Uma {@code String} formatada com o estilo, 
     *         informação de bateria e voltagem/potência.
     */
    @Override
    public String toString() {
        return style + ", battery: " + battery() + " " + ", Voltagem: " + globRating;
    }
}

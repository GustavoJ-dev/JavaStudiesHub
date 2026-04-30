package module03.learning.extrachallenges;

/**
 * Classe que contém a resolução do Desafio Extra Dois do Módulo 03.
 * Focada na conversão de segundos e minutos para um formato de tempo legível (horas, minutos, segundos),
 * demonstrando sobrecarga de métodos e validação de entrada.
 */
public class ExtraTwo {

    /**
     * Metodo principal para testar as funcionalidades de conversão de duração.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println(getDurationString(3945)); // 1h 5m 45s
        System.out.println(getDurationString(65, 45)); // 1h 5m 45s
        System.out.println(getDurationString(-1)); // Segundos inválidos!
        System.out.println(getDurationString(60, -1)); // Parâmetros inválidos!
        System.out.println(getDurationString(60, 60)); // Parâmetros inválidos!
        System.out.println(getDurationString(0)); // 0h 0m 0s
        System.out.println(getDurationString(0, 0)); // 0h 0m 0s
    }

    /**
     * Converte um total de minutos e segundos em uma string formatada como "Xh Ym Zs".
     * Realiza validação para garantir que os minutos e segundos sejam valores válidos.
     *
     * @param minutos O número total de minutos. Deve ser um valor não negativo.
     * @param segundos O número de segundos. Deve ser um valor entre 0 e 59 (inclusive).
     * @return Uma string formatada com horas, minutos e segundos, ou uma mensagem de erro
     *         se os parâmetros forem inválidos.
     */
    public static String getDurationString(int minutos, int segundos) {
        if (minutos < 0 || segundos < 0 || segundos > 59) {
            return "Parâmetros inválidos!";
        }
        int horas = minutos / 60;
        int minRest = minutos % 60;
        return horas + "h " + minRest + "m " + segundos + "s";
    }

    /**
     * Converte um total de segundos em uma string formatada como "Xh Ym Zs".
     * Este metodo sobrecarregado calcula os minutos e segundos a partir do total de segundos
     * e então chama o metodo {@link #getDurationString(int, int)} para formatar a saída.
     *
     * @param segundos O número total de segundos. Deve ser um valor não negativo.
     * @return Uma string formatada com horas, minutos e segundos, ou uma mensagem de erro
     *         se os segundos forem inválidos.
     */
    public static String getDurationString(int segundos) {
        if (segundos < 0) {
            return "Segundos inválidos!";
        }
        // Calcula os minutos e segundos a partir do total de segundos
        int minutos = segundos / 60;
        int segundosRestantes = segundos % 60;
        // Chama o metodo sobrecarregado para formatar a string
        return getDurationString(minutos, segundosRestantes);
    }
}

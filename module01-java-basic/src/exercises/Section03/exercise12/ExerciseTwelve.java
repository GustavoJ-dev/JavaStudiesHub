package exercises.Section03.exercise12;

/**
 * Classe que contém a resolução do Exercício Doze do Módulo 03.
 * Focada na lógica condicional para determinar se um gato está brincando
 * com base na temperatura e na estação do ano (verão).
 */
public class ExerciseTwelve {

    /**
     * Metodo principal para testar a funcionalidade de verificação de brincadeira do gato.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("Gato brincando (não verão, 10°C)? " + isCatPlaying(false, 10)); // false
        System.out.println("Gato brincando (verão, 36°C)? " + isCatPlaying(true, 36));   // true
        System.out.println("Gato brincando (não verão, 36°C)? " + isCatPlaying(false, 36)); // false (max 35)
        System.out.println("Gato brincando (verão, 46°C)? " + isCatPlaying(true, 46));    // false (max 45)
        System.out.println("Gato brincando (verão, 25°C)? " + isCatPlaying(true, 25));    // true
    }

    /**
     * Verifica se um gato está brincando com base na temperatura e se é verão.
     * As regras são:
     * - Se for verão, o gato brinca se a temperatura estiver entre 25°C e 45°C (inclusive).
     * - Se não for verão, o gato brinca se a temperatura estiver entre 25°C e 35°C (inclusive).
     *
     * @param summer Um booleano que indica se é verão (true) ou não (false).
     * @param temperature A temperatura atual em graus Celsius.
     * @return {@code true} se o gato estiver brincando, {@code false} caso contrário.
     */
    public static boolean isCatPlaying(boolean summer, int temperature){
        // Define a temperatura máxima permitida com base na estação
        int maxTemp = summer ? 45 : 35;
        // Verifica se a temperatura está dentro do intervalo permitido
        return temperature >= 25 && temperature <= maxTemp;
    }
}

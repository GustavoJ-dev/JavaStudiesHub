package exercises.Section03_statements_and_methods.exercise03;

/**
 * Classe que contém uma atividade prática sobre statements e methods.
 * Focada na conversão de Kilobytes para Megabytes e Kilobytes restantes,
 * e vice-versa, demonstrando operações de divisão e módulo.
 */
public class KConverse {

    /**
     * Método principal para testar as funcionalidades de conversão e impressão.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        printMegaBytesAndKiloBytes(2500);
        printMegaBytesAndKiloBytes(100);
        printMegaBytesAndKiloBytes(2716);
    }

    /**
     * Imprime a conversão de um valor em Kilobytes para Megabytes e Kilobytes restantes.
     * Se o valor de entrada for negativo, imprime "Invalid Value".
     *
     * @param kiloBytes O valor em Kilobytes a ser convertido.
     */
    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
            return;
        }
        int megaBytes = kiloBytes / 1024;
        int remainingKiloBytes = kiloBytes % 1024;

        System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + remainingKiloBytes + " KB");
    }

    /**
     * Calcula e retorna uma string formatada da conversão de Kilobytes para Megabytes e Kilobytes restantes.
     * Este método é auxiliar e não é chamado diretamente no `main` atual, mas pode ser útil.
     *
     * @param kiloBytes O valor em Kilobytes.
     * @return Uma string com a conversão, ou "Invalid Value" se o input for negativo.
     * @deprecated Este método tem uma lógica similar a {@link #printMegaBytesAndKiloBytes(int)}
     *             e pode ser redundante. Considere usar {@link #printMegaBytesAndKiloBytes(int)} para impressão.
     */
    public static String megaByteValue(int kiloBytes) {
        if (kiloBytes < 0) {
            return "Invalid Value"; // Retorna string em vez de imprimir diretamente
        }
        int restKB = kiloBytes % 1024;
        int megaBytes = kiloBytes / 1024;
        return kiloBytes + " KiloBytes = " + megaBytes + " MegaBytes and " + restKB + " KiloBytes";
    }

    /**
     * Calcula e retorna uma string formatada da conversão de Megabytes para Kilobytes.
     * Este método é auxiliar e não é chamado diretamente no `main` atual, mas pode ser útil.
     *
     * @param megaBytes O valor em Megabytes.
     * @return Uma string com a conversão, ou "Invalid Value" se o input for negativo.
     * @deprecated Este método não é utilizado no fluxo principal e pode ser removido se não houver uso.
     */
    public static String kiloByteValue(int megaBytes) {
        if (megaBytes < 0) {
            return "Invalid Value"; // Retorna string em vez de imprimir diretamente
        }
        int kyloBytes = megaBytes * 1024;
        return megaBytes + " MegaBytes = " + kyloBytes + " KiloBytes";
    }
}

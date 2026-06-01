package exercises.Section03.exercise02;

/**
 * Classe que contém uma atividade prática sobre o Módulo 03.
 * Focada na conversão de quilômetros por hora para milhas por hora,
 * demonstrando o uso de métodos estáticos e controle de fluxo.
 */
public class KmConversor {

    /**
     * Metodo principal para testar as funcionalidades de conversão e impressão.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        printConversion(10.5);
        printConversion(-5.6);
        printConversion(75.114);
    }

    /**
     * Converte uma velocidade de quilômetros por hora (km/h) para milhas por hora (mi/h).
     *
     * @param kilometersPerHour A velocidade em quilômetros por hora. Deve ser um valor não negativo.
     * @return A velocidade convertida para milhas por hora, arredondada para o inteiro mais próximo.
     *         Retorna -1 se o valor de entrada for negativo.
     */
    public static long toMilesPerHour(double kilometersPerHour){
        if (kilometersPerHour < 0){
            return -1;
        }
        // 1 milha = 1.609344 quilômetros
        return Math.round(kilometersPerHour / 1.609344);
    }

    /**
     * Imprime no console a conversão de quilômetros por hora para milhas por hora.
     * Se o valor de entrada for negativo, imprime "invalid value".
     *
     * @param kilometersPerHour A velocidade em quilômetros por hora a ser convertida e impressa.
     */
    public static void printConversion(double kilometersPerHour){
        if (kilometersPerHour < 0){
            System.out.println("invalid value");
            return;
        }
        long milesPerHours = toMilesPerHour(kilometersPerHour);
        System.out.println(kilometersPerHour + " km/h = " + milesPerHours + " mi/h");
    }
}

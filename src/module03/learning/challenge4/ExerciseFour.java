package module03.learning.challenge4;

/**
 * Classe que contém a resolução do Exercício Quatro do Módulo 03.
 * Focada na lógica condicional para determinar se um cachorro está latindo
 * em um horário inadequado.
 */
public class ExerciseFour {

    /**
     * Método principal para testar a funcionalidade de verificação de latidos.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println(barking(true, 1)); // true (latindo de madrugada)
        System.out.println(barking(true, 8)); // false (latindo de manhã, ok)
        System.out.println(barking(false, 2)); // false (não está latindo)
        System.out.println(barking(true, 23)); // true (latindo tarde da noite)
        System.out.println(barking(true, -1)); // false (hora inválida)
        System.out.println(barking(true, 25)); // false (hora inválida)
    }

    /**
     * Verifica se um cachorro está latindo em um horário que pode causar problemas.
     * O cachorro está latindo em horário inadequado se for antes das 8h ou depois das 22h.
     *
     * @param barking Um booleano que indica se o cachorro está latindo (true) ou não (false).
     * @param hourOfDay Um inteiro representando a hora do dia (0-23).
     * @return {@code true} se o cachorro estiver latindo e a hora for antes das 8h ou depois das 22h,
     *         {@code false} caso contrário ou se a hora for inválida.
     */
    public static boolean barking(boolean barking, int hourOfDay) {
        if (hourOfDay < 0 || hourOfDay > 23) {
            return false; // Hora inválida
        }
        // Retorna true se estiver latindo E a hora for antes das 8h OU depois das 22h
        return barking && (hourOfDay < 8 || hourOfDay > 22);
    }
}

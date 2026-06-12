package exercises.Section04_flow_control.challenge14;

/**
 * Classe que contém uma atividade prática sobre flow control.
 * Focada no cálculo do número de dias em um determinado mês de um ano específico,
 * considerando anos bissextos e utilizando a estrutura `switch expression`.
 */
public class EnhancedLeapYear {

    /**
     * Metodo principal para testar a funcionalidade de obtenção do número de dias no mês.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("Dias em Jan/2020: " + getDaysInMonth(1, 2020));   // 31
        System.out.println("Dias em Fev/2024: " + getDaysInMonth(2, 2024));   // 29 (ano bissexto)
        System.out.println("Dias em Fev/2023: " + getDaysInMonth(2, 2023));   // 28 (não bissexto)
        System.out.println("Dias em Nov/2022: " + getDaysInMonth(11, 2022));  // 30
        System.out.println("Dias em Mês inválido (0): " + getDaysInMonth(0, 2020)); // -1
        System.out.println("Dias em Mês inválido (13): " + getDaysInMonth(13, 2020)); // -1
        System.out.println("Dias em Ano inválido (-2020): " + getDaysInMonth(1, -2020)); // -1
    }

    /**
     * Retorna o número de dias em um determinado mês de um ano específico.
     * Considera as regras para anos bissextos para o mês de fevereiro.
     *
     * @param month O número do mês (1 para Janeiro, 12 para Dezembro).
     * @param year O ano (deve ser um valor positivo).
     * @return O número de dias no mês especificado, ou -1 se o mês ou o ano forem inválidos.
     */
    public static int getDaysInMonth(int month, int year){
        if (month < 1 || month > 12 || year < 1) {
            return -1; // Mês ou ano inválido
        }

        return switch (month){
            case 1, 3, 5, 7, 8, 10, 12 -> 31; // Meses com 31 dias
            case 2 -> { // Fevereiro
                // Lógica para verificar se o ano é bissexto
                boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                yield isLeapYear ? 29 : 28; // 29 dias se bissexto, 28 caso contrário
            }
            case 4, 6, 9, 11 -> 30; // Meses com 30 dias
            default -> -1; // Não deveria chegar aqui devido à validação inicial, mas é um fallback
        };
    }
}

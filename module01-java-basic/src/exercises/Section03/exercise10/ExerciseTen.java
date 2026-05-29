package exercises.Section03.exercise10;

/**
 * Classe que contém a resolução do Exercício Dez do Módulo 03.
 * Focada na conversão de minutos para anos e dias,
 * demonstrando operações de divisão e módulo com tipos de dados `long`.
 */
public class ExerciseTen {

    /**
     * Método principal para testar a funcionalidade de conversão de tempo.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        printYearsAndDays(525600);  // 1 ano e 0 dias
        printYearsAndDays(1051200); // 2 anos e 0 dias
        printYearsAndDays(561600);  // 1 ano e 36 dias
        printYearsAndDays(-100);    // Valor inválido
        printYearsAndDays(0);       // 0 min = 0 years and 0 days
    }

    /**
     * Converte um valor em minutos para uma representação em anos e dias.
     * Assume que 1 dia tem 24 horas (1440 minutos) e 1 ano tem 365 dias.
     * Imprime o resultado no console. Se o valor de entrada for negativo,
     * imprime "Invalid Value".
     *
     * @param minutes O número total de minutos a ser convertido. Deve ser um valor não negativo.
     */
    public static void printYearsAndDays(long minutes){
        if (minutes < 0){
            System.out.println("Invalid Value");
            return;
        }
        long days = minutes / 1440; // Calcula o total de dias
        long years = days / 365;    // Calcula o total de anos
        long restDays = days % 365; // Calcula os dias restantes após a conversão para anos

        System.out.println(minutes + " min = " + years + " years and " + restDays + " days");
    }
}

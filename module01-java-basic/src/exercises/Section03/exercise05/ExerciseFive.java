package exercises.Section03.exercise05;

/**
 * Classe que contém a resolução do Exercício Cinco do Módulo 03.
 * Focada na lógica para determinar se um ano é bissexto,
 * aplicando regras de divisibilidade.
 */
public class ExerciseFive {

    /**
     * Método principal para testar a funcionalidade de verificação de ano bissexto.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("2000 é bissexto? " + isLeapYear(2000)); // true
        System.out.println("2001 é bissexto? " + isLeapYear(2001)); // false
        System.out.println("1900 é bissexto? " + isLeapYear(1900)); // false
        System.out.println("2024 é bissexto? " + isLeapYear(2024)); // true
        System.out.println("Ano inválido (0)? " + isLeapYear(0));   // false
        System.out.println("Ano inválido (10000)? " + isLeapYear(10000)); // false
    }

    /**
     * Verifica se um determinado ano é bissexto.
     * Um ano é bissexto se for divisível por 4,
     * mas não por 100, a menos que seja divisível por 400.
     * O ano deve estar no intervalo de 1 a 9999.
     *
     * @param year O ano a ser verificado (entre 1 e 9999).
     * @return {@code true} se o ano for bissexto e estiver no intervalo válido,
     *         {@code false} caso contrário.
     */
    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false; // Ano fora do intervalo válido
        }
        // Regra para ano bissexto:
        // (divisível por 4 E (não divisível por 100 OU divisível por 400))
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }
}

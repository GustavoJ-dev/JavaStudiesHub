package exercises.Section03.exercise08;

/**
 * Classe que contém a resolução do Exercício Oito do Módulo 03.
 * Focada na verificação de idades para determinar se uma pessoa é adolescente (teen)
 * e se um grupo de pessoas contém pelo menos um adolescente.
 */
public class ExerciseEight {

    /**
     * Método principal para testar as funcionalidades de verificação de idade.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("isTeen(13)? " + isTeen(13)); // true
        System.out.println("isTeen(12)? " + isTeen(12)); // false
        System.out.println("isTeen(19)? " + isTeen(19)); // true
        System.out.println("isTeen(20)? " + isTeen(20)); // false

        System.out.println("\nhasTeen(9, 99, 19)? " + hasTeen(9, 99, 19)); // true
        System.out.println("hasTeen(23, 15, 42)? " + hasTeen(23, 15, 42)); // true
        System.out.println("hasTeen(22, 23, 34)? " + hasTeen(22, 23, 34)); // false
    }

    /**
     * Verifica se uma idade está na faixa etária de adolescente (entre 13 e 19 anos, inclusive).
     *
     * @param age A idade a ser verificada.
     * @return {@code true} se a idade for entre 13 e 19, {@code false} caso contrário.
     */
    public static boolean isTeen(int age){
        return age >= 13 && age <= 19;
    }

    /**
     * Verifica se pelo menos uma das três idades fornecidas está na faixa etária de adolescente.
     * Reutiliza o método {@link #isTeen(int)} para cada idade.
     *
     * @param ageOne A primeira idade.
     * @param ageTwo A segunda idade.
     * @param ageThree A terceira idade.
     * @return {@code true} se pelo menos uma das idades for de um adolescente, {@code false} caso contrário.
     */
    public static boolean hasTeen(int ageOne, int ageTwo, int ageThree){
        return isTeen(ageOne) || isTeen(ageTwo) || isTeen(ageThree);
    }
}

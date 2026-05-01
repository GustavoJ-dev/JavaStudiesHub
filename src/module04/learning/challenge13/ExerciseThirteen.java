package module04.learning.challenge13;

public class ExerciseThirteen {
    public static void main(String[] args) {
        System.out.println(longDigit(9));

    }
    public static String longDigit(int number){
        return switch (number){
            case 1 -> "Um";
            case 2 -> "Dois";
            case 3 -> "Três";
            case 4 -> "Quatro";
            case 5 -> "Cinco";
            case 6 -> "Seis";
            case 7 -> "Sete";
            case 8 -> "Oito";
            case 9 -> "Nove";
            default -> "Inválido";
        };
    }
}

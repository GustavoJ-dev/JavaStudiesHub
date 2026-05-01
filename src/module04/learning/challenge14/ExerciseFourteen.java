package module04.learning.challenge14;

public class ExerciseFourteen {
    public static void main(String[] args) {
        System.out.println(getDaysInMonth(1, 2020));
        System.out.println(getDaysInMonth(2, 2024));
        System.out.println(getDaysInMonth(11, 2022));


    }

    public static int getDaysInMonth(int month, int year){
         return switch (month){
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> {
                boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                yield isLeapYear ? 29 : 28;
            }
            case 4, 6, 9, 11 -> 30;
            default -> -1;
        };
    }

}

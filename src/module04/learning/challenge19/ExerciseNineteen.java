package module04.learning.challenge19;

public class ExerciseNineteen {
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(10,11));
        System.out.println(hasSharedDigit(12,43));
        System.out.println(hasSharedDigit(9,99));
        System.out.println(hasSharedDigit(15,55));


    }
    public static boolean hasSharedDigit(int a, int b) {
        if (a < 10 || a > 99 || b < 10 || b > 99) {
            return false;
        }
        int digitARight = a % 10;
        int digitALeft = a / 10;

        int digitBRight = b % 10;
        int digitBLeft = b / 10;

        boolean rightMatch = digitARight == digitBRight || digitARight == digitBLeft;
        boolean leftMatch = digitALeft == digitBRight || digitALeft == digitBLeft;

        return rightMatch || leftMatch;
    }
}
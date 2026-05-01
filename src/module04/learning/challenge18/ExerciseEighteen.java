package module04.learning.challenge18;

public class ExerciseEighteen {
    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(252));
        System.out.println(getEvenDigitSum(123456789));

    }
    public static int getEvenDigitSum(int number){
        if (number < 0){
            return -1;
        }
        int sum = 0;
        while (number != 0){
            int digit = number % 10;
            if (digit % 2 == 0){
                sum += digit;
            }
            number = number / 10;
        }
        return sum;
    }
}

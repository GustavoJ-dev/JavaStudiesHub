package module04.learning.challenge16;

public class ExerciseSixteen {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));

    }

    public static boolean isPalindrome(int number){
       int origin = Math.abs(number);
       int reverse = 0;
       while (origin != 0){
           reverse = reverse * 10 + origin % 10;
           origin = origin / 10;
       }
       return reverse == Math.abs(number);
    }
}

package module04.learning.challenge15;

public class ExerciseFifTeen {
    public static void main(String[] args) {
        System.out.println(sumOdd(1,100));

    }
    public static int sumOdd(int start, int end){
        if (start < 0 || end < 0 || start > end){
            return -1;
        }
        int total = 0;
        for(int i = start; i <= end; i++){
            if (i % 2 != 0){
                total += i;
            }
        }
        return total;
    }
}

package pratices.javaArrays.exercise43;

import java.util.Arrays;

public class ReversedArray {
    public static void main(String[] args) {
        reverse(new int[]{1, 2, 3, 4, 5});
        reverse(new int[]{5, 4, 3, 2, 1});
        reverse(new int[]{38, 192, 182, 2, 1});


    }

    private static void reverse(int[] array){
        System.out.println("Array = " + Arrays.toString(array));
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;

        for(int i = 0; i < halfLength; i++){
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }

        System.out.println("Reversed array = " + Arrays.toString(array));
        System.out.println("_".repeat(30));
    }

}

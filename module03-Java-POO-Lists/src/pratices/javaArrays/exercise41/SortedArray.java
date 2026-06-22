package pratices.javaArrays.exercise41;

import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {

    public static void main(String[] args) {

        int[] originArray = getIntegers(10);
        System.out.println("_".repeat(30));
        int[] sortedArray = sortInteger(originArray);

        printArray(originArray);
        System.out.println("_".repeat(30));
        printArray(sortedArray);

    }

    public static int[] getIntegers(int len){
        Scanner scanner = new Scanner(System.in);
        int[] myArray = new int[len];
        for (int i = 0; i < myArray.length; i++){
            System.out.println("Entre com " + (len - i) + " valores inteiros:");
            int valueOfIndex = scanner.nextInt();
            myArray[i] = valueOfIndex;
        }
        return myArray;
    }

    public static int[] sortInteger(int[] array){
        int[] sortedArray = Arrays.copyOf(array, array.length);

        boolean flag = true;
        int temp;

        while (flag){
            flag = false;
            for(int i = 0; i < array.length - 1; i++){
                if (sortedArray[i] < sortedArray[i + 1]){
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }

    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println("Elemento " + i + " contém " + array[i]);
        }
    }


}

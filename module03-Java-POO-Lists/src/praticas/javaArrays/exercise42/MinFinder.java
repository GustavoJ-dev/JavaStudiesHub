package praticas.javaArrays.exercise42;

import java.util.Scanner;

public class MinFinder {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int[] myArray = readElements(readInteger());
        int minValue = findMin(myArray);
        System.out.println("O menor valor do array é: " + minValue);

    }

    public static int readInteger(){
        System.out.println("Entre com um valor inteiro:");
        int number = scanner.nextInt();
        return number;
    }

    public static int[] readElements(int number){
        scanner = new Scanner(System.in);
        int[] indexArray = new int[number];
        for(int i = 0; i < indexArray.length; i++){
            System.out.println("Entre com " + (number - i) + " Valores inteiros:");
            int valueOfIndex = scanner.nextInt();
            indexArray[i] = valueOfIndex;
        }
        return indexArray;
    }

    private static int findMin(int[] array){
        int min = Integer.MAX_VALUE;
        for (int element : array){
            if (element < min){
                min = element;
            }
        }
        return min;
    }



}

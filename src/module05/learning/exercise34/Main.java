package module05.learning.exercise34;

public class Main {
    public static void main(String[] args) {
        printCarpetValue(2.75, 4.00, 2.25);
        printCarpetValue(2.45, 1.88, 2.42);
        printCarpetValue(5.4, 4.5, 3.3);
        printCarpetValue(-2.75, 4.00, 2.25);


    }
    public static void printCarpetValue(double width, double height, double cost){
        CarpetCost carpet = new CarpetCost(cost);
        Floor floor = new Floor(width,height);
        Calculator calculator = new Calculator(carpet,floor);

        System.out.println("Total = " + calculator.getTotalCost());
    }
}

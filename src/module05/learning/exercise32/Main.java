package module05.learning.exercise32;

public class Main {
    public static void main(String[] args) {
        printArea(5.5, 10);
        printArea(3.5,6.9);
        printArea(2.8, 15);

    }

    public static void printArea(double width, double height){
        Wall wall = new Wall(width,height);

        Wall wall2 = new Wall();
        wall2.setWidth(width);
        wall2.setHeight(height);

        System.out.println("Area = " + wall.getArea());
        System.out.println("Area = " + wall2.getArea());
    }
}

package module05.learning.exercise36;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3.75);
        System.out.printf("circle.radius= %.2f%n", circle.getRadius());
        System.out.printf("circle.area= %.2f%n", circle.getArea());


        Cylinder cylinder = new Cylinder(5.55, 7.25);
        System.out.printf("cylinder.radius = %.2f%n", cylinder.getRadius());
        System.out.printf("cylinder.height = %.2f%n", cylinder.getHeight());
        System.out.printf("cylinder.area = %.2f%n", cylinder.getArea());
        System.out.printf("cylinder.volume = %.2f%n", cylinder.getVolume());



    }
}

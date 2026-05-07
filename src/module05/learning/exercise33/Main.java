package module05.learning.exercise33;

public class Main {
    public static void main(String[] args) {
        printPoint(6,5);

    }
    public static void printPoint(int x, int y){
        Point firstPoint = new Point(x,y);
        Point secondPoint = new Point();
        secondPoint.setX(3);
        secondPoint.setY(1);


        System.out.println("Distance(0,0) = " + firstPoint.distance());
        System.out.println("Distance(secondPoint) = " + firstPoint.distance(secondPoint));
        System.out.println("Distance(2,2) = " + firstPoint.distance(2,2));
        Point point = new Point();
        System.out.println("Distance() = " + point.distance());

    }
}

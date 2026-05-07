package module05.learning.exercise32;

public class Wall {
    private double width;
    private double height;

    public Wall(){

    }
    public Wall(double width, double height) {
        this.width = (width > 0) ? width : 0;
        this.height = (height > 0) ? height : 0;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea(){
        return Math.round(width * height);
    }
}

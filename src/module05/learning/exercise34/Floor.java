package module05.learning.exercise34;

public class Floor {

    private double width;
    private double height;

    public Floor(double width, double height) {
        if (width < 0 || height < 0) {
            this.width = 0;
            this.height = 0;
        }else {
            this.width = width;
            this.height = height;
        }
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
        return width * height;
    }
}

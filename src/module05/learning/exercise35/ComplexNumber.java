package module05.learning.exercise35;

public class ComplexNumber {
    private double real;
    private double imaginary;


    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void add(double real, double imaginary){
        this.real += real;
        this.imaginary += imaginary;
    }

    public void add(ComplexNumber other){
        add(other.real, other.imaginary);
    }

    public void subtract(double real, double imaginary){
        this.real -= real;
        this.imaginary -= imaginary;
    }

    public void subtract(ComplexNumber other){
        add(other.real, other.imaginary);
    }


    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}

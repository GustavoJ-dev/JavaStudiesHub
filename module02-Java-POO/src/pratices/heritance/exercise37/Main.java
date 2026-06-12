package pratices.heritance.exercise37;

/**
 * Classe principal para execução do exercício 37.
 * Este exercício demonstra os fundamentos de herança em Java, utilizando
 * as classes {@link Rectangle} como base e {@link Cuboid} como sua subclasse.
 */
public class Main {
    /**
     * Ponto de entrada da aplicação. 
     * Demonstra a criação de formas geométricas e a execução de cálculos de área e volume.
     */
    public static void main(String[] args) {
        // Demonstração da classe base: Retângulo
        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println("rectangle.width= " + rectangle.getWidth());
        System.out.println("rectangle.length= " + rectangle.getLength());
        System.out.println("rectangle.area= " + rectangle.getArea());

        // Demonstração da subclasse: Cuboide (Paralelepípedo)
        Cuboid cuboid = new Cuboid(5,10,5);
        System.out.println("cuboid.width= " + cuboid.getWidth());
        System.out.println("cuboid.length= " + cuboid.getLength());
        System.out.println("cuboid.area= " + cuboid.getArea());
        System.out.println("cuboid.height= " + cuboid.getHeight());
        System.out.println("cuboid.volume= " + cuboid.getVolume());
    }
}

/**
 * Classe principal que demonstra o uso de polimorfismo com diferentes marcas de carros.
 * 
 * Esta classe exemplifica como o polimorfismo funciona permitindo que diferentes tipos
 * de carros (Ford, Holden, Mitsubishi) sejam criados e utilizados através de referências
 * da classe base Car, cada um com seu próprio comportamento.
 */
package praticas.polymorphism.exercise40;

public class Main {
    
    /**
     * Metodo principal que executa demonstrações de polimorfismo com diferentes carros.
     * 
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        carros("Mitsubishi", "Outlander VRX 4WD", 6);
        carros("Ford", "Ford falcon", 8);
        carros("Holden", "Holden Commodore", 8);
        carros("Corolla", "supra", 12);
    }

    /**
     * Cria um carro da marca especificada e executa seus comportamentos básicos.
     * 
     * Este metodo utiliza um switch statement para criar a instância apropriada
     * da subclasse de Car baseado na marca fornecida, e então executa os métodos
     * startEngine(), accelerate() e brake() para demonstrar polimorfismo.
     * 
     * @param mark marca do carro (MITSUBISHI, FORD, HOLDEN ou padrão)
     * @param name nome ou modelo do carro
     * @param cylinders número de cilindros do motor
     */
    public static void carros(String mark, String name, int cylinders){
        Car car = null;
        switch (mark.toUpperCase()){
            case "MITSUBISHI" ->{
                car = new Mitsubishi(cylinders, name);
                System.out.println(car.startEngine());
                System.out.println(car.accelerate());
                System.out.println(car.brake());
            }
            case "FORD" -> {
                car = new Ford(cylinders, name);
                System.out.println(car.startEngine());
                System.out.println(car.accelerate());
                System.out.println(car.brake());
            }
            case "HOLDEN" -> {
                car = new Holden(cylinders, name);
                System.out.println(car.startEngine());
                System.out.println(car.accelerate());
                System.out.println(car.brake());
            }
            default -> {
                car = new Car(cylinders, name);
                System.out.println(car.startEngine());
                System.out.println(car.accelerate());
                System.out.println(car.brake());
            }
        }
    }
}

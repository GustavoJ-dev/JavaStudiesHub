package pratices.polymorphism.exercise38;

/**
 * Esta classe orquestra a criação de um quarto (BedRoom) e seus componentes.
 */
public class Main {
    public static void main(String[] args) {
        BedRoom myBedRoom = quarto();
        System.out.println(myBedRoom);
    }

    /**
     * Cria e configura uma instância completa de um quarto.
     * @return Um objeto {@link BedRoom} contendo paredes, teto, cama e lâmpada configurados.
     */
    public static BedRoom quarto(){

        //lampada do quarto
        Lamp lamp = new Lamp("Fluorescente", false, 110);
        lamp.turnOn();

        //paredes do quarto
        Wall wall1 = new Wall("West");
        Wall wall2 = new Wall("North");
        Wall wall3 = new Wall("South");
        Wall wall4 = new Wall("East");

        //teto do quarto
        Ceiling ceiling = new Ceiling(12, "White");

        //cama do quarto
        Bed bed = new Bed("Modern", 4, 3, 2, 1);

        return new BedRoom("Quarto", wall1, wall2, wall3, wall4, ceiling, bed, lamp);

    }
}

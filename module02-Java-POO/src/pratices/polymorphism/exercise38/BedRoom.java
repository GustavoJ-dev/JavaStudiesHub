package pratices.polymorphism.exercise38;

/**
 * Representa um quarto, demonstrando o conceito de Composição em Java.
 * A classe agrega diversos objetos (Wall, Ceiling, Bed, Lamp) para formar um todo.
 */
public class BedRoom {
    private String name;
    private Wall wall;
    private Wall wall2;
    private Wall wall3;
    private Wall wall4;
    private Ceiling ceiling;
    private Bed bed;
    private Lamp lamp;

    /**
     * Construtor para inicializar o quarto com todos os seus componentes.
     * 
     * @param name O nome identificador do quarto.
     * @param wall A primeira parede.
     * @param wall2 A segunda parede.
     * @param wall3 A terceira parede.
     * @param wall4 A quarta parede.
     * @param ceiling O teto do quarto.
     * @param bed A cama do quarto.
     * @param lamp A lâmpada do quarto.
     */
    public BedRoom(String name, Wall wall, Wall wall2, Wall wall3, Wall wall4,
                   Ceiling ceiling, Bed bed, Lamp lamp) {
        this.name = name;
        this.wall = wall;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.wall4 = wall4;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }

    /**
     * Fornece acesso ao objeto Lamp.
     * @return A instância da lâmpada associada ao quarto.
     */
    public Lamp getLamp(){
        return this.lamp;
    }

    /**
     * Simula o ato de arrumar a cama.
     * Este método demonstra como o BedRoom interage com o objeto Bed (Composição).
     */
    public void makeBed(){
        System.out.println("BedRoom -> making bed | ");
        bed.make();
    }

    /**
     * Gera uma representação em String do quarto e seus componentes.
     * @return Detalhes formatados do quarto.
     */
    @Override
    public String toString() {
        return "Quarto: " +
                "nome: " + name + "\n" +
                "Parede 1: " + wall.getDirection() + "\n" +
                "Parede 2: " + wall2.getDirection() + "\n" +
                "Parede 3: " + wall3.getDirection() + "\n" +
                "Parede 4: " + wall4.getDirection() + "\n" +
                "teto: " + ceiling.toString() + "\n" +
                "cama: " + bed.toString() + "\n" +
                "lâmpada: " + lamp.toString();

    }
}

package praticas.polymorphism.exercise38;

/**
 * Representa uma parede individual que compõe um cômodo.
 * Utilizada para definir a orientação espacial dentro de uma estrutura maior.
 */
public class Wall {

    private final String direction;

    /**
     * Construtor para criar uma parede com uma direção definida.
     * 
     * @param direction A direção da parede (ex: "North", "South", "East", "West").
     */
    public Wall(String direction){
        this.direction = direction;
    }

    /**
     * Recupera a direção associada a esta parede.
     * 
     * @return Uma string contendo a direção da parede.
     */
    public String getDirection() {
        return direction;
    }
}

package module05.learning.exercise34;

public class CarpetCost {
    private double cost;

    public CarpetCost(double cost){
        if (cost < 0){
            this.cost = 0;
        }else {
            this.cost = cost;
        }
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

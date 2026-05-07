package module05.learning.exercise34;

public class Calculator {
    private CarpetCost carpet;
    private Floor floor;

    public Calculator(CarpetCost carpet, Floor floor) {
        this.carpet = carpet;
        this.floor = floor;
    }

    public CarpetCost getCarpet() {
        return carpet;
    }

    public void setCarpet(CarpetCost carpet) {
        this.carpet = carpet;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public double getTotalCost(){
        return floor.getArea() * carpet.getCost();
    }
}

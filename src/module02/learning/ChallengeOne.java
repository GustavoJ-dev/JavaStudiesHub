package module02.learning;

public class ChallengeOne {
    public static void main(String[] args) {

        double doubleValue = 20.00;
        double doubleValueTwo = 80;

        double result = (doubleValue + doubleValueTwo) * 100;


        double rest = result % 40.00;

        if (rest == 0){
                    System.out.println("Não há resto");
        }else {
                    System.out.println("tem resto");
        }

    }
}

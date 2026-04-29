package module03.learning.challenge3;

public class ExerciseThree {
    public static void main(String[] args) {

        printMegaBytesAndKiloBytes(2500);
        printMegaBytesAndKiloBytes(100);
        printMegaBytesAndKiloBytes(2716);


    }

    public static void printMegaBytesAndKiloBytes(int value) {
        if (value < 0) {
            System.out.println("Invalid Value");
            return;
        }
        System.out.println(megaByteValue(value));
        System.out.println(kiloByteValue(value));
        System.out.println();


    }

    public static String megaByteValue(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        }

        int restKB = kiloBytes % 1024;
        int megaBytes = kiloBytes / 1024;

        return kiloBytes + " KiloBytes = " + megaBytes + " MegaBytes and " + restKB + " KiloBytes";


    }

    public static String kiloByteValue(int megaBytes) {
        if (megaBytes < 0) {
            System.out.println("Invalid Value");
        }

        int kyloBytes = megaBytes * 1024;

        return megaBytes + " MegaBytes = " + kyloBytes + " KiloBytes";
    }
}

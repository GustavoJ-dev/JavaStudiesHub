package praticas.Section01_first_steps.Alearning;

public class TiposPrimitivos {
    public static void main(String[] args) {

        //cada tipo tem seus intervalos numeros e podemos ver isso com sua Wrapper Class(Classe de cobertura);


        //tipos e seus dados e intervalos

        // int e sua classe de cobertura Integer são usadas para números inteiros.
        int maxInt = Integer.MAX_VALUE;// maior intervalo para números inteiros
        int minInt = Integer.MIN_VALUE;//menor intervalo para inteiros
        System.out.println("O intervalo de inteiros é de " + minInt + " até " + maxInt);

        //Também são inteiros o byte, short e long e também possuem possui sua classe de cobertura
        long maxLong = Long.MAX_VALUE;
        long minLong = Long.MIN_VALUE;
        System.out.println("O intervalo de long é de " + minLong + " até " + maxLong);

        byte maxByte = Byte.MAX_VALUE;
        byte minByte = Byte.MIN_VALUE;
        System.out.println("O intervalo de byte é de " + minByte + " até " + maxByte);

        short maxShort = Short.MAX_VALUE;
        short minShort = Short.MIN_VALUE;
        System.out.println("O intervalo de short é de " + minShort + " até " + maxShort);


        /*o float e o double tambem possuem suas classes de cobertura que são o Float e Double
         * que servem para numeros com casas decimais
         * o double é maior que o float*/

        float maxFloat = Float.MAX_VALUE;//maior valor para flutuante
        float minFloat = Float.MIN_VALUE;//menor valor para flutuante
        double maxDouble = Double.MAX_VALUE; //maior valor para double
        double minDouble = Double.MIN_VALUE;// menor valor para double
        System.out.println("O intervalo de float é de " + minFloat + " até " + maxFloat);
        System.out.println("O intervalo de double é de " + minDouble + " até " + maxDouble);

        // boleanos so tem dois valores: verdadeiro e falso
        boolean falseBoolean = Boolean.FALSE;
        boolean trueBoolean = Boolean.TRUE;
        System.out.println("Valor boolean = " + falseBoolean + " e " + trueBoolean);



        // a String não é um tipo primitivo, porem é uma classe especial do java
        String string = "cadeia de caracteres";
        System.out.println("String = " + string);

        char character = 'a';//armazena apenas um caractere
        System.out.println("representa um caractere = " + "'" + character + "'");

    }
}

package exercises.Section01.Alearning;


//A tradição: Hello World! para o primeiro programa de um programador
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");//comando que exibe texto na tela

        //no comando de output podemos concatenar em uma String essas variaveis com o '+'
        //tudo concatenado a uma String se torna uma String.


        //possivel exibir variaveis, expressoes
        int integer = 10;
        System.out.println("int = " + integer);

        float flt = 3.0F;
        System.out.println("flot = " + flt);

        String string = "Gustavo.dev";
        System.out.println("string = " + string);

        double dbl = 5.0;
        System.out.println("double = " + dbl);

        char character = 'a';
        System.out.println("char = " + character);

        long lng = 122222222L;
        System.out.println("long = " + lng);

        byte bte = 2;
        System.out.println("byte = " + bte);

        short sht = 3;
        System.out.println("short = " + sht);

        boolean bool = true;
        boolean bool2 = false;
        System.out.println(bool2);
        System.out.println(bool);

        System.out.println("Expressão: " + integer + flt);
        System.out.println("Expressão: " + integer + lng);











    }
}

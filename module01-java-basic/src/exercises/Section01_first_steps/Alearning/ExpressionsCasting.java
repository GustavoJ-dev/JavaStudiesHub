package exercises.Section01_first_steps.Alearning;

public class ExpressionsCasting {
    public static void main(String[] args) {
        //no java temos expressões formada por valores(operandos) e operadores
        // e possuimos conversões de tipos

        //operando expressões com variaveis
        int sum = 10 + 13;//expressão de soma
        int subtract = 515 - 15;//expressão de subtração

        //operando expressões com variaveis
        int multiply = sum * subtract;//expressão de multiplicação
        int divide = subtract / sum;//expressão de divisão
        double rest =  8 % 3;//operado de resto, retorna o resto da divisão

        System.out.println("Soma = " + sum);
        System.out.println("Subtração = " + subtract);
        System.out.println("Multiplicação = " + multiply);
        System.out.println("Divisão = " + divide);
        System.out.println("Resto = " + rest);

        // o casting é usado para converter tipos ex: int para double
        //pode ser feito com varios tipos
        double casting = (double) multiply / divide;

        System.out.println("_______________________");

        /*podemos incrementar valores usado o '++'
        * decrementar usando '--'
        * de forma compasta com '-=' ou '+='. */

        sum++;
        subtract--;
        multiply *=  2;
        divide /= 2;
        System.out.println("Incrementos e decrementos");
        System.out.println("Soma = " + sum);
        System.out.println("Subtração = " + subtract);
        System.out.println("Multiplicação = " + multiply);
        System.out.println("Divisão = " + divide);













    }
}

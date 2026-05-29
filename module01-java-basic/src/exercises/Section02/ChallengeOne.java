package exercises.Section02;

/**
 * Esta classe representa o primeiro exercicio do módulo 01, focado em operações
 * básicas com tipos de dados numéricos e operadores aritméticos e lógicos.
 * O desafio consiste em realizar cálculos e verificar o resto de uma divisão.
 */
public class ChallengeOne {
    /**
     * O metodo principal que executa o desafio.
     * Realiza a soma de dois valores double, multiplica o resultado por 100,
     * e então verifica se o resto da divisão desse resultado por 40.00 é zero.
     * Imprime uma mensagem indicando se há ou não resto.
     *
     * @param args Argumentos da linha de comando (não utilizados neste programa).
     */
    public static void main(String[] args) {

        double doubleValue = 20.00;
        double doubleValueTwo = 80;

        // Soma os dois valores e multiplica por 100
        double result = (doubleValue + doubleValueTwo) * 100;

        // Calcula o resto da divisão do resultado por 40.00
        double rest = result % 40.00;

        // Verifica se o resto é zero e imprime a mensagem apropriada
        if (rest == 0){
            System.out.println("Não há resto");
        }else {
            System.out.println("tem resto");
        }

    }
}

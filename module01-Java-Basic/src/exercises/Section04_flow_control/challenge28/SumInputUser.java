package exercises.Section04_flow_control.challenge28;

import java.util.Scanner;

/**
 * Classe que contém uma atividade prática sobre flow control.
 * Focada na leitura de entrada do usuário (números inteiros),
 * cálculo da soma e da média desses números, e tratamento de entrada não numérica.
 */
public class SumInputUser {

    /**
     * Metodo principal para iniciar a funcionalidade de leitura, soma e média.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("Digite números inteiros (ou qualquer texto para finalizar):");
        inputThenPrintSumAndAverage();
    }

    /**
     * Lê uma série de números inteiros da entrada padrão (console) até que
     * uma entrada não numérica seja fornecida. Calcula a soma e a média
     * desses números e imprime os resultados no console.
     * A média é arredondada para o inteiro mais próximo.
     */
    public static void inputThenPrintSumAndAverage(){
        int sum = 0;
        long average = 0; // Usar long para a média arredondada, conforme o problema
        int count = 0;    // Contador de números válidos lidos

        Scanner scanner = new Scanner(System.in);

        while (true){
            // Tenta ler a próxima linha como um número inteiro
            String nextLine = scanner.nextLine();
            try {
                int number = Integer.parseInt(nextLine);
                sum += number;
                count++;
                // Recalcula a média a cada nova entrada válida
                // É importante fazer o cast para double antes da divisão para obter precisão
                average = Math.round((double) sum / count);
            } catch (NumberFormatException e){
                // Se a entrada não for um número, o loop é encerrado
                break;
            }
        }
        scanner.close(); // Fechar o scanner para liberar recursos

        System.out.println("SUM = " + sum + " AVG = " + average);
    }
}

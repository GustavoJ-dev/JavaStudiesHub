package pratices.heritance.exercise30;

/**
 * Classe principal para demonstrar o uso da classe {@link SumCalculator}.
 * Este é o ponto de entrada para o Módulo 05,
 * realizando e exibindo operações de cálculo.
 */
public class Main {
    /**
     * Metodo principal que inicia a demonstração das operações da calculadora.
     * Chama o metodo {@code printCalculate} com diferentes pares de números
     * para exibir a soma, subtração, divisão e multiplicação.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        printCalculate(20, 15);
        printCalculate(10, 18);
        printCalculate(14, 12718);
        printCalculate(3213, 19);
        printCalculate(100, 0); // Teste de divisão por zero
    }

    /**
     * Cria uma instância de {@link SumCalculator}, define seus números
     * e imprime os resultados das operações básicas (soma, subtração,
     * divisão e multiplicação) no console.
     *
     * @param numberOne O primeiro número a ser usado nos cálculos.
     * @param numberTwo O segundo número a ser usado nos cálculos.
     */
    public static void printCalculate(double numberOne, double numberTwo){
        SumCalculator calculator = new SumCalculator();
        calculator.setFirstNumber(numberOne);
        calculator.setSecondNumber(numberTwo);

        System.out.println("--- Cálculos para " + numberOne + " e " + numberTwo + " ---");
        System.out.println("SOMA = " + calculator.sum());
        System.out.println("SUBTRAÇÃO = " + calculator.subtract());
        System.out.println("DIVISÃO = " + calculator.divide());
        System.out.println("MULTIPLICAÇÃO = " + calculator.multiply());
        System.out.println("=".repeat(30)); // Separador para melhor visualização
    }
}

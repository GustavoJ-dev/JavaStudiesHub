package module05.learning.exercise30;

/**
 * Classe que implementa uma calculadora simples para realizar operações
 * básicas (soma, subtração, multiplicação, divisão) entre dois números.
 * Esta classe faz parte do Módulo 05.
 */
public class SumCalculator {
    /**
     * O primeiro número para as operações de cálculo.
     */
    private double firstNumber;
    /**
     * O segundo número para as operações de cálculo.
     */
    private double secondNumber;

    /**
     * Retorna o valor do primeiro número.
     * @return O primeiro número.
     */
    public double getFirstNumber() {
        return firstNumber;
    }

    /**
     * Define o valor do primeiro número.
     * @param firstNumber O novo valor para o primeiro número.
     */
    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    /**
     * Retorna o valor do segundo número.
     * @return O segundo número.
     */
    public double getSecondNumber() {
        return secondNumber;
    }

    /**
     * Define o valor do segundo número.
     * @param secondNumber O novo valor para o segundo número.
     */
    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    /**
     * Calcula a soma do {@code firstNumber} e {@code secondNumber}.
     * @return A soma dos dois números.
     */
    public double sum(){
        return firstNumber + secondNumber;
    }

    /**
     * Calcula a diferença entre o {@code firstNumber} e {@code secondNumber}.
     * @return A diferença entre os dois números.
     */
    public double subtract(){
        return firstNumber - secondNumber;
    }

    /**
     * Calcula a divisão do {@code firstNumber} pelo {@code secondNumber}.
     * Se o {@code secondNumber} for zero, retorna 0 para evitar divisão por zero.
     * @return O resultado da divisão, ou 0 se o segundo número for zero.
     */
    public double divide(){
        if (secondNumber == 0){
            return 0; // Evita divisão por zero
        }
        return firstNumber / secondNumber;
    }

    /**
     * Calcula o produto do {@code firstNumber} e {@code secondNumber}.
     * @return O produto dos dois números.
     */
    public double multiply(){
        return firstNumber * secondNumber;
    }
}

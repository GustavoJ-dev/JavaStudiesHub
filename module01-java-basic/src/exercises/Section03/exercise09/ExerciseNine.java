package exercises.Section03.exercise09;

/**
 * Classe que contém a resolução do Exercício Nove do Módulo 03.
 * Focada no cálculo da área de um círculo e de um retângulo,
 * demonstrando sobrecarga de métodos e validação de entrada.
 */
public class ExerciseNine {

    /**
     * Método principal para testar as funcionalidades de cálculo de área.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("Área do círculo (raio 5.0): " + area(5.0));   // Esperado: 78.54
        System.out.println("Área do círculo (raio -1): " + area(-1));    // Esperado: -1.0 (valor inválido)
        System.out.println("Área do retângulo (5.0 x 4.0): " + area(5.0, 4.0)); // Esperado: 20.0
        System.out.println("Área do retângulo (-1 x 4.0): " + area(-1, 4.0)); // Esperado: -1.0 (valor inválido)
        System.out.println("Área do círculo (raio 0): " + area(0)); // Esperado: 0.0
        System.out.println("Área do retângulo (0 x 0): " + area(0, 0)); // Esperado: 0.0
    }

    /**
     * Calcula a área de um círculo dado o seu raio.
     * A área é calculada pela fórmula: `π * raio^2`.
     * O resultado é arredondado para duas casas decimais.
     *
     * @param radius O raio do círculo. Deve ser um valor não negativo.
     * @return A área do círculo arredondada para duas casas decimais,
     *         ou -1.0 se o raio for negativo.
     */
    public static double area(double radius){
        if (radius < 0){
            return -1; // Raio inválido
        }
        double area = Math.pow(radius, 2) * Math.PI;
        // Arredonda para duas casas decimais
        return Math.round(area * 100.0) / 100.0;
    }

    /**
     * Calcula a área de um retângulo dadas suas duas dimensões (largura e altura).
     * A área é calculada pela fórmula: `largura * altura`.
     *
     * @param x A primeira dimensão do retângulo (largura ou altura). Deve ser um valor não negativo.
     * @param y A segunda dimensão do retângulo (largura ou altura). Deve ser um valor não negativo.
     * @return A área do retângulo, ou -1.0 se qualquer uma das dimensões for negativa.
     */
    public static double area(double x, double y){
        if (x < 0 || y < 0){
            return -1; // Dimensões inválidas
        }
        return x * y;
    }
}

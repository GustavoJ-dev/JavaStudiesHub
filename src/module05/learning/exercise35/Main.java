package module05.learning.exercise35;

/**
 * Classe principal para demonstrar o uso da classe {@link ComplexNumber}.
 * Este é o ponto de entrada para o Exercício 35 do Módulo 05,
 * que cria e manipula números complexos.
 */
public class Main {
    /**
     * Metodo principal que inicia a demonstração da criação e manipulação de objetos {@link ComplexNumber}.
     * Realiza operações de adição e subtração com números complexos e imprime os resultados.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // Cria dois números complexos para demonstração
        ComplexNumber one = new ComplexNumber(1.0, 1.0);
        ComplexNumber number = new ComplexNumber(2.5, -1.5);

        // Demonstração do metodo add(double real, double imaginary)
        System.out.println("--- Teste de Adição (one.add(1,1)) ---");
        one.add(1, 1); // one se torna (2.0, 2.0)
        System.out.println("one.real= " + one.getReal());
        System.out.println("one.imaginary= " + one.getImaginary());
        System.out.println("one (toString)= " + one); // Imprime a representação do objeto
        System.out.println("=".repeat(30));

        // Demonstração do metodo subtract(ComplexNumber other)
        System.out.println("--- Teste de Subtração (one.subtract(number)) ---");
        one.subtract(number); // one se torna (2.0 - 2.5, 2.0 - (-1.5)) = (-0.5, 3.5)
        System.out.println("one.real= " + one.getReal());
        System.out.println("one.imaginary= " + one.getImaginary());
        System.out.println("one (toString)= " + one);
        System.out.println("=".repeat(30));

        // Demonstração do metodo subtract(ComplexNumber other) novamente, com 'number'
        System.out.println("--- Teste de Subtração (number.subtract(one)) ---");
        number.subtract(one); // number se torna (2.5 - (-0.5), -1.5 - 3.5) = (3.0, -5.0)
        System.out.println("number.real= " + number.getReal());
        System.out.println("number.imaginary= " + number.getImaginary());
        System.out.println("number (toString)= " + number);
        System.out.println("=".repeat(30));
    }
}

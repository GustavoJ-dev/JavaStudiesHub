package pratices.heritance.exercise35;

/**
 * Representa um número complexo com uma parte real e uma parte imaginária.
 * Esta classe faz parte do Exercício 35 do Módulo 05,
 * demonstrando a criação de objetos e operações matemáticas.
 */
public class ComplexNumber {
    /**
     * A parte real do número complexo.
     */
    private double real;
    /**
     * A parte imaginária do número complexo.
     */
    private double imaginary;

    /**
     * Construtor que inicializa um número complexo com as partes real e imaginária especificadas.
     *
     * @param real A parte real do número complexo.
     * @param imaginary A parte imaginária do número complexo.
     */
    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Retorna a parte real do número complexo.
     * @return A parte real.
     */
    public double getReal() {
        return real;
    }

    /**
     * Retorna a parte imaginária do número complexo.
     * @return A parte imaginária.
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Adiciona um número complexo (definido por suas partes real e imaginária)
     * ao número complexo atual.
     *
     * @param real A parte real a ser adicionada.
     * @param imaginary A parte imaginária a ser adicionada.
     */
    public void add(double real, double imaginary){
        this.real += real;
        this.imaginary += imaginary;
    }

    /**
     * Adiciona outro objeto {@link ComplexNumber} ao número complexo atual.
     * Reutiliza o método {@link #add(double, double)}.
     *
     * @param other O objeto ComplexNumber a ser adicionado.
     */
    public void add(ComplexNumber other){
        add(other.real, other.imaginary);
    }

    /**
     * Subtrai um número complexo (definido por suas partes real e imaginária)
     * do número complexo atual.
     *
     * @param real A parte real a ser subtraída.
     * @param imaginary A parte imaginária a ser subtraída.
     */
    public void subtract(double real, double imaginary){
        this.real -= real;
        this.imaginary -= imaginary;
    }

    /**
     * Subtrai outro objeto {@link ComplexNumber} do número complexo atual.
     *
     * @param other O objeto ComplexNumber a ser subtraído.
     */
    public void subtract(ComplexNumber other){
        // Correção: deve subtrair, não adicionar
        subtract(other.real, other.imaginary);
    }

    /**
     * Retorna uma representação em string do número complexo no formato "real + imaginaryi".
     *
     * @return Uma string representando o número complexo.
     */
    @Override
    public String toString() {
        // Formatação para lidar com números imaginários negativos
        if (imaginary < 0) {
            return real + " - " + Math.abs(imaginary) + "i";
        }
        return real + " + " + imaginary + "i";
    }
}

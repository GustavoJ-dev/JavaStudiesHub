package praticas.Section04_flow_control.challenge29;

/**
 * Classe que contém uma atividade prática sobre flow control.
 * Focada no cálculo da quantidade de baldes de tinta necessários para pintar
 * uma determinada área, considerando diferentes cenários e sobrecarga de métodos.
 */
public class PaintBuckets{

    /**
     * Metodo principal para testar as funcionalidades de cálculo de baldes.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("Cenário 1: Área = 3.4, Área por Balde = 1.5 -> Baldes: "
                + getBucketCount(3.4, 1.5)); // 3
        System.out.println("Cenário 1: Área = 6.75, Área por Balde = 2.5 -> Baldes: "
                + getBucketCount(6.75, 2.5)); // 3
        System.out.println("Cenário 1: Área = 3.4, Área por Balde = 2.1 -> Baldes: "
                + getBucketCount(3.4, 2.1)); // 2
        System.out.println("Cenário 1: Valores inválidos -> Baldes: "
                + getBucketCount(-3.4, 1.5)); // -1

        System.out.println("\nCenário 2: Largura = 2.75, Altura = 3.5, Área por Balde = 1.5 -> Baldes: "
                + getBucketCount(2.75, 3.5, 1.5)); // 7
        System.out.println("Cenário 2: Largura = 7.25, Altura = 4.3, Área por Balde = 2.35 -> Baldes: "
                + getBucketCount(7.25, 4.3, 2.35)); // 14
        System.out.println("Cenário 2: Valores inválidos -> Baldes: "
                + getBucketCount(-2.75, 3.5, 1.5)); // -1

        System.out.println("\nCenário 3: Largura = 3.4, Altura = 2.1, Área por" +
                " Balde = 1.5, Baldes Extras = 2 -> Baldes: "
                + getBucketCount(3.4, 2.1, 1.5, 2)); // 3
        System.out.println("Cenário 3: Largura = 7.25, Altura = 4.3, Área por Balde = 2.35," +
                " Baldes Extras = 1 -> Baldes: "
                + getBucketCount(7.25, 4.3, 2.35, 1)); // 13
        System.out.println("Cenário 3: Valores inválidos -> Baldes: " +
                getBucketCount(3.4, 2.1, 1.5, -2)); // -1
    }

    /**
     * Calcula o número de baldes de tinta necessários para pintar uma área.
     *
     * @param area A área total a ser pintada (deve ser maior que 0).
     * @param areaPerBucket A área que um único balde de tinta pode cobrir (deve ser maior que 0).
     * @return O número de baldes necessários, arredondado para cima, ou -1 se os parâmetros forem inválidos.
     */
    public static int getBucketCount(double area, double areaPerBucket){
        if (area <= 0 || areaPerBucket <= 0){
            return -1; // Valores inválidos
        }
        double numberOfBuckets = area / areaPerBucket;
        return (int) Math.ceil(numberOfBuckets); // Arredonda para cima, pois não se pode comprar uma fração de balde
    }

    /**
     * Calcula o número de baldes de tinta necessários para pintar uma área retangular.
     *
     * @param width A largura da área a ser pintada (deve ser maior que 0).
     * @param height A altura da área a ser pintada (deve ser maior que 0).
     * @param areaPerBucket A área que um único balde de tinta pode cobrir (deve ser maior que 0).
     * @return O número de baldes necessários, arredondado para cima, ou -1 se os parâmetros forem inválidos.
     */
    public static int getBucketCount(double width, double height, double areaPerBucket){
        if (width <= 0 || height <= 0 || areaPerBucket <= 0){
            return -1; // Valores inválidos
        }
        double area = width * height;
        return getBucketCount(area, areaPerBucket); // Reutiliza o método anterior
    }

    /**
     * Calcula o número de baldes de tinta necessários para pintar uma área retangular,
     * considerando uma quantidade de baldes extras já disponíveis.
     *
     * @param width A largura da área a ser pintada (deve ser maior que 0).
     * @param height A altura da área a ser pintada (deve ser maior que 0).
     * @param areaPerBucket A área que um único balde de tinta pode cobrir (deve ser maior que 0).
     * @param extraBuckets O número de baldes de tinta já disponíveis (deve ser não negativo).
     * @return O número de baldes adicionais necessários, arredondado para cima,
     *         ou -1 se os parâmetros forem inválidos.
     */
    public static int getBucketCount(double width, double height, double areaPerBucket,
                                     int extraBuckets){
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0){
            return -1; // Valores inválidos
        }
        double totalArea = width * height;
        // Calcula a área restante a ser pintada após considerar os baldes extras
        double remainingArea = totalArea - (extraBuckets * areaPerBucket);

        // Se a área restante for negativa (baldes extras cobrem mais do que o necessário),
        // significa que nenhum balde adicional é necessário.
        if (remainingArea <= 0) {
            return 0;
        }
        return getBucketCount(remainingArea, areaPerBucket); // Reutiliza o método para a área restante
    }
}

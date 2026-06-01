package exercises.Section04_flow_control.challenge27;

/**
 * Classe que contém uma atividade prática sobre flow control.
 * Focada na impressão de um padrão de estrela (asterisco) em formato de quadrado,
 * com estrelas nas bordas e nas diagonais.
 */
public class PrintStar {

    private static final String STAR = "*";
    private static final String SPACE = " ";

    /**
     * Método principal para testar a funcionalidade de impressão do padrão de estrela.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("Padrão para tamanho 5:");
        printSquareStar(5);
        System.out.println("\nPadrão para tamanho 8:");
        printSquareStar(8);
        System.out.println("\nPadrão para tamanho 4 (Inválido):");
        printSquareStar(4); // Invalid Value
    }

    /**
     * Imprime um padrão de estrela em formato de quadrado no console.
     * O quadrado terá estrelas nas bordas (primeira e última linha/coluna)
     * e nas duas diagonais.
     * O `number` representa o tamanho do lado do quadrado.
     * Se `number` for menor que 5, imprime "Invalid Value".
     *
     * @param number O tamanho do lado do quadrado (deve ser >= 5).
     */
    public static void printSquareStar(int number){
        if (number < 5){
            System.out.println("Invalid Value");
            return;
        }

        // Loop para as linhas
        for(int row = 1; row <= number; row++){
            // Loop para as colunas
            for (int col = 1; col <= number; col++){
                // Condições para imprimir uma estrela:
                // 1. É a primeira ou última linha/coluna
                boolean isFirstOrLastRowCol = (row == 1 || row == number || col == 1 || col == number);
                // 2. É uma das diagonais (principal ou secundária)
                boolean isDiagonal = (row == col) || (col == (number - row + 1));

                if(isFirstOrLastRowCol || isDiagonal){
                    System.out.print(STAR);
                } else {
                    System.out.print(SPACE);
                }
            }
            System.out.println(); // Quebra de linha após cada linha do quadrado
        }
    }
}

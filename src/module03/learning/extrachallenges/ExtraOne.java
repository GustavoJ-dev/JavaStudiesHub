package module03.learning.extrachallenges;

/**
 * Classe que contém a resolução do Desafio Extra Um do Módulo 03.
 * Focada na lógica de cálculo e exibição de posições em um placar de alta pontuação,
 * demonstrando o uso de múltiplos métodos e condicionais.
 */
public class ExtraOne {

    /**
     * Método principal para testar as funcionalidades de cálculo e exibição de placar.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        displayHighScorePosition("Gustavo", calculateHighScorePosition(1500)); // Posição 1
        displayHighScorePosition("Lucas", calculateHighScorePosition(1000));  // Posição 1
        displayHighScorePosition("Tim", calculateHighScorePosition(500));    // Posição 2
        displayHighScorePosition("Lola", calculateHighScorePosition(100));   // Posição 3
        displayHighScorePosition("Edu", calculateHighScorePosition(25));     // Posição 4
    }

    /**
     * Calcula a posição de um jogador no placar de alta pontuação com base na sua pontuação.
     * As regras de pontuação são:
     * - >= 1000: Posição 1
     * - >= 500: Posição 2
     * - >= 100: Posição 3
     * - < 100: Posição 4
     *
     * @param score A pontuação do jogador.
     * @return A posição do jogador no placar.
     */
    public static int calculateHighScorePosition(int score){
        if (score >= 1000){
            return 1;
        } else if (score >= 500){
            return 2;
        } else if (score >= 100){
            return 3;
        } else {
            return 4;
        }
    }

    /**
     * Exibe a posição de um jogador no placar de alta pontuação no console.
     *
     * @param name O nome do jogador.
     * @param position A posição do jogador no placar.
     */
    public static void displayHighScorePosition(String name, int position){
        System.out.println(name + " conseguiu ficar em " + position + "° lugar do placar de desempenho");
    }
}

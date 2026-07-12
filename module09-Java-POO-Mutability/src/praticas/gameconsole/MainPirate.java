package praticas.gameconsole;

import praticas.gameconsole.game.GameConsole;
import praticas.gameconsole.player.pirate.PirateGame;

/**
 * Classe principal responsável por inicializar o jogo de piratas.
 *
 * <p>Cria uma instância de {@link PirateGame} e utiliza
 * {@link GameConsole} para gerenciar a interação do jogador
 * com o jogo.</p>
 */
public class MainPirate {

    /**
     * Ponto de entrada da aplicação.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {

        GameConsole<PirateGame> game = new GameConsole<>(new PirateGame("Jogo de Piratas"));

        int playerIndex = game.addPlayer();
        game.playGame(playerIndex);
    }
}

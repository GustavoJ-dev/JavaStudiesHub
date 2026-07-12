package praticas.gameconsole;

import praticas.gameconsole.game.GameConsole;
import praticas.gameconsole.player.shooter.ShooterGame;

/**
 * Classe principal responsável por iniciar a aplicação do jogo de tiro.
 *
 * <p>Este ponto de entrada cria uma instância de {@link ShooterGame},
 * associa o jogo a um {@link GameConsole} e inicia a interação
 * com o jogador através do console.</p>
 *
 * <p>Após o cadastro do jogador, o índice retornado é utilizado
 * para iniciar o fluxo principal de execução do jogo.</p>
 */
public class MainShooter {

    public static void main(String[] args) {

        var console = new GameConsole<>(
                new ShooterGame("O jogo de atirar")
        );

        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);
    }
}

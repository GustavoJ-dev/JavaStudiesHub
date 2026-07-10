package praticas.collections.cardgame.game.controller;

import praticas.collections.cardgame.game.poker.PokerGame;

/**
 * Classe responsável por iniciar a execução da aplicação.
 *
 * Cria uma partida de pôquer do tipo Five Card Draw com um número
 * definido de jogadores e cartas por mão, iniciando em seguida o jogo.
 *
 */
public class GameController {

    /**
     * Ponto de entrada da aplicação.
     * Cria uma instância de {@link PokerGame} e inicia uma partida.
     *
     */
    public static void main(String[] args) {

        PokerGame fiveCardDraw = new PokerGame(8, 5);
        fiveCardDraw.startPlay();
    }
}

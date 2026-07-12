package praticas.gameconsole.game;

import praticas.gameconsole.player.interfaces.Player;

import java.util.Scanner;

/**
 * Representa o console responsável pela interação entre o jogador
 * e uma determinada implementação de jogo.
 *
 * <p>Esta classe gerencia a entrada de dados do usuário, o cadastro
 * de jogadores e o fluxo principal de execução das ações disponíveis
 * durante o jogo.</p>
 *
 * <p>O tipo genérico {@code T} deve representar uma implementação
 * de {@link Game} que trabalhe com tipos derivados de {@link Player}.</p>
 *
 * @param <T> tipo de jogo executado pelo console
 */
public class GameConsole<T extends Game<? extends Player>> {

    private final T game;
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Cria um novo console associado ao jogo informado.
     *
     * @param game jogo que será controlado pelo console
     */
    public GameConsole(T game) {
        this.game = game;
    }

    /**
     * Solicita o nome do jogador e adiciona um novo participante
     * ao jogo.
     *
     * <p>Após a leitura do nome, uma mensagem de boas-vindas é exibida
     * utilizando o nome do jogo e do jogador.</p>
     *
     * @return índice do jogador adicionado ou {@code -1} caso
     *         o jogador não seja criado
     */
    public int addPlayer() {

        System.out.print("Entre com o seu nome: ");
        String name = scanner.nextLine();

        System.out.printf(
                "Bem Vindo a %s, %s!%n"
                        .formatted(game.getGameName(), name)
        );

        return game.addPlayer(name);
    }

    /**
     * Inicia e controla o fluxo principal de execução do jogo
     * para o jogador informado.
     *
     * <p>As ações disponíveis são obtidas a partir do jogo e exibidas
     * no console. O jogador pode selecionar uma ação utilizando
     * a tecla correspondente.</p>
     *
     * <p>O ciclo de execução continua até que uma ação retorne
     * {@code true}, indicando o encerramento do jogo.</p>
     *
     * @param playerIndex índice do jogador participante
     */
    public void playGame(int playerIndex) {

        boolean done = false;

        while (!done) {

            var gameActions = game.getGameActions(playerIndex);

            System.out.println("Selecione uma das seguinte ações: ");

            for (Character c : gameActions.keySet()) {

                String prompt = gameActions.get(c).prompt();
                System.out.println("\t" + prompt + " (" + c + ")");
            }

            System.out.print("Qual próximo movimento: ");

            char nextMove = scanner.nextLine()
                    .toUpperCase()
                    .charAt(0);

            GameAction gameAction = gameActions.get(nextMove);

            if (gameAction != null) {

                System.out.println(
                        "-------------------------------------------------"
                );

                done = game.executeGameAction(playerIndex, gameAction);

                if (!done) {

                    System.out.println(
                            "-------------------------------------------------"
                    );
                }
            }
        }
    }
}
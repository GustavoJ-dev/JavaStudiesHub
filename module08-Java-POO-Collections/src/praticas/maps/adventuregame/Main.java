package praticas.maps.adventuregame;

import java.util.Scanner;

/**
 * Classe responsável por iniciar a aplicação do jogo de aventura.
 *
 * Permite executar o jogo utilizando o mapa padrão ou um conjunto
 * personalizado de localizações.
 *
 *
 */
public class Main {

    /**
     * Ponto de entrada da aplicação.
     *
     */
    public static void main(String[] args) {

        String lugares = """
        praia,na Praia de Copacabana,O:lago,N:mirante
        chapada,na Chapada Diamantina,L:cachoeira,S:trilha
        cataratas,diante das Cataratas do Iguaçu,N:floresta,O:mirante
        """;

        AdventureGame game = new AdventureGame();
        game.play("Estrada");
    }

    /**
     * Inicia o jogo utilizando um conjunto personalizado de localizações.
     *
     * As localizações informadas são adicionadas ao mapa do jogo e o
     * jogador pode navegar entre elas utilizando os pontos cardeais.
     * A execução termina quando o usuário informa a opção {@code Q}.
     *
     *
     * @param places texto contendo as localizações personalizadas
     */
    public static void custom(String places) {

        AdventureGame game = new AdventureGame(places);
        game.play("praia");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            String direction = scanner.next()
                    .trim()
                    .toUpperCase()
                    .substring(0, 1);

            if (direction.equals("Q")) break;

            game.move(direction);
        }
    }
}

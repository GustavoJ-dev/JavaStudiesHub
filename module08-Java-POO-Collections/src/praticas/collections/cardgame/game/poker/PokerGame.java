package praticas.collections.cardgame.game.poker;

import praticas.collections.cardgame.game.model.Card;

import java.util.*;
import java.util.function.Consumer;

/**
 * Gerencia uma partida de pôquer.
 *
 * Esta classe é responsável por criar o baralho, embaralhá-lo,
 * distribuir as cartas entre os jogadores, avaliar cada mão e
 * exibir as cartas restantes após a distribuição.
 *
 */
public class PokerGame {

    /** Baralho utilizado na partida. */
    private final List<Card> deck = Card.getStandardDeck();

    /** Quantidade de jogadores participantes. */
    private int playerCount;

    /** Quantidade de cartas distribuídas para cada jogador. */
    private int cardsInHand;

    /** Lista contendo as mãos de todos os jogadores. */
    private List<PokerHand> pokerHands;

    /** Cartas que permanecem no baralho após a distribuição. */
    private List<Card> remainingCards;


    /**
     * Cria uma nova partida de pôquer.
     *
     * @param playerCount quantidade de jogadores
     * @param cardsInHand quantidade de cartas distribuídas para cada jogador
     */
    public PokerGame(int playerCount, int cardsInHand){
        this.playerCount = playerCount;
        this.cardsInHand = cardsInHand;
        pokerHands = new ArrayList<>(cardsInHand);
    }


    /**
     * Inicia a partida.
     *
     * As etapas executadas são:
     *
     *     Embaralhar o baralho.
     *     Rotacionar as cartas em uma posição aleatória.
     *     Distribuir as cartas aos jogadores.
     *     Avaliar cada mão.
     *     Exibir as cartas restantes do baralho.
     */
    public void startPlay(){

        Collections.shuffle(deck);
        Card.printDeck(deck);
        int randomMiddle = new Random().nextInt(15, 35);
        Collections.rotate(deck, randomMiddle);
        Card.printDeck(deck);

        deal();
        System.out.println("----------------------------");
        Consumer<PokerHand> checkHand = PokerHand::evalHand;
        pokerHands.forEach(checkHand.andThen(System.out::println));

        int cardsDealt = playerCount * cardsInHand;
        int cardsRemaining = deck.size() - cardsDealt;

        remainingCards = new ArrayList<>(Collections.nCopies(cardsRemaining, null));
        remainingCards.replaceAll(c -> deck.get(cardsDealt + remainingCards.indexOf(c)));
        Card.printDeck(remainingCards, "Cartas restantes", 2);
    }


    /**
     * Distribui as cartas entre os jogadores.
     *
     * A distribuição ocorre em rodadas, entregando uma carta por vez
     * para cada jogador até que todas as mãos estejam completas.
     * Após a distribuição, uma instância de {@code PokerHand} é criada
     * para cada jogador.
     *
     */
    private void deal(){

        Card[][] hands = new Card[playerCount][cardsInHand];

        for (int deckIndex = 0, i = 0; i < cardsInHand; i++){

            for (int j = 0; j < playerCount; j++){

                hands[j][i] = deck.get(deckIndex++);
            }
        }

        int playerNo = 1;
        for (Card[] hand : hands){
            pokerHands.add(new PokerHand(playerNo++, Arrays.asList(hand)));
        }
    }
}

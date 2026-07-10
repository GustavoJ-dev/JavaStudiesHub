package praticas.collections.cardgame.game.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Representa uma carta de um baralho padrão.
 *
 * Cada carta possui um naipe ({@link Suit}), uma representação da face
 * (como "2", "10", "J", "D", "K" ou "A") e um valor de ranking utilizado
 * para comparações e ordenações.
 *
 */
public record Card(Suit suit, String face, int rank) {

    /**
     * Representa os quatro naipes de um baralho padrão.
     */
    public enum Suit {

        /** Paus. */
        CLUB,

        /** Ouros. */
        DIAMOND,

        /** Copas. */
        HEART,

        /** Espadas. */
        SPADE;


        /**
         * Retorna o caractere Unicode correspondente ao símbolo do naipe.
         *
         * @return caractere Unicode que representa o naipe
         */
        public char getImage(){
            return (new char[]{9827, 9830, 9829, 9824})[this.ordinal()];
        }
    }


    /**
     * Retorna um {@link Comparator} que ordena cartas pelo ranking em ordem
     * decrescente e, em caso de empate, pelo naipe.
     *
     * @return comparador para ordenação das cartas
     */
    public static Comparator<Card> sortRankReversedSuit(){
        return Comparator.comparing(Card::rank).reversed()
                .thenComparing(Card::suit);
    }


    /**
     * Retorna uma representação textual da carta.
     *
     * Exemplo:
     * A♠(12)
     * 10♥(8)
     *
     * @return representação formatada da carta
     */
    @Override
    public String toString() {

        int index = face.equals("10") ? 2 : 1;
        String faceString = face.substring(0, index);
        return "%s%c(%d)".formatted(faceString, suit.getImage(), rank);
    }


    /**
     * Cria uma carta numérica.
     *
     * @param suit naipe da carta
     * @param cardNumber número da carta, entre 2 e 10
     * @return uma nova carta numérica ou {@code null} caso o número seja inválido
     */
    public static Card getNumericCard(Suit suit, int cardNumber){

        if (cardNumber > 1 && cardNumber < 11){
            return new Card(suit, String.valueOf(cardNumber), cardNumber - 2);
        }
        System.out.println("Numero inválido de carta numérica selecionado");
        return null;
    }


    /**
     * Cria uma carta de figura (J, D, K ou A).
     *
     * @param suit naipe da carta
     * @param abbrev abreviação da carta ('J', 'D', 'K' ou 'A')
     * @return uma nova carta de figura ou {@code null} caso a abreviação seja inválida
     */
    public static Card getFaceCard(Suit suit, char abbrev){

        int charIndex = "JDKA".indexOf(abbrev);
        if (charIndex > -1){
            return new Card(suit, "" + abbrev, charIndex + 9);
        }
        System.out.println("Numero inválido de carta de figura selecionado");
        return null;
    }


    /**
     * Gera um baralho padrão contendo 52 cartas.
     *
     * @return lista contendo todas as cartas do baralho
     */
    public static List<Card> getStandardDeck(){

        List<Card> deck = new ArrayList<>(52);
        for (Suit suit : Suit.values()){
            for (int i = 2; i <= 10; i++){
                deck.add(getNumericCard(suit, i));
            }
            for(char c : new char[]{'J', 'D', 'K', 'A'}){
                deck.add(getFaceCard(suit, c));
            }
        }
        return deck;
    }


    /**
     * Imprime um baralho utilizando quatro linhas.
     *
     * @param deck lista de cartas a ser impressa
     */
    public static void printDeck(List<Card> deck){
        printDeck(deck, " ", 4);
    }


    /**
     * Imprime um baralho organizado em um número específico de linhas.
     *
     * @param deck lista de cartas a ser impressa
     * @param description descrição exibida antes das cartas; pode ser {@code null}
     * @param rows quantidade de linhas utilizadas para exibição
     */
    public static void printDeck(List<Card> deck, String description, int rows){

        System.out.println("-----------------------------------");
        if (description != null){
            System.out.println(description);
        }
        int cardsInRows = deck.size()/ rows;
        for (int i = 0; i < rows; i++){
            int startIndex = i * cardsInRows;
            int endIndex = startIndex + cardsInRows;
            deck.subList(startIndex, endIndex)
                    .forEach(c -> System.out.print(c + " "));
            System.out.println();
        }

    }
}

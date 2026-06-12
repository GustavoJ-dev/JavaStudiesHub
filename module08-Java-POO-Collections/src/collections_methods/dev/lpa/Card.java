package collections_methods.dev.lpa;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma carta de baralho, definida por seu naipe, face e valor (rank).
 * Esta é uma classe record, que fornece automaticamente construtor, acessores,
 * {@code equals()}, {@code hashCode()} e {@code toString()}.
 *
 * @param suit O naipe da carta (ex: CLUB, DIAMOND, HEART, SPADE).
 * @param face A face da carta (ex: "2", "King", "Ace").
 * @param rank O valor numérico da carta, usado para ordenação ou comparação.
 */
public record Card(Suit suit, String face, int rank) {

    /**
     * Enumeração que representa os quatro naipes de um baralho padrão.
     */
    public enum Suit {
        CLUB, DIAMOND, HEART, SPADE;

        /**
         * Retorna o caractere Unicode que representa a imagem do naipe.
         *
         * @return O caractere Unicode correspondente ao naipe.
         */
        public char getImage() {
            // Os valores ordinais (0, 1, 2, 3) correspondem aos índices do array de caracteres Unicode.
            return (new char[]{9827, 9830, 9829, 9824})[this.ordinal()];
        }
    }

    /**
     * Retorna uma representação em string da carta, formatada como "FaceImagemNaipe(Rank)".
     * Por exemplo, "K♠(11)" para um Rei de Espadas.
     *
     * @return Uma string formatada representando a carta.
     */
    @Override
    public String toString() {
        // Determina quantos caracteres da 'face' devem ser usados (1 para a maioria, 2 para "10").
        int index = face.equals("10") ? 2 : 1;
        String faceString = face.substring(0, index);
        return "%s%c(%d)".formatted(faceString, suit.getImage(), rank);
    }

    /**
     * Cria e retorna uma carta numérica (de 2 a 10) com o naipe e número especificados.
     * O rank é calculado com base no número da carta.
     *
     * @param suit O naipe da carta.
     * @param cardNumber O número da carta (de 2 a 10).
     * @return Uma instância de {@link Card} para a carta numérica, ou {@code null} se o número for inválido.
     */
    public static Card getNumericCard(Suit suit, int cardNumber) {
        if (cardNumber > 1 && cardNumber < 11) {
            // O rank é cardNumber - 2 para que 2 tenha rank 0, 3 tenha rank 1, etc.
            return new Card(suit, String.valueOf(cardNumber), cardNumber - 2);
        }
        System.out.println("Invalid Numeric card selected");
        return null;
    }

    /**
     * Cria e retorna uma carta de face (Valete, Rainha, Rei, Ás) com o naipe e abreviação especificados.
     * O rank é calculado com base na posição da abreviação na string "JQKA".
     *
     * @param suit O naipe da carta.
     * @param abbrev A abreviação da face da carta ('J', 'Q', 'K', 'A').
     * @return Uma instância de {@link Card} para a carta de face, ou {@code null} se a abreviação for inválida.
     */
    public static Card getFaceCard(Suit suit, char abbrev) {
        int charIndex = "JQKA".indexOf(abbrev);
        if (charIndex > -1) {
            // O rank é charIndex + 9 para que J tenha rank 9, Q tenha rank 10, K tenha rank 11, A tenha rank 12.
            return new Card(suit, "" + abbrev, charIndex + 9);
        }
        System.out.println("Invalid Face card selected");
        return null;
    }

    /**
     * Gera e retorna um baralho padrão completo de 52 cartas.
     * O baralho contém cartas numéricas (2 a 10) e cartas de face (J, Q, K, A) para cada naipe.
     *
     * @return Uma {@link List} de {@link Card} representando um baralho padrão.
     */
    public static List<Card> getStandardDeck() {
        List<Card> deck = new ArrayList<>(52);
        for (Suit suit : Suit.values()) { // Itera sobre cada naipe
            for (int i = 2; i <= 10; i++) { // Adiciona cartas numéricas
                deck.add(getNumericCard(suit, i));
            }
            for (char c : new char[]{'J', 'Q', 'K', 'A'}) { // Adiciona cartas de face
                deck.add(getFaceCard(suit, c));
            }
        }
        return deck;
    }

    /**
     * Imprime um baralho de cartas no console com uma descrição padrão e 4 linhas.
     *
     * @param deck A lista de cartas a ser impressa.
     */
    public static void printDeck(List<Card> deck) {
        printDeck(deck, "Current Deck", 4);
    }

    /**
     * Imprime um baralho de cartas no console, formatado em um número especificado de linhas.
     *
     * @param deck A lista de cartas a ser impressa.
     * @param description Uma descrição para o baralho, impressa antes das cartas. Pode ser {@code null}.
     * @param rows O número de linhas em que as cartas serão distribuídas.
     */
    public static void printDeck(List<Card> deck, String description, int rows) {
        System.out.println("-------------------------------------------------------");
        if (description != null) {
            System.out.println(description);
        }
        int cardsInRow = deck.size() / rows; // Calcula quantas cartas por linha
        for (int i = 0; i < rows; i++) {
            int startIndex = i * cardsInRow;
            int endIndex = startIndex + cardsInRow;

            // Imprime a sublista de cartas para a linha atual
            deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c + " "));
            System.out.println(); // Nova linha após cada linha de cartas
        }
    }
}

package praticas.collections.cardgame.game.poker;

import praticas.collections.cardgame.game.model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Representa a mão de um jogador em uma partida de pôquer.
 *
 * Esta classe é responsável por armazenar as cartas de um jogador,
 * avaliar a combinação formada, identificar seu {@link Ranking} e
 * determinar quais cartas devem ser mantidas ou descartadas.
 *
 */
public class PokerHand {

    /** Cartas que compõem a mão do jogador. */
    private List<Card> hand;

    /** Cartas que devem ser mantidas após a avaliação. */
    private List<Card> keepers;

    /** Cartas recomendadas para descarte. */
    private List<Card> discards;

    /** Classificação atual da mão. */
    private Ranking score = Ranking.NONE;

    /** Número identificador do jogador. */
    private int playerNO;

    /**
     * Cria uma nova mão de pôquer para um jogador.
     *
     * As cartas são ordenadas do maior para o menor ranking antes da
     * avaliação da mão.
     *
     *
     * @param playerNO número do jogador
     * @param hand lista de cartas pertencentes ao jogador
     */
    public PokerHand(int playerNO, List<Card> hand) {

        hand.sort(Card.sortRankReversedSuit());
        this.hand = hand;
        this.playerNO = playerNO;

        keepers = new ArrayList<>(hand.size());
        discards = new ArrayList<>(hand.size());
    }

    /**
     * Retorna uma representação textual da mão do jogador,
     * incluindo sua classificação, cartas, melhor carta,
     * pior carta e possíveis descartes.
     *
     * @return representação formatada da mão
     */
    @Override
    public String toString() {

        return "%d. %-16s Rank:%d %-40s Melhor:%-7s pior:%-6s %s".formatted(
                playerNO,
                score,
                score.ordinal(),
                hand,
                Collections.max(hand, Comparator.comparing(Card::rank)),
                Collections.min(hand, Comparator.comparing(Card::rank)),
                (discards.size() > 0) ? "Discartes:" + discards : "");
    }

    /**
     * Atualiza a classificação da mão de acordo com a quantidade
     * de cartas de mesmo valor encontradas.
     *
     * @param faceCount quantidade de cartas com a mesma face
     */
    private void setRank(int faceCount) {

        switch (faceCount) {

            case 4 -> score = Ranking.FOUR_OF_A_KIND;

            case 3 -> {

                if (score == Ranking.NONE)
                    score = Ranking.THREE_OF_A_KIND;
                else
                    score = Ranking.FULL_HOUSE;
            }

            case 2 -> {

                if (score == Ranking.NONE)
                    score = Ranking.ONE_PAIR;
                else if (score == Ranking.THREE_OF_A_KIND)
                    score = Ranking.FULL_HOUSE;
                else
                    score = Ranking.TWO_PAIR;
            }
        }
    }

    /**
     * Avalia a mão do jogador.
     *
     * O metodo identifica cartas de mesmo valor, determina o
     * {@link Ranking} correspondente e seleciona as cartas que
     * devem ser mantidas para uma possível troca.
     *
     */
    public void evalHand() {

        List<String> faceList = new ArrayList<>(hand.size());

        hand.forEach(card -> faceList.add(card.face()));

        List<String> duplicateFaceCards = new ArrayList<>();

        faceList.forEach(face -> {

            if (!duplicateFaceCards.contains(face)
                    && Collections.frequency(faceList, face) > 1) {

                duplicateFaceCards.add(face);
            }
        });

        for (String duplicate : duplicateFaceCards) {

            int start = faceList.indexOf(duplicate);
            int last = faceList.lastIndexOf(duplicate);

            setRank(last - start + 1);

            List<Card> sub = hand.subList(start, last + 1);
            keepers.addAll(sub);
        }

        pickDiscards();
    }

    /**
     * Determina quais cartas devem ser descartadas.
     *
     * As cartas que fazem parte da combinação identificada são
     * preservadas. Entre as restantes, são escolhidas para descarte
     * as cartas de menor valor, respeitando a estratégia implementada
     * pela classe.
     */
    private void pickDiscards() {

        List<Card> temp = new ArrayList<>(hand);
        temp.removeAll(keepers);

        int rankedCards = keepers.size();

        Collections.reverse(temp);

        int index = 0;

        for (Card c : temp) {
            if (index++ < 3 && (rankedCards > 2 || c.rank() < 9))
                discards.add(c);
            else
                keepers.add(c);
        }
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards = null;

    /**
     * Constructor, It fill cards by eligible values
     */
    public Deck() {
        cards = new ArrayList<Card>();

        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                Card card = new Card(s, r);
                this.cards.add(card);
            }
        }
    }

    /**
     * the cards in the deck being randomly
     permuted
     */
    private void shuffle() {
        Collections.shuffle(this.cards);
    }

    /**
     * choose a card and delete it from the cards and returns the card from the deck to the caller.
     * @return Card
     * @throws ETSException, If the caller then makes a 53rd call or more it return en Exception
     */
    public Card dealOneCard() throws ETSException {
        if (cards.size() == Suit.values().length * Rank.values().length) {
            shuffle();
         }
        Card card = null;
        if (!cards.isEmpty()) {
            card = cards.remove(0);
        } else {
            throw new ETSException(ETSException.ExecptioinEnum.NO_CARD_IS_DEALT.name());
        }

        return card;

    }




}
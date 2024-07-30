import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck implements DeckActions {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Suits suit : Suits.values()) {
            for (Values value : Values.values()) {
                cards.add(new Card(suit, value));
            }
        }
        shuffle();
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public Card dealNextCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }

    @Override
    public void printDeck(int numToPrint) {
        int count = Math.min(numToPrint, cards.size());
        for (int i = 0; i < count; i++) {
            System.out.println(cards.get(i));
        }
    }
}
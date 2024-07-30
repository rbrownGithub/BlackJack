import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private int balance;

    public Player(String name, int initialBalance) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.balance = initialBalance;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public int getHandValue() {
        int value = 0;
        int numAces = 0;

        for (Card card : hand) {
            if (card.getValue() == Values.ACE) {
                numAces++;
                value += 11;
            } else {
                value += card.getValue().getValue();
            }
        }

        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }

        return value;
    }

    public void clearHand() {
        hand.clear();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getBalance() {
        return balance;
    }

    public void adjustBalance(int amount) {
        balance += amount;
    }
}
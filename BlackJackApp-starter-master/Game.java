import java.util.Scanner;

public class Game {
    private Deck deck;
    private Player player;
    private Player dealer;
    private Scanner scanner;

    public Game(String playerName, int initialBalance) {
        deck = new Deck();
        player = new Player(playerName, initialBalance);
        dealer = new Player("Dealer", 0);
        scanner = new Scanner(System.in);
    }

    public void playRound() {
        int bet = getBet();
        dealInitialCards();
        playerTurn();
        dealerTurn();
        determineWinner(bet);
        resetHands();
    }

    private int getBet() {
        System.out.println("Your current balance: $" + player.getBalance());
        System.out.print("Enter your bet: $");
        return scanner.nextInt();
    }

    private void dealInitialCards() {
        player.addCard(deck.dealNextCard());
        dealer.addCard(deck.dealNextCard());
        player.addCard(deck.dealNextCard());
        dealer.addCard(deck.dealNextCard());

        System.out.println("Your hand: " + player.getHand() + " (Value: " + player.getHandValue() + ")");
        System.out.println("Dealer's face-up card: " + dealer.getHand().get(0));
    }

    private void playerTurn() {
        while (true) {
            System.out.print("Do you want to hit or stand? (h/s): ");
            String choice = scanner.next().toLowerCase();
            if (choice.equals("h")) {
                Card card = deck.dealNextCard();
                player.addCard(card);
                System.out.println("You drew: " + card);
                System.out.println("Your hand: " + player.getHand() + " (Value: " + player.getHandValue() + ")");
                if (player.getHandValue() > 21) {
                    System.out.println("Bust! You lose.");
                    return;
                }
            } else if (choice.equals("s")) {
                return;
            }
        }
    }

    private void dealerTurn() {
        System.out.println("Dealer's hand: " + dealer.getHand() + " (Value: " + dealer.getHandValue() + ")");
        while (dealer.getHandValue() < 17) {
            Card card = deck.dealNextCard();
            dealer.addCard(card);
            System.out.println("Dealer drew: " + card);
            System.out.println("Dealer's hand: " + dealer.getHand() + " (Value: " + dealer.getHandValue() + ")");
        }
    }

    private void determineWinner(int bet) {
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        if (playerValue > 21) {
            System.out.println("You bust. You lose $" + bet);
            player.adjustBalance(-bet);
        } else if (dealerValue > 21) {
            System.out.println("Dealer busts. You win $" + bet);
            player.adjustBalance(bet);
        } else if (playerValue > dealerValue) {
            System.out.println("You win $" + bet);
            player.adjustBalance(bet);
        } else if (playerValue < dealerValue) {
            System.out.println("Dealer wins. You lose $" + bet);
            player.adjustBalance(-bet);
        } else {
            System.out.println("It's a tie. Your bet is returned.");
        }

        System.out.println("Your new balance: $" + player.getBalance());
    }

    private void resetHands() {
        player.clearHand();
        dealer.clearHand();
        deck = new Deck(); // Create a new shuffled deck for the next round
    }
}
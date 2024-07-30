import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        // play some music
        String filepath = "CasinoJazz.wav";
        PlayMusic music = new PlayMusic();
        music.playMusic(filepath);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String playerName = sc.nextLine();
        System.out.print("Enter your initial balance: $");
        int initialBalance = sc.nextInt();

        Game game = new Game(playerName, initialBalance);

        while (true) {
            game.playRound();
            System.out.print("Do you want to play another round? (y/n): ");
            String playAgain = sc.next().toLowerCase();
            if (!playAgain.equals("y")) {
                break;
            }
        }

        System.out.println("Thanks for playing!");
        sc.close();
    }
}
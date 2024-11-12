# BlackJack

A text-based BlackJack card game implemented in Java that simulates the classic casino experience. Players can enter their name, manage their betting balance, and play multiple rounds against the dealer.

## Features

- Classic BlackJack gameplay
- Player name customization
- Balance and betting system
- Multiple round gameplay
- Optional background music support (currently commented out)
- Interactive command-line interface

## Game Rules

- The goal is to beat the dealer by getting a hand value as close to 21 as possible without going over
- Card values:
  - Number cards (2-10): Face value
  - Face cards (Jack, Queen, King): 10
  - Ace: 1 or 11 (whichever benefits the player)
- Player options:
  - Hit: Take another card
  - Stand: Keep current hand
  - Double Down: Double the bet after receiving initial cards
- Dealer must hit on 16 and below, stand on 17 and above
- BlackJack (an Ace with a 10 or face card) pays 3:2

## Prerequisites

To run this game, you need:

- Java Development Kit (JDK) 8 or higher
- A terminal or command prompt
- Basic understanding of command-line operations

## Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/BlackJack.git
```

2. Navigate to the project directory:
```bash
cd BlackJack
```

3. Compile the Java files:
```bash
javac GameRunner.java Game.java
```

## How to Play

1. Run the game:
```bash
java GameRunner
```

2. Game Flow:
   - Enter your name when prompted
   - Input your initial balance
   - Place your bet for each round
   - Make decisions during gameplay (hit/stand)
   - Choose whether to play another round
   - Cash out when you're done

## Project Structure

- `GameRunner.java` - Main class containing the game loop and player setup
- `Game.java` - Contains BlackJack game logic and round management
- `PlayMusic.java` - (Optional) Handles background music functionality
- Audio files (optional):
  - `CasinoJazz.wav` - Background music file (currently disabled)

## Future Enhancements

- Implement split pairs functionality
- Add insurance betting option
- Enable multiplayer support
- Include background music
- Add graphical user interface
- Implement statistical tracking of wins/losses
- Save player progress and high scores

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Troubleshooting

If you encounter any issues:

1. Ensure Java is properly installed and added to your system PATH
2. Verify all source files are in the same directory
3. Check that you have proper read/write permissions in the game directory
4. Make sure your terminal/command prompt supports text input

## Authors

- Rodale Brown

## Acknowledgments

- Java Documentation
- Standard BlackJack casino rules
- [Any other resources or inspirations]


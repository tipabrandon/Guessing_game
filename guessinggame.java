import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private int level;
    private int score;
    private int maxNumber;
    private int numberToGuess;
    private Scanner scanner;
    private Random random;

    public GuessingGame() {
        this.level = 1;
        this.score = 0;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public void play() {
        while (level <= 3) {
            switch (level) {
                case 1:
                    maxNumber = 10;
                    break;
                case 2:
                    maxNumber = 20;
                    break;
                case 3:
                    maxNumber = 100;
                    break;
            }

            numberToGuess = random.nextInt(maxNumber + 1);
            System.out.println("Level " + level + ": Guess a number between 0 and " + maxNumber);

            int attempts = 0;
            boolean guessed = false;
            while (!guessed) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += 10 - attempts + 1;
                    if (score < 0) {
                        score = 0;
                    }
                    System.out.println("Your score for this level is: " + score);
                    level++;
                    guessed = true;
                }

                if (attempts >= 10) {
                    System.out.println("Game over! The number was " + numberToGuess);
                    System.out.println("Your final score is: " + score);
                    return;
                }
            }
        }

        System.out.println("Congratulations! You completed all levels.");
        System.out.println("Your final score is: " + score);
    }

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        game.play();
    }
}
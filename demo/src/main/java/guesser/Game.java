package guesser;

import java.util.Scanner;

public class Game {
    public static int number = 0;
    public static Scanner scan = new Scanner(System.in); // made non-final so tests can inject
    public static String output = "";
    public static boolean test = false; // flag to disable playAgain prompts during tests

    // allow tests to inject a Scanner with predetermined input
    public static void setScanner(Scanner s) {
        scan = s;
    }
    
    public static void generateNumber() {
        number = (int) (Math.random() * 100) + 1;
    }

    public static void getGuess() {
        System.out.print("Enter your guess: ");
        int guess = scan.nextInt();
        scan.nextLine(); // consume newline
        checkGuess(guess);
    }

    public static void checkNumber(int guess) {
        if (guess < number) {
            output = "Too low! \nThe correct number was: " + number;
        } else if (guess > number) {
           output = "Too high! \nThe correct number was: " + number;
        } else {
           output = "Correct!";
        }
        System.out.println(output);
        playAgain();
    }

    public static void checkGuess(int guess) {
        if (guess < 1 || guess > 100) {
            throw new IllegalArgumentException("Guess must be between 1 and 100");
        } else {
            checkNumber(guess);
        }
    }

    public static void playAgain() {
        if (!test) {
            output = "Do you want to play again? (y/n)\n";
            System.out.print(output);
            String response = scan.nextLine();
            if (response.equalsIgnoreCase("y")) {
                generateNumber();
                getGuess();
            } else {
                output = "Thanks for playing!";
                System.out.println(output);
            }
        }
    }
}

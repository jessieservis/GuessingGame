package guesser;

import java.util.Scanner;

public class Game {
    static int number = 0;

    public static void generateNumber() {
        number = (int) (Math.random() * 100) + 1;
    }

    public static void getGuess() {
        System.out.println("Enter your guess:");
        Scanner scan = new Scanner(System.in);
        int guess = scan.nextInt();
        scan.close();
        checkGuess(guess);
    }

    public static void checkNumber(int guess) {
        if (guess < number) {
            System.out.println("Too low!");
            System.out.println("The correct number was: " + number);
        } else if (guess > number) {
            System.out.println("Too high!");
            System.out.println("The correct number was: " + number);
        } else {
            System.out.println("Correct!");
        }
    }

    public static void checkGuess(int guess) {
        if (guess < 1 || guess > 100) {
            throw new IllegalArgumentException("Guess must be between 1 and 100");
        } else {
            checkNumber(guess);
        }
    }
}

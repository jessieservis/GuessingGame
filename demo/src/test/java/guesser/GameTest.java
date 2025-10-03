package guesser;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Scanner;


public class GameTest {
    @Test
    public void testGenerateNumberInRange() {
        for (int i = 0; i < 100; i++) {
            Game.generateNumber();
            Game.test = true; // disable playAgain prompts during tests
            assertTrue(Game.number >= 1 && Game.number <= 100);
        }
    }

    @Test
    public void testCheckGuessCorrect() {
        Game.number = 50;
        Game.test = true; // disable playAgain prompts during tests
        Game.checkGuess(50);
        assertEquals("Correct!", Game.output);
    }

    @Test
    public void testCheckGuessTooLow() {
        Game.number = 60;
        Game.test = true; // disable playAgain prompts during tests
        Game.checkGuess(40);
        assertEquals(Game.output.startsWith("Too low!"), true);
    }

    @Test
    public void testCheckGuessTooHigh() {
        Game.number = 20;
        Game.test = true; // disable playAgain prompts during tests
        Game.checkGuess(80);
        assertEquals(Game.output.startsWith("Too high!"), true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckGuessBelowRange() {
        Game.number = 10;
        Game.test = true; // disable playAgain prompts during tests
        Game.checkGuess(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckGuessAboveRange() {
        Game.number = 10;
        Game.test = true; // disable playAgain prompts during tests
        Game.checkGuess(101);
    }

    @Test
    public void testPlayAgainNo() {
        // Pretend the user typed "n"
        Game.setScanner(new Scanner("n\n"));
        Game.test = false; // allow playAgain to run

        Game.number = 50;
        Game.checkGuess(40); // triggers playAgain

        assertEquals("Thanks for playing!", Game.output);
    }

    @Test
    public void testPlayAgainYes() {
        // Pretend user typed "y" then guessed "50" then typed "n" to exit
        String fakeInput = "y\n50\nn\n";
        Game.setScanner(new Scanner(fakeInput));
        Game.test = false; // allow playAgain to run

        Game.number = 50;
        Game.checkGuess(50); // correct guess triggers playAgain

        // Eventually should quit with "Thanks for playing!"
        assertEquals("Thanks for playing!", Game.output);
    }

}

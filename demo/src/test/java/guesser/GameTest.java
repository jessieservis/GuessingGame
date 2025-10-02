package guesser;

import static org.junit.Assert.*;
import org.junit.Test;
    
public class GameTest {

    @Test
    public void testGenerateNumberInRange() {
        for (int i = 0; i < 100; i++) {
            Game.generateNumber();
            assertTrue(Game.number >= 1 && Game.number <= 100);
        }
    }

    @Test
    public void testCheckGuessCorrect() {
        Game.number = 50;
        // Should not throw and should print "Correct!"
        Game.checkGuess(50);
    }

    @Test
    public void testCheckGuessTooLow() {
        Game.number = 60;
        // Should not throw and should print "Too low!"
        Game.checkGuess(30);
    }

    @Test
    public void testCheckGuessTooHigh() {
        Game.number = 20;
        // Should not throw and should print "Too high!"
        Game.checkGuess(80);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckGuessBelowRange() {
        Game.number = 10;
        Game.checkGuess(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckGuessAboveRange() {
        Game.number = 10;
        Game.checkGuess(101);
    }
}

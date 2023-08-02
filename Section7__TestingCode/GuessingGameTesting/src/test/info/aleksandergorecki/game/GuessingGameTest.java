package info.aleksandergorecki.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingGameTest {

    private GuessingGame game;

    @BeforeEach
    void setUp() {
        game = new GuessingGame();
    }

    @Test
    public void testSimpleWinSituation(){
        int randomNumber = game.getRandomNumber();
        String message = game.guess(randomNumber);
        assertEquals("You got it", message);
    }

    @Test
    public void testOneFalseNegativeGuessSituation(){
        String message = game.guess(-5);
        assertEquals("You did not guess it", message);
    }

    @Test
    public void testOneFalsePositiveGuessSituation(){
        int randomNumber = game.getRandomNumber();
        String message = game.guess(randomNumber + 1);
        assertEquals("You did not guess it", message);
    }

    @RepeatedTest(50)
    public void testRandomNumberGeneration(){

        // 1 2 3 4 5 6 7 8 9 10
        // 1 1 1 1 0 1 0 1 1 1 = 10

        int[] randomNumberCount = new int[11];

        for (int counter = 0; counter < 60; counter++){
            GuessingGame localeGame = new GuessingGame();
            int randomNumber = localeGame.getRandomNumber();
            randomNumberCount[randomNumber] = 1;
        }

        int sum = 0;
        for (int counter = 0; counter < 11; counter++){
            sum += randomNumberCount[counter];
        }


        assertEquals(10, sum);
    }

    @Test
    public void testFourWrongGuesses(){
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        String message = game.guess(-3);
        assertEquals("You did not get it and you had for guesses. Game over.", message);
    }

    @Test
    public void testThreeWrongGuessesAndOneCorrect(){
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);

        int randomNumber = game.getRandomNumber();
        String message = game.guess(randomNumber);
        assertEquals("You got it", message);
    }

    @Test
    public void testTwoWrongGuessesAndOneCorrect(){
        game.guess(-3);
        game.guess(-3);

        int randomNumber = game.getRandomNumber();
        String message = game.guess(randomNumber);
        assertEquals("You got it", message);
    }
}

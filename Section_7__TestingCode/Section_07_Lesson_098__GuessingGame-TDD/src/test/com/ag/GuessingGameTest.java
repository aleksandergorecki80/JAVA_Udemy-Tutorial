package com.ag;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuessingGameTest {

    private GuessingGame game;

    @BeforeEach
    void setUp() {
        game = new GuessingGame();
    }

    @Test
    public void testSimpleWinSituation() {
        int randomNumber = game.getRandomNumber();
        String message = game.guess(randomNumber);
        assertEquals("You got it in 1 try", message);
    }

    @Test
    public void testOneWrongNegativeGuessSituation() {
        String message = game.guess(-5);
        assertEquals("It is wrong number - too low.", message);
    }

    @Test
    public void testOneWrongPositiveGuessSituation() {
        int randomNumber = game.getRandomNumber();
        String message = game.guess(randomNumber+1);
        assertEquals("It is wrong number - too high.", message);
    }

//    @Test
    @RepeatedTest(5)
    public void testGeneratingRandomNumber() {

        int[] randomNumberCount = new int[11];

        for (int count = 0; count < 100; count++){
            GuessingGame myGame = new GuessingGame();
            int randomNumber = myGame.getRandomNumber();
            randomNumberCount[randomNumber] = 1;
        }

        int sum = 0;
        for (int count = 0; count < randomNumberCount.length; count++){
           sum +=  randomNumberCount[count];
        }

        System.out.println(sum);

        assertEquals(10, sum);
    }

    @Test
    public void testFourWrongGuesses() {
        makeThreeWrongGuesses();
        String message = game.guess(-4);
        assertEquals("You did not get it and you had 4 tries. Game over", message);
    }

    private void makeThreeWrongGuesses() {
        game.guess(-4);
        game.guess(-4);
        game.guess(-4);
    }

    @Test
    public void testFreeWrongGuessesAndOneCorrect() {
        makeThreeWrongGuesses();
        int correctAnswer = game.getRandomNumber();
        String message = game.guess(correctAnswer);
        assertEquals("You got it in 4 tries", message);
    }

    @Test
    public void testTwoWrongGuessesAndOneCorrect() {
        game.guess(-4);
        game.guess(-4);
        int correctAnswer = game.getRandomNumber();
        String message = game.guess(correctAnswer);
        assertTrue(message.contains("3"), "Should indicate 3 tries");
        assertEquals("You got it in 3 tries", message);
    }

    @Test
    public void testTenWrongGuesses() {
        game.guess(-4);
        game.guess(-4);
        game.guess(-4);
        game.guess(-4);
        game.guess(-4);
        game.guess(-4);
        game.guess(-4);
        game.guess(-4);
        game.guess(-4);
        String message = game.guess(-4);
        assertEquals("You are limited to 4 tries. You lost. Game over!", message);
    }
}

package info.aleksandergorecki.game;

import java.util.Random;

public class GuessingGame {

    private final int randomNumber = new Random().nextInt(10) + 1;
    private int counter = 0;

    public String guess(int number) {
        counter++;
        if(counter == 4 && number != getRandomNumber()){
            return "You did not get it and you had for guesses. Game over.";
        }
        return number == getRandomNumber() ? "You got it" : "You did not guess it";
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}

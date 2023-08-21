package com.ag;

import java.util.Random;

public class GuessingGame {

    private final int random = new Random().nextInt(10) + 1;
    private int counter = 0;

    public String guess(int pickedNumber) {
        counter++;
        String tryText = counter == 1 ? "try" : "tries";
        String message = String.format("You got it in %d %s", counter, tryText);

        String response;

        if(counter == 4 && pickedNumber != random){
            response =  String.format("You did not get it and you had %d %s. Game over", counter, tryText);
        } else if (counter > 4) {
            response = String.format("You are limited to 4 tries. You lost. Game over!");
        } else {
            String hintText = null;
            if(pickedNumber < getRandomNumber()){
                hintText = "- too low.";
            } else if (pickedNumber > getRandomNumber()) {
                hintText = "- too high.";
            } else {
                hintText = "";
            }

            String loseText = String.format("It is wrong number %s", hintText).trim();
            response =  pickedNumber == random ? message : loseText;
        }


        return response;
    }

    public int getRandomNumber() {
        return random;
    }

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        boolean loopShouldContinue = true;
        do {
            String input = System.console().readLine("Enter a number: ");
            if("q".equals(input)){
                return;
            };
            String output = game.guess(Integer.parseInt(input));
            System.out.println(output);
            if (output.contains("You got it") || output.contains("Game over")) {
                loopShouldContinue = false;
            }
        } while (loopShouldContinue);
    }
}

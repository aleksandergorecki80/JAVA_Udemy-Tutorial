import java.util.Random;

public class GuessLoopDoWhile {
        public static final int MAX_TRIES = 4;
    public static void main(String[] args) {
        int randomNr = new Random().nextInt(10) + 1;
        String guessedNumText = null;
        int counter = 0;
        do {
            System.out.println(randomNr + " == randomNr");

            counter++;
            guessedNumText = System.console().readLine("Please enter a number");
            if (guessedNumText.matches("-?\\d{1,2}")) {
                int guessedNum = Integer.parseInt(guessedNumText.strip());

                if(guessedNum == randomNr){
                    String guessesText = counter == 1 ? "try" : "tries";
                    System.out.printf("The random nr is %d. You got it in %d %s %n", randomNr, counter, guessesText);
                    return;
                } else {
                    System.out.printf("%d is not correct. Try again %n", guessedNum);
                    if (counter >=MAX_TRIES){
                        System.out.printf("You have had %d of wrong guesses, ending program now.", counter);
                    }
                }
            }
            System.out.println(guessedNumText + " = guessedNumText");
        } while (!"q".equals(guessedNumText) && counter < MAX_TRIES);


    }
}

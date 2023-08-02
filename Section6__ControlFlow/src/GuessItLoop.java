import java.util.Random;

public class GuessItLoop {
    public static void main(String[] args) {
        int randomNr = new Random().nextInt(10) + 1;
        String guessedNumText = null;
        while (!"q".equals(guessedNumText)) {
            guessedNumText = System.console().readLine("Please enter a number");
            if (guessedNumText.matches("-?\\d{1,2}")) {
                int guessedNum = Integer.parseInt(guessedNumText.strip());
                if(guessedNum == randomNr){
                    System.out.printf("The random nr is %d. You have guessed it! %n", randomNr);
                    return;
                } else {
                    System.out.printf("%d is not correct. Try again %n", guessedNum);
                }
            }
        }


    }
}

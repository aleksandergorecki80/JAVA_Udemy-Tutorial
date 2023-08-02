import java.util.Random;

public class GuessIt {
    public static void main(String[] args) {
        int randomDigit =  new Random().nextInt(3) + 1;
        System.out.printf("The number is: %d.%n", randomDigit);

        if (randomDigit == 3) {
            System.out.println("You gat it!");
        } else {
            System.out.println("Sorry you didn't get it.");
        }

        String command = null;

        if("stop".equals(command)){
            System.out.println("I am stopping now..");
        } else if ("run".equals(command)) {
            System.out.println("I am running now...");
        } else {
            System.out.println("Command not found!");
            }
        }
    }


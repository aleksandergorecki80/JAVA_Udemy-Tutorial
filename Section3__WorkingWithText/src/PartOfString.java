public class PartOfString {
    public static void main(String[] args) {
        String myText = "Learning a little each day adds up. Research shows that students who make learning a habit are more likely to reach their goals. Set time aside to learn and get reminders using your learning scheduler.";
        String myNewText = myText.substring(30);
        String myNewText22 = myText.substring(10, 50);

        System.out.println("=========================");

        System.out.println(myNewText);

        System.out.println("=========================");

        System.out.println(myNewText22);

        String apple = "apple";

        String appleUpper = apple.substring(0,1).toUpperCase() + apple.substring(1).toLowerCase();
        System.out.println(appleUpper);


        String s1 = apple.substring(0, 1).toUpperCase();
        String s2 = apple.substring(1).toLowerCase();

        String result = new StringBuilder(s1).append(s2).toString();
        System.out.println(result);
    }
}

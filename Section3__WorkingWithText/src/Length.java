public class Length {
    public static void main(String[] args) {
        String myText = "Learning a little each day adds up. Research shows that students who make learning a habit are more likely to reach their goals. Set time aside to learn and get reminders using your learning scheduler.";
        System.out.println(myText.length());

        char[] chars = myText.toCharArray();
        System.out.println(chars[2]);
    }
}

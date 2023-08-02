public class Contain {
    public static void main(String[] args) {
        String longText = "Learning a little each day adds up. Research shows that students who make learning a habit are more likely to reach their goals. Set time aside to learn and get reminders using your learning scheduler.";
        String shortText = "adds";

        System.out.println(longText.contains(shortText));
    }
}

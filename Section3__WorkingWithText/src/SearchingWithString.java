public class SearchingWithString {
    public static void main(String[] args) {
        String myText = "Learning a little each day adds up. Research shows that students who make " +
                "learning a habit are more likely to reach their goals. Set time aside to learn and " +
                "get reminders using your learning scheduler.";
        System.out.println(myText.indexOf("day"));

        System.out.println(myText.lastIndexOf("lear"));
        System.out.println(myText.indexOf("lear"));


        String myPhoneNumber = "(23489494) 333-5551";

        System.out.println(parseAreaCode(myPhoneNumber));
        System.out.println(parseExchangeCode(myPhoneNumber));
        System.out.println(parseLineCode(myPhoneNumber));
    }

    public static String parseAreaCode (String phoneNumber){
        int open = phoneNumber.indexOf("(");
        int close = phoneNumber.indexOf(")");
        return phoneNumber.substring(open+1, close);
    }

    public static String parseExchangeCode (String phoneNumber){
        int start = phoneNumber.indexOf(" ");
        int end = phoneNumber.indexOf("-");
        return phoneNumber.substring(start+1, end);
    }

    public static String parseLineCode (String phoneNumber) {
        int start = phoneNumber.indexOf("-");
        return phoneNumber.substring(start+1);
    }
}

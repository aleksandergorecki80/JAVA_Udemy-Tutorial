public class Concatenation {
    public static void main(String[] args) {
        String textOne = "This is text one";
        String textTwo = "This is text two";

        System.out.println(textOne.concat(textTwo));

        String result = new StringBuilder()
                            .append(textOne)
                            .append(" ")
                            .append(textTwo)
                            .toString();

        System.out.println(result);

        System.out.format("%s %s\n", textOne, textTwo);

        String finalString = String.format("%s %s", textOne, textTwo);

        System.out.println(finalString);
    }
}

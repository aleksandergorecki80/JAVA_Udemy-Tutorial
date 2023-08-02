public class BeginningAndEnding {
    public static void main(String[] args) {
        String filename = "   myFile.txt    ";

        System.out.println(filename.strip().endsWith("txt"));
        System.out.println(filename.strip().startsWith("myFile"));

        String firstString = "Apple";
        StringBuffer secondString = new StringBuffer("Apple");

        System.out.println(firstString.equals(secondString));
        System.out.println(firstString.contentEquals(secondString));
    }
}

public class UpperAndLowerCase_Replace {
    public static void main(String[] args) {
        String myText = "any text for training gaol";
        System.out.println(myText.toUpperCase());

        String myText2 = "ANOTHER TRAINING TEXT";
        System.out.println(myText2.toLowerCase());

        String myText3 = "";
        System.out.println("is  it empty? = " + myText3.isEmpty());
        System.out.println("is  it blank? = " + myText3.isBlank());

        String myText4 = " ";
        System.out.println("is  it empty? = " + myText4.isEmpty());
        System.out.println("is  it blank? = " + myText4.isBlank());

        String myTextWithWordToReplace = "this is a phrase with a word to replace";
        System.out.println(myTextWithWordToReplace);
        System.out.println(myTextWithWordToReplace.replace("phrase", "sentence"));
    }
}

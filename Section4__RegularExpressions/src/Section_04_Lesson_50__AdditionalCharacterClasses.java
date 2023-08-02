public class Section_04_Lesson_50__AdditionalCharacterClasses {
    public static void main(String[] args) {
        System.out.println("Hello world");
        System.out.println("doggy".matches(".....")); // The dot " . " represents any character.
        System.out.println("doggy".matches(".+")); // One or more
        System.out.println("doggy".matches("[^ert]")); // Opposite to
        System.out.println("doggy".matches("^.....")); // Beginning of the line or string
        System.out.println("doggy".matches(".....$")); // End of the line or string
        System.out.println("dat doggy".matches("...\\s\\b.....")); // Boundary
        System.out.println("&)%".matches("(\\W\\W\\W)")); // Capital " W " anything than word character
        System.out.println("abc".matches("(\\D\\D\\D)")); // Capital " W " anything than digit character
     }
}

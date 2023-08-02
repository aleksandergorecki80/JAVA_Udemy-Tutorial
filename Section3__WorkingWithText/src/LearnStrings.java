public class LearnStrings {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String fruit = "apple";
        String fruit1 = "apple";
        String vegetable = new String("beetroot");
        String vegetable1 = new String("beetroot");

        System.out.println(fruit == fruit1);
        System.out.println(vegetable == vegetable1);
    }
}
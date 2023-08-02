public class Comparing {
    public static void main(String[] args) {
        String firstFruit = "Apple";
        String secondFruit = "Apple";
        String lastFruit = "Banana";

        System.out.println(firstFruit.compareTo(secondFruit));
        System.out.println(firstFruit.compareTo(lastFruit));
        System.out.println(lastFruit.compareTo(firstFruit));


        String firstFruitNoCase = "apple";
        String secondFruitNoCase = "Apple";
        String lastFruitNoCase = "banana";

        System.out.println(firstFruitNoCase.compareTo(secondFruitNoCase));
        System.out.println(firstFruitNoCase.compareTo(lastFruitNoCase));
        System.out.println(lastFruitNoCase.compareTo(firstFruitNoCase));

        System.out.println(firstFruitNoCase.compareToIgnoreCase(secondFruitNoCase));
        System.out.println(firstFruitNoCase.compareToIgnoreCase(lastFruitNoCase));
        System.out.println(lastFruitNoCase.compareToIgnoreCase(firstFruitNoCase));
    }
}

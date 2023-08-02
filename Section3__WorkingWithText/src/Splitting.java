public class Splitting {
    public static void main(String[] args) {
        String textBlock = """
                John ,Doe,35
                Tomas ,Anderssons,33
                John ,Smith,999
                """;

        System.out.println(textBlock);

        String[] people = textBlock.split("\n");

        System.out.println(people);

        for (String person: people
             ) {
            System.out.println(person);
        }
    }
}

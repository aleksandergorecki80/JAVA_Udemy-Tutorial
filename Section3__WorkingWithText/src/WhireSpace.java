public class WhireSpace {
    public static void main(String[] args) {
        String firstName = "      John    ";
        System.out.format("'%s'", firstName);

        System.out.format("'%s'", firstName.trim());

        System.out.format("'%s'", firstName.strip());

        System.out.format("'%s'", firstName.stripTrailing());

        System.out.format("'%s'", firstName.stripLeading());

        System.out.println(firstName.trim().length());

        String multipleLine = """
                first line
                second line
                third line
                """;
        System.out.println(multipleLine);
    }
}

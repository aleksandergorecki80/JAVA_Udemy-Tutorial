public class RegExPartOne {
    public static void main(String[] args) {
        System.out.println("Cat".matches("[cC]at"));
        System.out.println("Kat".matches("[c-fC-F]at"));
        System.out.println("cat".matches("[^c]at"));  // ^ - excludes "c"
        System.out.println("fat".matches("[^a-z]at"));  // ^ - excludes
        System.out.println("1at".matches("[^a-z]at"));  // ^ - excludes


        System.out.println("1at".matches("\\wat"));  // \w - one word character
        System.out.println("1at".matches("\\dat"));  // \d - digits
        System.out.println("335-646-6546".matches("\\d{3}-\\d{3}-\\d{4}"));  // \d - digits
        System.out.println("334.646.6564".matches("\\d{3}[.-]\\d{3}[.-]\\d{4}"));  // \d - digits
        System.out.println("334 646 6564".matches("\\d{3}[-.,\\s]\\d{3}[-.\\s]\\d{4}"));  // \s - space
        System.out.println("334 646-. 6564".matches("\\d{3}[-.,\\s]\\d{3}[-.\\s]+\\d{4}"));  // \+ - one or more
        System.out.println("334 6466564".matches("\\d{3}[-.,\\s]?\\d{3}[-.\\s]?\\d{4}"));  // \? - zero or one

        System.out.println("1.334 646.6564".matches("(\\d[-.\\s])?(\\d{3}[-.\\s]){2}\\d{4}"));  // \? - zero or one
        System.out.println("1.334 646.6564".matches("(\\d[-.\\s])?(\\d{3}[-.\\s]){2}\\d{3,4}"));  // min = 3 , max = 4
        System.out.println("1.334 646.65".matches("(\\d[-.\\s])?(\\d{3}[-.\\s]){2}\\d{3,4}"));  // min = 3 , max = 4

        System.out.println("1.334 646.65".matches("(\\d[-.\\s])?(\\d{3}[-.\\s]){2}\\d{2,}"));  // 2,  - from 2 to no limit


        System.out.println("334 245 6465".matches("(\\d{3}[-.\\s]?){2}\\d{4}"));  //   - ( ) bracket means a group
        System.out.println("334 6465".matches("(\\d[-.\\s]?)?(\\d{3}[-.\\s]?){1,2}\\d{4}"));  //   - ( ) bracket means a group


    }
}

public class Person {
    private String firstName;
    private String middleName = "Harley";
    String lastName; // can be accessed by class in the same package

    public static double PI = 3.14;
    public static int[] numbers;
    public static int[] moreNumbers = initMoreNumbers();

    static {
        numbers = new int[5];

        numbers[0] = 32;
        numbers[1] = 13;
        numbers[2] = 35;
        numbers[3] = 123;
        numbers[4] = 443;
    }

    public static int[] initMoreNumbers(){
        return new int[] {4, 8, 78, 14};
    }


    public void sayHello(){
        System.out.println("Hello");
    }



    public char getLetter(int index) {
        return middleName.charAt(index);
    }

    public void words(String[] words){
        for (String word: words
             ) {
            System.out.println(word);
        }
    }

    public void varargs(String... words){
        for (String word: words
        ) {
            System.out.println(word);
        }
    }

    @Override
    public String toString() {
//        return super.toString();
        return "Hello Tony";
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.sayHello();
        char letter = person1.getLetter(0);
        System.out.println(letter);
        person1.words(new String[] {"one", "two", "three"});

        person1.varargs("four", "five", "six");

        System.out.println(PI);
        System.out.println(moreNumbers);

        System.out.println(person1);

        /// Fields
        person1.firstName = "John";

    }
}

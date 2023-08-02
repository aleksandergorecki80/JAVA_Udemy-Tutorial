public class PatternMatching {
    public static void main(String[] args) {

//        Object obj = null;
        Object obj = 777;

        switch (obj) {
            case String msg -> System.out.println(msg);
            case Integer nr -> System.out.println("Your nr is " + nr);
            case null -> System.out.println("It is null");
            default -> System.out.println("None of it");
            }
        }

    }



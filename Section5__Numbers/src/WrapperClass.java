public class WrapperClass {
    public static void main(String[] args) {
        int num1 = 7;
        storeData(num1);



        // auto-boxing

        Integer numInt = Integer.valueOf(45);
        Double doubleNr = Double.valueOf(12.15);
        Float myFloat = Float.valueOf(121.454f);
        Byte myByte = Byte.valueOf("24");

        //

        int age = Integer.parseInt("37");
        double amount = Double.parseDouble("345.12");
        boolean flag = Boolean.parseBoolean("true");

        int userNumber = Integer.parseInt(args[0]);
        System.out.printf("Your number plus 15 is = %d ", userNumber + 15 );
    }

    /**
     * Takes in any type of data and stores it somewhere generically
     */
    public static void storeData(Object obj){
        // do something with obj
    }
}

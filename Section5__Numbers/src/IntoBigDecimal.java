import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class IntoBigDecimal {
    public static void main(String[] args) {
        float num1 = 2.12f;
        float num2 = 1.10f;
        System.out.println(num1 - num2);


        BigDecimal num3 = new BigDecimal("2.12");
        BigDecimal num4 = new BigDecimal("1.10");

        System.out.println(num3.subtract(num4));

        System.out.println(new BigDecimal(".314").add(new BigDecimal(".122")));

        MathContext mc = new MathContext(15, RoundingMode.HALF_UP);
        System.out.println(new BigDecimal(".034654614").divide(new BigDecimal("5.3122"), mc));

        System.out.println(new BigDecimal("49").sqrt(mc));

        System.out.println(new BigDecimal("7").max(new BigDecimal("78")));

        System.out.println(new BigDecimal("13").remainder(new BigDecimal("6")));
    }
}

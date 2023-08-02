import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CompoundInterest {

    private static final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentageFormat = NumberFormat.getPercentInstance();



    public static BigDecimal calculate(String principal, String rate, int period, String contribution) throws ParseException {
        String rateAsPercent = percentageFormat.parse(rate).toString();
        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(rateAsPercent)).pow(period);
        BigDecimal c = a.subtract(BigDecimal.ONE);
        BigDecimal d = c.divide(new BigDecimal(rateAsPercent));
        BigDecimal e = d.multiply(new BigDecimal(moneyFormat.parse(contribution).toString()));
        BigDecimal f = a.multiply(new BigDecimal(moneyFormat.parse(principal).toString()));
        BigDecimal g = f.add(e);
        return g;
    }

    public static void main(String[] args) throws ParseException {
        DecimalFormat df = new DecimalFormat("$,###.##");
        DecimalFormat df2 = new DecimalFormat("$000000000,000.00");
        DecimalFormat percentageFormater = new DecimalFormat("#%");
        BigDecimal result = CompoundInterest.calculate("£10,000", "8%", 10, "£1,000");
        System.out.println(moneyFormat.format(result));
        System.out.println(df.format(result));
        System.out.println(df2.format(result));
        System.out.println(percentageFormater.format(0.8));

        System.out.printf("$%,(.2f%n", result.negate());
        System.out.printf("$%,(.2f%n", result);
        System.out.format("$%,(.2f%n", result);

        String myMoney = String.format("$%,(.2f%n", result);
        System.out.println(myMoney);
    }
}



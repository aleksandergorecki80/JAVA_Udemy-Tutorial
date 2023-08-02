public class BlackJack {
    public static void main(String[] args) {
        String cart = "9";
        int currentTotalValue = 15;

        int currentValue = switch (cart) {
            case "king", "queen", "jack" -> 10;
            case "ace" -> {
                if (currentTotalValue <= 10) {
                    yield 11;
                } else {
                    yield 1;
                }
            }
            default -> Integer.parseInt(cart);
        };

        System.out.printf("Total value: %d%n", currentValue + currentTotalValue);

    }
}

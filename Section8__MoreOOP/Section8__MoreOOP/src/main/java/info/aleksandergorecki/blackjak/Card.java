package info.aleksandergorecki.blackjak;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Card(String enteredSuit, String enteredRank){
        this.suit = Suit.valueOf(enteredSuit.toUpperCase());
        this.rank = Rank.valueOf(enteredRank.toUpperCase());
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public static void main(String[] args) {
        Card card1 = new Card(Suit.DIAMONDS, Rank.TEN);
        Card card2 = new Card(Suit.CLUBS, Rank.JACK);
        Card card3 = new Card("hearts", "queen");

        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);
    }

    @Override
    public String toString() {
        return this.rank.toString().concat(" ").concat(this.suit.toString());
    }

    public int getValue(){
        return this.rank.getValue();
    }
}

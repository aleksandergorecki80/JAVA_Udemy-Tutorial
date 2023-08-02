package info.aleksandergorecki.blackjak;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void canGetValueOfTwoCard() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.TWO);
        assertEquals(2, card1.getValue());
    }

    @Test
    void canGetValueOfThreeCard() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.THREE);
        assertEquals(3, card1.getValue());
    }

    @Test
    void canGetValueOfAceCard() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.ACE);
        assertEquals(1, card1.getValue());
    }

    @Test
    void canGetValueOfJackCard() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.JACK);
        assertEquals(10, card1.getValue());
    }

    @Test
    void canGetValueOfKingCard() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.KING);
        assertEquals(10, card1.getValue());
    }

}
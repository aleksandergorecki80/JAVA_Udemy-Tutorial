package com.ag.blacjac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void canGetValueOfTwo() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.TWO);
        assertEquals(2, card1.getValue());
    }

    @Test
    void canGetValueOfFive() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.FIVE);
        assertEquals(5, card1.getValue());
    }

    @Test
    void canGetValueOfAce() {
        Card card1 = new Card(Suit.CLUBS, Rank.ACE);
        assertEquals(1, card1.getValue());
    }

    @Test
    void canGetValueOfJack() {
        Card card1 = new Card(Suit.CLUBS, Rank.JACK);
        assertEquals(10, card1.getValue());
    }

    @Test
    void canGetValueOfQueen() {
        Card card1 = new Card(Suit.CLUBS, Rank.QUEEN);
        assertEquals(10, card1.getValue());
    }

    @Test
    void canGetValueOfKing() {
        Card card1 = new Card(Suit.CLUBS, Rank.KING);
        assertEquals(10, card1.getValue());
    }
}
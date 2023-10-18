package com.ag.blacjac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @Test
    void getValueOfKing() {
        // Rank KING = new Rank("KING");
        // Rank QUEEN = new Rank("QUEEN");
        // Rank JACK = new Rank("JACK");
        assertEquals(10, Rank.KING.getValue());
    }
}
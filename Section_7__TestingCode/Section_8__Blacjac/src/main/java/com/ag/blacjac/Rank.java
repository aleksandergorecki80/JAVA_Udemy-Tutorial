package com.ag.blacjac;

public enum Rank {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10, "Bohemian rhapsody"),
    KING(10);

    private int value;
    private String favouriteSong;

    Rank(int value) {
        this.value = value;
    }

    Rank(int value, String favouriteSong) {
        this.value = value;
        this.favouriteSong = favouriteSong;
    }

    // Rank KING = new Rank("KING");
    // Rank QUEEN = new Rank("QUEEN");
    // Rank JACK = new Rank("JACK");
    // assertEquals(10, Rank.KING.getValue());
    public int getValue() {
//        return switch (this){
//            case JACK, QUEEN, KING -> 10;
//            default -> ordinal() + 1;
//        };
        return value;
    }

}

package org.design.g4g.playingcards.simple;


/**
 * Card class for Poker deck excluding jokers.
 */
public class Card {

    // codes for the 4 suits
    public final static int SPADES = 0;
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;

    // codes for the non-numeric cards
    public final static int ACE = 1;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    /**
     * This card's suit.
     */
    private final int suit;

    /**
     * The card's numeric value.
     */
    private final int value;

    /**
     * Creates a card with a specified suit and value.
     */
    public Card(int value, int suit) {
        if (suit < SPADES || suit > CLUBS)
            throw new IllegalArgumentException("illegal playing card suit");
        if (value < ACE || value > KING)
            throw new IllegalArgumentException("illegal playing card value");
        this.value = value;
        this.suit = suit;
    }

    /**
     * Returns the suit of this card.
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Returns the value of this card.
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns a String representation of the card's suit.
     */
    public String getSuitAsString() {
        switch (suit) {
            case SPADES:
                return "Spades";
            case HEARTS:
                return "Hearts";
            case DIAMONDS:
                return "Diamonds";
            case CLUBS:
                return "Clubs";
            default:
                return "Unknown";
        }
    }

    /**
     * Returns a String representation of the card's value.
     */
    public String getValueAsString() {
        switch (value) {
            case 1:
                return "Ace";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            default:
                return "King";
        }
    }

    /**
     * Returns a string representation of this card.
     */
    public String toString() {
        return getValueAsString() + " of " + getSuitAsString();
    }
}
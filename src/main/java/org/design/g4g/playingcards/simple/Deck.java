package org.design.g4g.playingcards.simple;

/**
 * http://www.nobigo.com/design-a-deck-of-playing-cards-deck-shuffling
 *
 * http://math.hws.edu/javanotes/c5/s4.html
 *
 * An object of type Deck represents a deck of playing cards. The deck is a
 * regular poker deck that contains 52 regular cards and excludes two jokers.
 */


/*

 Question 1: how would you represent a standard 52 card deck in (basically any language)? How would you shuffle the
 deck?

 In Java, I would use:

 ArrayList<Card> deck as data type and name.
 Collections.shuffle(deck) or Collections.shuffle(deck, myRnd) to shuffle the deck.

 Question 2: how to represent a large sparse matrix? the matrix can be very large... like 1000x1000... but only a relatively small number (~20) of the entries are non-zero.
 In Java, I would store only non-zero elements, in:

 HashMap<TupleN, Data> matrix as a data type in general case, where TupleN is a value class (with a custom hash function) and contains element locations.
 In case of 2 dimensions I would combine them in long type HashMap<Long, Data> m and use m.get(((Long)i1<<32)+i2);, if i need an element.


 */

/*

Deck contains list of 52 cards, each card has some info associated with it. Deck has to support Deal and shuffle.
set cannot be used because order matters. Shuffle will be a random number function. Deal will be assignment of card to
the users.

Shuffle: initialize a random num generator with a seed
Deal: generate random numbers in a round-robin fashion.

 */

public class Deck {

    /**
     * An array of 52 cards.
     */
    private Card[] deck;

    /**
     * Keeps track of the number of cards that have been dealt from the deck so
     * far.
     */
    private int cardsUsed;

    /**
     * Constructs a poker deck of playing cards. The deck contains the usual 52
     * cards.
     */
    public Deck() {
        deck = new Card[52];
        int cardCounter = 0;
        // how many cards have been created so far.
        for (int suit = 0; suit <= Card.CLUBS; suit++) {
            for (int value = 1; value <= Card.KING; value++) {
                deck[cardCounter] = new Card(value, suit);
                cardCounter++;
            }
        }
        cardsUsed = 0;
    }

    /**
     * Put all the used cards back into the deck (if any), and shuffle the deck
     * into a random order.
     */
    public void shuffle() {
        for (int i = deck.length - 1; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsUsed = 0;
    }

    /**
     * Removes the next card from the deck and return it.
     *
     * @return the card which is removed from the deck.
     * @throws IllegalStateException
     *             if there are no cards left in the deck
     */
    public Card deal_one_card() {
        if (cardsUsed == deck.length) {
            throw new IllegalArgumentException("no cards are left in the deck.");
        }
        cardsUsed++;
        return deck[cardsUsed - 1];
    }

    /**
     * Test of cards deck.
     * @param args
     */
    public static final void main(String[] args) {
        // create deck
        Deck deck = new Deck();
        // shuffle
        deck.shuffle();
        // we will try 53 times instead of 52 to display empty deck
        for (int i = 1; i <= 53; i++) {
            Card card = deck.deal_one_card();
            System.out.println(i + " : card [" + card + "]");
        }
    }
}
package com.champlain.oop2assignment3;

import java.util.*;

/**
 * Represents a deck of playing cards.
 * <p>
 * This class allows for creating a standard deck, shuffling it, drawing cards,
 * and checking if the deck is empty.
 * It follows the singleton design pattern to be sure there is no other
 * than one instance of the deck in existence
 * </p>
 */
public class Deck extends CardCollection implements CardSource {

    /**
     * The only instance of the Deck
     */
    private static Deck instance = new Deck();

    /**
     * The list of cards in the deck.
     */
    private final List<Card> aCards = new ArrayList<>();

    /**
     * Constructs a new Deck containing all standard playing cards.
     * The deck is initialized with one of each rank and suit combination.
     * This constructor is private to enforce the singleton design pattern
     */
    private Deck() {
        for (Rank currentRank : Rank.values()) {
            for (Suit currentSuit : Suit.values()) {
                this.aCards.add(new Card(currentRank, currentSuit));
            }
        }
    }

    /**
     * Returns the single instance of the deck
     * If the instance is null, it creates a new one
     *
     * @return the single instance of the deck
     */
    public static Deck getInstance() {
        if (Deck.instance == null) {
            Deck.instance = new Deck();
        }
        return new Deck();
    }

    /**
     * Shuffles the cards in this deck randomly.
     */
    public void shuffle() {
        Collections.shuffle(this.aCards);
    }

    public Card draw() {
        int last = this.aCards.size() - 1;
        Card myCard = this.aCards.get(last);
        this.aCards.remove(last);
        return myCard;
    }

    public boolean isEmpty() {
        return this.aCards.isEmpty();
    }

    /**
     * Returns an iterator over the cards in this deck.
     *
     * @return an iterator for the cards
     */
    public Iterator<Card> iterator() {
        return this.aCards.iterator();
    }

    public void sortByRank() {
        this.aCards.sort(Comparator.comparing(Card::getRank).thenComparing(Card::getSuit));
    }
    public void sortBySuit() {
        this.aCards.sort(Comparator.comparing(Card::getSuit).thenComparing(Card::getRank));
    }
}

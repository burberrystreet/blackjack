/** 
 * Deck class, from scratch
 */

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Deck {

	private ArrayList<Card> deck = new ArrayList<Card>(); // each deck object has an ArrayList of cards

	/**
	 * constructors
	 */
	
	public Deck(ArrayList<Card> c) {
		deck = c;
	}

	public Deck() {
		int s = 0;
		int i = 1;
		for (s=0; s<4; s++) {
			for (i=1; i<14; i++) {
				deck.add(new Card(s, i));
			}
		}
	}
	
	/**
	 * set method
	 */
	
	public void setDeck(ArrayList<Card> c) {
		deck.clear();
		deck = c;
	}
	
	/**
	 * get method
	 */
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	public int getSize() {
		return deck.size();
	}
	
	public Card getCard(int index) {
		return deck.get(index);
	}

    /**
     * modification methods
     */
	public void removeCard(int index) {
		deck.remove(index);
	}
	
	public void addCard(Card c) {
		deck.add(c);
	}
	
	/**
	 * toString methods
	 */
	
	public ArrayList<String> deckToString() {
		ArrayList<String> d = new ArrayList<String>();
		for (Card c : this.deck) {
			d.add(c.toString());
		}
		return d;
	}
	
}

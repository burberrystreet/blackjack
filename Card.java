/**
 * Card class, modified from ada
 */

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Card {
  public static int CLUB = 0;
	public static int DIAMOND = 1;
	public static int HEART = 2;
	public static int SPADE = 3;

	public static Image[] cardImages;

	private int id;
	private int suit;

	/**
	 * Constructors
	 */
	
	public Card() {	}

	public Card(int suit, int val) {
		this.suit = suit;
		id = val;
	}

	/** get methods */
	
	public int getSuit() {
		return suit;
	}

	public int getValue() {
		return id;
	}

	public int getScore() {
		return id;
	}

	/** toString methods */
	
	public String suitToString() {
		String s = "";
		switch (suit) {
			case 0: 
				s = "C";
				break;
			case 1: 
				s = "D";
				break;
			case 2: 
				s = "H";
				break;
			case 3: 
				s = "S";
				break;
		}
		return s;
	}
	
	public String idToString() {
		String s = "";
		if (id == 1) {
			s = "A";
		} else if (id < 11) {
			s = Integer.toString(id);
		} else {
			switch (id) {
			case 11: 
				s = "J";
				break;
			case 12: 
				s = "Q";
				break;
			case 13: 
				s = "K";
				break;
			}
		}
		return s;
	}
	
	public String toString() {
		String s = this.suitToString() + this.idToString();
		return s;
	}
}

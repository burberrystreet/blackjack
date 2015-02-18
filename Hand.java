/**
 * Hand class, from scratch
 */

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Hand {
	private ArrayList<Card> hand = new ArrayList<Card>();
	private String name = "";
	private boolean bust;

	/**
	 * constructors
	 */

	public Hand() {
		
	}
	
	public Hand(String n) {
		this.setName(n);
	}

	/**
	 * get/set method
	 */

	public String getName() {
		return this.name;
	}

	public void setName(String n) {
		this.name = n;
	}

	public boolean getBust() {
		return bust;
	}
	
	public void setBust(boolean b) {
		this.bust = b;
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> c) {
		hand.clear();
		hand = c;
	}

	/**
	 * modification methods
	 */
	
	public void hit(Card c) {
		hand.add(c);
	}
	
	/**
	 * scoring method
	 */

	public int getScore() {
		int s = 0;
		int a = 0;
		int asum = 0;
		int tempsum = 0;

		for (Card c : this.getHand()) {
			if (c.getScore() > 1) {
				s += c.getScore();
			} else if (c.getScore() == 1) {
				a++;
			}
		}
		if (a>0) {
			int[] array = new int[a];
			for (int m=0;m<a;m++) {
				array[m] = 1;
			}
			for (int k=0;k<a;k++) {
				tempsum = 0;
				for (int f=0;f<a;f++) {
					tempsum += array[f];
				}
				if (s+tempsum+10<=21) {
					array[k] = 11;
				}
			}
			for (int f=0;f<a;f++) {
				asum += array[f];
			}
		}
		return s + asum;
	}

/**
 * toString methods
 */
	
	public String bustToString() {
		String str = "";
		if (this.bust==true) {
			str = "BUST";
		}
		return str;
	}
	
	public String toString() {
		String s = "";
		for (Card c : this.getHand()) {
			s += (c.toString() + " ");
			}
		return s;
	}

}

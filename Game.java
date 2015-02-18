/**
 * Game or driver class, from scratch
 */

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.lang.*;

public class Game {

	private ArrayList<Hand> players = new ArrayList<Hand>();
	private Deck cards = new Deck();
	private boolean gameover = false;
	private Hand winner = new Hand();
	
	/**
	 * constructor
	 */
	public Game() {
		
	}
	
	
	/**
	 * get/set methods
	 */
	
	public void setWinner(Hand c) {
		winner = c;
	}
	
	public Hand getWinner() {
		return winner;
	}
	
	public void setGameOver(boolean b) {
		gameover = b;
	}
	
	public boolean getGameOver() {
		return gameover;
	}
	
	/**
	 * main
	 */
	
	public static void main(String[] args) {
		Game g = new Game();
		g.players.add(new Hand("Player 1"));
		g.players.add(new Hand("Player 2"));
		g.dealTwo();
		g.checkBust();
		g.checkWinner();
		g.printArrayList(g.scoreToString());
		g.play();
	}
	
	/**
	 * interactivity
	 */
	
	public void play() {
		while (this.getGameOver()==false) {
			this.askHit();
			this.checkBust();
			this.checkWinner();
			this.printArrayList(this.scoreToString());
		}
	}
	
	public void askHit() {
		Scanner s = new Scanner(System.in);
		if (this.gameover==false) {
			for (Hand h : this.players) {
				if (h.getBust()==false) {
					System.out.println(h.getName() + ": Want to hit?");
					String str = s.nextLine();
					str = str.toUpperCase();
					char confirm = str.charAt(0);
					if (confirm=='Y') {
						h.hit(this.randomDraw());
					}
				}
			}
		}
	}
	
	/**
	 * deal/hit/draw methods
	 */
	
	public void dealTwo() {
		for (int i=0;i<2;i++) {
			this.dealOne();
		}
	}
	
	public void dealOne() {
		for (Hand h : this.players) {
			h.hit(this.randomDraw());
		}
	}
	
	public void hit(Hand h) {
		h.hit(this.randomDraw());
	}
	
	public Card randomDraw() {
		Card draw = new Card();
		int length = this.cards.getSize();
		Random rn = new Random();
		int index = rn.nextInt(length);
		draw = this.cards.getCard(index);
		this.cards.removeCard(index);
		return draw;
	}
	
	/**
	 * scoring methods
	 */
	
	public void checkBust() {
		int count = 0;
		for (Hand h : players) {
			if (h.getScore()>21) {
				h.setBust(true);
				count++;
			}
		}
	}
	
	public void checkWinner() {
		for (Hand h : players) {
			if (h.getScore()==21) {
				this.setGameOver(true);
 				this.setWinner(h);
				break;
			}
		}
		if (this.getWinner().getName()=="") {
			int num = players.size();
			int count = 0;
			for (Hand h : players) {
				if (h.getBust() == true) {
					count++;
				}
			}
			if (num-count==1) {
				this.setGameOver(true);
				for (Hand h : players) {
					if (h.getBust() == false) {
						this.setWinner(h);
						break;
					}
				}
			} else if (num-count==0) {
				this.setGameOver(true);
			}
		}
	}
	
	/**
	 * toString methods
	 */
	
	public ArrayList<String> standingToString() {
		ArrayList<String> s = new ArrayList<String>();
		for (Hand h : this.players) {
			String str = (h.getName() + " " + h.bustToString());
			s.add(str);
		}
		return s;
	}
	
	public ArrayList<String> scoreToString() {
		ArrayList<String> s = new ArrayList<String>();
		for (Hand h : this.players) {
			String str = (h.getName() + ": " + h.toString() + "- " + h.getScore() + ". " + h.bustToString());
			s.add(str);
		}
		if (this.getGameOver()==true) {
			if (this.getWinner().getName()!="") {
				s.add("GAME OVER");
				s.add("Winner is: " + this.getWinner().getName() + "!!!");
			}
		}
		return s;
	}
	
	/**
	 * print methods
	 */
	
	public void printArrayList(ArrayList<String> s) {
		for (String str : s) {
			System.out.println(str);
		}
	}
	
}

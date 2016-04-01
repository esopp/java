import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Emily Oppenheim
 * a deck of 52 cards, without Jokers.
 */
public class CardDeck { //start class
	
Scanner input = new Scanner(System.in);	
ArrayList<Card> deck = new ArrayList<Card>();
ArrayList<Card> hand = new ArrayList<Card> (); 
final private int JACK = 11; 
final private int QUEEN = 12;
final private int KING = 13;
final private int ACE = 14; 
int top = 0; //the card at the top of the deck.


/**
 * makes a CardDeck
 */
public CardDeck() { //start constructor 
	int shuffles = (int)(Math.random() * 5);
	makeDeck();
	for(int i = 0; i <= shuffles; i++) { //start 
					     //for 1
		shuffle();
	} //end for 1
} //end constructor


/**
 * fills the deck with 52 objects of the Card class.
 */
private void makeDeck(){ //start method: makeDeck
	String suit;
	int level;
	for (int i = 0; i <= 51; i++){ //start for 2
		switch(i%4) { //start switch statement 1
			      //decides suit
		case 0: suit = "HEARTS"; break;
		case 1: suit = "DIAMONDS"; break;
		case 2: suit = "SPADES"; break;
		default: suit = "CLUBS"; break;
		} //end switch statement 1

		switch(i/4) { //start switch statement 2
			      //decides level
		case 0: level = 2; break;
		case 1: level = 3; break; 
		case 2: level = 4; break;
		case 3: level = 5; break;
		case 4: level = 6; break;
		case 5: level = 7; break;
		case 6: level = 8; break;
		case 7: level = 9; break;
		case 8: level = 10; break;
		case 9: level = JACK; break;
		case 10: level = QUEEN; break;
		case 11: level = KING; break;
		default: level = ACE; break;
		} //end switch statement 2

		deck.add(new Card(suit, level));

	} //end for 2
} //end method: makeDeck

/**
 * shuffles the deck of cards.
 */
public void shuffle() { //start method: shuffle

	for(int i = 0; i <= 51; i++) { //start for: iterate through deck
		int newDeckPosition;

		if (i <= 20) { //start if 1
			newDeckPosition = (int)(Math.random() * 20) + 30;
		} //end if 1

		else { 
		newDeckPosition = (int)(Math.random() * 52);
		} 

		Card card = deck.get(i); 
		deck.remove(i);
		deck.add(newDeckPosition, card);
	} //end for: iterate through deck

	top = 0;

} //end method: shuffle


/**
 * returns the card on "top" of the deck.
 * @return the card on "top of the deck.
 */
public Card draw() { //start method: draw
	Card card = deck.get(top);
	top++;
	return card;
} //end method: draw



/**
* Prints the deck of 52 cards, for test purposes.
* Not used by the driver class.
* @return the deck of 52 cards.
*/
public String toString() { //start method: toString
	String r = ""; 

	for (int i = 0; i <= 51; i++) { //start for 4
		r = r + "\n" + deck.get(i);
	} //end for 4

	return r;

} //end method: toString

} //end class

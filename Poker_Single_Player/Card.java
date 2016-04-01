
/**
 * @author Emily Oppenheim
 * A standard poker card has a suit (ex: Hearts), 
 * and a level (ex: Queen).
 */
public class Card { //start class
	private String suit = "";
	private String level;
	private int intLevel = 0; 


/**
* a standard poker card.
* @param String the card's suit.
* @param int    the card's level.
*/	
	public Card(String s, int l) { //start constructor 
		suit = s;
		intLevel = l;
		
		switch(intLevel) { //start case statement 1
		case 2: level = " TWO"; break;
		case 3: level = " THREE"; break;
		case 4: level = " FOUR"; break;
		case 5: level = " FIVE"; break;
		case 6: level = " SIX"; break;
		case 7: level = " SEVEN"; break;
		case 8: level = " EIGHT"; break;
		case 9: level = " NINE"; break;
		case 10: level = " TEN"; break;
		case 11: level = " JACK"; break;
		case 12: level = " QUEEN"; break;
		case 13: level = " KING"; break;
		default: level = " ACE"; break;
		} //end case statement 1
			
	} //end constructor
	

/**
* Prints a String articulation of the card's suit, and the 
* card's level. 
*/
	public String toString() { //start method: toString
		String r = level + " OF " + suit;
		return r;
	} //end method: toString
	
	public boolean compareSuit(String s) { //start method:
	//compareSuit
		boolean isSameSuit;
		if (s.equals(suit)) isSameSuit = true;
		else isSameSuit = false;
		return isSameSuit;
	} //end method: compareSuit
	
	



/**
* the suit of a card.
* @return the suit.
*/
	public String getSuit() { //start method: getSuit
		return suit;
	} //end method: getSuit
	


	
/**
* the level of a card.
* @return the level.
*/
	public int getLevel() { //start method: getLevel
		return intLevel;
	} //end method: getLevel

} //end class

import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Emily Oppenheim
 * manages a poker simulation.
 */
public class PokerGame { //start class

	Scanner input = new Scanner(System.in);
	private CardDeck deck = new CardDeck();
	private ArrayList<Card> hand = new ArrayList<Card>(); 
	private int javaDollars = 0;
	private boolean greet = true;
	
/**
*constructor: PokerGame
*/
	public PokerGame() { //start constructor
		javaDollars = 25; 
	} //end constructor
	
	


/**
* Allows the user to play poker, quit, or see the rules.
*/
	public void startGame() { //start method: 
								  //showOptions
		String option = "";
		
		if (greet) { //start if greet=true
		System.out.println("Welcome to Java Poker!");
		sleep(2000);
		greet = false;
		} //end if greet=true
		
		while(true) { //start game loop

		if (javaDollars == 0) break; //player runs out of money, allow menu cycle to terminate when control is returned from the play() method

		System.out.println("You have: " + javaDollars 
				+ " Java Dollars.");
		sleep(2000);
		System.out.println("What would you like to do?");
		sleep(1000);
		System.out.println("OPTIONS:");
		System.out.println("Type 1) To Play (costs 1 Java Dollar).");
		System.out.println("Type 2) To Quit.");
		System.out.println("Type 3) To See The Rules.");
		option = input.next();
		
		if (option.equals("1")) { //start if selected: 1) Play
			javaDollars = javaDollars - 1;
			play();
		} //end if selected: 1) Play
		
		else if (option.equals("2")) { //start else if selected: 2) Quit
			sleep(2000);
			System.out.println("Bye!");
			break;
		} //end else if selected: 2) Quit
		
		else if (option.equals("3")) { //start else if selected: 3) View Rules
			sleep(2000);
			System.out.println(" ");
			System.out.println("********************************************");
			System.out.println("1) You can exchange any number of cards");
			System.out.println("from the first hand you draw (including 0).");
			System.out.println("2) WINNING HANDS:");
			System.out.println("   ROYAL FLUSH (worth 250 Java Dollars)");
			System.out.println("     A TEN, JACK, QUEEN, KING, and ACE,");
			System.out.println("     all in  the same suit.");
			System.out.println(" ");
			System.out.println("   STRAIGHT FLUSH (worth 50 Java Dollars)");
			System.out.println("     Five cards, of consecutive values, all");
			System.out.println("     in the same suit.");
			System.out.println(" ");
			System.out.println("   FOUR OF A KIND (worth 25 Java Dollars)");
			System.out.println("     Four cards with the same value."); 
			System.out.println(" ");
			System.out.println("   FULL HOUSE (worth 6 Java Dollars)");
			System.out.println("     One PAIR, and one THREE OF A KIND.");
			System.out.println(" ");
			System.out.println("   FLUSH (worth 5 Java Dollars)");
			System.out.println("     Five cards of the same suit.");
			System.out.println(" ");
			System.out.println("   STRAIGHT (worth 4 Java Dollars)"); 
			System.out.println("     Five cards of consecutive values.");
			System.out.println(" ");
			System.out.println("   TWO PAIR (worth 3 Java Dollars)");
			System.out.println("     Two PAIRs.");
			System.out.println(" ");
			System.out.println("   THREE OF A KIND (worth 2 Java Dollars)");
			System.out.println("     Three cards with the same value.");
			System.out.println(" "); 
			System.out.println("   PAIR"); 
			System.out.println("     Two cards with the same value. Worth");
			System.out.println("     1 Java Dollar if the level of the pair");
			System.out.println("     is JACK or better.");
			System.out.println("*************************************************");
			System.out.println(" ");
			sleep(3000);
		} //end else if selected: 3) View Rules
		
		else { //start else user input/selected invalid menu option
			System.out.println("Not an option.");
			sleep(2000);
		} //end else user input/selected invalid menu option

		} //end game loop
	} //end method: showOptions
	
	

/**
* Manages one round of poker (one hand).
*/
	private void play() { //start method: play
		deck.shuffle();
		System.out.println("YOU'VE DRAWN:");
		drawHand();
		sort();
		showHand(); 
		exchange();
		outcome();
		emptyHand();
	} //end method: play




/**
* Draws a hand of five cards from the deck.
*/
	private void drawHand() { //start method: drawHand
		for (int i = 0; i <= 4 ; i++) { //start drawing five cards for the user's hand
			hand.add(deck.draw());
		} //finish drawing five cards for the users's hand 
	} //end method: drawHand
	



/**
* Empties the ArrayList, hand.
*/
	private void emptyHand() { //start method: emptyHand
		hand = new ArrayList<Card>();
	} //end method: emptyHand
	


/**
* prints the contents of the ArrayList, hand. 
*/
	private void showHand() { //start method: showHand
			for(int i = 0; i <= 4; i++) { //start printing each card
			Card card = hand.get(i);
			System.out.println((i + 1) + ". " + card);
		} //finish printing each card
	} //end method: showHand
	



/**
* exchanges a user-specified number of Cards in the ArrayList,
* hand, for a Card from the deck. 
*/
	public void exchange() { //start method: exchange
		String strTrade = "";
		int trade = 0;
		String cardPosition;
		ArrayList<Integer> placeInHand = new ArrayList<Integer>(); //keeps track of the trades that have already occured
		
		while(true) { //start while loop to prompt user to give valid number of cards to exchange 
		System.out.println("How many cards would you" +
				" like to exchange?");
		System.out.println("(Enter a number from 0 to 5)");
		strTrade = input.next(); 

		if (strTrade.equals("0")) break; 

		else if (isOneThroughFive(strTrade)) break;

		else { 
			System.out.println("Not an option.");
			sleep(1000);
		} 
		} //end while loop to prompt user to give valid number of cards to exchange
	

		if (isOneThroughFive(strTrade)) { //if user wants to exchange any cards
		
		trade = Integer.parseInt(strTrade);
		
		for (int i = 0; i < trade; i++) { //trade one card at a time until the specified number of cards have been traded

			while(true) { //start while loop that only allows next trade to occur if the current trade is valid
			System.out.println("Enter the number of a card");
			System.out.println("you would like to exchange:");
			cardPosition = input.next();
			
			if (isOneThroughFive(cardPosition)) { //if: user input is a valid position in the hand
				boolean isRepeat = false;
				
				for (int j = 0; j < i; j++) { //iterate through placeInHand to see if selected traded has already occurred 
					if(Integer.parseInt(cardPosition) == 
					placeInHand.get(j)) { //start if: user has already traded the card at cardPosition
						isRepeat = true; 
					} //end if: user has already traded the card at cardPosition
				} //iterated through placeInHand

				if (isRepeat) { //start if: input is invalid because the card at cardPosition has already been traded
					System.out.println("You have already selected"
							+ "that card.");
					sleep(500);
				} //end if: input is invalid


				else { //start else: user input is a valid position in the hand and trade has not already occured 
					int intCardPosition = 
						Integer.parseInt(cardPosition);
					placeInHand.add(intCardPosition);
					hand.remove(intCardPosition - 1);
					hand.add((intCardPosition- 1), deck.draw());
					break;
				} //end else: user input is valid position and trade has not already occured

			} //end if: user input is a valid position in hand 

			else { //else: user input is not a valid position in the hand of cards
				System.out.println("Not an option.");
				sleep(1000);
			} //end else: user input is not a valid position in the hand of cards

			} //end while loop that only allows the next trade to occur if the current trade is valid

		} //finish trading the specified number of cards

		sleep(1000);
		System.out.println("YOUR NEW HAND:");
		sort();
		showHand();

		} //end if user wants to exchange any cards.

		else sleep(1000); //sleep but do not reprint deck if user chose not to exchange any cards

	} //end method: exchange
	


/**
* Determines whether a String has an integer value from 1 to 5.
* @param String, num, a String provided by the user.
* @return boolean, isValid, is num an integer from 1 to 5.
*/
	private boolean isOneThroughFive(String num) { //start method: 
						       //isOneThroughFive
		return  num.equals("1") || num.equals("2") 
				|| num.equals("3") || num.equals("4") 
				|| num.equals("5");

	} //end method: isOneThroughFive
	
	
/**
* determines the outcome of the game.
*/
	private void outcome() { //start method: outcome
		boolean straight = true; //will be set to false if the hand is not a straight
		boolean flush = true; //will be set to false if the hand is not a flush
		boolean endMatch = true; //set to false when the card being compared is not part of an ongoing matching streak;
		int match1 = 0;
		int match2 = 0;
		int startOfStraight = 0;
		int levelOfMatch = 0;
		for(int i = 0; i < 4; i++) { //start iterating through entire hand
			Card first = hand.get(i);
			int lastLevel = first.getLevel();
			int startOfMatch = i; 
			int endOfMatch = i;
			for(int j = i + 1; j <= 4; j++) { //start iterating through part of hand being compared to "first"
				
				Card next = hand.get(j);
				
				if (straight) { //if: straight-- check if straight should still be true
					if ((next.getLevel() - lastLevel) == 1) { //if: straight should still be true
						lastLevel = next.getLevel();
					} //end if: straight should still be true

				//else if (j == 3 && lastLevel == 5); //if comparing last card in hand

				else straight = false;

				} //end if straight
				
				
				if(flush) { //if: flush-- check if flush should still be true

					if (!first.compareSuit(next.getSuit())) flush = false;

				} //end if: flush
				
				
				if (first.getLevel() != next.getLevel()
						&& endMatch) {  //if current "next" does not match the level of "first"
					endOfMatch = j - 1;
					endMatch = false;
				} 
				
				
				else if (first.getLevel() == next.getLevel()
						&& j == 4) { //if current "next" is also the current end of a match, 
									 //endMatch stays true (basically  saying "this is the last matching card so far")
									 //but keep searching to extend the match
					endOfMatch = j;
				} 
				
			
			} //end of for loop iterating through part of hand being compared to "first"

			if (flush || straight) {
				startOfStraight = first.getLevel();
				break;
			}
			else if (match1 == 0) {
				match1 = endOfMatch - startOfMatch;
				levelOfMatch = first.getLevel();
			}
			else if (match2 == 0) {
				match2 = endOfMatch - startOfMatch;
			}
			endMatch = true;
			i = endOfMatch;
		} //end of for loop iterating through entire hand

		if (flush) { //start if: hand is a flush
			if (straight) { //start if: hand is a straight
				if (startOfStraight == 10) { //start if: royal flush
					System.out.println("That's a "
						+ "ROYAL FLUSH!");
					System.out.println("Worth " 
							+ "250 Java Dollars.");
					javaDollars = javaDollars + 250;
				} //end if: royal flush
				else { //straight flush, but not a royal flush
					System.out.println("That's a "
							+ "STRAIGHT FLUSH!");
						System.out.println("Worth " 
								+ "50 Java Dollars.");
						javaDollars = javaDollars + 50;
				} //straight flush
			} //end if: straight
			else { //hand is a flush, but not a straight
				System.out.println("That's a "
						+ "FLUSH!");
					System.out.println("Worth " 
							+ "5 Java Dollars.");
					javaDollars = javaDollars + 5;
			} //else hand is a flush but not a straight
		} //end if: hand is a flush

		else if (straight) { //start else if: hand is a straight but not a flush
			System.out.println("That's a "
					+ "STRAIGHT!");
				System.out.println("Worth " 
						+ "4 Java Dollars.");
				javaDollars = javaDollars + 4;
		} //hand is a straight but not a flush

		else if (match1 >= 1) { //start else: hand has at least a pair
			if (match2 >= 1) { //start if: hand has two pairs
				if (match1 >= 2 || match2 >= 2) { //start if: hand is a full house
					System.out.println("That's a "
							+ "FULL HOUSE!");
						System.out.println("Worth " 
								+ "6 Java Dollars.");
						javaDollars = javaDollars + 6;
				} //end if: full house
				else { //start else: two pair, but not a full house
					System.out.println("That's "
							+ "TWO PAIR!");
						System.out.println("Worth " 
								+ "2 Java Dollars.");
						javaDollars = javaDollars + 2;
				} //end else: two pair, but not a full house
			} //end if: two pair

			else if (match1 == 3) { 
				System.out.println("That's FOUR "
						+ "OF A KIND!");
					System.out.println("Worth " 
							+ "25 Java Dollars.");
					javaDollars = javaDollars + 25;
			} 

			else if (match1 == 2) { 
				System.out.println("That's THREE "
						+ "OF A KIND!");
					System.out.println("Worth " 
							+ "3 Java Dollars.");
					javaDollars = javaDollars + 3;
			} 

			else if (levelOfMatch >= 11) { 
				System.out.println("That's only a "
						+ "PAIR, but because its a ");
				System.out.println("pair of Jacks " 
						+ "or better, you break even");
				System.out.println("for this round.");
					System.out.println("Worth " 
							+ "1 Java Dollar.");
					javaDollars = javaDollars + 1;
			} 

			else { //user did not get any JavaDollars
				if (javaDollars == 0) { //alert user to game over: user is out of money
					System.out.println("WAAAAH!!!!!!");
					sleep(1000);
					System.out.println("You've bet all your"
							+ "money away, you");
					System.out.println("GAMBLING FIEND!!!"); 
					sleep(2000);
					System.out.println("Let this be a lesson"
							+" to you!");
					sleep(2000);
					System.out.println("GAME OVER");
				} //game over
				else { //tell user that they did not win Java Dollars
					System.out.println("Just a PAIR won't" 
							+ " get you anything, you know...");
				} 
			} //else: user did not get any Java Dollars
		} //end else if: user had at least a pair
		
		else { //user did not have a winning hand, didn't get any Java Dollars
			if (javaDollars == 0) { //start if game over 
				System.out.println("WAAAAH!!!!!!");
				sleep(1000);
				System.out.println("You've bet all your"
						+ "money away, you");
				System.out.println("GAMBLING FIEND!!!"); 
				sleep(2000);
				System.out.println("Let this be a lesson"
						+" to you!");
				sleep(2000);
				System.out.println("GAME OVER");
			} //end if: game over
			else { //start else: losing hand, not game over
				System.out.println("That's, erm... well, I'm"
						+ " afraid that's nothing at all.");
				sleep(1000);
			} //end else: losing hand, not game over
		} //end else: user did not have a winning hand, did not get any java dollars

	} //end method: outcome
	
	
	
	/**
	 * Sorts hand, by level. 
	 */
	public void sort() { //start method: sort 
		for(int i = 0; i < 4; i++) { //start for: iterate through entire hand
			Card first = hand.get(i);
			
			for(int j = i + 1; j <=4; j++) { //start for: iterate through part of hand being compared
			 Card compare = hand.get(j);
			 int compareLevel = compare.getLevel();
			 int firstLevel = first.getLevel();
			 if (firstLevel > compareLevel) { //start if: compared card should come before first
			 first = compare; 
			 hand.remove(j);
			 hand.add(i, compare);
			 } //end if: compared card should come before first
			} //end for: iterate through part of hand being compared
		
		} //end for: iterate through entire hand
	} //end method: sort
	
	
	
	/**
	 * Stalls the program, so that the user has time to read the text.
	 * @param time int, indicates the amount of time the pause should last.
	 */
	public void sleep(int time){ //start method: sleep
		try { //start try
			 Thread.sleep(time);
			} //end try
		catch(InterruptedException e) { //start catch
				e.printStackTrace();
			} //end catch
	} //end method: sleep
	
} //end class

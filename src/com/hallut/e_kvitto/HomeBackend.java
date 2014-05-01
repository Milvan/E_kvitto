package com.hallut.e_kvitto;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;


public class HomeBackend {

	private LinkedList<CreditCard> cards; // can be empty if no credit cards exists on user.
	private CreditCard currentCard; //can be null if no creditcards exist on user
	private Iterator<CreditCard> cardIterator;
	private Database db;
	
	/**
	 * Sets up a backend precessor for the HomeScreen.
	 * @param c
	 */
	public HomeBackend(){
		db = Database.getDatabase();
	}
	
	/**
	 * Loads info from the database, stores in local variables.
	 */
	public void loadInfo(){
		getCards();
		
		cardIterator = cards.iterator();
		try{
			currentCard = cardIterator.next();
		} catch (EmptyStackException e){
			
		}
		
	}

	/**
	 * Gets a String description of the users current card.
	 * @return A String representation of the next credit card
	 */
	public String getCurrentCard(){
		return currentCard.toString();
	}
	
	/**
	 * Gets the next card for the user.
	 * @return A String representation of the next credit card
	 * @throws Throws EmptyStackException if there are no available cards for the user.
	 */
	public String getNextCard() throws EmptyStackException{
		if(cardIterator.hasNext()){
			return cardIterator.next().toString();
		}else{
			cardIterator = cards.iterator();
			if(cardIterator.hasNext()){
				return cardIterator.next().toString();
			}else {
				throw new EmptyStackException();
			}
		}
	}
	
	/**
	 * Gets credit cards from database and stores in local cards[].
	 */
	private void getCards(){
		//connect to db
		cards = db.getCards("test@");// query for cards
		//close/disconnect from db
	}
}

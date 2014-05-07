package com.hallut.e_kvitto;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;


public final class HomeBackend {

	private static HomeBackend HB;
	
	private LinkedList<CreditCard> cards; // can be empty if no credit cards exists on user.
	private CreditCard currentCard; //can be null if no creditcards exist on user
	private Iterator<CreditCard> cardIterator;
	private Database db;
	
	/**
	 * Sets up a backend precessor for the HomeScreen.
	 * @param c
	 */
	private HomeBackend(){
		db = Database.getDatabase();
	}
	
	/**
	 * Returns this HomeBackend object
	 * @return This unique HomeBackend object.
	 */
	public static HomeBackend getHomeBackend(){
		if(HB!=null){
			return HB;
		}else {
			HB = new HomeBackend();
			return HB;
		}
			
	}
	
	
	/**
	 * Loads info from the database, stores in local variables.
	 */
	public void loadInfo(String user){
		getCards(user);
		
		cardIterator = cards.iterator();
		try{
			currentCard = cardIterator.next();
		} catch (EmptyStackException e){
			
		}
		
	}

	/**
	 * Gets the current selected card
	 * @return The credit card that is currently selected.
	 */
	public CreditCard getCurrentCard(){
			return currentCard;
	}
	
	/**
	 * Sets the current card to the one specified.
	 */
	public void setCurrentCard(CreditCard card){
		currentCard=card;
	}
	
	/**
	 * Gets the users list of cards
	 */
	public LinkedList<CreditCard> getUsersCards(){
		return cards;
	}
	
	/**
	 * Gets the next card for the user.
	 * @return A String representation of the next credit card
	 * @throws Throws EmptyStackException if there are no available cards for the user.
	 */
	public CreditCard getNextCard() throws EmptyStackException{
		if(cardIterator.hasNext()){
			return cardIterator.next();
		}else{
			cardIterator = cards.iterator(); // starts to iterate from beginning again.
			if(cardIterator.hasNext()){
				return cardIterator.next();
			}else {
				throw new EmptyStackException();
			}
		}
	}
	
	/**
	 * Gets credit cards from database and stores in local cards[].
	 */
	private void getCards(String user){
		//connect to db
		cards = db.getCards(user);// query for cards
		//close/disconnect from db
	}
}

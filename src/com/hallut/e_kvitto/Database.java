package com.hallut.e_kvitto;

import java.util.HashMap;
import java.util.LinkedList;


/**
 * This is a local database on the phone that should simulate the public database that this application should be connected to later.
 * @author Marcus
 *
 */
public final class Database {
	
	private static Database DB;
	
	//TABLES
	private HashMap<String, LinkedList<CreditCard>> cards;
	private HashMap<CreditCard, LinkedList<Receipt>> receipts;
	
	
	
	private Database(){
		cards = new HashMap<String, LinkedList<CreditCard>>();
		receipts = new HashMap<CreditCard, LinkedList<Receipt>>();
		fillDatabase();
	}
	
	private void fillDatabase(){
		fillCards();
		fillReceipts();
	}
	
	/**
	 * This method will fill the database with static credit card information.
	 */
	private void fillCards(){
		LinkedList<CreditCard> list = new LinkedList<CreditCard>();
		list.add(new CreditCard("5295768101681568", "Pelle Svanslös", 1 ,16, 654, "MasterCard", "Ticket Rikskortet"));
		list.add(new CreditCard("4865135008460565", "Pelle Svanslös", 8, 16, 785, "Visa", "SEB", "IVaE Consultants"));
		cards.put("123456789012", list);
		
		LinkedList<CreditCard> list2 = new LinkedList<CreditCard>();
		list2.add(new CreditCard("7865156765820645", "Maja Gräddnos", 2, 15, 657, "American Express", "Amex"));
		cards.put("123123123123", list2);
	}
	
	/**
	 * This method will fill the database with static receipt information.
	 */
	private void fillReceipts(){
		CreditCard card = cards.get("123456789012").getFirst();
		String date = "2014-04-22";
		Article[] articles1 = new Article[]{new Article("Mellanmj�lk", 12.9 , 1.548), new Article("Gurka", 10.90, 1.308), new Article("Plastkasse", 2, 0.5)};
		Article[] articles2 = new Article[]{new Article("SD kort 4GB", 499.0, 125.0)};
		addReceipt(2833, "ICA Kvantum", date, "19:24", "282", "6293-012019", card, articles1);
		addReceipt(2830, "Konsum", date, "19:00", "280", "6293-012010", card, articles1);
		addReceipt(1023, "Mediamarkt", "2014-04-25", "17:10", "19", "123-2314", card, articles2);
		addReceipt(1023, "Elgiganten", "2014-04-24", "17:17", "12", "3463-25321", card, articles2);
	}
	
	/**
	 * Returns this database object
	 * @return This unique database object.
	 */
	public static Database getDatabase(){
		if(DB!=null){
			return DB;
		}else {
			DB = new Database();
			return DB;
		}
			
	}
	
	/**
	 * Returns a list of credit cards that belongs to the user
	 * @param userID The user id.
	 * @return A list of the users credit cards.
	 */
	public LinkedList<CreditCard> getCards(String userID){
		LinkedList<CreditCard> cardList = cards.get(userID);
		if (cardList!=null){
			return cardList;
		} else {
			return new LinkedList<CreditCard>();
		}
	}
	
	/**
	 * Returns a list of all receipts for a specific credit card
	 * @param card The credit card.
	 * @return List of all receipts linked to the card. 
	 */
	public LinkedList<Receipt> getReceipts(CreditCard card){
		LinkedList<Receipt> receiptList = receipts.get(card);
		if (receiptList!=null){
			return receipts.get(card);
		} else {
			return new LinkedList<Receipt>();
		}
		
	}
	
	/**
	 * Add a new receipt to the Database.
	 * @param id
	 * @param company
	 * @param date
	 * @param time
	 * @param sellerID
	 * @param terminalID
	 * @param card
	 * @param articles
	 * @return true if receipt was successfully added, else false.
	 */
	public boolean addReceipt(long id, String company, String date, String time, String sellerID, String terminalID, CreditCard card, Article[] articles){
		if(card==null){
			return false;
		}
		LinkedList<Receipt> rec = receipts.get(card);
		if (rec==null){
			rec = new LinkedList<Receipt>();
			rec.add(new Receipt(id, company, date, time, sellerID, terminalID, card, articles));
			
			receipts.put(card, rec);
			return true;
		} else {
			rec.add(new Receipt(id, company, date, time, sellerID, terminalID, card, articles));
			receipts.put(card, rec);
			return true;
		}
	}
	

}

package com.hallut.e_kvitto;

import java.util.HashMap;
import java.util.LinkedList;


/**
 * This is a local database on the phone that should simulate the public database that this application should be connected to later.
 * @author Marcus
 *
 */
public class Database {
	
	private static Database DB;
	
	//TABLES
	// Credit cards mapped on userID Hashmap<userID, CreditCard[]> better with non-array, gotta be possible to add more cards delete. nn finding cards.Iterate will be fine.
	private HashMap<String, LinkedList<CreditCard>> cards;
	// Receipts mapped on credit cards
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
	
	private void fillCards(){
		LinkedList<CreditCard> list = new LinkedList<CreditCard>();
		list.add(new CreditCard("5295768101681568", "Pelle Svanslös", 1 ,16, 654, "MasterCard", "Ticket Rikskortet"));
		list.add(new CreditCard("4865135008460565", "Pelle Svanslös", 8, 16, 785, "Visa", "SEB", "IVaE Consultants"));
		cards.put("test@", list);
		
		LinkedList<CreditCard> list2 = new LinkedList<CreditCard>();
		list2.add(new CreditCard("7865156765820645", "Maja Gräddnos", 2, 15, 657, "American Express", "Amex"));
		cards.put("foo@example.com", list2);
	}
	
	private void fillReceipts(){
		LinkedList<Receipt> receiptList = new LinkedList<Receipt>();
		
		CreditCard card = cards.get("test@").getFirst();
		String date = "2014-04-22";
		Article[] articles1 = new Article[]{new Article("Mellanmjölk", 12.9 , 1.548), new Article("Gurka", 10.90, 1.308), new Article("Plastkasse", 2, 0.5)};
		receiptList.add(new Receipt(2833, "ICA Kvantum", date, "19:24", "282", "6293-012019", card, articles1));
		
		receipts.put(card, receiptList);
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
		return cards.get(userID);
	}
	
	/**
	 * Returns a list of all receipts for a specific credit card
	 * @param card The credit card.
	 * @return List of all receipts linked to the card.
	 */
	public LinkedList<Receipt> getReceipts(CreditCard card){
		return receipts.get(card);
	}
	

}

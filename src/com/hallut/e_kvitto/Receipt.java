package com.hallut.e_kvitto;

import java.io.Serializable;


/**
 * This class is used to hold information about receipts.
 *
 */
public class Receipt implements Serializable{
	
	private long ID;
	private String company, date, time, sellerID, terminalID; 
	private CreditCard card;
	private Article[] articles;
	private double totalSum;
	
	/**
	 * Constructor of Receipt, set all the required information that is needed for a receipt
	 * 
	 * @param ID set the receipt id
	 * @param company set where the receipt is bought
	 * @param date set when the receipt is made
	 * @param time set when the receipt is made
	 * @param sellerID set the id of the seller
	 * @param terminalID set the id of the terminal which sent the receipt to the database
	 * @param card set the card, which the receipt belongs to
	 * @param articles set all the articles to the receipt
	 */
	public Receipt(long ID, String company, String date, String time, String sellerID, String terminalID, CreditCard card, Article[] articles){
		this.ID = ID;
		this.company = company;
		this.date = date;
		this.time = time;
		this.sellerID = sellerID;
		this.terminalID = terminalID;
		this.card = card;
		this.articles = articles;
		totalSum = totalSum();
	}
	
	/** 
	 * @return total sum of all articles
	 */
	private double totalSum(){
		double sum=0;
		for(Article a : articles){
			sum+=a.getPrice();
		}
		return sum;
	}

	/**
	 * @return the iD
	 */
	public long getID() {
		return ID;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @return the sellerID
	 */
	public String getSellerID() {
		return sellerID;
	}

	/**
	 * @return the terminalID
	 */
	public String getTerminalID() {
		return terminalID;
	}

	/**
	 * @return the card
	 */
	public CreditCard getCard() {
		return card;
	}

	/**
	 * @return the totalSum
	 */
	public double getTotalSum() {
		return totalSum;
	}

	/**
	 * @return the articles
	 */
	public Article[] getArticles() {
		return articles;
	}
	
	/**
	 * Returns a string representation of this Receipt.
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Id: ");
		sb.append(ID);
		sb.append("\n");
		sb.append("Summa: ");
		sb.append(totalSum);
		return sb.toString();
	}

}

package com.hallut.e_kvitto;

public class Receipt {
	
	private final long ID;
	private final String company, date, time, sellerID, terminalID; 
	private final CreditCard card;
	private final Article[] articles;
	private final double totalSum;
	
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

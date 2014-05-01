package com.hallut.e_kvitto;

public class CreditCard {
	private final String cardNumber, owner, company, type, bank;
	private final int month, year, cvv;
	
	/**
	 * Only for coding. All parameters except cardnumber set to null.
	 * @param itemId
	 */
	public CreditCard(String cardNumber){
		this.cardNumber = cardNumber;
		this.owner = null;
		this.month = 0;
		this.year = 0;
		this.cvv = 0;
		this.type = null;
		this.bank = null;
		this.company = null;
	}
	
	/**
	 * 
	 * @param cardNumber
	 * @param owner
	 * @param month
	 * @param year
	 * @param cvv
	 * @param type E.g. Visa or Mastercard
	 * @param bank
	 */
	public CreditCard(String cardNumber, String owner, int month, int year, int cvv, String type, String bank){
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.month = month;
		this.year = year;
		this.cvv = cvv;
		this.type = type;
		this.bank = bank;
		this.company = null; //unspecified, all personal cards, non-company cards.
	}
	
	/**
	 * 
	 * @param cardNumber
	 * @param owner
	 * @param month
	 * @param year
	 * @param cvv
	 * @param type E.g. Visa or Mastercard
	 * @param bank 
	 * @param company
	 */
	public CreditCard(String cardNumber, String owner, int month, int year, int cvv, String type, String bank, String company){
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.month = month;
		this.year = year;
		this.cvv = cvv;
		this.type = type;
		this.bank = bank;
		this.company = company;
	}
	
	/**
	 * 
	 * @return the card number
	 */
	public String getCardNumber(){
		return this.cardNumber;
	}
	
	
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the bank
	 */
	public String getBank() {
		return bank;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the cvv
	 */
	public int getCvv() {
		return cvv;
	}

	public String toString(){
		return cardNumber;
	}

}

package com.hallut.e_kvitto;

import java.io.Serializable;


public class Article implements Serializable{
	
	private final String name;
	private final double price, tax;

	public Article(String name, double price, double tax){
		this.name = name;
		this.price = price;
		this.tax = tax;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the tax
	 */
	public double getTax() {
		return tax;
	}
	
	/**
	 * Returns a string description of this article
	 */
	public String toString(){
		return name + " " + price + " varav moms: " +tax; 
	}

}

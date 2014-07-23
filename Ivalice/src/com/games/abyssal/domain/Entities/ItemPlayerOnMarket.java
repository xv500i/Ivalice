package com.games.abyssal.domain.Entities;

import java.util.Date;

/**
 * Represents an item that is being sold.
 * @author alex
 *
 */
public class ItemPlayerOnMarket extends Entity{
	
	/** The date when was submitted */
	private Date submitedOn;
	
	/** The initial price imposed by the player */
	private int initialPrice;
	
	/** The player's instance of the item */
	private ItemOnPlayer item;
	
	/**
	 * @param submitedOn
	 * @param initialPrice
	 * @param item
	 */
	public ItemPlayerOnMarket(Date submitedOn, int initialPrice,
			ItemOnPlayer item) {
		super();
		this.submitedOn = submitedOn;
		this.initialPrice = initialPrice;
		this.item = item;
	}

	/**
	 * @return the submitedOn
	 */
	public Date getSubmitedOn() {
		return submitedOn;
	}
	
	/**
	 * @param submitedOn the submitedOn to set
	 */
	public void setSubmitedOn(Date submitedOn) {
		this.submitedOn = submitedOn;
	}
	
	/**
	 * @return the initialPrice
	 */
	public int getInitialPrice() {
		return initialPrice;
	}
	
	/**
	 * @param initialPrice the initialPrice to set
	 */
	public void setInitialPrice(int initialPrice) {
		this.initialPrice = initialPrice;
	}
	
	/**
	 * @return the item
	 */
	public ItemOnPlayer getItem() {
		return item;
	}
	
	/**
	 * @param item the item to set
	 */
	public void setItem(ItemOnPlayer item) {
		this.item = item;
	}
	
	@Override
	public Long getId() {
		return item.getId();
	}
	
	/**
	 * @return the item's name
	 */
	public String getName() {
		return item.getName();
	}

	
}

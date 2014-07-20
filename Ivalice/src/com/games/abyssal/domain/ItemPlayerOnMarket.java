package com.games.abyssal.domain;

import java.util.Date;

public class ItemPlayerOnMarket extends Entity{
	private Date submitedOn;
	private int initialPrice;
	private ItemOnPlayer item;
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
	public Long getId() {
		return item.getId();
	}
	public String getName() {
		return item.getName();
	}

	
}

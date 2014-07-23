package com.games.abyssal.domain.Entities;

/**
 * Represents a general item that players can acquire and trade.
 * @author alex
 *
 */
public class Item extends Entity {
	
	/**
	 * Basic constructor.
	 * @param id the id
	 * @param name the name
	 * @param description the description
	 * @param price the price
	 */
	public Item(long id, String name, String description, int price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	/** The id */
	private long id;
	
	/** The item's name */	
	private String name;
	
	/** The description */
	private String description;
	
	/** The price */
	private int price;
	
	@Override
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
}

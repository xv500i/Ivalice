package com.games.abyssal.Domain.Entities;

import java.util.Collection;

public class Recipe extends Entity {
	
	/**
	 * @param id
	 * @param itemLines
	 */
	public Recipe(long id, Collection<ItemLine> itemLines) {
		super();
		this.id = id;
		this.itemLines = itemLines;
	}


	private long id;
	private Collection<ItemLine> itemLines;
	
	@Override
	public Long getId() {
		return id;
	}
	
	
	public class ItemLine {
		public Item item;
		public int amount;
	}


	/**
	 * @return the itemLines
	 */
	public Collection<ItemLine> getItemLines() {
		return itemLines;
	}


	/**
	 * @param itemLines the itemLines to set
	 */
	public void setItemLines(Collection<ItemLine> itemLines) {
		this.itemLines = itemLines;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
}

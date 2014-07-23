package com.games.abyssal.Domain.Entities;

import java.util.Date;

/**
 * Represents an item instance owned by some player.
 * @author alex
 *
 */
public class ItemOnPlayer extends Entity{

	/** The acquisition date */
	private Date adquiredOn;
	
	/** The unique instance id between all items on players */
	private long instanceId;
	
	/** The item owned */
	private Item item;
	
	/** The player who owns the item */
	private Player player;
	
	/** The instance of the item on the market or null */
	private ItemPlayerOnMarket itemOnMarket;
	
	
	public ItemOnPlayer(Date adquiredOn, long instanceId, Item item,
			Player player, ItemPlayerOnMarket itemOnMarket) {
		super();
		this.adquiredOn = adquiredOn;
		this.instanceId = instanceId;
		this.item = item;
		this.player = player;
		this.itemOnMarket = itemOnMarket;
	}

	/**
	 * @return the adquiredOn
	 */
	public Date getAdquiredOn() {
		return adquiredOn;
	}
	
	/**
	 * @param adquiredOn the adquiredOn to set
	 */
	public void setAdquiredOn(Date adquiredOn) {
		this.adquiredOn = adquiredOn;
	}
	
	/**
	 * @return the instanceId
	 */
	public Long getId() {
		return instanceId;
	}
	
	/**
	 * @param instanceId the instanceId to set
	 */
	public void setId(long instanceId) {
		this.instanceId = instanceId;
	}
	
	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}
	
	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	
	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return item.getName();
	}

	/**
	 * @return the instanceId
	 */
	public long getInstanceId() {
		return instanceId;
	}

	/**
	 * @param instanceId the instanceId to set
	 */
	public void setInstanceId(long instanceId) {
		this.instanceId = instanceId;
	}

	/**
	 * @return the itemOnMarket
	 */
	public ItemPlayerOnMarket getItemOnMarket() {
		return itemOnMarket;
	}

	/**
	 * @param itemOnMarket the itemOnMarket to set
	 */
	public void setItemOnMarket(ItemPlayerOnMarket itemOnMarket) {
		this.itemOnMarket = itemOnMarket;
	}

}

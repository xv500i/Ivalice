package com.games.abyssal.domain;

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

}

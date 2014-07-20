package com.games.abyssal.domain;

import java.util.Date;

public class ItemOnPlayer extends Entity{

	private Date adquiredOn;
	private long instanceId;
	
	private Item item;
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
	public String getName() {
		return item.getName();
	}
	
	
}

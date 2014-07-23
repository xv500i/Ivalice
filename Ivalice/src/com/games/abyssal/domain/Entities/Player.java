package com.games.abyssal.domain.Entities;

import java.util.Collection;

/**
 * Represents a player info
 * @author alex
 *
 */
public class Player extends Entity {

	/**
	 * Basic constructor
	 * @param id the identifier
	 * @param login the login
	 */
	public Player(long id, String login, Collection<ItemOnPlayer> items) {
		super();
		this.id = id;
		this.login = login;
		this.items = items;
	}

	/** The identifier */
	private long id;
	
	/** The login */
	private String login;
	
	/** The items of the player */
	private Collection<ItemOnPlayer> items;

	/**
	 * @return the id
	 */
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
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the items
	 */
	public Collection<ItemOnPlayer> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Collection<ItemOnPlayer> items) {
		this.items = items;
	}
	
}

package com.games.abyssal.domain;

import java.util.Collection;

public class Player {

	private long id;
	private String login;
	
	private Collection<ItemOnPlayer> items;

	/**
	 * @return the id
	 */
	public long getId() {
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

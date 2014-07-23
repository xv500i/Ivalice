package com.games.abyssal.Domain.EntityManagers;

import com.games.abyssal.Domain.Entities.Item;

/**
 * Item manager.
 * @author alex
 *
 */
public class ItemManager extends HashMapEntityManager<Item, Long>{
	
	/** The instance of the singleton */
	private static ItemManager instance;
	
	/**
	 * Basic constructor
	 */
	private ItemManager()
	{
		super();
		entities.put(0L, new Item(0L, "Wooden Sword", "The wooden sword is the basic sword", 100));
	}
	
	/**
	 * Instance accessor
	 * @return the instance
	 */
	public static ItemManager getInstance()
	{
		if (instance == null) instance = new ItemManager();
		return instance;
	}

}

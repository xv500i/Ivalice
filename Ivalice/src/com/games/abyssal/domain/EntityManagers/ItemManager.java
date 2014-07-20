package com.games.abyssal.domain.EntityManagers;

import com.games.abyssal.domain.Item;

public class ItemManager extends HashMapEntityManager<Item, Long>{
	
	private static ItemManager instance;
	
	private ItemManager()
	{
		super();
		entities.put(0L, new Item(0L, "Wooden Sword", "The wooden sword is the basic sword", 100));
	}
	
	public static ItemManager getInstance()
	{
		if (instance == null) instance = new ItemManager();
		return instance;
	}

}

package com.games.abyssal.Domain.EntityManagers;

import java.util.ArrayList;

import com.games.abyssal.Domain.Entities.ItemOnPlayer;
import com.games.abyssal.Domain.Entities.Player;
import com.games.abyssal.Domain.Events.NewPlayerEvent;
import com.games.abyssal.Domain.Events.Observer;
import com.games.abyssal.Domain.Events.PlayerDeletedEvent;

/**
 * Player manager
 * @author alex
 *
 */
public class PlayerManager extends HashMapEntityManager<Player, Long>{

	/** The instance of the singleton */
	private static PlayerManager instance;
	
	/**
	 * Basic constructor
	 */
	private PlayerManager()
	{
		super();
		entities.put(0L, new Player(0L, "Alex", new ArrayList<ItemOnPlayer>()));
		entities.put(1L, new Player(1L, "Zenit", new ArrayList<ItemOnPlayer>()));
	}
	
	/**
	 * Instance access
	 * @return the instance
	 */
	public static PlayerManager getInstance()
	{
		if (instance == null) instance = new PlayerManager();
		return instance;
	}
	
	@Override
	public boolean create(Player object) {
		boolean created = super.create(object);
		if (created) NewPlayerEvent.fire(object.getLogin());
		return created;
	}
	
	@Override
	public boolean delete(Player object) {
		boolean removed = super.delete(object);
		if (removed) PlayerDeletedEvent.fire(object.getLogin());
		return removed;
	}

}

package com.games.abyssal.Domain.EntityManagers;

import com.games.abyssal.Domain.Entities.Player;

/**
 * Player manager
 * @author alex
 *
 */
public class PlayerManager extends HashMapEntityManager<Player, Long> {

	/** The instance of the singleton */
	private static PlayerManager instance;
	
	/**
	 * Basic constructor
	 */
	private PlayerManager()
	{
		super();
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
	

}
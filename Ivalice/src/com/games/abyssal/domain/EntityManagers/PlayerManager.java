package com.games.abyssal.domain.EntityManagers;

import com.games.abyssal.domain.Player;

public class PlayerManager extends HashMapEntityManager<Player, Long> {

	private static PlayerManager instance;
	
	private PlayerManager()
	{
		super();
	}
	
	public static PlayerManager getInstance()
	{
		if (instance == null) instance = new PlayerManager();
		return instance;
	}
	

}

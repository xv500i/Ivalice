package com.games.abyssal.domain;

import java.util.Collection;

import com.games.abyssal.domain.Entities.Item;
import com.games.abyssal.domain.Entities.Market;
import com.games.abyssal.domain.Entities.Player;
import com.games.abyssal.domain.EntityManagers.ItemManager;
import com.games.abyssal.domain.EntityManagers.PlayerManager;

public class Game {
	
	public Game() {
		players = PlayerManager.getInstance().getAll();
		items = ItemManager.getInstance().getAll();
		market = new Market();
	}
	
	public Collection<Player> players;
	public Collection<Item> items;
	public Market market;
}

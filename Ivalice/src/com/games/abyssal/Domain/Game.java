package com.games.abyssal.Domain;

import java.util.Collection;

import com.games.abyssal.Domain.Entities.Item;
import com.games.abyssal.Domain.Entities.Market;
import com.games.abyssal.Domain.Entities.Player;
import com.games.abyssal.Domain.EntityManagers.ItemManager;
import com.games.abyssal.Domain.EntityManagers.PlayerManager;

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

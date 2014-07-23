package com.games.abyssal.Domain;

import java.util.Collection;
import java.util.logging.Logger;

import com.games.abyssal.Domain.Entities.Item;
import com.games.abyssal.Domain.Entities.Market;
import com.games.abyssal.Domain.Entities.Player;
import com.games.abyssal.Domain.EntityManagers.ItemManager;
import com.games.abyssal.Domain.EntityManagers.PlayerManager;
import com.games.abyssal.Domain.Events.NewPlayerEvent;
import com.games.abyssal.Domain.Events.Observer;
import com.games.abyssal.Domain.Events.PlayerDeletedEvent;
import com.games.abyssal.Presentation.LogView;
import com.games.abyssal.Presentation.View;

public class Game implements Observer {
	
	/** Default logger */
	private final static Logger logger = Logger.getLogger(Game.class.getName());
	
	
	public Game() {
		players = PlayerManager.getInstance().getAll();
		NewPlayerEvent.addObserver(this);
		PlayerDeletedEvent.addObserver(this);
		logger.info(String.format("%d players loaded", players.size()));
		items = ItemManager.getInstance().getAll();
		logger.info(String.format("%d items loaded", items.size()));
		market = new Market();
		
		// Hardcoded for testing
		view = new LogView();
		
		inputController = new KeyboardAndMouseController();
	}
	
	public Collection<Player> players;
	public Collection<Item> items;
	public Market market;
	public View view;
	public InputController inputController;


	@Override
	public void notify(Object sender, Object arguments) {
		if (sender instanceof NewPlayerEvent){
			logger.info("New player event recieved for: " + arguments);
		} else if (sender instanceof PlayerDeletedEvent){
			logger.info("Deleted player event recieved for: " + arguments);
		}
		
	}
}

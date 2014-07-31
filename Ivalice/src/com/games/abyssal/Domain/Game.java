package com.games.abyssal.Domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import com.games.abyssal.Domain.Entities.Item;
import com.games.abyssal.Domain.Entities.Market;
import com.games.abyssal.Domain.Entities.Player;
import com.games.abyssal.Domain.Entities.Recipe.ItemLine;
import com.games.abyssal.Domain.Events.NewPlayerEvent;
import com.games.abyssal.Domain.Events.Observer;
import com.games.abyssal.Domain.Events.PlayerDeletedEvent;
import com.games.abyssal.Presentation.Controllers.MainMenuController;
import com.games.abyssal.Presentation.Models.MainMenuModel;
import com.games.abyssal.Presentation.Views.MainMenuView;

public class Game implements Observer, MainMenuController {
	
	private enum GameState {Market, MainMenu}
	
	/** Default logger */
	private final static Logger logger = Logger.getLogger(Game.class.getName());
	
	
	public Game() {
		exitGame = false;
		state = GameState.Market;
		players = new ArrayList<Player>();
		activePlayer = null;
		NewPlayerEvent.addObserver(this);
		PlayerDeletedEvent.addObserver(this);
		items = new ArrayList<Item>();
		market = new Market();
		inputController = new KeyboardAndMouseController();
		MainMenuModel mainMenuModel = new MainMenuModel(activePlayer);
		mainMenuView = new MainMenuView(inputController, this, mainMenuModel);
	}
	
	public GameState state;
	public Collection<Player> players;
	public Player activePlayer;
	public Collection<Item> items;
	public Market market;
	public MainMenuView mainMenuView;
	public InputController inputController;
	public boolean exitGame;

	public void update(long msec)
	{
		
	}

	@Override
	public void notify(Object sender, Object arguments) {
		if (sender instanceof NewPlayerEvent){
			logger.info("New player event recieved for: " + arguments);
		} else if (sender instanceof PlayerDeletedEvent){
			logger.info("Deleted player event recieved for: " + arguments);
		}
		
	}

	@Override
	public void onExit() {
		exitGame = true;
		
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHelp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onOptions() {
		// TODO Auto-generated method stub
		
	}
}

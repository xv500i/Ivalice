package com.games.abyssal.Presentation.Models;

import com.games.abyssal.Domain.Entities.Player;

public class MainMenuModel {

	
	
	/**
	 * @param player
	 */
	public MainMenuModel(Player player) {
		super();
		this.player = player;
	}

	public Player player;
}

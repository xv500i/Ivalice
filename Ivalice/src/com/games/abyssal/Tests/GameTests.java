package com.games.abyssal.Tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.games.abyssal.Domain.Game;
import com.games.abyssal.Domain.Entities.Player;
import com.games.abyssal.Domain.EntityManagers.PlayerManager;

public class GameTests {
	
	

	@Test
	public void test() {
		Game game = new Game();
		assertTrue(game.market != null);
		assertTrue(game.players != null);
		assertTrue(game.items != null);
		
		PlayerManager.getInstance().create(new Player(99807L, "Alexis", null));
		PlayerManager.getInstance().delete(new Player(99807L, "Alexis", null));
	}

}

package com.games.abyssal.Tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.games.abyssal.Domain.Game;

public class GameTests {

	@Test
	public void test() {
		Game game = new Game();
		assertTrue(game.market != null);
		assertTrue(game.players != null);
		assertTrue(game.items != null);
		
	}

}

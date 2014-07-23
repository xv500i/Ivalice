package com.games.abyssal.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.games.abyssal.domain.Game;

public class GameTests {

	@Test
	public void test() {
		Game game = new Game();
		assertTrue(game.market != null);
		assertTrue(game.players != null);
		assertTrue(game.items != null);
		
	}

}

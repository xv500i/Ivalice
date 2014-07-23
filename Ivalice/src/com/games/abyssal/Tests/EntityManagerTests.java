package com.games.abyssal.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.games.abyssal.Domain.Entities.ItemOnPlayer;
import com.games.abyssal.Domain.Entities.Player;
import com.games.abyssal.Domain.EntityManagers.PlayerManager;

public class EntityManagerTests {

	@Test
	public void test() {
		PlayerManager manager = PlayerManager.getInstance();
		
		Player me = manager.get(0L);
		assertTrue("Player should not exist", me == null);
		me = new Player(0L, "Alex", new ArrayList<ItemOnPlayer>());
		assertTrue("Creation failed", manager.create(me));
		
		me = manager.get(0L);
		assertTrue("Player should exist", me != null);
		assertTrue("Incorrect name", me.getLogin().equals("Alex"));
		assertTrue("Incorrect id", me.getId() == 0L);
		
		assertFalse("Creation should have failed", manager.create(me));
		
		assertTrue("There should be 1 user", manager.getAll().size() == 1);
		
		assertTrue("Deletion should not fail", manager.delete(me));
		
		assertTrue("There should be 1 user", manager.getAll().size() == 0);
		
		assertTrue("Recreation should not fail", manager.create(me));
	}

}

package com.games.abyssal.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;

import com.games.abyssal.domain.Item;
import com.games.abyssal.domain.ItemOnPlayer;
import com.games.abyssal.domain.Market;
import com.games.abyssal.domain.Player;
import com.games.abyssal.domain.EntityManagers.ItemManager;
import com.games.abyssal.exceptions.ItemAlreadyInMarketException;
import com.games.abyssal.exceptions.ItemNotBeeingSoldException;

public class MarketTests {

	@Test
	public void test() {
		Market market = new Market();
		
		Player player = new Player(0L, "Alex");
		
		Player seller = new Player(1L, "AlexSeller");
		
		Collection<Item> items = new ArrayList<>();
		Item woodenSword = ItemManager.getInstance().get(0L);
		items.add(woodenSword);
		
		try {
			market.buyItem(0L, player, new Date());
			fail("Item is not currently being sold.");
		} catch (ItemNotBeeingSoldException e) {
			
		}
		
		ItemOnPlayer swordOnSeller = new ItemOnPlayer();
		swordOnSeller.setPlayer(seller);
		swordOnSeller.setItem(woodenSword);
		
		try {
			market.addItem(swordOnSeller, 100);
		} catch (ItemAlreadyInMarketException e) {
			fail("Item should not be in market");
		}
		
		try {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_YEAR, 11);
			market.buyItem(0L, player, cal.getTime());
			
		} catch (ItemNotBeeingSoldException e) {
			fail("The item should be buyable.");
		}
	}

}

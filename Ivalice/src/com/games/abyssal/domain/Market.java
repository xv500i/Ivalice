package com.games.abyssal.domain;

import java.util.Collection;
import java.util.Date;

public class Market {
	private Collection<ItemPlayerOnMarket> items;
	private Date lastItemUpdate;
	private static long itemMaxUpdateWindow;
	private static long maximumTimeOfSubmission;
	private static int maximumDiscount;
	
	public void update(long msec)
	{
				
	}
	
	public void addItem(ItemPlayerOnMarket item)
	{
		items.add(item);
	}
	
	public boolean removeItem(ItemPlayerOnMarket item)
	{
		return items.remove(item);
	}
}

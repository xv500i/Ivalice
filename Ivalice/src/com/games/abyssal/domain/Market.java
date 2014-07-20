package com.games.abyssal.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;

import com.games.abyssal.exceptions.ItemAlreadyInMarketException;
import com.games.abyssal.exceptions.ItemNotBeeingSoldException;

public class Market {
	
	private final static Logger logger = Logger.getLogger(Market.class.getName());
	
	private HashMap<Long, ItemPlayerOnMarket> items;
	private Date lastItemUpdate;
	private final static long itemMaxUpdateWindow = 1000*60;
	private final static long maximumTimeOfSubmission = 1000*60*60*24*10;
	private final static int maximumDiscount = 33;
	
	public Market()
	{
		items = new HashMap<Long, ItemPlayerOnMarket>();
	}
	
	public void update(long msec)
	{
				
	}
	
	public boolean buyItem(long itemInstanceId, Player buyer, Date buyDate) throws ItemNotBeeingSoldException
	{
		ItemPlayerOnMarket item = items.get(itemInstanceId);
		logger.info(String.format("Searching item %d", itemInstanceId));
		if (item == null) throw new ItemNotBeeingSoldException();
		
		int price = calculatePrice(item, buyDate);
		
		logger.info(String.format("Player %1$s(%2$s) buyed the item %3$s(%4$s) for %5$d",
			buyer.getLogin(),
			buyer.getId(),
			item.getName(),
			item.getInstanceId(),
			price)
		);
		return true;
	}
	
	
	private int calculatePrice(ItemPlayerOnMarket item, Date buyDate) {
		int initialPrice = item.getInitialPrice();
		
		long msecDiff = buyDate.getTime() - new Date().getTime();
		logger.info(String.format("Hours difference: %d", msecDiff/1000/60/60));
		
		float threshold = (float)msecDiff / (float)maximumTimeOfSubmission;
		threshold = Math.min(1.0f, threshold);
		float discount = (int) ((float)maximumDiscount * (threshold));
		logger.info(String.format("discount: %.2f percent", discount));
		
		
		return (int)( (1.0f - discount/100.0f) * (float)initialPrice );
	}

	public void addItem(ItemOnPlayer newItemOnPlayer, int price) throws ItemAlreadyInMarketException {
		ItemPlayerOnMarket item = items.get(newItemOnPlayer.getInstanceId());
		if (item != null) throw new ItemAlreadyInMarketException();
		ItemPlayerOnMarket newItem = new ItemPlayerOnMarket();
		newItem.setItem(newItemOnPlayer);
		newItem.setInitialPrice(price);
		newItem.setSubmitedOn(new Date());
		items.put(newItemOnPlayer.getInstanceId(), newItem);
	}
	
}

package com.games.abyssal.Domain.Entities;

import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;

import com.games.abyssal.Exceptions.ItemAlreadyInMarketException;
import com.games.abyssal.Exceptions.ItemNotBeeingSoldException;

/**
 * Represents a Market when the users can sell items.
 * Every item is sold at an initial price. During some time the price is lowered.
 * Finally when some time has been passed, the item is returned to the seller unless some player
 * buys it.
 * @author alex
 *
 */
public class Market {
	
	/** Default logger */
	private final static Logger logger = Logger.getLogger(Market.class.getName());
	
	/** The items being sold */
	private HashMap<Long, ItemPlayerOnMarket> items;
	
	/** The maximum time that an item could be in the market */
	private final static long maximumTimeOfSubmission = 1000*60*60*24*10;
	
	/** The maximum discount applied to the price of an item */
	private final static int maximumDiscount = 33;
	
	
	public Market()
	{
		items = new HashMap<Long, ItemPlayerOnMarket>();
	}
	
	public void update(long msec)
	{
				
	}
	
	/**
	 * The player buys an item
	 * @param itemInstanceId the item being bought
	 * @param buyer The player who buys
	 * @param buyDate The date of the bought
	 * @return Whether the bought has been carried out
	 * @throws ItemNotBeeingSoldException If the itemInstanceId does not belong to a valid selling item
	 */
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
			item.getId(),
			price)
		);
		return true;
	}
	
	/**
	 * Calculates the price of the item
	 * @param item
	 * @param buyDate
	 * @return The items price with the discount corresponding of a linear interpolation of 0% for
	 * a recently added item to maximum discount for an item that is close to the maximum time.
	 */
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

	/**
	 * Adds the item on the market
	 * @param newItemOnPlayer The new item
	 * @param price The initial price
	 * @throws ItemAlreadyInMarketException If the item is already beeing sold
	 */
	public void addItem(ItemOnPlayer newItemOnPlayer, int price) throws ItemAlreadyInMarketException {
		ItemPlayerOnMarket item = items.get(newItemOnPlayer.getId());
		if (item != null) throw new ItemAlreadyInMarketException();
		ItemPlayerOnMarket newItem = new ItemPlayerOnMarket(new Date(), price, newItemOnPlayer);
		items.put(newItemOnPlayer.getId(), newItem);
	}
	
}

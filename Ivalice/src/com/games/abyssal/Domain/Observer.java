package com.games.abyssal.Domain;

/**
 * The Observer of the Observer pattern
 * @author alex
 *
 */
public interface Observer {
	public abstract void notifyEvent(Object sender, Object arguments);
}

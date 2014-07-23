package com.games.abyssal.Domain.Events;

/**
 * The Observer of the Observer pattern
 * @author alex
 *
 */
public interface Observer {
	public abstract void notify(Object sender, Object arguments);
}

package com.games.abyssal.domain;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The Observer's subject
 * @author alex
 *
 */
public interface Subject {
	
	/** The observers that are registered with this event */
	public Collection<Observer> registeredObservers = new ArrayList<Observer>();
}

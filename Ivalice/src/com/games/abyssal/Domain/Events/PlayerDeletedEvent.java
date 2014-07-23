package com.games.abyssal.Domain.Events;

import java.util.ArrayList;
import java.util.Collection;

public class PlayerDeletedEvent {
	private static Collection<Observer> observers = new ArrayList<>();
	public static void addObserver(Observer o) {observers.add(o);}
	public static void fire(Object argument){
		for (Observer o : observers) o.notify(new PlayerDeletedEvent(), argument);
	}
}

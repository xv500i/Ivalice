package com.games.abyssal.domain.EntityManagers;

import java.util.Collection;


public interface EntityManager<T, K> {
	
	public boolean delete(T object);
	
	public boolean create(T object);
	
	public boolean update(T object);
	
	public T get(K key);
	
	public Collection<T> getAll();
}

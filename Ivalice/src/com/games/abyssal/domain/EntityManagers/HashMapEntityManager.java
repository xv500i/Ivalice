package com.games.abyssal.domain.EntityManagers;

import java.util.Collection;
import java.util.HashMap;

import com.games.abyssal.domain.Entity;

public class HashMapEntityManager<T extends Entity, K> implements EntityManager<T, K> {

	protected HashMap<Object, T> entities;
	
	protected HashMapEntityManager() {
		entities = new HashMap<>();
	}
	
	@Override
	public boolean delete(T object) {
		return entities.remove(object.getId()) != null;
	}

	@Override
	public boolean create(T object) {
		T result = entities.get(object.getId());
		boolean created = false;
		if (result == null) 
		{
			entities.put(object.getId(), object);
			created = true;
		}
		return created;
	}

	@Override
	public boolean update(T object) {
		return true;
	}

	@Override
	public T get(K key) {
		return entities.get(key);
	}

	@Override
	public Collection<T> getAll() {
		return entities.values();
	}

}

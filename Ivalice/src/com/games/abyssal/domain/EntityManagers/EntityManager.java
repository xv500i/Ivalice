package com.games.abyssal.domain.EntityManagers;

import java.util.Collection;

/**
 * Defines a manager for the objects that should be persisted
 * @author alex
 *
 * @param <T> The object that has to be persisted
 * @param <K> The identifier of the object
 */
public interface EntityManager<T, K> {
	
	/**
	 * Deletes a object
	 * @param object
	 * @return whether the deletion was successful
	 */
	public boolean delete(T object);
	
	/**
	 * Creates an object
	 * @param object
	 * @return whether the creation was successful
	 */
	public boolean create(T object);
	
	/**
	 * Updates an object
	 * @param object
	 * @return whether the update was sucessful
	 */
	public boolean update(T object);
	
	/**
	 * Gets an item by giving its key
	 * @param key
	 * @return the object if found or null
	 */
	public T get(K key);
	
	/**
	 * Gets all objects
	 * @return all current objects
	 */
	public Collection<T> getAll();
}

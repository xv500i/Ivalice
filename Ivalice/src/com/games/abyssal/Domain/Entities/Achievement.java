package com.games.abyssal.Domain.Entities;

public class Achievement extends Entity{

	private Long id;
	private String title;
	private String description;
	
	/**
	 * @param id
	 * @param title
	 * @param description
	 */
	public Achievement(Long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}



	@Override
	public Long getId() {
		return id;
	}



	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}



	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}



	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}



	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}

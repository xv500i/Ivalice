package com.games.abyssal.Presentation.Views;


public abstract class View {
	
	InputController input;
	
	public View(InputController input)
	{
		this.input = input;
	}
	
	public abstract void update(long msec);
	
	public abstract void render();
}

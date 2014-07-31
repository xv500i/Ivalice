package com.games.abyssal.Presentation.Views;

import com.games.abyssal.Domain.InputController;

public abstract class View {
	
	InputController input;
	
	public View(InputController input)
	{
		this.input = input;
	}
	
	public abstract void update(long msec);
}

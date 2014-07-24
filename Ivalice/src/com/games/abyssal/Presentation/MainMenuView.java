package com.games.abyssal.Presentation;

import com.games.abyssal.Domain.InputController;



public class MainMenuView extends View {

	MainMenuController controller;
	
	public MainMenuView(InputController input, MainMenuController controller) {
		super(input);
		this.controller = controller;
	}

	@Override
	public void update(long msec) {
		
	}
	
	public void buttonExitClicked()
	{
		controller.onExit();
	}

}

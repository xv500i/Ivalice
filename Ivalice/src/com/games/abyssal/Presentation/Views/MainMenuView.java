package com.games.abyssal.Presentation.Views;

import com.games.abyssal.Presentation.Controllers.MainMenuController;
import com.games.abyssal.Presentation.Models.MainMenuModel;



public class MainMenuView extends View {

	MainMenuController controller;
	MainMenuModel model;
	
	public MainMenuView(InputController input, MainMenuController controller, MainMenuModel model) {
		super(input);
		this.controller = controller;
		this.model = model;
	}

	@Override
	public void update(long msec) {
		
	}
	
	public void buttonExitClicked()
	{
		controller.onExit();
	}

	@Override
	public void render() {
		
	}

}

package com.games.abyssal.Presentation.Views;

public class InputController {
	private boolean isActionDown;
	
	public boolean isActionDown(){
		return isActionDown;
	}
	
	public void onReleaseAction(){
		isActionDown = false;
	}
	public void onPushAction(){
		isActionDown = true;
	}
}

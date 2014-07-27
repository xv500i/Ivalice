package com.games.abyssal;

import com.games.abyssal.Presentation.Sound.SoundManager;

public class Main {

	public static void main(String[] args) {
		
		SoundManager sound = SoundManager.getInstance();
		sound.playBGE(0);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Stopping");
		sound.stopBGE();
		
	}

}

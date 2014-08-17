package com.games.abyssal;

import com.games.abyssal.Presentation.Sound.SoundManager;
import com.games.abyssal.Presentation.Sound.SoundManager.SoundNotFoundException;

public class Main {

	public static void main(String[] args) {
		
		SoundManager sound = SoundManager.getInstance();
		try {
			sound.playBGE(0);
		} catch (SoundNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Stopping");
		sound.stopBGE();
		
	}

}

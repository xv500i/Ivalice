package com.games.abyssal.Presentation.Sound;

import java.util.ArrayList;

public class SoundManager {
	
	public ArrayList<String> files;
	public SoundAdapter bgePlayer;
	
	private SoundManager()
	{
		bgePlayer = new SoundPlayer();
		files = new ArrayList<>();
		files.add("Ressources/Sound/instrumental.mp3");
	}
	
	private static SoundManager instance;
	
	public static SoundManager getInstance()
	{
		if (instance == null) instance = new SoundManager();
		return instance;
	}
	
	public void playBGE(int n) throws SoundNotFoundException
	{
		if (n < 0 || n >= files.size()) throw new SoundNotFoundException();
		bgePlayer.playBGE(n);
	}

	public void stopBGE() {
		bgePlayer.stopBGE();
	}
	
	public class SoundNotFoundException extends Exception {
		private static final long serialVersionUID = -7914441558582497885L;
	}
}

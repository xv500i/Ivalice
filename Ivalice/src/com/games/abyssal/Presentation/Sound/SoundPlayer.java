package com.games.abyssal.Presentation.Sound;

import java.io.FileInputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class SoundPlayer implements SoundAdapter {

	private Player playMP3;
	private PlayThread playThread;
	
	public SoundPlayer()
	{
		playThread = new PlayThread();
	}
	
	@Override
	public void playBGE(int n) {
		try{
		    FileInputStream fis = new FileInputStream("Ressources/Sound/instrumental.mp3");
		    playMP3 = new Player(fis);
		    playThread.start();
		}
		catch(Exception exc){
		    exc.printStackTrace();
		    System.out.println("Failed to play the file.");
		}
		
	}

	@Override
	public void stopBGE() {
		playMP3.close();
		playThread.interrupt();
	}
	
	
	private class PlayThread extends Thread {

		@Override
		public void run() {
			super.run();
			while(!isInterrupted()) {
				try {
					playMP3.play(1);
				} catch (JavaLayerException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

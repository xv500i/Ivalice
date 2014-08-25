package com.games.abyssal.Presentation.Models;

import java.util.HashMap;

import com.games.abyssal.Domain.Entities.Achievement;

public class AchievementsModel {
	public HashMap<Long, Achievement> playerAchievements;
	public Achievement viewingAchievement = null;
	
	public AchievementsModel() {
		playerAchievements = new HashMap<>();
		playerAchievements.put(0L, new Achievement(0L, "MVC", "This runs MVC!"));
		playerAchievements.put(1L, new Achievement(1L, "Input", "The input is correct!"));
		playerAchievements.put(2L, new Achievement(2L, "Thief", "You have participated in more than 100 missions involving robery!\nYou're a real robber."));
	}

	public void changeShowingDetails(Long id) {
		viewingAchievement = playerAchievements.get(id);
	}
}

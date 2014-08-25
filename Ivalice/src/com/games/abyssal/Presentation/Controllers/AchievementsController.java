package com.games.abyssal.Presentation.Controllers;

import com.games.abyssal.Presentation.Models.AchievementsModel;
import com.games.abyssal.Presentation.Views.AchievementsView;
import com.games.abyssal.Presentation.Views.InputController;

public class AchievementsController {
	
	public AchievementsModel model;
	public AchievementsView view;
	
	public AchievementsController() {
		model = new AchievementsModel();
		view = new AchievementsView(new InputController(), this, model);
	}
	
	public void onViewAchievementsDetail(Long id) {
		model.changeShowingDetails(id);
	}
	public void onExit() {}
}

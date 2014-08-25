package com.games.abyssal.Presentation.Views;

import com.games.abyssal.Presentation.Controllers.AchievementsController;
import com.games.abyssal.Presentation.Models.AchievementsModel;

public class AchievementsView extends View {
	
	public AchievementsController controller;
	public AchievementsModel model;
	
	public AchievementsView(InputController input, AchievementsController controller, AchievementsModel model) {
		super(input);
		this.model = model;
		this.controller = controller;
	}

	@Override
	public void update(long msec) {

	}

	@Override
	public void render() {
		
	}
	
	public void onAchievementClicked(Long id){
		controller.onViewAchievementsDetail(id);
		// notify ui
	}

}

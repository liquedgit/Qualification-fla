package Pages;

import java.util.ArrayList;

import Model.Score;

public class Highscore extends BasePage{
	private ArrayList<Score> scoreList;
	
	
	
	public Highscore(ArrayList<Score> scoreList) {
		super();
		this.scoreList = scoreList;
	}



	@Override
	public void ShowPage() {
		// TODO Auto-generated method stub
		System.out.println("Highscore");
		System.out.println("Rank, Restaurant's Name, Score");
		
	}

}

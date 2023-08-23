package Pages;

import java.util.ArrayList;
import java.util.Scanner;

import Manager.HighscoreManager;
import Model.Score;

public class HighscorePage extends BasePage {
	private ArrayList<Score> scoreList;
	Scanner sc;
	
	public HighscorePage() {
		// TODO Auto-generated constructor stub
		this.scoreList = HighscoreManager.GetInstance().getScore();
		this.sc = new Scanner(System.in);
	}
	
	@Override
	public void ShowPage() {
		// TODO Auto-generated method stub
		System.out.println("Highscore");
		System.out.println("Rank, Restaurant's Name, Score");
		for(int i = 0;i<scoreList.size();i++) {
			System.out.println(i+1+". "+scoreList.get(i).getRestaurantName()+", "+
					scoreList.get(i).getScore());
		}
		sc.nextLine();
		new MainMenuPage().ShowPage();
	}

}

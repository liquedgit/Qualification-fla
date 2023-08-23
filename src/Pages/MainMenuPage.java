package Pages;


import java.util.ArrayList;
import java.util.Scanner;

import Facade.Helper;
import Model.Score;

public class MainMenuPage extends BasePage {
	private Scanner sc;
	private Helper helper;
	
	public MainMenuPage() {
		sc = new Scanner(System.in);
		helper = new Helper();
		
	}
	
	
	
	@Override
	public void ShowPage() {
		// TODO Auto-generated method stub
//		helper.cls();
		int choice;
		do {
			System.out.println("Main Menu");
			System.out.println("1. Play New Restaurant");
			System.out.println("2. High Score");
			System.out.println("3. Exit");
			System.out.print("Input [1...3] : ");
			choice = sc.nextInt();sc.nextLine();
		}while(choice < 1 || choice > 3);
		if(choice == 1) {
			new PlayNewRestaurantPage().ShowPage();
		}else if(choice == 2) {
			new HighscorePage().ShowPage();
		}
	}
}

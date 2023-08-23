package Pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Facade.Helper;
import Model.Score;

public class MainMenuPage extends BasePage {
	private Scanner sc;
	private Helper helper;
	private ArrayList<Score> scoreList;
	public MainMenuPage() {
		sc = new Scanner(System.in);
		helper = new Helper();
		
		File myFile = new File("highscore.txt");
		Scanner fileSc;
		try {
			fileSc = new Scanner(myFile);
			while(fileSc.hasNextLine()) {
				String data = fileSc.nextLine();
				String[] arrOfStr = data.split("#",2);
				Score score= new Score(arrOfStr[0], Integer.parseInt(arrOfStr[1]));
				scoreList.add(score);
			}
			fileSc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
			
		}else if(choice == 2) {
			new Highscore(scoreList).ShowPage();
		}
	}
}

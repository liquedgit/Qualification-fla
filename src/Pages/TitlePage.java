package Pages;

import java.util.Scanner;

public class TitlePage extends BasePage{
	private Scanner sc;
	
	public TitlePage() {
		sc = new Scanner(System.in);
	}
	@Override
	public void ShowPage() {
		
		// TODO Auto-generated method stub
		System.out.println("Da Resto");
		System.out.println("Press enter to continue");
		sc.nextLine();
		new MainMenuPage().ShowPage();;
	}
	
}

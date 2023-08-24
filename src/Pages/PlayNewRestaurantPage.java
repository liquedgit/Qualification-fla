package Pages;

import java.util.Scanner;

import Manager.GameManager;
import Observer.CustomerGenerator;

public class PlayNewRestaurantPage extends BasePage{
	private Scanner sc;
	private GameManager instance;
	public PlayNewRestaurantPage() {
		// TODO Auto-generated constructor stub
		this.sc = new Scanner(System.in);
	}
	
	@Override
	public void ShowPage() {
		// TODO Auto-generated method stub
		String restaurantName;
		do {
			System.out.print("Restaurant Name :");
			restaurantName = sc.nextLine();
			if(restaurantName.length() < 3 || restaurantName.length() > 15) {
				System.out.println("Restaurant name must be 3 - 15 character");
			}
		}while(restaurantName.length() < 3 || restaurantName.length() > 15);
		
		this.instance = GameManager.GetInstance();
		instance.initializeRestaurant();
		instance.getActiveRestaurant().setRestaurantName(restaurantName);
		CustomerGenerator cg = new CustomerGenerator();
		instance.getActiveRestaurant().addSubscriber(cg);
		new PlayPage().ShowPage();
	}

}

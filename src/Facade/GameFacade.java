package Facade;

import java.util.Scanner;

import Manager.GameManager;

public class GameFacade {
	private GameManager instance;
	private Helper helper;
	private Scanner sc;
	public GameFacade() {
		this.instance = GameManager.GetInstance();
		this.helper = new Helper();
		this.sc = new Scanner(System.in);
	}
	
	public void toogleIsPause() {
		while(!instance.getIsEnded()) {
//			System.out.println(instance.getIsRunning());
			if(instance.getIsRunning()) {
				System.out.println("Bisa di pause");
				sc.nextLine();
				instance.setIsRunning(false);
			}
		}
	}
	
	public void GameUpgrade() {
		System.out.println("Status");
		System.out.println("Money : Rp. " + instance.getActiveRestaurant().getMoney());
		System.out.println("Score : "+ instance.getActiveRestaurant().getScore() + " Points");
		System.out.println("Size  : "+ instance.getActiveRestaurant().getChair()+" Seats");
		System.out.println("1. Increase Restaurant's Seat <Rp. "+100*instance.getActiveRestaurant().getChair()+">");
		System.out.println("2. Hire new employee");
		
	}
	
	public void GameRunning() {
		while(!instance.getIsEnded()) {
			if(instance.getIsRunning()) {
				helper.cls();
				System.out.println("Status");
				System.out.println("Money : Rp. " + instance.getActiveRestaurant().getMoney());
				System.out.println("Score : "+ instance.getActiveRestaurant().getScore() + " Points");
				System.out.println("Size  : "+ instance.getActiveRestaurant().getChair()+" Seats");
			
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("Pause Menu");
				System.out.println("Status");
				System.out.println("Money : Rp. " + instance.getActiveRestaurant().getMoney());
				System.out.println("Score : "+ instance.getActiveRestaurant().getScore() + " Points");
				System.out.println("Size  : "+ instance.getActiveRestaurant().getChair()+" Seats");
				System.out.println("1. Continue Business");
				System.out.println("2. Upgrade Business");
				System.out.println("3. Close Business");
				System.out.print("Input [1..3] : ");
				Integer ch;
				ch = sc.nextInt();sc.nextLine();
				System.out.println(ch);
				if(ch == 1) {
					instance.setIsRunning(true);
				}else if(ch == 2) {
					
				}else if(ch == 3) {
					instance.setIsEnded(true);
				}
			}
		}
	}
}

package Manager;

import Model.Restaurant;

public class GameManager {
	private static GameManager instance;
	private Restaurant activeRestaurant;
	private volatile Boolean isRunning;
	private volatile Boolean isEnded;
	public Boolean getIsEnded() {
		return isEnded;
	}

	public void setIsEnded(Boolean isEnded) {
		this.isEnded = isEnded;
	}

	public Boolean getIsRunning() {
		return isRunning;
	}

	public void setIsRunning(Boolean isRunning) {
		this.isRunning = isRunning;
	}

	public Restaurant getActiveRestaurant() {
		return activeRestaurant;
	}

	public void setActiveRestaurant(Restaurant activeRestaurant) {
		this.activeRestaurant = activeRestaurant;
	}

	private GameManager() {
		this.activeRestaurant = new Restaurant();
		this.isRunning = true;
		this.isEnded = false;
	}
	
	public static GameManager GetInstance() {
		if(instance == null) {
			instance = new GameManager();
		}
		return instance;
	}
	
}

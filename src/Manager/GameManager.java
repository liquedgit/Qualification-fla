package Manager;

import java.util.ArrayList;

import Model.Customer;
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
		this.isRunning = true;
		this.isEnded = false;
	}
	
	public synchronized static GameManager GetInstance() {
		if(instance == null) {
			synchronized (GameManager.class) {
				if(instance == null) {
					instance = new GameManager();
					
				}
			}
		}
		return instance;
	}
	
	public void initializeRestaurant() {
        if (this.activeRestaurant == null) {
            this.activeRestaurant = new Restaurant();
        }
    }
	
}

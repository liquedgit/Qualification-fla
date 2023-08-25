package Multithread;

import Manager.GameManager;
import Model.Chef;

public class ChefThread implements Runnable{
	private GameManager instance;
	private Chef chef;
	public ChefThread(Chef chef2) {
		this.instance = GameManager.GetInstance();
		this.chef = chef2;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!instance.getIsEnded()) {
			if(instance.getIsRunning()) {
				chef.getCurrState().Update();
			}
		}
	}

}

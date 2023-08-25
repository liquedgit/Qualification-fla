package Multithread;

import Manager.GameManager;
import Model.Customer;

public class CustomerThread implements Runnable{
	private Customer customer;
	private GameManager instance;
	private volatile Boolean end;
	
	public CustomerThread(Customer customer) {
		this.customer = customer;
		this.instance = GameManager.GetInstance();
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!instance.getIsEnded() && !customer.getShouldStop()) {
			if(instance.getIsRunning()) {
				customer.getCurrState().Update();
			}
		}
	}
	
}

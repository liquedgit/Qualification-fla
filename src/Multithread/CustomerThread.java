package Multithread;

import Manager.GameManager;
import Model.Customer;

public class CustomerThread implements Runnable {
	private Customer customer;
	private GameManager instance;
	
	public CustomerThread(Customer customer) {
		this.customer = customer;
		this.instance = GameManager.GetInstance();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!instance.getIsEnded()) {
			if(instance.getIsRunning()) {
				customer.getCurrState().Update();
			}
		}
	}
	
}

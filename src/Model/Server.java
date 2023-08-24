package Model;

import EmployeeFactory.Employee;
import Mediator.RestaurantMediator;
import State.ServerState.ServerStateManager;

public class Server extends Employee {
	public Server(String name, RestaurantMediator mediator, Integer speed) {
		super(name, speed);
		this.currState = new ServerStateManager(mediator, this);
		// TODO Auto-generated constructor stub
	}
	
	private ServerStateManager currState;

	public ServerStateManager getCurrState() {
		return currState;
	}





	@Override
	public void peformDuties() {
		// TODO Auto-generated method stub
		
	}



}

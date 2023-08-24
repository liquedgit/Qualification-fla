package EmployeeFactory;

import Mediator.RestaurantMediator;
import Model.Server;

public class ServerFactory extends EmployeeFactory {
	
	private RestaurantMediator mediator;
	
	public ServerFactory(RestaurantMediator mediator) {
		this.mediator = mediator;
	}
	
	@Override
	public Employee createEmployee(String name) {
		// TODO Auto-generated method stub
		return new Server(name, mediator, 1);
	}

}

package EmployeeFactory;

import Mediator.RestaurantMediator;
import Model.Chef;

public class ChefFactory extends EmployeeFactory{
	private RestaurantMediator mediator;
	
	public ChefFactory(RestaurantMediator mediator) {
		this.mediator = mediator;
	}
	
	@Override
	public Employee createEmployee(String name) {
		// TODO Auto-generated method stub
		return new Chef(name, 1, 1);
	}



	
}

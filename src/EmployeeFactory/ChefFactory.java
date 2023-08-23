package EmployeeFactory;

import Model.Chef;

public class ChefFactory extends EmployeeFactory{

	@Override
	public Employee createEmployee(String name) {
		// TODO Auto-generated method stub
		return new Chef(name);
	}



	
}

package EmployeeFactory;

import Model.Server;

public class ServerFactory extends EmployeeFactory {

	@Override
	public Employee createEmployee(String name) {
		// TODO Auto-generated method stub
		return new Server(name);
	}

}

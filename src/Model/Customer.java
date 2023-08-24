package Model;

import EmployeeFactory.Employee;
import Mediator.RestaurantMediator;
import State.CustomerState.CustomerStateManager;

public class Customer{
	private String name;
	private Integer tolerance;
	private CustomerStateManager currState;

	public CustomerStateManager getCurrState() {
		return currState;
	}

	public void setCurrState(CustomerStateManager currState) {
		this.currState = currState;
	}
	
	public void setInteractWith(Employee employee) {
		this.currState.setInteractingWith(employee);
	}


	public Customer(String name, Integer tolerance, RestaurantMediator mediator) {
		this.currState = new CustomerStateManager(mediator, this);
		this.name = name;
		this.tolerance = tolerance;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTolerance() {
		return tolerance;
	}
	public void setTolerance(Integer tolerance) {
		this.tolerance = tolerance;
	}
	
}

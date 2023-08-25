package Model;

import EmployeeFactory.Employee;
import Mediator.RestaurantMediator;
import State.CustomerState.CustomerStateManager;

public class Customer{
	private String name;
	private Integer tolerance;
	private CustomerStateManager currState;
	private volatile Boolean shouldStop;

	public Boolean getShouldStop() {
		return shouldStop;
	}

	public void setShouldStop(Boolean shouldStop) {
		this.shouldStop = shouldStop;
	}

	public CustomerStateManager getCurrState() {
		return currState;
	}

	public void setCurrState(CustomerStateManager currState) {
		this.currState = currState;
	}


	public Customer(String name, Integer tolerance, RestaurantMediator mediator) {
		this.currState = new CustomerStateManager(mediator, this);
		this.name = name;
		this.tolerance = tolerance;
		this.shouldStop = false;
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
	
	public void decreaseTolerance() {
		this.tolerance--;
	}
	
	public void setTolerance(Integer tolerance) {
		this.tolerance = tolerance;
	}
	
}

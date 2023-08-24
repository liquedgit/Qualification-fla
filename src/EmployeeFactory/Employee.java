package EmployeeFactory;

import Mediator.RestaurantMediator;

public abstract class Employee {
	private String name;
	private Integer speed;
	private RestaurantMediator mediator;
	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public abstract void peformDuties();
	
	public Employee(String name, Integer speed) {
		this.name = name;
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

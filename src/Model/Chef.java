package Model;

import EmployeeFactory.Employee;
import Mediator.RestaurantMediator;
import State.ChefState.ChefStateManager;

public class Chef extends Employee{
	private Integer skill;
	private ChefStateManager currState;
	public ChefStateManager getCurrState() {
		return currState;
	}

	public Chef(String name, Integer speed, Integer skill, RestaurantMediator mediator) {
		super(name, speed);
		this.skill = skill;
		this.currState = new ChefStateManager(mediator, this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void peformDuties() {
		// TODO Auto-generated method stub
		
	}

	public Integer getSkill() {
		return skill;
	}

	public void setSkill(Integer skill) {
		this.skill = skill;
	}
}

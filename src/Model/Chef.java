package Model;

import EmployeeFactory.Employee;

public class Chef extends Employee{
	private Integer skill;
	public Chef(String name, Integer speed, Integer skill) {
		super(name, speed);
		this.skill = skill;
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

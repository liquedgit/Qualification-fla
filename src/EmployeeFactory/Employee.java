package EmployeeFactory;

public abstract class Employee {
	private String name;
	public abstract void peformDuties();
	
	public Employee(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

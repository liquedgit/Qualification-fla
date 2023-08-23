package Model;

import java.util.HashMap;

import EmployeeFactory.Employee;
import Facade.EmployeeGenerator;

public class Restaurant {
	private Integer chair;
	private HashMap<String,Employee> employee;
	private Integer money;
	private Integer score;
	private String restaurantName;
	
	
	public Restaurant() {
		// TODO Auto-generated constructor 
		this.employee = new HashMap<>();
		EmployeeGenerator eg = new EmployeeGenerator();
		eg.generateChef(employee, 2);
		eg.generateServer(employee, 2);
		this.chair = 4;
		this.money = 1300;
		this.score = 0;
	}
	
	
	
	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Integer getChair() {
		return chair;
	}

	public void setChair(Integer chair) {
		this.chair = chair;
	}

	

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	
	
}

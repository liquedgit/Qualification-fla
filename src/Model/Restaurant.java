package Model;

import java.util.ArrayList;
import java.util.HashMap;

import EmployeeFactory.Employee;
import Facade.EmployeeGenerator;
import Mediator.RestaurantMediator;
import Observer.Observer;
import Observer.Subject;

public class Restaurant implements Subject {
	private Integer chair;
	private HashMap<String,Employee> employee;
	private Integer money;
	private Integer score;
	private String restaurantName;
	private ArrayList<Observer> subscriber;
	private HashMap<String, Customer> customers;
	private RestaurantMediator mediator;

	
	public RestaurantMediator getMediator() {
		return mediator;
	}



	public void setMediator(RestaurantMediator mediator) {
		this.mediator = mediator;
	}



	public Restaurant() {
		// TODO Auto-generated constructor 
		this.mediator = new RestaurantMediator(this);
		this.subscriber = new ArrayList<>();
		this.customers = new HashMap<>();
		this.employee = new HashMap<>();
		EmployeeGenerator eg = new EmployeeGenerator();
		eg.generateChef(employee, 2, mediator);
		eg.generateServer(employee, 2, mediator);
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
	
	public void checkEmptySeat() {
		if(customers.size() < this.chair) {
			notifySubscriber(customers.size()-this.chair);
		}
	}

	public HashMap<String, Employee> getEmployee() {
		return employee;
	}



	public void setEmployee(HashMap<String, Employee> employee) {
		this.employee = employee;
	}



	public HashMap<String, Customer> getCustomers() {
		return customers;
	}



	public void setCustomers(HashMap<String, Customer> customers) {
		this.customers = customers;
	}



	@Override
	public void notifySubscriber(int emptySeat) {
		// TODO Auto-generated method stub
		for (Observer observer : subscriber) {
			observer.getNotif(emptySeat, customers, this.mediator);
		}
	}



	@Override
	public void addSubscriber(Observer observer) {
		// TODO Auto-generated method stub
		subscriber.add(observer);
	}



	@Override
	public void removeSubscriber(Observer observer) {
		// TODO Auto-generated method stub
		subscriber.remove(observer);
	}

	
	
}

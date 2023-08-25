package State.CustomerState;

import EmployeeFactory.Employee;
import Mediator.RestaurantMediator;
import Model.Chef;
import Model.Customer;
import Model.Server;

public class CustomerStateManager {
	private CustomerBaseState currState;

	public CustomerBaseState getState() {
		return currState;
	}

	protected Server server;
	protected CustomerOrderState orderState;
	public Server getServer() {
		return server;
	}

	public CustomerOrderState getOrderState() {
		return orderState;
	}

	public CustomerOrderServerState getOrderServerState() {
		return orderServerState;
	}

	public CustomerWaitState getWaitState() {
		return waitState;
	}

	public CustomerWaitChefState getWaitChefState() {
		return waitChefState;
	}

	public CustomerWaitServerState getWaitServerState() {
		return waitServerState;
	}

	public CustomerEatState getEatState() {
		return eatState;
	}

	public RestaurantMediator getMediator() {
		return mediator;
	}

	protected CustomerOrderServerState orderServerState;
	protected CustomerWaitState waitState;
	protected CustomerWaitChefState waitChefState;
	protected CustomerWaitServerState waitServerState;
	protected CustomerEatState eatState;
	private Customer customer;
	private Chef chef;

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public Customer getCustomer() {
		return customer;
	}

	protected RestaurantMediator mediator;

	public CustomerStateManager(RestaurantMediator mediator, Customer customer) {
		this.mediator = mediator;
		this.customer = customer;
		this.orderState = new CustomerOrderState();
		this.orderServerState = new CustomerOrderServerState();
		this.waitState = new CustomerWaitState();
		this.waitChefState = new CustomerWaitChefState();
		this.waitServerState = new CustomerWaitServerState();
		this.eatState = new CustomerEatState();
		this.currState = this.orderState;
		this.server = null;
		this.chef = null;
		this.currState.startState(this);
	}

	public void changeState(CustomerBaseState newState) {
		this.currState = newState;
		this.currState.startState(this);
		this.currState.getCurrentState();
	}

	public void Update() {
		
		if(this.customer.getTolerance() <= 0) {
			mediator.customerOutofTolerance(customer);
			this.customer.setShouldStop(true);
		}
		
		this.currState.updateState(this);
	}

	public void setServer(Server server) {
		this.server = server;
	}


}

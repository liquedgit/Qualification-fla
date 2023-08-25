package State.ChefState;

import Mediator.RestaurantMediator;
import Model.Chef;
import Model.Customer;

public class ChefStateManager {
	private ChefBaseState currState;
	public ChefBaseState getCurrState() {
		return currState;
	}
	protected ChefIdleState idleState;
	protected ChefCookState cookState;
	protected ChefDoneState doneState;
	private Chef chef;
	private Customer customer;
	
	public ChefIdleState getIdleState() {
		return idleState;
	}
	
	public ChefCookState getCookState() {
		return cookState;
	}

	public ChefDoneState getDoneState() {
		return doneState;
	}

	public RestaurantMediator getMediator() {
		return mediator;
	}
	
	public Chef getChef() {
		return chef;
	}
	protected RestaurantMediator mediator;
	public ChefStateManager(RestaurantMediator mediator, Chef chef) {
		this.idleState = new ChefIdleState();
		this.cookState = new ChefCookState();
		this.doneState = new ChefDoneState();
		this.currState = idleState;
		this.chef = chef;
		this.mediator = mediator;
		this.customer = null;
		this.currState.startState(this);
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void Update() {
		this.currState.updateState(this);
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void changeState(ChefBaseState newState) {
		this.currState = newState;
		this.currState.startState(this);
	}
}

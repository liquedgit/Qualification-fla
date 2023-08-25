package State.ServerState;

import Mediator.RestaurantMediator;
import Model.Chef;
import Model.Customer;
import Model.Server;

public class ServerStateManager {
	private ServerBaseState currState;
	protected ServerIdleState idleState;
	public ServerIdleState getIdleState() {
		return idleState;
	}

	public ServerTakeOrderState getTakeOrderState() {
		return takeOrderState;
	}

	public ServerWaitCookState getWaitCookState() {
		return waitCookState;
	}

	public ServerBringOrderState getBringOrderState() {
		return bringOrderState;
	}

	public ServerServingFoodState getServingFoodState() {
		return servingFoodState;
	}

	protected ServerTakeOrderState takeOrderState;
	protected ServerWaitCookState waitCookState;
	protected ServerBringOrderState bringOrderState;
	protected ServerServingFoodState servingFoodState;
	private Customer customer;
	private Server server;
	private Chef chef;
	public Server getServer() {
		return server;
	}

	protected RestaurantMediator mediator;
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public ServerStateManager(RestaurantMediator mediator, Server server) {
		this.mediator= mediator;
		this.idleState = new ServerIdleState();
		this.takeOrderState = new ServerTakeOrderState();
		this.waitCookState = new ServerWaitCookState();
		this.bringOrderState = new ServerBringOrderState();
		this.servingFoodState = new ServerServingFoodState();
		this.currState = idleState;
		this.server = server;
		this.chef = null;
		this.customer = null;
		this.currState.startState(this);
	}
	
	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void Update() {
		this.currState.updateState(this);
	}
	
	public ServerBaseState getCurrState() {
		return currState;
	}
	
	public void changeState(ServerBaseState newState) {
		this.currState = newState;
		this.currState.startState(this);
	}
	
}

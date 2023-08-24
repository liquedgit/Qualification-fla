package State.ChefState;

import Mediator.RestaurantMediator;
import Model.Chef;

public class ChefStateManager {
	private ChefBaseState currState;
	protected ChefIdleState idleState;
	protected ChefCookState cookState;
	protected ChefDoneState doneState;
	protected Chef chef;
	protected RestaurantMediator mediator;
	public ChefStateManager(RestaurantMediator mediator, Chef chef) {
		this.idleState = new ChefIdleState();
		this.cookState = new ChefCookState();
		this.doneState = new ChefDoneState();
		this.currState = idleState;
		this.chef = chef;
		this.mediator = mediator;
		this.currState.startState(this);
	}
}

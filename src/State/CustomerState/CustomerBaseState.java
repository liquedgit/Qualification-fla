package State.CustomerState;


public abstract class CustomerBaseState {
	public abstract void updateState(CustomerStateManager customer);
	public abstract void startState(CustomerStateManager customer);
	public abstract String getCurrentState();
}

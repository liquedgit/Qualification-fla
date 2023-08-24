package State.ChefState;


public abstract class ChefBaseState {
	public abstract void updateState(ChefStateManager customer);
	public abstract void startState(ChefStateManager customer);
	public abstract String getCurrentState();
}

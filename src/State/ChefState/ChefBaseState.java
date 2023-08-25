package State.ChefState;


public abstract class ChefBaseState {
	public abstract void updateState(ChefStateManager chef);
	public abstract void startState(ChefStateManager chef);
	public abstract String getCurrentState();
}

package State.ChefState;

public class ChefIdleState extends ChefBaseState {

	@Override
	public void updateState(ChefStateManager chef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startState(ChefStateManager chef) {
		// TODO Auto-generated method stub
		chef.mediator.addCheftoIdleQueue(chef.getChef());
	}

	@Override
	public String getCurrentState() {
		// TODO Auto-generated method stub
		return "idle";
	}
	
}

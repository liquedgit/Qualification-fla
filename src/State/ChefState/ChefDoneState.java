package State.ChefState;

public class ChefDoneState extends ChefBaseState{
	private ChefStateManager chef;
	@Override
	public void updateState(ChefStateManager chef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startState(ChefStateManager chef) {
		// TODO Auto-generated method stub
		this.chef = chef;
		chef.mediator.addCheftoIdleQueue(chef.getChef());
	}

	@Override
	public String getCurrentState() {
		// TODO Auto-generated method stub
		return "Done <"+chef.getCustomer().getName()+">";
	}

}

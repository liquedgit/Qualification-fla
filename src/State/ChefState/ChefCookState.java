package State.ChefState;

public class ChefCookState extends ChefBaseState{
	private ChefStateManager chef;
	@Override
	public void updateState(ChefStateManager chef) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(6000 - chef.getChef().getSpeed());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chef.changeState(chef.doneState);
	}

	@Override
	public void startState(ChefStateManager chef) {
		// TODO Auto-generated method stub
		this.chef = chef;
	}

	@Override
	public String getCurrentState() {
		// TODO Auto-generated method stub
		return "Cook <"+chef.getCustomer().getName()+">";
	}

}

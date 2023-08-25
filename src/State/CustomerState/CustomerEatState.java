package State.CustomerState;

import Model.Chef;

public class CustomerEatState extends CustomerBaseState{

	@Override
	public void updateState(CustomerStateManager customer) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customer.mediator.customerdoneEating(customer.getCustomer(), customer.getChef());
	}

	@Override
	public void startState(CustomerStateManager customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCurrentState() {
		// TODO Auto-generated method stub
		return "<Eat>";
	}

	

}

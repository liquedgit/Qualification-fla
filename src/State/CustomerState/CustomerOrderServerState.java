package State.CustomerState;

import Model.Customer;

public class CustomerOrderServerState extends CustomerBaseState {
	private CustomerStateManager customer;
	@Override
	public void updateState(CustomerStateManager customer) {
		// TODO Auto-generated method stub
	}

	@Override
	public void startState(CustomerStateManager customer) {
		// TODO Auto-generated method stub
		this.customer = customer;
	}

	@Override
	public String getCurrentState() {
		// TODO Auto-generated method stub
		return "Order <"+this.customer.getServer().getName()+">";
	}

	

}

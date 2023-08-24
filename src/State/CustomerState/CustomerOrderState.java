package State.CustomerState;

public class CustomerOrderState extends CustomerBaseState{
	@Override
	public void updateState(CustomerStateManager customer) {
		// TODO Auto-generated method stub
		if(customer.getInteractingWith() != null) {
			customer.changeState(customer.orderServerState);
		}
	}

	@Override
	public void startState(CustomerStateManager customer) {
		// TODO Auto-generated method stub
		customer.mediator.addCustomertoIdleQueue(customer.getCustomer());
	}

	@Override
	public String getCurrentState() {
		// TODO Auto-generated method stub
		return "<Order>";
	}

	
	

	
}

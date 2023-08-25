package State.CustomerState;

public class CustomerWaitServerState extends CustomerBaseState{
	private CustomerStateManager customer;
	@Override
	public void updateState(CustomerStateManager customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startState(CustomerStateManager customer) {
		// TODO Auto-generated method stub
		this.customer =customer;
	}

	@Override
	public String getCurrentState() {
		// TODO Auto-generated method stub
		return "Wait food <";
	}

}

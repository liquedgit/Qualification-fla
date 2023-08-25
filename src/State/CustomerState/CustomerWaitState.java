package State.CustomerState;

public class CustomerWaitState extends CustomerBaseState {

	@Override
	public void updateState(CustomerStateManager customer) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customer.getCustomer().decreaseTolerance();
	}

	@Override
	public void startState(CustomerStateManager customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCurrentState() {
		// TODO Auto-generated method stub
		return "Wait Food";
	}

}

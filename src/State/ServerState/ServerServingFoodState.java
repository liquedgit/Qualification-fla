package State.ServerState;

public class ServerServingFoodState extends ServerBaseState{
	private ServerStateManager server;
	@Override
	public void updateState(ServerStateManager server) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		server.getCustomer().getCurrState().changeState(server.getCustomer().getCurrState().getEatState());
		
		server.changeState(server.idleState);
	}

	@Override
	public void startState(ServerStateManager server) {
		// TODO Auto-generated method stub
		this.server = server;
	}

	@Override
	public String getCurrentState() {
		// TODO Auto-generated method stub
		return "Serving food <"+server.getCustomer().getName()+">";
	}

}

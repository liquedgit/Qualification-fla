package State.ServerState;

public class ServerBringOrderState extends ServerBaseState {
	private ServerStateManager server;
	@Override
	public void updateState(ServerStateManager server) {
		// TODO Auto-generated method stub
		server.mediator.chefAssignJob(server.getCustomer(), server.getServer(), server.getChef());
	}

	@Override
	public void startState(ServerStateManager server) {
		// TODO Auto-generated method stub
		this.server = server;
	}

	@Override
	public String getCurrentState() {
		// TODO Auto-generated method stub
		return "Bring order <"+server.getChef().getName()+">";
	}

}

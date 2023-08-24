package State.ServerState;

public class ServerTakeOrderState extends ServerBaseState{
	private ServerStateManager server;
	@Override
	public void updateState(ServerStateManager server) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startState(ServerStateManager server) {
		// TODO Auto-generated method stub
		this.server = server;
	}

	@Override
	public String getCurrentState() {
		// TODO Auto-generated method stub
		if(server == null) {
			return "";
		}
		return "<"+server.getCustomer().getName()+">";
	}

}

package State.ServerState;

public class ServerTakeOrderState extends ServerBaseState{
	private ServerStateManager server;
	@Override
	public void updateState(ServerStateManager server) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(6000 - server.getServer().getSpeed());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		server.mediator.customerWaitFood(server.getCustomer());
		server.changeState(server.waitCookState);
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

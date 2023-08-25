package State.ServerState;

public class ServerWaitCookState extends ServerBaseState{

	@Override
	public void updateState(ServerStateManager server) {
		// TODO Auto-generated method stub
		if(server.mediator.checkAvailableChef(server.getServer())){
			server.changeState(server.bringOrderState);
		}
		
	}

	@Override
	public void startState(ServerStateManager server) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCurrentState() {
		// TODO Auto-generated method stub
		return "Wait cook";
	}

}

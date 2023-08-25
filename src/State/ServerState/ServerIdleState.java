package State.ServerState;

public class ServerIdleState extends ServerBaseState{

	@Override
	public void updateState(ServerStateManager server) {
		// TODO Auto-generated method stub
		Boolean res = server.mediator.serverAssignJob(server.getServer());
		if(res) {
			server.changeState(server.takeOrderState);
		}
		
		if(server.mediator.checkDoneChef(server.getServer())){
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
		return "idle";
	}

}

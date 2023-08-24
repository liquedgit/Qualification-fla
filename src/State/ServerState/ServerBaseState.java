package State.ServerState;


public abstract class ServerBaseState {
	public abstract void updateState(ServerStateManager server);
	public abstract void startState(ServerStateManager server);
	public abstract String getCurrentState();
}

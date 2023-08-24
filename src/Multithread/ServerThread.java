package Multithread;

import Manager.GameManager;
import Model.Server;

public class ServerThread implements Runnable {
	
	private GameManager instance;
	private Server server;
	
	public ServerThread(Server server) {
		this.server = server;
		this.instance = GameManager.GetInstance();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!instance.getIsEnded()) {
			if(instance.getIsRunning()) {
				server.getCurrState().Update();
			}
		}
	}
	
	
}

package Multithread;

import java.util.Scanner;

import Facade.GameFacade;

public class GameThreading implements Runnable{
	
	private GameFacade gf;
	
	public GameThreading() {
		this.gf = new GameFacade();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		gf.GameRunning();
		
	}

}

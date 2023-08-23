package Pages;
import Facade.GameFacade;
import Multithread.GameThreading;

public class PlayPage extends BasePage {
	private GameFacade gf;
	public PlayPage() {
		this.gf = new GameFacade();
	}
	
	@Override
	public void ShowPage() {
		// TODO Auto-generated method stub
		new Thread(new GameThreading()).start();
		gf.toogleIsPause();
		
	}
	
}

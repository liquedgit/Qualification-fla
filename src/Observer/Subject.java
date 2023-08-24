package Observer;

public interface Subject {
	public void addSubscriber(Observer observer);
	public void removeSubscriber(Observer observer);
	public void notifySubscriber(int emptySeat);
}

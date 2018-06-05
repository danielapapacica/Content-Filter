

abstract class Observer{
	protected StocksSubject subject;
	public abstract void update(String updateTypeMessage);
}



public class ObserverFactory {
	
	private static final ObserverFactory INSTANCE = new ObserverFactory();
	
	private ObserverFactory() {
	}
	
	public static ObserverFactory getInstance() {
		return INSTANCE;
	}

	
	public Observer createObserver(int id, String[] filter, StocksSubject subject) {
		
		return new ClassicObserver(id, filter, subject);

	}

}

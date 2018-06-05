import java.util.*;

public class StocksSubject {
	
	private static final StocksSubject INSTANCE = new StocksSubject();
	
	private StocksSubject() {
	}
	
	public static StocksSubject getInstance() {
		return INSTANCE;
	}
	
	
	// list of observers
	 private ArrayList<Observer> observers = new ArrayList<Observer>();
	 
	 private TreeMap<String, Double> stocks = new TreeMap<String, Double>();
	 
	 public ArrayList<Observer> getObservers(){
		 return observers;
	 }
	 
	 public void add(Observer o) {
	        observers.add(o);
	        o.update("new observer added");
	 }
	 
	 public void remove(int id) {
		 for(Observer observer:observers)
			 if(((ClassicObserver)observer).id == id) {
				 observers.remove(observer);
				 break;
			 }
	 }
	 
	 public TreeMap<String, Double> getStocks(){
		 return stocks;
	 }
	 
	 
	 // To add a new stock in the treemap or modify the value of a certain stock
	 public void addToStockOrModify(String name, double value){
		 stocks.put(name, value);
		 execute("add To Stock Or Modify");
	 }
	 
	 private void execute(String updateTypeMessage) {
	    for (Observer observer : observers) {
	        observer.update(updateTypeMessage);
	    }
	 }
}

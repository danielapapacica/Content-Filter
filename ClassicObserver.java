import java.util.*;

public class ClassicObserver extends Observer{
	
	int id;
	Filter filter;
	private TreeMap<String, StocksInfo> stocks = new TreeMap<String, StocksInfo>();


	public ClassicObserver(int id, String[] filterExpression, StocksSubject subject) {
		this.filter = new Filter(filterExpression);
		this.id = id;
		this.subject = subject;
		this.subject.add(this);
	}
	
	@Override
	public void update(String updateTypeMessage) {
		
		TreeMap<String, Double> subjectStocks = subject.getStocks();
		
		// if a new stock have been added to the treemap
		// or a new obsever have been created
		if(subjectStocks.size() > stocks.size()) {
			for(String name:(subjectStocks.keySet())) {
				if(!stocks.containsKey(name)) {
					StocksInfo info = new StocksInfo();
					info.setLastValue(subjectStocks.get(name));
					if(updateTypeMessage.equals("new observer added"))
						info.resetNumberOfChanges();
					stocks.put(name, info);
					if(!updateTypeMessage.equals("new observer added"))
						break;
				}
			}
			
			return;
		}
        else
		    // if the value of a stock have been modified
		    for(String name:(subjectStocks.keySet())) {
			    if(subjectStocks.get(name) != stocks.get(name).getLastValue()) {
				    stocks.get(name).setLastValue(subjectStocks.get(name));
				    break;
			    }
		    }	
	}
	
	public void print(){
		FilterVisitor visitor = new FilterVisitor();
		for(String name:(stocks.keySet())) {
			
			visitor.setName(name);
			visitor.setValue(stocks.get(name).getLastValue());
			
			if(filter.filterTree.accept(visitor)) {
				
				System.out.println("obs " + this.id + ": " + name + " " 
						+ String.format("%.2f", stocks.get(name).getLastValue() ) 
						+ " " + String.format("%.2f", stocks.get(name).getFluctuation() ) 
						+ "% " + stocks.get(name).getNumberOfChanges()  );
				stocks.get(name).resetNumberOfChanges();
			}
		}
	}
	
	
}

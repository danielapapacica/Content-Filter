import java.util.*;

public class Main {
	
	public static String addSpacesBrackets(String str){
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(' || str.charAt(i) == ')') {
				str = str.substring(0, i) + " " + str.charAt(i) + " " + str.substring(i+1);
				i++;
			}
		}
		
		return str;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);	
		StocksSubject subject = StocksSubject.getInstance();	
		ObserverFactory obsFactory = ObserverFactory.getInstance();
		
		// read commands
		String line = s.nextLine();
		
		while(!line.equals("end")) {
			line = s.nextLine();
			if(line.contains(")") ||  line.contains("(")) {
				line = addSpacesBrackets(line);
			}
			String[] parts = line.split("\\s+");
					
			
			switch(parts[0]) {
			
			case "create_obs":	
				obsFactory.createObserver(Integer.parseInt(parts[1]),
						Arrays.copyOfRange(parts, 2, parts.length), subject);
				break;
				
			case "feed":
				subject.addToStockOrModify(parts[1], Double.parseDouble(parts[2]));
				break;
				
			case "delete_obs":
				subject.remove(Integer.parseInt(parts[1]));
				break;
				
			case "print":
				ArrayList<Observer> observers = subject.getObservers();
				for(Observer observer:observers) {
					 if(((ClassicObserver)observer).id == Integer.parseInt(parts[1])) {
						 ((ClassicObserver)observer).print();
					 }			 
				}
				break;
			}
		}
		
		s.close();
		
		
	}
		
}

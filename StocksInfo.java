
public class StocksInfo {
	
	private double lastValue;
	private double lastValueFromPrint;
	private int numberOfChanges;
	
	public double getLastValue() {
		return lastValue;
	}
	
	public double getLastValueFromPrint() {
		return lastValueFromPrint;
	}
	
	public int getNumberOfChanges() {
		return numberOfChanges;
	}
	
	public void resetNumberOfChanges() {
		this.numberOfChanges = 0;
	}
	
	public void setLastValue(double value) {
		this.lastValue = value;
		this.numberOfChanges++;
	}
	
	public void setLastValueFromPrint(double value) {
		this.lastValueFromPrint = value;
	}
	
	public double getFluctuation() {
		
		if(lastValueFromPrint == 0) {
			setLastValueFromPrint(lastValue);
			return 0;
		}
		double d = ((lastValue - lastValueFromPrint)/lastValueFromPrint) * 100;
		setLastValueFromPrint(lastValue);
		return d;
	}
}

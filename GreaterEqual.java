public class GreaterEqual extends Operator{

	double toCompare;
	
	public GreaterEqual(double value) {
		this.toCompare = value;
	}
	
	@Override
	boolean check(Object value) {
		
		return (double)value >= this.toCompare;
	}


}

public class Greater extends Operator{

	double toCompare;
	
	public Greater(double value) {
		this.toCompare = value;
	}
	
	@Override
	boolean check(Object value) {
		
		return (double)value > this.toCompare;
	}


}

public class Lower extends Operator{

	double toCompare;
	
	public Lower(double value) {
		this.toCompare = value;
	}
	
	@Override
	boolean check(Object value) {
		
		return (double)value < this.toCompare;
	}


}

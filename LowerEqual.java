public class LowerEqual extends Operator{

	double toCompare;
	
	public LowerEqual(double value) {
		this.toCompare = value;
	}
	
	@Override
	boolean check(Object value) {
		
		return (double)value <= this.toCompare;
	}


}

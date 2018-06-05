public class NotEqual extends Operator{

	// a name or a value
	Object toCompare;
	
	public NotEqual(Object toCompare) {
		this.toCompare = toCompare;
	}
	
	@Override
	boolean check(Object obj) {
		
		return !this.toCompare.equals(obj);
	}


}

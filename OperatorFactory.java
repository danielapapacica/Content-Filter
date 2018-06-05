abstract class Operator {
	abstract boolean check(Object obj);
}



public class OperatorFactory {
	
	private static final OperatorFactory INSTANCE = new OperatorFactory();
	
	private OperatorFactory() {
	}
	
	public static OperatorFactory getInstance() {
		return INSTANCE;
	}
	
	
	public Operator createOperator(String operation, String objType, String obj) {
		
		Operator operator = null;
		switch(operation) {
		case "nil":
			operator = new NoOperation();
			break;
		case "eq":
			if(objType.equals("name"))
				operator = new Equal(obj);
			else
				operator = new Equal(Double.parseDouble(obj));
			break;
		case "ne":
			if(objType.equals("name"))
				operator = new NotEqual(obj);
			else
				operator = new NotEqual(Double.parseDouble(obj));
			break;
		case "lt":
			operator = new Lower(Double.parseDouble(obj));
			break;
		case "le":
			operator = new LowerEqual(Double.parseDouble(obj));
			break;
		case "gt":
			operator = new Greater(Double.parseDouble(obj));
			break;
		case "ge":
			operator = new GreaterEqual(Double.parseDouble(obj));
			break;
		}
		
		return operator;

	}

}

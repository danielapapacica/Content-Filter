
interface IVisitor {

    boolean visit(OrNode operatorNode);

    boolean visit(AndNode operatorNode);

    boolean visit(ExpressionNode expNode);
}

class FilterVisitor implements IVisitor {
	
	String name;
	double value;
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

    @Override
    public boolean visit(OrNode operatorNode) {
        return operatorNode.Left.accept(this) || operatorNode.Right.accept(this);
    }

    @Override
    public boolean visit(AndNode operatorNode) {
        return operatorNode.Left.accept(this) && operatorNode.Right.accept(this);
    }

    @Override
    public boolean visit(ExpressionNode expNode) {
    	
    	// verify if the operator eq/ne compares the name or the value
    	if((expNode.operator instanceof Equal && ((Equal)expNode.operator).toCompare instanceof String)
    		|| (expNode.operator instanceof NotEqual && ((NotEqual)expNode.operator).toCompare instanceof String)){
    		
    		return expNode.operator.check(this.name);
    	}

    	return expNode.operator.check(this.value);
    		
    }    
    
}
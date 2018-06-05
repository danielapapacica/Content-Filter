import java.util.*;

public class Filter {
	
	// array of words consisting the filter expression
	Node filterTree;
	
	public Filter(String[] filterExpression) {
		this.filterTree = CreateFilter(filterExpression);
	}
	
	public static final String[] operatorTypes =  new String[]{"eq", "ne", "gt", "ge", "lt", "le"};
	
	public Node CreateFilter(String[] filter) {
		
		LinkedList<Object> outputList = new LinkedList<Object>();	
		Stack<String> logicalOperatorStack = new Stack<String>();	
		OperatorFactory opFactory = OperatorFactory.getInstance();		
		
	// Fill the output List
		for(int i = 0; i < filter.length; i++) {
			String word = filter[i];
			
			// put logical opearators on the operator Stack
			if(word.equals("||") || word.equals("&&") || word.equals("(")) {
				logicalOperatorStack.push(word);
				
			// take out logical opearators between brackets from Stack and put them on the ouput List to set their priority
			}else if(word.equals(")")) {
				
				while(!word.equals("(")) {
					word = logicalOperatorStack.pop();
					outputList.addLast(word);
				}
				
				// remove the last objet put into the output list (the bracket "(") 
				outputList.removeLast();
				
			// putt expressions witch include operators(ne/eq/ ...) on the output list
			}else if (Arrays.asList(operatorTypes).contains(word)) {
				Operator op = opFactory.createOperator(word, filter[i+1], filter[i+2]);
				ExpressionNode expNode = new ExpressionNode(op);
				i +=2;
				outputList.addLast(expNode);
				
			}else if (word.equals("nil")) {
				Operator op = opFactory.createOperator(word, null, null);
				ExpressionNode expNode = new ExpressionNode(op);
				outputList.addLast(expNode);
			}	
		}
		
		// the root logical operator
		if(!logicalOperatorStack.isEmpty()) {
			outputList.addLast(logicalOperatorStack.pop());
		}
		
//System.out.println("Size " + outputList.size());
		
		
	// Create the tree
		while(outputList.size() > 1) {
			
			// auxiliar list
			LinkedList<Object> auxList = new LinkedList<Object>();
			
			// create nodes for the tree. Put the operators in Expression Nodes.
			// Put 2 ExppresionNodes as leaves ofr the next logical operator Node(AndNode/OrNode)
			while(!outputList.isEmpty()) {
				Object obj = outputList.removeFirst();
//System.out.println(outputList.size());
				if(obj instanceof String) {
					if(obj.equals("||")) {
						OrNode orNode = new OrNode((Node)auxList.removeLast(), (Node)auxList.removeLast());
						auxList.addLast(orNode);
					}else if(obj.equals("&&")){
						AndNode andNode = new AndNode((Node)auxList.removeLast(), (Node)auxList.removeLast());
						auxList.addLast(andNode);
					}	
				}else 
					auxList.add(obj);
			}	
			outputList = auxList;
			
		}
		
		return (Node)outputList.remove();
	}
}

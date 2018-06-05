
interface IVisitable {

    boolean accept(IVisitor visitor);
}

class Node implements IVisitable {

    public Node Left;
    public Node Right;

    public Node(Node left, Node right) {
        Left = left;
        Right = right;
    }

    @Override
    public boolean accept(IVisitor visitor) {
        //throw new NotImplementedException();
    	return false;
    }
}

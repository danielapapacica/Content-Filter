
class OrNode extends Node implements IVisitable {

    public OrNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public boolean accept(IVisitor visitor) {
        return visitor.visit(this);
    }
}

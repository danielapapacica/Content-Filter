
class AndNode extends Node implements IVisitable {

    public AndNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public boolean accept(IVisitor visitor) {
        return visitor.visit(this);
    }
}

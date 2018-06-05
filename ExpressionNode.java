
class ExpressionNode extends Node implements IVisitable {

    public Operator operator;

    public ExpressionNode(Operator operator) {
        super(null, null);
        this.operator = operator;
    }

    @Override
    public boolean accept(IVisitor visitor) {
        return visitor.visit(this);
    }
}

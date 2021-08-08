package cn.emengjzs.ddel.expression;

public class DecimalLiteralNode extends LiteralNode {
    private final int value;

    public DecimalLiteralNode(int value) {
        this.value = value;
    }

    @Override
    public Object getValue() {
        return value;
    }
}

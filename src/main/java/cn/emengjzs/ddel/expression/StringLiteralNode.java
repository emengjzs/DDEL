package cn.emengjzs.ddel.expression;

public class StringLiteralNode extends LiteralNode {
    private final String value;

    public StringLiteralNode(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}

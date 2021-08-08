package cn.emengjzs.ddel.expression;

public class VarNode extends ExpressionNode {
    private final String name;

    public VarNode(String name) {
        this.name = name;
    }
}

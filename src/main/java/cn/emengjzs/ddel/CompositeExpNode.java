package cn.emengjzs.ddel;

import java.util.List;

public class CompositeExpNode extends ExpNode {
    protected Operator operator;
    protected List<ExpNode> children;

    public CompositeExpNode(Operator operator, List<ExpNode> children) {
        this.operator = operator;
        this.children = children;
    }

    public int getChildSize() {
        return children.size();
    }

    public Object evaluate(ExpNodeEvaluator evaluator) {
        return operator.evaluate(evaluator, children);
    }
}

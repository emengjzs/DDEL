package cn.emengjzs.ddel;

public class ConstNode extends ExpNode {
    private final Object value;

    public ConstNode(Object value) {
        this.value = value;
    }

    @Override
    public int getChildSize() {
        return 0;
    }

    @Override
    public Object evaluate(ExpNodeEvaluator evaluator) {
        return value;
    }
}

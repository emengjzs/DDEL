package cn.emengjzs.ddel;

public class ExpNodeEvaluator {
    public Object evaluate(ExpNode node) {
        return node.evaluate(this);
    }
}

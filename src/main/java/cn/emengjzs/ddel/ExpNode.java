package cn.emengjzs.ddel;

public abstract class ExpNode {

    public abstract int getChildSize();

    public abstract Object evaluate(ExpNodeEvaluator evaluator);

}

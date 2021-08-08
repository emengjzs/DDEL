package cn.emengjzs.ddel;


public abstract class ExpNode {
    protected String name;

    public abstract int getChildSize();

    public abstract Object evaluate(ExpNodeEvaluator evaluator);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

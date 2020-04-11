package cn.emengjzs.ddel;

import jdk.dynalink.linker.GuardedInvocation;
import jdk.dynalink.linker.LinkRequest;

import java.util.List;

public abstract class Operator {
    protected final String name;

    protected Operator(String name) {
        this.name = name;
    }

    public abstract Object evaluate(ExpNodeEvaluator evaluator, List<ExpNode> nodes);

    public String getName() {
        return name;
    }

    public abstract GuardedInvocation createGuardedInvocation(LinkRequest request);
}

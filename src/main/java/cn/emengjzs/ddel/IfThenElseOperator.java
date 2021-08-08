package cn.emengjzs.ddel;

import jdk.dynalink.linker.GuardedInvocation;
import jdk.dynalink.linker.LinkRequest;

import java.util.List;

public class IfThenElseOperator extends Operator {

    protected IfThenElseOperator() {
        super("IfThenElse");
    }

    @Override
    public Object evaluate(ExpNodeEvaluator evaluator, List<ExpNode> nodes) {
        return (Boolean) evaluator.evaluate(nodes.get(0)) ?
                evaluator.evaluate(nodes.get(1)) :
                evaluator.evaluate(nodes.get(2));
    }

    @Override
    public GuardedInvocation createGuardedInvocation(LinkRequest request) {
        return null;
    }
}

package cn.emengjzs.ddel;

import jdk.dynalink.linker.GuardedInvocation;
import jdk.dynalink.linker.LinkRequest;

import java.util.ArrayList;
import java.util.List;

public class ListOperator extends Operator {

    protected ListOperator() {
        super("List");
    }

    @Override
    public Object evaluate(ExpNodeEvaluator evaluator, List<ExpNode> nodes) {
        List<Object> list = new ArrayList<>(nodes.size());
        nodes.forEach(node -> list.add(evaluator.evaluate(node)));
        return list;
    }

    @Override
    public GuardedInvocation createGuardedInvocation(LinkRequest request) {
        return null;
    }
}

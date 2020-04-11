package cn.emengjzs.ddel.dlink;

import cn.emengjzs.ddel.Operator;
import jdk.dynalink.Operation;

public class MyOperation implements Operation {
    Operator operator;

    public MyOperation(Operator operator) {
        this.operator = operator;
    }

    public Operator getOperator() {
        return operator;
    }
}

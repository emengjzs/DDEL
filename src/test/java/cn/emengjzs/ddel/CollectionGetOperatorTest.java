package cn.emengjzs.ddel;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class CollectionGetOperatorTest {

    @Test
    public void test() {
        ExpNode node = new CompositeExpNode(
                new CollectionGetOperator(),
                List.of(new ConstNode(Map.of("1", "2")),
                        new ConstNode("1"))
        );
        ExpNodeEvaluator evaluator = new ExpNodeEvaluator();
        Assert.assertEquals(evaluator.evaluate(node), "2");
        Assert.assertEquals(evaluator.evaluate(node), "2");
    }

}

package cn.emengjzs.ddel;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class CollectionGetOperatorTest {

    @Test
    public void test() {
        ExpNode node = new CompositeExpNode(
                new CollectionGetOperator(),
                List.of(
                        new CompositeExpNode(
                                new ListOperator(),
                                List.of(new ConstNode("1"), new ConstNode("2")
                                )
                        ),
                        new ConstNode(1)
                )
        );

        ExpNodeEvaluator evaluator = new ExpNodeEvaluator();
        Assert.assertEquals(evaluator.evaluate(node), "2");

        Runnable runnable = () -> Assert.assertEquals(evaluator.evaluate(node), "2");

        for (int j = 1; j < 100; j ++) {
            long begin = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                runnable.run();
            }
            System.out.println(System.currentTimeMillis() - begin);
        }
    }


    @Test
    public void test2() throws Throwable {
       run(() -> {
           try {
               Assert.assertEquals(
                       CollectionGetOperator.HANDLE_MAP_GET.invoke(Map.of("1", "2"), "1"), "2");
           } catch (Throwable throwable) {
               throwable.printStackTrace();
           }
           return null;
       });
    }

    @Test
    public void test3() throws Throwable {
        run(() -> {
            try {
                Assert.assertEquals(
                        CollectionGetOperator.HANDLE_IS_MAP.invoke(Map.of("1", "2"), "1"), true);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return null;
        });
    }


    private void run(Callable runnable) throws Throwable {
        for (int j = 1; j < 100; j ++) {
            long begin = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                runnable.call();
            }
            System.out.println(System.currentTimeMillis() - begin);
        }
    }
}

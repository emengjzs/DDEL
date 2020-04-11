package cn.emengjzs.ddel;

import cn.emengjzs.ddel.dlink.MyLinker;
import jdk.dynalink.linker.GuardedInvocation;
import jdk.dynalink.linker.LinkRequest;
import jdk.dynalink.linker.support.Guards;
import jdk.dynalink.linker.support.Lookup;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.List;
import java.util.Map;

public class CollectionGetOperator extends Operator {
    private CallSite callSite;

    public CollectionGetOperator() {
        super("CollectionGet");
    }

    public Object evaluate(ExpNodeEvaluator evaluator, List<ExpNode> nodes) {
        Object collection = evaluator.evaluate(nodes.get(0));
        Object key = evaluator.evaluate(nodes.get(1));
        if (callSite != null) {
            try {
                return callSite.dynamicInvoker().invoke(collection, key);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        if (collection == null || key == null) {
            return null;
        }
        callSite = MyLinker.createCallSite(this, MethodType.methodType(Object.class, collection.getClass(), key.getClass()));
        if (collection instanceof Map) {
            return ((Map) collection).get(key);
        }
        if (collection instanceof List && key instanceof Number) {
            return ((List) collection).get(((Number) key).intValue());
        }
        return null;
    }

    @Override
    public GuardedInvocation createGuardedInvocation(LinkRequest request) {
        Object[] arguments = request.getArguments();
        if (arguments[0] instanceof Map) {
            return new GuardedInvocation(HANDLE_MAP_GET, HANDLE_IS_MAP);
        }
        if (arguments[0] instanceof List && arguments[1] instanceof Number) {
            return new GuardedInvocation(HANDLE_LIST_GET, HANDLE_IS_LIST);
        }
        return null;
    }

    public static Object mapGet(Map map, Object key) {
        return map == null || key ==null ? null : map.get(key);
    }

    public static Object listGet(List list, Number key) {
        return list == null ? null : list.get(key.intValue());
    }

    public static final Lookup lookup = new Lookup(MethodHandles.lookup());
    private static final MethodHandle HANDLE_MAP_GET = lookup.findOwnStatic("mapGet", Object.class, Map.class, Object.class);
    private static final MethodHandle HANDLE_IS_MAP = Guards.isInstance(Map.class, 1, HANDLE_MAP_GET.type());

    private static final MethodHandle HANDLE_LIST_GET = lookup.findOwnStatic("listGet", Object.class, List.class, Number.class);
    private static final MethodHandle HANDLE_IS_LIST = Guards.isInstance(List.class, 1, HANDLE_MAP_GET.type());
}

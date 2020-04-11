package cn.emengjzs.ddel.dlink;

import cn.emengjzs.ddel.Operator;
import jdk.dynalink.CallSiteDescriptor;
import jdk.dynalink.DynamicLinker;
import jdk.dynalink.DynamicLinkerFactory;
import jdk.dynalink.Operation;
import jdk.dynalink.linker.GuardingDynamicLinker;
import jdk.dynalink.support.SimpleRelinkableCallSite;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MyLinker {
    private static final GuardingDynamicLinker DDL_LANGUAGE_LINKER = new MyGuardingDynamicLinker();
    private static final DynamicLinker LINKER = createDynamicLinker();
    private static final MethodHandles.Lookup LOOKUP = MethodHandles.lookup();

    private static DynamicLinker createDynamicLinker() {
        final DynamicLinkerFactory factory = new DynamicLinkerFactory();
        factory.setPrioritizedLinker(DDL_LANGUAGE_LINKER);
        return factory.createLinker();
    }

    public static CallSite createCallSite(Operator operator, MethodType type) {
        return LINKER.link(
                new SimpleRelinkableCallSite(
                        new CallSiteDescriptor(LOOKUP, parseOperation(operator), type)));
    }

    private static MyOperation parseOperation(Operator operator) {
        return new MyOperation(operator);
    }
}

package cn.emengjzs.ddel.dlink;

import jdk.dynalink.CallSiteDescriptor;
import jdk.dynalink.Operation;
import jdk.dynalink.linker.GuardedInvocation;
import jdk.dynalink.linker.GuardingDynamicLinker;
import jdk.dynalink.linker.LinkRequest;
import jdk.dynalink.linker.LinkerServices;

public class MyGuardingDynamicLinker implements GuardingDynamicLinker {

    @Override
    public GuardedInvocation getGuardedInvocation(LinkRequest request, LinkerServices linkerServices) throws Exception {
        final CallSiteDescriptor callSiteDescriptor = request.getCallSiteDescriptor();
        final Operation operation = callSiteDescriptor.getOperation();
        if (! (operation instanceof MyOperation)) {
            return null;
        }
        final MyOperation myOperation = (MyOperation) operation;
        return myOperation.getOperator().createGuardedInvocation(request);
    }
}

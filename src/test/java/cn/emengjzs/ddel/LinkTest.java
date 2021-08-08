package cn.emengjzs.ddel;

import cn.emengjzs.ddel.dlink.MyGuardingDynamicLinker;
import cn.emengjzs.ddel.dlink.MyOperation;
import jdk.dynalink.*;
import jdk.dynalink.beans.BeansLinker;
import jdk.dynalink.linker.GuardedInvocation;
import jdk.dynalink.linker.GuardingDynamicLinker;
import jdk.dynalink.linker.LinkRequest;
import jdk.dynalink.linker.LinkerServices;
import jdk.dynalink.linker.support.Guards;
import jdk.dynalink.support.SimpleRelinkableCallSite;
import org.junit.Test;
import org.objectweb.asm.*;
import org.springframework.lang.Nullable;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.concurrent.Callable;

import static org.objectweb.asm.Opcodes.*;


public class LinkTest {

    private static final DynamicLinker LINKER = createDynamicLinker();
    private static final MethodHandles.Lookup LOOKUP = MethodHandles.lookup();
    private static ChildClassLoader childClassLoader = new ChildClassLoader(LinkTest.class.getClassLoader());

    private static DynamicLinker createDynamicLinker() {
        final DynamicLinkerFactory factory = new DynamicLinkerFactory();
        factory.setPrioritizedLinker(myLinker());
        return factory.createLinker();
    }

    static GuardingDynamicLinker myLinker() {
        BeansLinker beansLinker = new BeansLinker();
        return new  GuardingDynamicLinker() {
            @Override
            public GuardedInvocation getGuardedInvocation(LinkRequest request, LinkerServices linkerServices) throws Exception {
                Object receiver = request.getReceiver();
                if (receiver == null) {
                    return new GuardedInvocation(MethodHandles.empty(MethodType.methodType(Integer.class, A.class)),
                            Guards.isNull().asType(MethodType.methodType(Boolean.class, A.class)));
                }
                return null;
            }
        };
    };

    public static CallSite createCallSite() {
        return LINKER.link(
                new SimpleRelinkableCallSite(
                        new CallSiteDescriptor(LOOKUP, StandardOperation.GET
                                .withNamespace(StandardNamespace.PROPERTY)
                                .named("x"), MethodType.methodType(Integer.class, A.class))));
    }

    public static CallSite bootstrap(MethodHandles.Lookup lookup, String name, MethodType type) {
        System.out.println(name + " " + type.toString());
        return LINKER.link(
                new SimpleRelinkableCallSite(
                        new CallSiteDescriptor(lookup, StandardOperation.GET
                                .withNamespace(StandardNamespace.PROPERTY)
                                .named("x"), type)));
    }

    @Test
    public void test() throws Throwable {
        CallSite callSite = createCallSite();
        MethodHandle methodHandle = callSite.dynamicInvoker();
        Object invoke ;
        long start;
        int j = 0;
//
//        for (int k = 0; k < 100; k ++ ) {
//            start = System.currentTimeMillis();
//            for (int i = 0; i < 1000000; i++) {
//                Integer a = (Integer) methodHandle.invokeExact((A) null);
//                if (a == null) j++;
//            }
//            System.out.println("null " + (System.currentTimeMillis() - start));
//        }
//
//
//        start= System.currentTimeMillis();
//
//        for (int i = 0; i < 1000000; i ++ ) {
//            invoke = methodHandle.invoke(new A(i));
//            if (invoke == null) j ++;
//        }
//        System.out.println(System.currentTimeMillis() - start);
//
//        start= System.currentTimeMillis();
//
//        for (int i = 0; i < 1000000; i ++ ) {
//            invoke = methodHandle.invoke((Object) null);
//            if (invoke == null) j ++;
//        }
//        System.out.println(System.currentTimeMillis() - start);
//
//
//
//
        for (int k = 0; k < 100; k ++ ) {
            start= System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                Object a = new A(i);
                if (a instanceof A) {
                    Integer x = ((A) a).getX();
                    if (x == null) j++;
                }
            }
            System.out.println("base " + (System.currentTimeMillis() - start));
        }
//
//        for (int k = 0; k < 1000; k ++ ) {
//            start= System.currentTimeMillis();
//            for (int i = 0; i < 1000000; i++) {
//                A a = new A(i);
//                Integer b = (Integer) methodHandle.invokeExact(a);
//                if (b == null) j++;
//            }
//            System.out.println("methodHandle " + (System.currentTimeMillis() - start));
//        }


        XMethod xMethod = create();
        System.out.println(xMethod.get(new A(1)));
        for (int k = 0; k < 1000; k ++ ) {
            start= System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                Object b = xMethod.get(new A(i));
                if (b == null) j++;
            }
            System.out.println("xMethod " + (System.currentTimeMillis() - start));
        }
        System.out.println(xMethod.get(new A(1)));
        for (int k = 0; k < 1000; k ++ ) {
            start= System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                Object b = xMethod.get(null);
                if (b == null) j++;
            }
            System.out.println("xMethod null" + (System.currentTimeMillis() - start));
        }
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

    public class A {
        private Integer x = 0;

        A(Integer a) { this.x = a; }

        public Integer getX() {
            return x;
        }
    }

    public XMethod create()  throws Throwable, Error {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        MethodVisitor mv;
        cw.visit(V11, ACC_PUBLIC + ACC_SUPER, "InvokeDynXMethod", null,	"java/lang/Object", new String[]{ Type.getInternalName(XMethod.class) });

        MethodType bootstrapMt = MethodType.methodType(CallSite.class, MethodHandles.Lookup.class, String.class, MethodType.class);
        Handle bootstrap = new Handle(Opcodes.H_INVOKESTATIC, Type.getInternalName(LinkTest.class),
                "bootstrap", bootstrapMt.toMethodDescriptorString(), false);

        {
            mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_FINAL, "get", MethodType.methodType(Object.class, Object.class).descriptorString(), null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 1);
            mv.visitInvokeDynamicInsn("GET:X", MethodType.methodType(Object.class, Object.class).descriptorString(), bootstrap);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 2);
            mv.visitEnd();
        }

        cw.visitEnd();
        byte[] code = cw.toByteArray();

        Class<XMethod> c =  (Class<XMethod>) childClassLoader.defineClass("InvokeDynXMethod", code);
        return c.newInstance();
    }


    private static class ChildClassLoader extends URLClassLoader {

        private static final URL[] NO_URLS = new URL[0];

        private int classesDefinedCount = 0;

        public ChildClassLoader(@Nullable ClassLoader classLoader) {
            super(NO_URLS, classLoader);
        }

        int getClassesDefinedCount() {
            return this.classesDefinedCount;
        }

        public Class<?> defineClass(String name, byte[] bytes) {
            Class<?> clazz = super.defineClass(name, bytes, 0, bytes.length);
            this.classesDefinedCount++;
            return clazz;
        }
    }
}

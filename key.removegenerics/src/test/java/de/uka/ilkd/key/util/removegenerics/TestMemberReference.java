package de.uka.ilkd.key.util.removegenerics;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMemberReference extends ResolveGenericClass {

    @BeforeEach
    protected void setUp() throws Exception {
        registerCU("package java.lang; public class String {}");
        registerCU("package java.lang; public interface Comparator<X extends Comparator<X>> { }");
        registerCU(
            "package java.lang; public class Object { public String toString() {}; protected final Object clone(); }");
        registerCU("class G<E> { E[][] array; E field; " + "E m() { return null; } "
            + "E[][] n() { return null; } } " + "class B { void bb(); }");
    }

    @Test
    public void testMethod() throws Exception {
        String before = "class T { void m() { B i = new G<B>().m(); } }";
        String after = "class T { void m() { B i = ((B) new G().m()); } }";
        equalCU(before, after);
    }

    @Test
    public void testField() throws Exception {
        String before = "class T { void m() { B i = new G<B>().field; } }";
        String after = "class T { void m() { B i = ((B) new G().field); } }";
        equalCU(before, after);
    }

    @Test
    public void testArray() throws Exception {
        String before = "class T { void m() { B[][] array = new G<B>().array; } }";
        String after = "class T { void m() { B[][] array = ((B[][]) new G().array); } }";
        equalCU(before, after);
    }

    @Test
    public void testExtends() throws Exception {
        String before =
            "class T { public void m() { G<? extends B> g = new G<B>(); B b = g.m(); } }";
        String after = "class T { public void m() { G g = new G(); B b = ((B) g.m()); } }";
        equalCU(before, after);
    }

    @Test
    public void testMemberOfParameter() throws Exception {
        String before = "class T<E extends B> { E e; void m() { e.bb(); } }";
        String after = "class T {\n\n B e; void m() { e.bb(); } }";
        equalCU(before, after);
    }

    @Test
    public void testArrayArg() throws Exception {
        String before = "class T { void m() { B[] a = new G<B[]>().field; } }";
        String after = "class T { void m() { B[] a = ((B[]) new G().field); } }";
        equalCU(before, after);
    }

    @Test
    public void testArrayReturn() throws Exception {
        String before = "class T { void m() { B[][] array = new G<B>().n(); } }";
        String after = "class T { void m() { B[][] array = ((B[][]) new G().n()); } }";
        equalCU(before, after);
    }

    @Test
    public void testParameterised() throws Exception {
        String before = "class L<E> { void m() { G<E> g = g(); } G<E> g() { return new G<E>(); } }";
        String after = "class L { void m() { G g = g(); } G g() { return new G(); } }";
        equalCU(before, after);
    }

    /*
     * expression statements may not be casted!
     */
    @Test
    public void testExpressionStatement() throws Exception {
        String before = "class T { void m() { G<B> g = new G<B>(); g.m(); g.m();} }";
        String after = "class T { void m() { G g = new G(); g.m(); g.m(); } }";
        equalCU(before, after);
    }

    @Test
    public void testExpressionStatementStructures() throws Exception {
        String before =
            "class T { void m() { G<B> g = new G<B>(); while(true) g.m(); if(true) g.m(); else g.m(); } }";
        String after =
            "class T { void m() { G g = new G(); while(true) g.m(); if(true) g.m(); else g.m(); } }";
        equalCU(before, after);
    }

    @Test
    public void testTypeParameterIsTV() throws Exception {
        String before = "class A<F extends B> { G<F> g = new G<F>(); F e = g.m(); }";
        String after = "class A { G g = new G();\n\nB e = ((B) g.m()); }";
        equalCU(before, after);
    }

    @Test
    public void testTypeParameterIsTVArray() throws Exception {
        String before = "class A<E extends B> { G<E> g = new G<E>(); E[][] e = g.n(); }";
        String after = "class A { G g = new G();\n\n B[][] e = ((B[][]) g.n()); }";
        equalCU(before, after);
    }

    @Test
    public void testMultiLevel() throws Exception {
        String before = "class T { G<B> g; Object o = g.field; Object o2 = g.m(); }";
        String after = "class T { G g; Object o = g.field; Object o2 = g.m(); }";
        equalCU(before, after);
    }

    @Test
    public void testParameterisedMember() throws Exception {
        String before = "class T { G<G<B>> g; G<B> o = g.field; }";
        String after = "class T { G g; G o = ((G) g.field); }";
        equalCU(before, after);
    }

    @Test
    public void testAssignmentToMember() throws Exception {
        String before = "class T { G<B> g; void t() { g.field = g.n(); } }";
        String after = "class T { G g; void t() { g.field = ((B) g.n()); } }";
        equalCU(before, after);
    }

    @Test
    public void testArrayLength() throws Exception {
        String before = "class T { void m() { int i = new G<B[]>().field.length; } }";
        String after = "class T { void m() { int i = ((B[]) new G().field).length; } }";
        equalCU(before, after);
    }

    // Obj data[] not Obj[] data !!!!
    @Test
    public void testArrayAssign() throws Exception {
        String before = "class T { G<B> g; void m() { Object data[][] = g.array; } }";
        String after = "class T { G g; void m() { Object data[][] = g.array; } }";
        equalCU(before, after);
    }

    @Test
    public void testRawType() throws Exception {
        String before = "class T { static G g = new G(); void m() { B o = (B) g.m(); } }";
        String after = "class T { static G g = new G(); void m() { B o = (B) g.m(); } }";
        equalCU(before, after);
    }

    @Test
    public void testStortArray() throws Exception {
        String before =
            "class Arrays { public static <T> void sort(T[] a, Comparator<? super T> c) {"
                + "T[] aux = (T[])a.clone(); } }";
        String after =
            "class Arrays { public static void sort(java.lang.Object[] a, Comparator c) {"
                + "java.lang.Object[] aux = (java.lang.Object[])a.clone(); } }";
        equalCU(before, after);
    }
}

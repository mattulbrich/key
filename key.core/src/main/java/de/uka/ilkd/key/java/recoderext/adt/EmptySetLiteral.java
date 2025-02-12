package de.uka.ilkd.key.java.recoderext.adt;

import recoder.java.Expression;
import recoder.java.SourceVisitor;
import recoder.java.expression.Literal;


public final class EmptySetLiteral extends Literal {

    /**
     *
     */
    private static final long serialVersionUID = 262935836224837458L;
    public static final EmptySetLiteral INSTANCE = new EmptySetLiteral();

    @Override
    public Expression deepClone() {
        return this;
    }

    @Override
    public void accept(SourceVisitor v) {
    }


    @Override
    public Object getEquivalentJavaType() {
        return null;
    }
}

package org.key_project.util.collection;

/**
 * Directed graph edge for use in {@link DirectedGraph} that simply stores the source and target
 * graph nodes.
 *
 * @author Arne Keller
 */
public class DefaultEdge implements GraphEdge {
    /**
     * Source node of this edge.
     */
    private Object source;
    /**
     * Target node of this edge.
     */
    private Object target;

    @Override
    public Object getSource() {
        return source;
    }

    @Override
    public void setSource(Object source) {
        this.source = source;
    }

    @Override
    public Object getTarget() {
        return target;
    }

    @Override
    public void setTarget(Object target) {
        this.target = target;
    }
}

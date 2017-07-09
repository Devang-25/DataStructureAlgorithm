package graph;

import java.util.List;

/**
 * Created by rakeshgupta on 10/29/16.
 */
public interface Graph {
    enum GraphType{
        DIRECTED,
        UNDIRECTED
    }
    void addEdge(int v1, int v2);

    List<Integer> getAdjacentVertices(int v);
}

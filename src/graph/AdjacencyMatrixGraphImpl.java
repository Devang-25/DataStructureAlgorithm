package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rakeshgupta on 10/29/16.
 */
public class AdjacencyMatrixGraphImpl extends AdjacencyMatrixGraph {
    private int[][] adjacencyMatrix;
    private Graph.GraphType graphType = Graph.GraphType.DIRECTED;
    private int numVertices = 0;

    public static void main(String[] args) {
        AdjacencyMatrixGraphImpl graph = new AdjacencyMatrixGraphImpl(Graph.GraphType.UNDIRECTED, 6);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(4,5);
        graph.addEdge(3,5);
        graph.addEdge(1,5);

        graph.printVertices(graph.getAdjacentVertices(5));

    }

    public  AdjacencyMatrixGraphImpl(Graph.GraphType graphType, int numVertices) {
        this.graphType = graphType;
        this.numVertices = numVertices;

        adjacencyMatrix = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    public void addEdge(int v1, int v2){
        if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0)
         throw new IllegalArgumentException("Vertex number is not valid");

        adjacencyMatrix[v1][v2] = 1;
        if (graphType == Graph.GraphType.UNDIRECTED)
            adjacencyMatrix[v2][v1] = 1;
    }

    public List<Integer> getAdjacentVertices(int v){
        if (v >= numVertices || v < 0)
            throw new IllegalArgumentException("Vertex number is not valid");

        List<Integer> adjacentVerticesList = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i] == 1)
                adjacentVerticesList.add(i);
        }

        Collections.sort(adjacentVerticesList);
        return adjacentVerticesList;
    }

    public void printVertices(List<Integer> list){
        System.out.println(list);
    }
}

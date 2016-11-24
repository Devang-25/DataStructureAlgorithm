package graph;

/**
 * Created by rakeshgupta on 11/24/16.
 */
public class App {

    public static void main(String[] args) {

        BreadthFirstSearch bfs = new BreadthFirstSearch();

        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v7 = new Vertex(7);
        Vertex v9 = new Vertex(9);

        v1.addNeighbourList(v2);
        v1.addNeighbourList(v3);

        v2.addNeighbourList(v4);
        v3.addNeighbourList(v9);

        v4.addNeighbourList(v7);
        v9.addNeighbourList(v7);

        v7.addNeighbourList(new Vertex(12));
        v7.addNeighbourList(new Vertex(11));

        bfs.bfs(v1);
    }
}

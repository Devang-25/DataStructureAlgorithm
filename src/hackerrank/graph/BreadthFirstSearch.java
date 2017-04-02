package hackerrank.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rakeshgupta on 11/24/16.
 */
public class BreadthFirstSearch {

    public void bfs(Vertex root){

        Queue<Vertex> queue = new LinkedList<>();

        root.setVisited(true);
        queue.add(root);

        while (!queue.isEmpty()){
            Vertex actualVertex = queue.remove();
            System.out.print(actualVertex + "-");

            for (Vertex v : actualVertex.getNeighbourList()){
                if ( ! v.isVisited()){
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }
    }
}

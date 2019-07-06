package graph;

import java.util.Stack;

/**
 * Created by rakeshgupta on 2/5/17.
 */
public class DepthFirstSearch {
    public void DFSUsingStack(Vertex root) {
        Stack<Vertex> stack = new Stack<>();
        stack.add(root);
        root.setVisited(true);

        while (!stack.isEmpty()) {
            Vertex node = stack.pop();
            System.out.print(node.getData() + " ");

            for (Vertex neighbours : node.getNeighbourList()) {
                if (!neighbours.isVisited() && neighbours != null) {
                    neighbours.setVisited(true);
                    stack.add(neighbours);
                }
            }
        }
    }
}

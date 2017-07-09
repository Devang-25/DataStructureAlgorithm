package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rakeshgupta on 11/24/16.
 */
public class Vertex {

    private int data;
    private boolean visited;
    private List<Vertex> neighbourList;

    public Vertex(int data) {
        this.data = data;
        this.neighbourList = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbourList() {
        return neighbourList;
    }

    public void addNeighbourList(Vertex vertex) {
        this.neighbourList.add(vertex);
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}

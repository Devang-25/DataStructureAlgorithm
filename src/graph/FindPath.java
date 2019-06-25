//package graph;
//
///* give a directed graph, design an algorithm to find out whether there is a route between two nodes */
//
//import java.util.LinkedList;
//
//public class FindPath {
//    public static boolean search(Graph g, Node start, Node end) {
//        if (start == end) return true;
//
//        //operates as Queue
//        LinkedList<Node> q = new LinkedList<Node>();
//
//        for (Node u : g.getNodes()) {
//            u.state = State.Unvisited;
//        }
//
//        start.state = State.Visiting;
//        q.add(start);
//        Node u;
//        while (!q.isEmpty()) {
//            u = q.removeFirst(); //i.e., dequeue()
//            if (u != null) {
//                for (Node v : u.getAdjacent()) {
//                    if (v.state == State.Unvisited) {
//                        if (v == end) {
//                            return true;
//                        } else {
//                            v.state = State.Visiting;
//                            q.add(v);
//                        }
//                    }
//                }
//            }
//            u.state = State.Visited;
//        }
//        return false;
//    }
//
//    public enum State {
//        Unvisited, Visited, Visiting;
//    }
//
//    // Definition for a binary tree node.
//    class Node {
//        int val;
//        Node left;
//        Node right;
//
//        Node(int x) {
//            val = x;
//        }
//    }
//}

package sample_exercise.treeoperation;

/**
 * Created by rakeshgupta on 9/24/16.
 */
public class BinaryTree {
    Node root;

    public void add(int data){
        Node nodeToAdd = new Node(data);

        if(root ==null ){
            root = nodeToAdd;
            traverseAndAddNode(root, nodeToAdd);
        }
    }

    private void traverseAndAddNode(Node node, Node nodeToAdd) {
        if(nodeToAdd.data < node.data) {
            if (node.leftChild == null){
                node.leftChild = nodeToAdd;
            }
            else
            traverseAndAddNode(node.leftChild, nodeToAdd);
        }
        else if (nodeToAdd.data > node.data) {
            if (node.rightChild == null){
                node.rightChild = nodeToAdd;
            }
            else
            traverseAndAddNode(node.rightChild, nodeToAdd);
        }
    }

}

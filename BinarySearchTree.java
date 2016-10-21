
class BinarySearchTree{
	public static void main(String args[]){
		Node node = new Node(5);
		node.setLeftChild(new Node(3));
		node.setRightChild(new Node(6));
		preOrder(node);
	}

	public static void preOrder(Node node){
		if (node == null)
			return;
		printData(node);
		preOrder(node.getLeftChild());
		preOrder(node.getRightChild());
	}

	public static void printData(Node node){
		System.out.println(node.getData());
		System.out.println(new java.sql.Timestamp());
	}

	public static class Node{
		private int data;
		private Node leftChild;
		private Node rightChild;

		public Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(Node leftChild) {
			this.leftChild = leftChild;
		}

		public Node getRightChild() {
			return rightChild;
		}

		public void setRightChild(Node rightChild) {
			this.rightChild = rightChild;
		}
	}
} 

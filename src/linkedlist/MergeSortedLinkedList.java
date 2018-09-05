package linkedlist;

public class MergeSortedLinkedList {
    public static void main(String[] args) {
        Node list1 = getPopulatedLL();
        Node list2 = getPopulatedLL2();
        Node sortedLL = mergeSortedLL(list1, list2);
        System.out.println("First List : " );
        ReverseLinkedList.printLinkedList(list1);

        System.out.println("Second List : " );
        ReverseLinkedList.printLinkedList(list2);

        System.out.println("Merged List : " );
        ReverseLinkedList.printLinkedList(sortedLL);

    }

    private static Node mergeSortedLL(Node list1, Node list2){

        Node root = null;
        Node head = null;

        while(list1 != null || list2 != null){

            if(list2 == null){
                if(root == null) {
                    root = new Node(list1.getData());
                    head = root;
                } else {
                    root.point = new Node(list1.getData());
                    root = root.point;
                }
                list1 = list1.point;
                continue;
            }


            if(list1 == null){
                if(root == null) {
                    root = new Node(list2.getData());
                    head = root;
                } else {
                    root.point = new Node(list2.getData());
                    root = root.point;
                }
                list2 = list2.point;
                continue;
            }

            if(list2.getData() > list1.getData()) {
                if(root == null) {
                    root = new Node(list1.getData());
                    head = root;
                } else {
                    root.point = new Node(list1.getData());
                    root = root.point;
                }
                list1 = list1.point;
            } else if(list1.getData() > list2.getData()) {
                if(root == null) {
                    root = new Node(list2.getData());
                    head = root;
                } else {
                    root.point = new Node(list2.getData());
                    root = root.point;
                }
                list2 = list2.point;
            }
        }

        return head;
    }

    private static Node getPopulatedLL(){
        Node head = new Node(9);
        Node first = new Node(11);
        Node second = new Node(12);
        Node third = new Node(13);
        Node four = new Node(14);

        head.point = first;
        first.point = second;
        second.point = third;
        third.point = four;
        four.point = null;
        return head;
    }

    private static Node getPopulatedLL2(){
        Node head = new Node(2);
        Node first = new Node(10);
        Node second = new Node(22);
        Node third = new Node(33);
        Node four = new Node(50);

        head.point = first;
        first.point = second;
        second.point = third;
        third.point = four;
        four.point = null;
        return head;
    }
}

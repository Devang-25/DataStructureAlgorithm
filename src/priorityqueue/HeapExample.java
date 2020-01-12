package priorityqueue;

public class HeapExample {
    public static void main(String[] args) throws HeapFullException {
        MinHeap minHeap = new MinHeap(5);
        for (int i = 10; i <15; i++) {
            minHeap.insert(i);
        }
        System.out.println(minHeap.getHighestPriority());
        minHeap.insert(20);

        System.out.println(minHeap.getHighestPriority());
        minHeap.insert(30);

        System.out.println(minHeap.getHighestPriority());
        minHeap.insert(40);
    }

}

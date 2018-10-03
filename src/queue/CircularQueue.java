package queue;


public class CircularQueue {

    int[] array;
    int front = 0, rear = -1, length = 0;

    /**
     * Initialize your data structure here.
     * Set the size of the queue to be k.
     */
    public CircularQueue(int k) {
        array = new int[k];
    }

    /**
     * Insert an element into the circular queue.
     * Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        rear = (rear + 1) % array.length;
        array[rear] = value;
        length++;
        return true;
    }

    /**
     * Delete an element from the circular queue.
     * Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty())
            return false;
        front = (front + 1) % array.length;
        length--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return array[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return array[rear];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return length == array.length;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(20);
        circularQueue.enQueue(20);
        circularQueue.enQueue(21);
        System.out.println(circularQueue.deQueue());
        circularQueue.enQueue(22);
        System.out.println(circularQueue.getFront());
        System.out.println(circularQueue.getRear());
        System.out.println(circularQueue.isEmpty());
        System.out.println(circularQueue.isFull());
    }
}

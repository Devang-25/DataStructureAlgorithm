package dsalgorithm0to1.queue;

import java.lang.reflect.Array;

/**
 * Created by rakeshgupta on 10/1/16.
 */
public class QueueImpl<T> {

    private static int SPECIAL_EMPTY_VALUE = -1;
    private static int MAX_VALUE = 40;
    private T[] elements;

    private int headIndex = SPECIAL_EMPTY_VALUE;
    private int tailIndex = SPECIAL_EMPTY_VALUE;

    public QueueImpl(Class<T> tClass) {
        elements = (T[]) Array.newInstance(tClass, MAX_VALUE);
    }


    public static void main(String[] args) throws Exception{

        QueueImpl<Integer> queue = new QueueImpl<>(Integer.class);
        queue.enqueue(23);
        queue.enqueue(24);
        queue.enqueue(25);
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//
       queue.printQueue(queue);

        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

    }



    public void printQueue(QueueImpl queue) throws QueueUnderflowException {
        System.out.print("queue = [" );
        while(!queue.isEmpty()){
            System.out.print(","+queue.dequeue());
        }
        System.out.println("]");
    }

    public T dequeue() throws QueueUnderflowException{
        if (isEmpty())
            throw new QueueUnderflowException();

        T data = elements[headIndex];

        if (headIndex == tailIndex)
            headIndex = SPECIAL_EMPTY_VALUE;
        else
            headIndex = (headIndex + 1) % elements.length;

        return data;
    }


    public void enqueue(T data) throws QueueOverflowException{
            if (isFull())
                throw new QueueOverflowException();

        tailIndex = (tailIndex + 1) % elements.length;
        elements[tailIndex] = data;
        if (headIndex == SPECIAL_EMPTY_VALUE)
            headIndex = tailIndex;
    }

    public boolean isFull(){
        int nextIndex = (tailIndex + 1) % elements.length;
        return nextIndex == headIndex;
    }

    public boolean isEmpty(){
        return headIndex == SPECIAL_EMPTY_VALUE;
    }

    public static class QueueOverflowException extends Exception{

    }

    public static class QueueUnderflowException extends Exception{

    }

}

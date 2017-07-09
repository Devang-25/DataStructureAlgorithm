package priorityqueue;

import java.lang.reflect.Array;

/**
 * Created by rakeshgupta on 10/22/16.
 */
public abstract  class Heap<T extends Comparable> {
    private static int MAX_SIZE = 40;
    public T[] array;
    public int count = 0;

    public Heap(Class<T> tClass){
        this(tClass, MAX_SIZE);
    }

    public Heap(Class<T> tClass, int maxSize) {
        array = (T[]) Array.newInstance(tClass, maxSize);
    }

    public int getLeftChildIndex(int index){
        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex >= count)
            return -1;

        return leftChildIndex;
    }

    public int getRightChildIndex(int index){
        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex >= count)
            return -1;

        return rightChildIndex;
    }

    public int getParentIndex(int index){
        if (index < 0 || index > count)
            return -1;

        return (index-1)/2;
    }

    protected void swap(int index1, int index2){
        T tempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = tempValue;
    }

    public int getCount(){
        return count;
    }

    public boolean isEmpty(){
        return count==0;
    }

    public boolean isFull(){
        return count==array.length;
    }

    public T getElementAtIndex(int index){
        return array[index];
    }
}

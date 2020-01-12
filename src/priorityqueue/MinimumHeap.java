package priorityqueue;

/**
 * Created by rakeshgupta on 10/22/16.
 */
public class MinimumHeap<T extends  Comparable> extends Heap<T> {

    public MinimumHeap(Class<T> tClass) {
        super(tClass);
    }

    public MinimumHeap(Class<T> tClass, int maxSize) {
        super(tClass, maxSize);
    }

    public void siftDown(int index){
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);

        int smallerIndex = -1;
        if (leftIndex != -1 && rightIndex != -1){
            smallerIndex = getElementAtIndex(leftIndex)
                    .compareTo(getElementAtIndex(rightIndex))
                    < 0 ? leftIndex : rightIndex;
        } else if (leftIndex != -1){
            smallerIndex = leftIndex;
        } else if (rightIndex != -1){
            smallerIndex = rightIndex;
        }

        if (smallerIndex == -1)
            return;

        if (getElementAtIndex(smallerIndex)
                .compareTo(getElementAtIndex(index)) < 0){
            swap(smallerIndex, index);
            siftDown(smallerIndex);
        }

    }

    public void siftUp(int index){
        int parentIndex = getParentIndex(index);

        if (parentIndex != -1 &&
                getElementAtIndex(index)
                .compareTo(getElementAtIndex(parentIndex)) < 0){
            swap(parentIndex, index);
            siftUp(parentIndex);
        }
    }

    public void insert(T value) throws HeapFullException{
        if (count >= array.length){
            throw new HeapFullException();
        }

        array[count] = value;
        siftUp(count);

        count++;
    }

    public T removeHighestPriority() throws HeapFullException{
        T min = getHighestPriority();

        array[0] = array[count-1];
        count--;

        return min;
    }

    public T getHighestPriority() throws HeapFullException {
        if (count == 0)
            throw new HeapFullException();
        return array[0];

    }

    public void printHeapArray() {
    }
}


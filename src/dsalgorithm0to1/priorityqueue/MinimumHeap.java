package dsalgorithm0to1.priorityqueue;

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

        }

    }
}

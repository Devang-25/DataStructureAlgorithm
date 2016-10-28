package dsalgorithm0to1.heapsort;

import dsalgorithm0to1.priorityqueue.HeapFullException;
import dsalgorithm0to1.priorityqueue.MinimumHeap;

/**
 * Created by rakeshgupta on 10/23/16.
 */
public class HeapProblems {

    public static void main(String[] args)
            throws HeapFullException,
            HeapEmptyException {
        new HeapProblems().printMaxKElements(4);
    }

    public void printMaxKElements(int k) throws
     HeapEmptyException, HeapFullException{

        MinimumHeap<Integer> minHeap =
                new MinimumHeap<Integer>(Integer.class, k);

        int[] randomNumberArray = {3,7,9,0,66,3,34,56,99};
        for (int num : randomNumberArray){
            if (minHeap.isEmpty()){
                minHeap.insert(num);
            } else if (!minHeap.isFull() || minHeap
                    .getHighestPriority() < num){
                if (minHeap.isFull())
                    minHeap.removeHighestPriority();

                minHeap.insert(num);
            }
        }
        minHeap.printHeapArray();
    }

    public int getMaximum(MinimumHeap<Integer> minHeap){

        int lastIndex = minHeap.getCount()-1;
        int lastParentIndex = minHeap.getParentIndex(lastIndex);

        int firstChildIndex = lastParentIndex + 1;
        int maxElement = minHeap.getElementAtIndex(firstChildIndex);

        for (int i = firstChildIndex; i <= lastIndex ; i++) {
            if (maxElement < minHeap.getElementAtIndex(i)){
                maxElement = minHeap.getElementAtIndex(i);
            }
        }
      return maxElement;
    }
}

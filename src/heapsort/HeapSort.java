package heapsort;

/**
 * Created by rakeshgupta on 10/23/16.
 */
public class HeapSort {

    static int[] array;

    public static void main(String[] args) {
        array = new int[]{ 3, 9, 5, 22, 34, 0, 55, 7, 4, 4};
        heapsort();
        for (int a : array)
            System.out.print( a +" ");
    }

    public static void heapsort(){
        heapify(array.length - 1);

        int endIndex = array.length - 1;
        while (endIndex > 0){
            swap(0, endIndex);
            endIndex--;
            percolateDown(0, endIndex);
        }
    }

    public static int getLeftChildIndex(int index, int endIndex){
        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex > endIndex)
            return -1;

        return leftChildIndex;
    }

    public static int getRightChildIndex(int index, int endIndex){
        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex > endIndex)
            return -1;

        return rightChildIndex;
    }

    public static int getParentIndex(int index, int endIndex){
        if (index <0 || index > endIndex)
            return -1;

        return (index-1)/2;
    }

    public static void swap(int index1, int index2){
        int tempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = tempValue;
    }

    public static void percolateDown(int index, int endIndex){
        int leftChildIndex = getLeftChildIndex(index, endIndex);
        int rightChildIndex = getRightChildIndex(index, endIndex);

        if (leftChildIndex != -1
                && array[leftChildIndex] > array[index]){
            swap(leftChildIndex, index);
            percolateDown(leftChildIndex, endIndex);
        }

        if (rightChildIndex != -1
                && array[rightChildIndex] > array[index]){
            swap(rightChildIndex, index);
            percolateDown(rightChildIndex, endIndex);
        }
    }

    public static void heapify(int endIndex){
        int index = getParentIndex(endIndex, endIndex);
        while (index >= 0){
            percolateDown(index, endIndex);
            index--;
        }
    }
}

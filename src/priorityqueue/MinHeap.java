package priorityqueue;

public class MinHeap {

    public int[] array;
    public int count = 0;

    public MinHeap(int maxSize) {
        array = new int[maxSize];
    }

    public int getLeftChildIndex(int index) {
        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex >= count)
            return -1;

        return leftChildIndex;
    }

    public int getRightChildIndex(int index) {
        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex >= count)
            return -1;

        return rightChildIndex;
    }

    public int getParentIndex(int index) {
        if (index < 0 || index > count)
            return -1;

        return (index - 1) / 2;
    }

    protected void swap(int index1, int index2) {
        int tempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = tempValue;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == array.length;
    }

    public int getElementAtIndex(int index) {
        return array[index];
    }

    public void siftDown(int index) {
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);

        int smallerIndex = -1;
        if (leftIndex != -1 && rightIndex != -1) {
            smallerIndex = getElementAtIndex(leftIndex) - (getElementAtIndex(rightIndex))
                    < 0 ? leftIndex : rightIndex;
        } else if (leftIndex != -1) {
            smallerIndex = leftIndex;
        } else if (rightIndex != -1) {
            smallerIndex = rightIndex;
        }

        if (smallerIndex == -1)
            return;

        if (getElementAtIndex(smallerIndex) - (getElementAtIndex(index)) < 0) {
            swap(smallerIndex, index);
            siftDown(smallerIndex);
        }

    }

    public void siftUp(int index) {
        int parentIndex = getParentIndex(index);
        if (parentIndex != -1 && getElementAtIndex(index) - (getElementAtIndex(parentIndex)) < 0) {
            swap(parentIndex, index);
            siftUp(parentIndex);
        }
    }

    public void insert(int value) throws HeapFullException {
        if (count >= array.length) {
            throw new HeapFullException();
        }
        array[count] = value;
        siftUp(count);
        count++;
    }

    public int removeHighestPriority() throws HeapFullException {
        int min = getHighestPriority();
        array[0] = array[count - 1];
        count--;
        return min;
    }

    public int getHighestPriority() throws HeapFullException {
        return array[0];
    }
}

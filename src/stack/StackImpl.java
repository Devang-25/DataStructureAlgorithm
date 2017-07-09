package stack;

/**
 * Created by rakeshgupta on 9/29/16.
 */
public class StackImpl<T> {

    private static int MAX_SIZE = 40;
    private int size = 0;
    private Element<T> top;

    public static void main(String[] args) throws Exception{

        StackImpl<Integer> stack = new StackImpl<>();
        stack.push(32);
        stack.push(43);
        stack.push(33);
        stack.push(77);
        stack.pop();
        System.out.println(stack.peek());
        stack.print(stack);

    }


    public void print(StackImpl stack) throws Exception {
        int size = stack.getSize();
        System.out.print("[");
        while (size != 0){
            System.out.print(stack.pop());
            if (stack.getSize()!=0)
                System.out.print(",");
            size--;
        }
        System.out.print("]");
    }

    public int getSize(){
        return size;
    }

    public boolean isFull(){
        return size == MAX_SIZE;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T peek() throws StackUnderFlowException{
        if (size == 0)
            throw new StackUnderFlowException();

        return top.getData();
    }

    public T pop() throws StackUnderFlowException{
        if (size == 0)
            throw new StackUnderFlowException();

        T data = top.getData();
        top = top.getNext();
        size--;
        return  data;
    }

    public void push(T data) throws StackOverFlowException{

        if (size == MAX_SIZE)
            throw new StackOverFlowException();

        Element el = new Element(data, top);
        top = el;
        size++;
    }

    public static class StackOverFlowException extends Exception{

    }

    public static class StackUnderFlowException extends Exception{

    }

    private static class Element<T> {
        private T data;
        private Element next;

        public Element(T data, Element next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }
}

package queue;

import stack.StackImpl;

/**
 * Created by rakeshgupta on 10/1/16.
 */
public class QueueImplByStack<T> {

    private StackImpl<T> forwordStack = new StackImpl<>();
    private StackImpl<T> reverseStack = new StackImpl<>();




    public static void main(String[] args) {

    }



    public void enqueue(T data) throws QueueImpl.QueueOverflowException{
        if (isFull())
            throw new QueueImpl.QueueOverflowException();

        try {

            if (forwordStack.isEmpty()){
                while (!reverseStack.isEmpty()){
                    forwordStack.push(reverseStack.pop());
                }
            }
            forwordStack.push(data);

        }catch (StackImpl.StackOverFlowException | StackImpl.StackUnderFlowException a){
            throw new QueueImpl.QueueOverflowException();
        }
    }

    public boolean isFull(){
        return forwordStack.isFull() || reverseStack.isFull();
    }

    public boolean isEmpty(){
       return forwordStack.isEmpty() && reverseStack.isEmpty();
    }

}

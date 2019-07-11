package queue;

import java.util.Stack;

public class QueueUsingSingleStack {
    public static void main(String[] args) {

        QueueUsingStack queueUsingStack = new QueueUsingStack();
        queueUsingStack.enQueue(10);
        queueUsingStack.enQueue(20);
        queueUsingStack.enQueue(30);

        queueUsingStack.deQueue();
    }

    static class QueueUsingStack {
        Stack<Integer> stack = new Stack<>();

        public void enQueue(int data) {
            stack.add(data);
        }

        public void deQueue() {
            if (stack.size() < 1) {
                System.out.println("Nothing to deQueue");
                return;
            }

            if (stack.size() == 1) {
                System.out.println(stack.pop());
                return;
            }

            int data = stack.pop();
            deQueue();
            stack.push(data);
        }
    }
}

import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int x) {
        stack1.push(x);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Main method for testing
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeue: " + queue.dequeue()); // Should print 10
        System.out.println("Dequeue: " + queue.dequeue()); // Should print 20
        queue.enqueue(40);
        System.out.println("Dequeue: " + queue.dequeue()); // Should print 30
        System.out.println("Dequeue: " + queue.dequeue()); // Should print 40

        // Uncomment below to test underflow:
        // System.out.println("Dequeue: " + queue.dequeue()); // Will throw exception
    }
}

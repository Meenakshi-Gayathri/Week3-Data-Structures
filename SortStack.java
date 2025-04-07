import java.util.Stack;

public class SortStack {
    public void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sort(stack);
            insertSorted(stack, temp);
        }
    }

    private void insertSorted(Stack<Integer> stack, int num) {
        if (stack.isEmpty() || stack.peek() <= num) {
            stack.push(num);
        } else {
            int temp = stack.pop();
            insertSorted(stack, num);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        SortStack sorter = new SortStack();
        sorter.sort(stack);

        System.out.println("Sorted stack (top to bottom):");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

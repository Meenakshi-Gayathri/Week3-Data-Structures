import java.util.Scanner;

class ActionNode {
    String action;
    ActionNode prev, next;

    ActionNode(String action) {
        this.action = action;
    }
}

class TextEditor {
    ActionNode current;

    void performAction(String action) {
        ActionNode newNode = new ActionNode(action);
        if (current != null) {
            current.next = newNode;
            newNode.prev = current;
        }
        current = newNode;
        System.out.println("Action performed: " + action);
    }

    void undo() {
        if (current == null) {
            System.out.println("No action to undo.");
        } else {
            System.out.println("Undo: " + current.action);
            current = current.prev;
        }
    }

    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.action);
        } else {
            System.out.println("No action to redo.");
        }
    }

    void displayHistory() {
        ActionNode temp = current;
        while (temp != null && temp.prev != null) {
            temp = temp.prev;
        }
        System.out.println("Action History:");
        while (temp != null) {
            System.out.println("- " + temp.action);
            temp = temp.next;
        }
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("\n1. Perform Action");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter action: ");
                    String action = sc.nextLine();
                    editor.performAction(action);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayHistory();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

import java.util.Scanner;

class TaskNode {
    int id, priority;
    String name, dueDate;
    TaskNode next;

    TaskNode(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

class TaskScheduler {
    TaskNode head = null, current = null;

    void addAtBeginning(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.next = head;
            current = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head) temp = temp.next;
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    void addAtEnd(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.next = head;
            current = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
        }
    }

    void addAtPosition(int id, String name, int priority, String dueDate, int pos) {
        if (pos <= 0 || head == null) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        TaskNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) temp = temp.next;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void removeById(int id) {
        if (head == null) return;
        TaskNode temp = head, prev = null;
        do {
            if (temp.id == id) {
                if (temp == head) {
                    TaskNode tail = head;
                    while (tail.next != head) tail = tail.next;
                    if (head == head.next) {
                        head = null;
                        current = null;
                        return;
                    }
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                if (current == temp) current = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void viewCurrentAndMoveNext() {
        if (current == null) return;
        System.out.println("Current Task: " + current.id + " | " + current.name + " | " + current.priority + " | " + current.dueDate);
        current = current.next;
    }

    void displayAll() {
        if (head == null) return;
        TaskNode temp = head;
        System.out.println("Tasks:");
        do {
            System.out.println(temp.id + " | " + temp.name + " | " + temp.priority + " | " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByPriority(int priority) {
        if (head == null) return;
        TaskNode temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println(temp.id + " | " + temp.name + " | " + temp.priority + " | " + temp.dueDate);
            }
            temp = temp.next;
        } while (temp != head);
    }
}

public class TaskSchedulerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();
        while (true) {
            System.out.println("\n1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task and Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    System.out.print("ID: ");
                    int id1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name1 = sc.nextLine();
                    System.out.print("Priority: ");
                    int p1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Due Date: ");
                    String d1 = sc.nextLine();
                    scheduler.addAtBeginning(id1, name1, p1, d1);
                    break;

                case 2:
                    System.out.print("ID: ");
                    int id2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name2 = sc.nextLine();
                    System.out.print("Priority: ");
                    int p2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Due Date: ");
                    String d2 = sc.nextLine();
                    scheduler.addAtEnd(id2, name2, p2, d2);
                    break;

                case 3:
                    System.out.print("ID: ");
                    int id3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name3 = sc.nextLine();
                    System.out.print("Priority: ");
                    int p3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Due Date: ");
                    String d3 = sc.nextLine();
                    System.out.print("Position: ");
                    int pos = sc.nextInt();
                    scheduler.addAtPosition(id3, name3, p3, d3, pos);
                    break;

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    int remId = sc.nextInt();
                    scheduler.removeById(remId);
                    break;

                case 5:
                    scheduler.viewCurrentAndMoveNext();
                    break;

                case 6:
                    scheduler.displayAll();
                    break;

                case 7:
                    System.out.print("Enter Priority: ");
                    int sp = sc.nextInt();
                    scheduler.searchByPriority(sp);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

import java.util.*;

class ItemNode {
    String name;
    int id, quantity;
    double price;
    ItemNode next;

    ItemNode(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }
}

class Inventory {
    ItemNode head = null;

    void addAtBeginning(String name, int id, int quantity, double price) {
        ItemNode newNode = new ItemNode(name, id, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    void addAtEnd(String name, int id, int quantity, double price) {
        ItemNode newNode = new ItemNode(name, id, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    void addAtPosition(String name, int id, int quantity, double price, int pos) {
        if (pos <= 0 || head == null) {
            addAtBeginning(name, id, quantity, price);
            return;
        }
        ItemNode newNode = new ItemNode(name, id, quantity, price);
        ItemNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) temp = temp.next;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null && temp.next.id != id) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }

    void updateQuantityById(int id, int quantity) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = quantity;
                return;
            }
            temp = temp.next;
        }
    }

    void searchById(int id) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.id == id) {
                System.out.println(temp.name + " | " + temp.id + " | " + temp.quantity + " | " + temp.price);
                return;
            }
            temp = temp.next;
        }
    }

    void searchByName(String name) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println(temp.name + " | " + temp.id + " | " + temp.quantity + " | " + temp.price);
            }
            temp = temp.next;
        }
    }

    void calculateTotalValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    void displayAll() {
        ItemNode temp = head;
        while (temp != null) {
            System.out.println(temp.name + " | " + temp.id + " | " + temp.quantity + " | " + temp.price);
            temp = temp.next;
        }
    }

    ItemNode mergeSort(ItemNode head, String key, boolean asc) {
        if (head == null || head.next == null) return head;
        ItemNode middle = getMiddle(head);
        ItemNode nextToMiddle = middle.next;
        middle.next = null;
        ItemNode left = mergeSort(head, key, asc);
        ItemNode right = mergeSort(nextToMiddle, key, asc);
        return merge(left, right, key, asc);
    }

    ItemNode merge(ItemNode left, ItemNode right, String key, boolean asc) {
        if (left == null) return right;
        if (right == null) return left;
        boolean condition;
        if (key.equals("name")) {
            condition = asc ? left.name.compareTo(right.name) <= 0 : left.name.compareTo(right.name) > 0;
        } else {
            condition = asc ? left.price <= right.price : left.price > right.price;
        }
        if (condition) {
            left.next = merge(left.next, right, key, asc);
            return left;
        } else {
            right.next = merge(left, right.next, key, asc);
            return right;
        }
    }

    ItemNode getMiddle(ItemNode head) {
        if (head == null) return head;
        ItemNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void sort(String key, boolean asc) {
        head = mergeSort(head, key, asc);
    }
}

public class InventoryManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        while (true) {
            System.out.println("\n1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search by ID");
            System.out.println("7. Search by Name");
            System.out.println("8. Calculate Total Value");
            System.out.println("9. Display All Items");
            System.out.println("10. Sort by Name");
            System.out.println("11. Sort by Price");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Quantity: ");
                    int q = sc.nextInt();
                    System.out.print("Price: ");
                    double p = sc.nextDouble();
                    if (ch == 1) inventory.addAtBeginning(name, id, q, p);
                    else if (ch == 2) inventory.addAtEnd(name, id, q, p);
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        inventory.addAtPosition(name, id, q, p, pos);
                    }
                    break;
                case 4:
                    System.out.print("Enter ID: ");
                    inventory.removeById(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    System.out.print("New Quantity: ");
                    int uq = sc.nextInt();
                    inventory.updateQuantityById(uid, uq);
                    break;
                case 6:
                    System.out.print("Enter ID: ");
                    inventory.searchById(sc.nextInt());
                    break;
                case 7:
                    System.out.print("Enter Name: ");
                    inventory.searchByName(sc.nextLine());
                    break;
                case 8:
                    inventory.calculateTotalValue();
                    break;
                case 9:
                    inventory.displayAll();
                    break;
                case 10:
                    System.out.print("Sort Ascending (true/false): ");
                    inventory.sort("name", sc.nextBoolean());
                    break;
                case 11:
                    System.out.print("Sort Ascending (true/false): ");
                    inventory.sort("price", sc.nextBoolean());
                    break;
                case 12:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

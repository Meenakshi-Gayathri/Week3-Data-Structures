import java.util.*;

class BookNode {
    String title, author, genre;
    int bookId;
    boolean isAvailable;
    BookNode prev, next;

    BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }
}

class Library {
    BookNode head = null, tail = null;

    void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void addAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int pos) {
        if (pos <= 0 || head == null) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        BookNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) temp = temp.next;
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) temp.next.prev = newNode;
        temp.next = newNode;
        if (newNode.next == null) tail = newNode;
    }

    void removeByBookId(int bookId) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp == head) {
                    head = temp.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = temp.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }

    void searchByTitle(String title) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println(temp.title + " | " + temp.author + " | " + temp.genre + " | " + temp.bookId + " | " + (temp.isAvailable ? "Available" : "Not Available"));
            }
            temp = temp.next;
        }
    }

    void searchByAuthor(String author) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println(temp.title + " | " + temp.author + " | " + temp.genre + " | " + temp.bookId + " | " + (temp.isAvailable ? "Available" : "Not Available"));
            }
            temp = temp.next;
        }
    }

    void updateAvailability(int bookId, boolean status) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                return;
            }
            temp = temp.next;
        }
    }

    void displayForward() {
        BookNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.author + " | " + temp.genre + " | " + temp.bookId + " | " + (temp.isAvailable ? "Available" : "Not Available"));
            temp = temp.next;
        }
    }

    void displayReverse() {
        BookNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.author + " | " + temp.genre + " | " + temp.bookId + " | " + (temp.isAvailable ? "Available" : "Not Available"));
            temp = temp.prev;
        }
    }

    int countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class LibraryManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        while (true) {
            System.out.println("\n1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search by Title");
            System.out.println("6. Search by Author");
            System.out.println("7. Update Availability");
            System.out.println("8. Display Forward");
            System.out.println("9. Display Reverse");
            System.out.println("10. Count Books");
            System.out.println("11. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    System.out.print("Available (true/false): ");
                    boolean status = sc.nextBoolean();
                    if (ch == 1) lib.addAtBeginning(title, author, genre, id, status);
                    else if (ch == 2) lib.addAtEnd(title, author, genre, id, status);
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        lib.addAtPosition(title, author, genre, id, status, pos);
                    }
                    break;
                case 4:
                    System.out.print("Enter Book ID: ");
                    lib.removeByBookId(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Title: ");
                    lib.searchByTitle(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Enter Author: ");
                    lib.searchByAuthor(sc.nextLine());
                    break;
                case 7:
                    System.out.print("Book ID: ");
                    int bid = sc.nextInt();
                    System.out.print("New Availability (true/false): ");
                    lib.updateAvailability(bid, sc.nextBoolean());
                    break;
                case 8:
                    lib.displayForward();
                    break;
                case 9:
                    lib.displayReverse();
                    break;
                case 10:
                    System.out.println("Total Books: " + lib.countBooks());
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Invalid");
            }
        }
    }
}

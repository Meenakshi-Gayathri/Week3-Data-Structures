import java.util.Scanner;

class MovieNode {
    String title, director;
    int year;
    double rating;
    MovieNode prev, next;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

class MovieManagementSystem {
    MovieNode head, tail;

    void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void addAtPosition(String title, String director, int year, double rating, int pos) {
        if (pos <= 0) return;
        if (pos == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) temp = temp.next;
        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
        } else {
            newNode.next = temp.next;
            temp.next.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    void removeByTitle(String title) {
        MovieNode temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) temp = temp.next;
        if (temp == null) return;
        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    void searchByDirector(String director) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            }
            temp = temp.next;
        }
    }

    void searchByRating(double rating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            }
            temp = temp.next;
        }
    }

    void displayForward() {
        MovieNode temp = head;
        System.out.println("Movies (Forward):");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.next;
        }
    }

    void displayReverse() {
        MovieNode temp = tail;
        System.out.println("Movies (Reverse):");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.prev;
        }
    }

    void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                break;
            }
            temp = temp.next;
        }
    }
}

public class MovieSystemApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieManagementSystem mms = new MovieManagementSystem();
        while (true) {
            System.out.println("\n1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Display Forward");
            System.out.println("8. Display Reverse");
            System.out.println("9. Update Rating");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Title: ");
                    String t1 = sc.nextLine();
                    System.out.print("Director: ");
                    String d1 = sc.nextLine();
                    System.out.print("Year: ");
                    int y1 = sc.nextInt();
                    System.out.print("Rating: ");
                    double r1 = sc.nextDouble();
                    mms.addAtBeginning(t1, d1, y1, r1);
                    break;

                case 2:
                    System.out.print("Title: ");
                    String t2 = sc.nextLine();
                    System.out.print("Director: ");
                    String d2 = sc.nextLine();
                    System.out.print("Year: ");
                    int y2 = sc.nextInt();
                    System.out.print("Rating: ");
                    double r2 = sc.nextDouble();
                    mms.addAtEnd(t2, d2, y2, r2);
                    break;

                case 3:
                    System.out.print("Title: ");
                    String t3 = sc.nextLine();
                    System.out.print("Director: ");
                    String d3 = sc.nextLine();
                    System.out.print("Year: ");
                    int y3 = sc.nextInt();
                    System.out.print("Rating: ");
                    double r3 = sc.nextDouble();
                    System.out.print("Position: ");
                    int pos = sc.nextInt();
                    mms.addAtPosition(t3, d3, y3, r3, pos);
                    break;

                case 4:
                    System.out.print("Enter Title to Remove: ");
                    String remTitle = sc.nextLine();
                    mms.removeByTitle(remTitle);
                    break;

                case 5:
                    System.out.print("Enter Director: ");
                    String director = sc.nextLine();
                    mms.searchByDirector(director);
                    break;

                case 6:
                    System.out.print("Enter Rating: ");
                    double rating = sc.nextDouble();
                    mms.searchByRating(rating);
                    break;

                case 7:
                    mms.displayForward();
                    break;

                case 8:
                    mms.displayReverse();
                    break;

                case 9:
                    System.out.print("Enter Title: ");
                    String titleUp = sc.nextLine();
                    System.out.print("New Rating: ");
                    double newR = sc.nextDouble();
                    mms.updateRating(titleUp, newR);
                    break;

                case 10:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

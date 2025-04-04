import java.util.Scanner;

class TicketNode {
    int ticketId;
    String passengerName;
    String destination;
    TicketNode next;

    TicketNode(int ticketId, String passengerName, String destination) {
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.destination = destination;
    }
}

class TicketSystem {
    TicketNode head = null;

    void bookTicket(int ticketId, String name, String destination) {
        TicketNode newNode = new TicketNode(ticketId, name, destination);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            TicketNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println("Ticket booked successfully.");
    }

    void cancelTicket(int ticketId) {
        if (head == null) return;

        if (head.ticketId == ticketId && head.next == head) {
            head = null;
            System.out.println("Ticket cancelled.");
            return;
        }

        TicketNode curr = head, prev = null;
        do {
            if (curr.ticketId == ticketId) {
                if (curr == head) {
                    TicketNode temp = head;
                    while (temp.next != head) temp = temp.next;
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = curr.next;
                }
                System.out.println("Ticket cancelled.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Ticket ID not found.");
    }

    void viewAllTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode temp = head;
        System.out.println("Booked Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Name: " + temp.passengerName + ", Destination: " + temp.destination);
            temp = temp.next;
        } while (temp != head);
    }

    void searchTicket(int ticketId) {
        if (head == null) return;
        TicketNode temp = head;
        do {
            if (temp.ticketId == ticketId) {
                System.out.println("Found Ticket - ID: " + temp.ticketId + ", Name: " + temp.passengerName + ", Destination: " + temp.destination);
                return;
            }
            temp = temp.next;
        } while (temp != head);
        System.out.println("Ticket ID not found.");
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketSystem system = new TicketSystem();

        while (true) {
            System.out.println("\n1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View All Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Passenger Name: ");
                    String name = sc.nextLine();
                    System.out.print("Destination: ");
                    String dest = sc.nextLine();
                    system.bookTicket(id, name, dest);
                    break;
                case 2:
                    System.out.print("Ticket ID to cancel: ");
                    system.cancelTicket(sc.nextInt());
                    break;
                case 3:
                    system.viewAllTickets();
                    break;
                case 4:
                    System.out.print("Enter Ticket ID to search: ");
                    system.searchTicket(sc.nextInt());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

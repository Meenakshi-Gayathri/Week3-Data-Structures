import java.util.*;

class ProcessNode {
    int pid, burstTime, priority, remainingTime, waitingTime, turnaroundTime;
    ProcessNode next;

    ProcessNode(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

class RoundRobinScheduler {
    ProcessNode head = null;

    void addProcess(int pid, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(pid, burstTime, priority);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            ProcessNode temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
        }
    }

    void removeProcess(int pid) {
        if (head == null) return;
        if (head.pid == pid && head.next == head) {
            head = null;
            return;
        }
        ProcessNode curr = head, prev = null;
        do {
            if (curr.pid == pid) {
                if (curr == head) {
                    ProcessNode temp = head;
                    while (temp.next != head) temp = temp.next;
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    void simulate(int timeQuantum) {
        if (head == null) return;
        int time = 0;
        Queue<ProcessNode> completed = new LinkedList<>();
        ProcessNode current = head;
        while (true) {
            boolean done = true;
            do {
                if (current.remainingTime > 0) {
                    done = false;
                    if (current.remainingTime > timeQuantum) {
                        time += timeQuantum;
                        current.remainingTime -= timeQuantum;
                    } else {
                        time += current.remainingTime;
                        current.waitingTime = time - current.burstTime;
                        current.turnaroundTime = time;
                        current.remainingTime = 0;
                        completed.add(current);
                    }
                }
                current = current.next;
            } while (current != head);
            if (done) break;
        }
        System.out.println("PID\tBT\tWT\tTAT");
        int totalWT = 0, totalTAT = 0, count = completed.size();
        for (ProcessNode p : completed) {
            System.out.println(p.pid + "\t" + p.burstTime + "\t" + p.waitingTime + "\t" + p.turnaroundTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }
        System.out.println("Average Waiting Time: " + (double) totalWT / count);
        System.out.println("Average Turnaround Time: " + (double) totalTAT / count);
    }

    void displayProcesses() {
        if (head == null) return;
        ProcessNode temp = head;
        do {
            System.out.println("PID: " + temp.pid + " | BT: " + temp.burstTime + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        while (true) {
            System.out.println("\n1. Add Process");
            System.out.println("2. Remove Process");
            System.out.println("3. Simulate Scheduling");
            System.out.println("4. Display Processes");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Process ID: ");
                    int pid = sc.nextInt();
                    System.out.print("Burst Time: ");
                    int bt = sc.nextInt();
                    System.out.print("Priority: ");
                    int pr = sc.nextInt();
                    scheduler.addProcess(pid, bt, pr);
                    break;
                case 2:
                    System.out.print("Enter PID to remove: ");
                    scheduler.removeProcess(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter Time Quantum: ");
                    scheduler.simulate(sc.nextInt());
                    break;
                case 4:
                    scheduler.displayProcesses();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid");
            }
        }
    }
}

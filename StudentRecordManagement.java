class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next; //ref to next student

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null; //initially none present
    }
}

class StudentRecord {
    Student head = null; //first student

    void addBegin(int rollNumber, String name, int age, String grade) {
        Student newS = new Student(rollNumber, name, age, grade); //new node creation after first node/head
        newS.next = head; //link to current head ie head->newS 
        head = newS; //second is the head now
    }

    void addEnd(int rollNumber, String name, int age, String grade) {
        Student newS = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newS; 
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next; //if not empty traverse to last
        }
        temp.next = newS; //append new node at the last
    }

    void addPosition(int p, int rollNumber, String name, int age, String grade) {
        if (p == 1) {
            addBegin(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        for (int i = 1; i < p - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Out of bounds");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    void delRoll(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student not found");
            return;
        }
        temp.next = temp.next.next;
    }

    void searchRoll(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Found: " + temp.name + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    void updateGrade(int rollNumber, String newG) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newG;
                System.out.println("Grade Updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    void displayAll() {
        Student temp = head;
        if (temp == null) {
            System.out.println("No records");
            return;
        }
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + ", Name: " + temp.name +
                    ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentRecord srm = new StudentRecord();
        srm.addEnd(101, "Alice", 20, "A");
        srm.addBegin(102, "Bob", 21, "B");
        srm.addPosition(2, 103, "Charlie", 22, "C");

        srm.displayAll();

        srm.searchRoll(103);
        srm.updateGrade(103, "A+");
        srm.delRoll(102);

        srm.displayAll();
    }
}

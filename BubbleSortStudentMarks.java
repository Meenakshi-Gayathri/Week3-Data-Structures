import java.util.Scanner;

public class BubbleSortStudentMarks {

    // Bubble Sort Logic
    public void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap marks[j] and marks[j + 1]
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped in the inner loop, array is sorted
            if (!swapped) break;
        }
    }

    // Utility to print array
    public void printArray(int[] marks) {
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[] marks = new int[n];

        System.out.println("Enter the marks of " + n + " students:");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }

        BubbleSortStudentMarks sorter = new BubbleSortStudentMarks();

        System.out.println("Original marks:");
        sorter.printArray(marks);

        sorter.bubbleSort(marks);

        System.out.println("Sorted marks in ascending order:");
        sorter.printArray(marks);

        scanner.close();
    }
}

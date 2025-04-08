import java.util.Scanner;

public class InsertionSortEmployeeIDs {

    // Insertion Sort Logic
    public void insertionSort(int[] ids) {
        int n = ids.length;

        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;

            // Move elements greater than key to one position ahead
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }
    }

    // Utility to print array
    public void printArray(int[] ids) {
        for (int id : ids) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = scanner.nextInt();
        int[] ids = new int[n];

        System.out.println("Enter the employee IDs:");
        for (int i = 0; i < n; i++) {
            ids[i] = scanner.nextInt();
        }

        InsertionSortEmployeeIDs sorter = new InsertionSortEmployeeIDs();

        System.out.println("Original employee IDs:");
        sorter.printArray(ids);

        sorter.insertionSort(ids);

        System.out.println("Sorted employee IDs in ascending order:");
        sorter.printArray(ids);

        scanner.close();
    }
}

import java.util.Scanner;

public class HeapSortSalaries {

    public void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of job applicants: ");
        int n = sc.nextInt();
        int[] salaries = new int[n];

        System.out.println("Enter expected salaries:");
        for (int i = 0; i < n; i++) {
            salaries[i] = sc.nextInt();
        }

        HeapSortSalaries sorter = new HeapSortSalaries();
        System.out.println("Original salaries:");
        sorter.printArray(salaries);

        sorter.heapSort(salaries);

        System.out.println("Sorted salaries in ascending order:");
        sorter.printArray(salaries);

        sc.close();
    }
}

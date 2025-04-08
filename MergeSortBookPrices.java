import java.util.Scanner;

public class MergeSortBookPrices {

    // Merge Sort function
    public void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort the left and right halves
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            // Merge the sorted halves
            merge(prices, left, mid, right);
        }
    }

    // Merge function
    public void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temp arrays
        double[] L = new double[n1];
        double[] R = new double[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = prices[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = prices[mid + 1 + j];

        // Merge the temp arrays
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                prices[k] = L[i];
                i++;
            } else {
                prices[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            prices[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            prices[k] = R[j];
            j++;
            k++;
        }
    }

    // Print array
    public void printArray(double[] prices) {
        for (double price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = scanner.nextInt();
        double[] prices = new double[n];

        System.out.println("Enter the prices of the books:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextDouble();
        }

        MergeSortBookPrices sorter = new MergeSortBookPrices();

        System.out.println("Original book prices:");
        sorter.printArray(prices);

        sorter.mergeSort(prices, 0, n - 1);

        System.out.println("Sorted book prices in ascending order:");
        sorter.printArray(prices);

        scanner.close();
    }
}

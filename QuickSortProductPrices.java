import java.util.Scanner;

public class QuickSortProductPrices {

    // Function to perform Quick Sort
    public void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);

            // Recursively sort elements before and after partition
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    // Partition function
    private int partition(double[] prices, int low, int high) {
        double pivot = prices[high];  // Pivot (last element)
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap prices[i+1] and prices[high] (or pivot)
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    // Function to print the array
    public void printArray(double[] prices) {
        for (double price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = scanner.nextInt();
        double[] prices = new double[n];

        System.out.println("Enter the prices of the products:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextDouble();
        }

        QuickSortProductPrices sorter = new QuickSortProductPrices();

        System.out.println("Original product prices:");
        sorter.printArray(prices);

        sorter.quickSort(prices, 0, n - 1);

        System.out.println("Sorted product prices in ascending order:");
        sorter.printArray(prices);

        scanner.close();
    }
}

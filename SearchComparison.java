import java.util.Arrays;

public class SearchComparison {
    public static void main(String[] args) {
        int size = 1000000;
        int[] data = new int[size];
        for (int i = 0; i < size; i++) data[i] = i;
        int target = size - 1;

        // Linear Search
        long start = System.nanoTime();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) break;
        }
        long end = System.nanoTime();
        System.out.println("Linear Search Time: " + (end - start) + " ns");

        // Binary Search
        start = System.nanoTime();
        Arrays.binarySearch(data, target);
        end = System.nanoTime();
        System.out.println("Binary Search Time: " + (end - start) + " ns");
    }
}

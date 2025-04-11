import java.util.Arrays;
import java.util.Random;

public class SortComparison {
    public static void main(String[] args) {
        int size = 10000;
        int[] original = new Random().ints(size, 0, size).toArray();

        // Bubble Sort
        int[] bubble = Arrays.copyOf(original, size);
        long start = System.nanoTime();
        for (int i = 0; i < bubble.length - 1; i++) {
            for (int j = 0; j < bubble.length - i - 1; j++) {
                if (bubble[j] > bubble[j + 1]) {
                    int temp = bubble[j];
                    bubble[j] = bubble[j + 1];
                    bubble[j + 1] = temp;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (end - start) + " ns");

        // Merge Sort
        int[] merge = Arrays.copyOf(original, size);
        start = System.nanoTime();
        Arrays.sort(merge); // Java uses Dual-Pivot QuickSort or TimSort depending on array type
        end = System.nanoTime();
        System.out.println("Merge/Quick Sort Time (Java Arrays.sort): " + (end - start) + " ns");
    }
}

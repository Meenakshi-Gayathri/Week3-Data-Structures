import java.util.HashSet;
import java.util.Set;

public class MissingNumberFinder {
    public int findMissing(int[] nums, int n) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1; // No missing number
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 3, 7, 8};
        int n = 8;

        MissingNumberFinder finder = new MissingNumberFinder();
        int missing = finder.findMissing(nums, n);
        System.out.println("Missing number is: " + missing); // Output: 5
    }
}

import java.util.Arrays;

public class LinearBinarySearch {

    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] present = new boolean[n + 1];

        for (int num : nums) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!present[i]) return i;
        }

        return n + 1;
    }

    public static int binarySearch(int[] sortedArr, int target) {
        int left = 0, right = sortedArr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sortedArr[mid] == target) return mid;
            if (sortedArr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int target = 4;

        int missing = findFirstMissingPositive(arr);
        System.out.println("First missing positive: " + missing);

        Arrays.sort(arr);
        int index = binarySearch(arr, target);
        System.out.println("Index of target (" + target + "): " + index);
    }
}
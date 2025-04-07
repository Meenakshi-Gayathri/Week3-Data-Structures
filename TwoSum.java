import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) {
                return new int[]{map.get(rem), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // Not found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        TwoSum ts = new TwoSum();
        int[] result = ts.findTwoSum(nums, target);

        if (result[0] != -1) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum pair found.");
        }
    }
}

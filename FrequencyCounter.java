import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {
    public void countFrequency(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            System.out.println("Element: " + entry.getKey() + ", Frequency: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 1, 4, 3, 1};
        FrequencyCounter counter = new FrequencyCounter();
        counter.countFrequency(nums);
    }
}

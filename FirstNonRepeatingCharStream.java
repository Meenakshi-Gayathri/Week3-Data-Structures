import java.util.*;

public class FirstNonRepeatingCharStream {
    public String firstNonRepeating(String stream) {
        Map<Character, Integer> freq = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (char ch : stream.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            q.offer(ch);

            while (!q.isEmpty() && freq.get(q.peek()) > 1) {
                q.poll();
            }

            result.append(q.isEmpty() ? "#" : q.peek());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String stream = "aabc";
        FirstNonRepeatingCharStream obj = new FirstNonRepeatingCharStream();
        String result = obj.firstNonRepeating(stream);
        System.out.println("Result: " + result); // Output: "a#bb"
    }
}

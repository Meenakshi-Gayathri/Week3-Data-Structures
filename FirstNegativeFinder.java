public class FirstNegativeFinder {

    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, -2, 9, -8};
        int index = findFirstNegative(arr);
        System.out.println("Index of First Negative Number: " + index);
    }
}

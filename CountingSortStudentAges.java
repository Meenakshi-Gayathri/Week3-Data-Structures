import java.util.Scanner;

public class CountingSortStudentAges {

    public void countingSort(int[] ages) {
        int max = 18, min = 10;
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        for (int age : ages) {
            count[age - min]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }

        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] ages = new int[n];

        System.out.println("Enter ages (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
        }

        CountingSortStudentAges sorter = new CountingSortStudentAges();
        System.out.println("Original ages:");
        sorter.printArray(ages);

        sorter.countingSort(ages);

        System.out.println("Sorted ages in ascending order:");
        sorter.printArray(ages);

        sc.close();
    }
}

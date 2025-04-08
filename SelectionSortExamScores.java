import java.util.Scanner;

public class SelectionSortExamScores {

    public void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = scores[minIdx];
            scores[minIdx] = scores[i];
            scores[i] = temp;
        }
    }

    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] scores = new int[n];

        System.out.println("Enter exam scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        SelectionSortExamScores sorter = new SelectionSortExamScores();
        System.out.println("Original scores:");
        sorter.printArray(scores);

        sorter.selectionSort(scores);

        System.out.println("Sorted scores in ascending order:");
        sorter.printArray(scores);

        sc.close();
    }
}

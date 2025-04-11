import java.io.*;

public class FileReadComparison {
    public static void main(String[] args) throws IOException {
        // Use the full path to your file
        File file = new File("C:\\Users\\meena\\OneDrive\\Desktop\\Capgemini\\Week 3\\06- Submission of Algorithm's Runtime Analysis & Big-O Notation\\large.txt");

        if (!file.exists()) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return;
        }

        // FileReader test
        long start = System.nanoTime();
        try (FileReader fr = new FileReader(file)) {
            while (fr.read() != -1) {
                // just read, do nothing
            }
        }
        long end = System.nanoTime();
        System.out.println("FileReader Time: " + (end - start) / 1_000_000 + " ms");

        // InputStreamReader test
        start = System.nanoTime();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file))) {
            while (isr.read() != -1) {
                // just read, do nothing
            }
        }
        end = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (end - start) / 1_000_000 + " ms");
    }
}

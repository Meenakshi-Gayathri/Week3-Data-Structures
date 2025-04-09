import java.io.*;

public class WordCount {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
        String target = "the";
        int count = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.equals(target)) count++;
            }
        }
        reader.close();
        System.out.println("Count: " + count);
    }
}
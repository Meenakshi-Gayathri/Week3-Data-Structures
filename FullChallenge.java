import java.io.*;

public class FullChallenge {
    public static void main(String[] args) throws Exception {
        int n = 1000000;

        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("hello");
        long end = System.nanoTime();
        System.out.println("StringBuilder: " + (end - start));

        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) sbf.append("hello");
        end = System.nanoTime();
        System.out.println("StringBuffer: " + (end - start));

        BufferedReader fr = new BufferedReader(new FileReader("largefile.txt"));
        int words = 0;
        String line;
        start = System.nanoTime();
        while ((line = fr.readLine()) != null) {
            words += line.split("\\s+").length;
        }
        end = System.nanoTime();
        fr.close();
        System.out.println("FileReader Word Count: " + words + ", Time: " + (end - start));

        BufferedReader ir = new BufferedReader(new InputStreamReader(new FileInputStream("largefile.txt"), "UTF-8"));
        words = 0;
        start = System.nanoTime();
        while ((line = ir.readLine()) != null) {
            words += line.split("\\s+").length;
        }
        end = System.nanoTime();
        ir.close();
        System.out.println("InputStreamReader Word Count: " + words + ", Time: " + (end - start));
    }
}
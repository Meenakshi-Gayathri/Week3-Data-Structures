import java.io.*;

public class ReadWriteInput {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        String line;
        while (!(line = reader.readLine()).equals("exit")) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
}
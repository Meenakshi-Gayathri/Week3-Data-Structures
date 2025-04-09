public class CompareConcat {
    public static void main(String[] args) {
        int n = 1000000;
        long start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) sbf.append("hello");
        long end = System.nanoTime();
        System.out.println("StringBuffer: " + (end - start));

        start = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < n; i++) sbd.append("hello");
        end = System.nanoTime();
        System.out.println("StringBuilder: " + (end - start));
    }
}
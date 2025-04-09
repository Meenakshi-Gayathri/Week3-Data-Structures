
public class ConcatenateStrings {
    public static String concatenate(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"Java", "is", "fun"};
        System.out.println(concatenate(arr));
    }
}


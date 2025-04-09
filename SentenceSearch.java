public class SentenceSearch {

    public static String searchSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) return sentence;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The sky is blue",
            "Java is a programming language",
            "Artificial Intelligence is the future",
            "I love learning new things"
        };
        String word = "Java";

        String result = searchSentence(sentences, word);
        System.out.println(result);
    }
}

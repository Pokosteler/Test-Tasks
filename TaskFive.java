import java.io.*;

class DecisionFive {
    private String word;

    DecisionFive() {
        try {
            System.out.print("Enter word: ");
            validatePalindromeWord(getKey());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    private String getKey() {
        String direction = "";
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            direction = String.valueOf(br.readLine());
        } catch (Exception e) {
            System.out.println("Input Error!");
        }
        return direction;
    }

    private void validatePalindromeWord(String s) {
        try {
            char[] arrStringBackwards = new char[s.length()];
            for (int i = s.length() - 1; i >= 0; i--) {
                arrStringBackwards[s.length() - i - 1] = s.charAt(i);
            }
            if (s.replaceAll(" ", "").equalsIgnoreCase(String.valueOf
                    (arrStringBackwards).replaceAll(" ", ""))) {
                System.out.println("It's a palindrome!");
            } else {
                System.out.println("It's not a palindrome!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

public class TaskFive {
    public static void main(String[] args) {
        new DecisionFive();
    }
}

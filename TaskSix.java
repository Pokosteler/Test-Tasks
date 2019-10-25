import java.io.BufferedReader;
import java.io.InputStreamReader;

class DecisionSix {
    private String word;

    DecisionSix() {
        try {
            System.out.print("Enter word: ");
            deleteNumber(getKey());
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

    private void deleteNumber(String s) {
        try {
            s = s.replaceAll("[0-9]", "");
            System.out.println(s);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

public class TaskSix {
    public static void main(String[] args) {
        new DecisionSix();
    }
}

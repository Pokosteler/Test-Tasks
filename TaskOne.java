import java.io.BufferedReader;
import java.io.InputStreamReader;

class DecisionOne {
    private int n;

    DecisionOne() {
        try {
            System.out.print("N = ");
            setN(getKey());
            findPrimeNumbers(getN());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    private int getKey() {
        int direction = 0;
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            direction = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.out.println("Input Error!");
        }
        return direction;
    }

    private void findPrimeNumbers(int n) {
        try {
            for (int i = 2; i <= n; i++) {
                boolean validate = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        validate = false;
                    }
                }
                if (validate) System.out.print(i + " ");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

public class TaskOne {
    public static void main(String[] args) {
        new DecisionOne();
    }
}

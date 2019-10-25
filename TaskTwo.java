import java.io.BufferedReader;
import java.io.InputStreamReader;

class DecisionTwo {
    private int n;

    DecisionTwo() {
        try {
            System.out.print("N = ");
            int n = getKey();
            int i = 1;
            while (fibonacci(i) <= n) {
                System.out.print(fibonacci(i) + " ");
                i++;
            }
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

    private int fibonacci(int n) {
        try {
            if (n == 0) {
                return 0;
            }
            if (n == 1 || n == 2) {
                return 1;
            }
            return fibonacci(n - 2) + fibonacci(n - 1);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return 0;
    }
}

public class TaskTwo {
    public static void main(String[] args) {
        new DecisionTwo();
    }
}

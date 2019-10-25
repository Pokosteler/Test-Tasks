import java.io.BufferedReader;
import java.io.InputStreamReader;

class DecisionFour {
    private int a;
    private int b;

    DecisionFour() {
        try {
            System.out.print("Enter a: ");
            setA(getKey());
            System.out.print("Enter b: ");
            setB(getKey());
            System.out.println("GCD = " + findGCD(getA(), getB()));
            System.out.println("LCM = " + findLCM(getA(), getB()));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getB() {
        return b;
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

    private int findGCD(int a, int b) {
        try {
            if (a == 0 && b != 0) {
                return b;
            }
            if (a != 0 && b == 0) {
                return a;
            }
            if (a == 1 && b != 1 || b == 1 && a != 1) {
                return 1;
            }
            if (a == b) {
                return a;
            }
            if (a < 0 || b < 0) {
                return findGCD(Math.abs(a), Math.abs(b));
            }
            if (a % 2 == 0) {
                if (b % 2 == 0) {
                    return 2 * findGCD(a / 2, b / 2);
                }
                if (b % 2 != 0) {
                    return findGCD(a / 2, b);
                }
            }
            if (a % 2 != 0) {
                if (b % 2 == 0) {
                    return findGCD(a, b / 2);
                }
                if (b % 2 != 0) {
                    if (b > a) {
                        return findGCD((b - a) / 2, a);
                    }
                    if (b < a) {
                        return findGCD((a - b) / 2, b);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return 1;
    }

    private int findLCM(int a, int b) {
        try {
            if (a != 0 && b != 0) {
                return Math.abs(a * b) / findGCD(a, b);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return 0;
    }
}

public class TaskFour {
    public static void main(String[] args) {
        new DecisionFour();
    }
}

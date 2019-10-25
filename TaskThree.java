import java.io.BufferedReader;
import java.io.InputStreamReader;

class Point {
    private double x;
    private double y;

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }
}

class Segment {
    Point point1 = new Point();
    Point point2 = new Point();
    Point point3 = new Point();
    Point point4 = new Point();

    Segment() {
        try {
            System.out.println(intersectionOfSegments());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private double getKey() {
        double direction = 0;
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            direction = Double.parseDouble(br.readLine());
        } catch (Exception e) {
            System.out.println("Input Error!");
        }
        return direction;
    }

    private void init() {
        try {
            System.out.print("Enter x for 1st point of the 1st segment: ");
            point1.setX(getKey());
            System.out.print("Enter y for 1st point of the 1st segment: ");
            point1.setY(getKey());
            System.out.print("Enter x for 2nd point of the 1st segment: ");
            point2.setX(getKey());
            System.out.print("Enter y for 2nd point of the 1st segment: ");
            point2.setY(getKey());
            System.out.print("Enter x for 1st point of the 2nd segment: ");
            point3.setX(getKey());
            System.out.print("Enter y for 1st point of the 2nd segment: ");
            point3.setY(getKey());
            System.out.print("Enter x for 2nd point of the 2nd segment: ");
            point4.setX(getKey());
            System.out.print("Enter y for 2nd point of the 2nd segment: ");
            point4.setY(getKey());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private boolean intersectionOfSegments() {
        try {
            init();
            if (point2.getX() < point1.getX()) {
                Point v = point1;
                point1 = point2;
                point2 = v;
            }
            if (point4.getX() < point3.getX()) {
                Point v = point3;
                point3 = point4;
                point4 = v;
            }
            if (point2.getX() < point3.getX()) {
                return false;
            }
            if ((point1.getX() - point2.getX() == 0) && (point3.getX() - point4.getX() == 0)) {
                if (point1.getX() == point3.getX()) {
                    if (!((Math.max(point1.getY(), point2.getY()) < Math.min(point3.getY(), point4.getY())) ||
                            (Math.min(point1.getY(), point2.getY()) > Math.max(point3.getY(), point4.getY())))) {
                        return true;
                    }
                }
                return false;
            }
            if (point1.getX() - point2.getX() == 0) {
                double abscissa = point1.getX();
                double a2 = (point3.getY() - point4.getY()) / (point3.getX() - point4.getX());
                double b2 = point3.getY() - a2 * point3.getX();
                double ordinate = a2 * abscissa + b2;
                if (point3.getX() <= abscissa && point4.getX() >= abscissa && Math.min(point1.getY(),
                        point2.getY()) <= ordinate && Math.max(point1.getY(), point2.getY()) >= ordinate) {
                    return true;
                }
                return false;
            }
            if (point3.getX() - point4.getX() == 0) {
                double abscissa = point3.getX();
                double a1 = (point1.getY() - point2.getY()) / (point1.getX() - point2.getX());
                double b1 = point1.getY() - a1 * point1.getX();
                double ordinate = a1 * abscissa + b1;
                if (point1.getX() <= abscissa && point2.getX() >= abscissa && Math.min(point3.getY(),
                        point4.getY()) <= ordinate && Math.max(point3.getY(), point4.getY()) >= ordinate) {
                    return true;
                }
                return false;
            }
            double a1 = (point1.getY() - point2.getY()) / (point1.getX() - point2.getX());
            double a2 = (point3.getY() - point4.getY()) / (point3.getX() - point4.getX());
            double b1 = point1.getY() - a1 * point1.getX();
            double b2 = point3.getY() - a2 * point3.getX();
            if (a1 == a2) {
                return false;
            }
            double abscissa = (b2 - b1) / (a1 - a2);
            if ((abscissa < Math.max(point1.getX(), point3.getX())) || (abscissa > Math.min(point2.getX(), point4.getX()))) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return true;
    }
}

public class TaskThree {
    public static void main(String[] args) {
        new Segment();
    }
}

import java.util.Scanner;

public class JAHA006_KiemTraVaTinhDienTichTamGiac {
    public static class Point{
        private double x,y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public static double distance(Point p1, Point p2){
            return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            Point p1 = new Point(sc.nextDouble(), sc.nextDouble());
            Point p2 = new Point(sc.nextDouble(), sc.nextDouble());
            Point p3 = new Point(sc.nextDouble(), sc.nextDouble());
            double c1 = Point.distance(p1, p2);
            double c2 = Point.distance(p1, p3);
            double c3 = Point.distance(p2, p3);
            if(c1+c2<=c3 || c1+c3<=c2 || c2+c3<=c1) {
                System.out.println("INVALID");
            } else {
                double P = (c1 + c2 + c3) / 2;
                System.out.printf("%.4f\n", Math.sqrt(P * (P - c1) * (P - c2) * (P - c3)));
            }
        }
    }
}

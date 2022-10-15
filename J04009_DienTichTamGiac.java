import java.util.Map;
import java.util.Scanner;

public class J04009_DienTichTamGiac {
    public static class Point {
        private double x, y;

        public Point() {
        }

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

        public double distance(Point secondPoint){
            return Math.sqrt(Math.pow(x - secondPoint.getX(),2) + Math.pow(y - secondPoint.getY(),2));
        }

        public static double distance(Point p1, Point p2){
            return Math.sqrt(Math.pow(p1.getX() - p2.getX(),2) + Math.pow(p1.getY() - p2.getY(),2));
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            Point p1 = new Point(sc.nextDouble(), sc.nextDouble());
            Point p2 = new Point(sc.nextDouble(), sc.nextDouble());
            Point p3 = new Point(sc.nextDouble(), sc.nextDouble());
            double c1 = Point.distance(p1,p2);
            double c2 = Point.distance(p1,p3);
            double c3 = Point.distance(p2,p3);
            if((c1 + c2 <= c3) || (c1 + c3 <= c2) || (c2 + c3 <= c1)){
                System.out.println("INVALID");
            }else {
                System.out.printf("%.2f\n", Math.sqrt((c1+c2+c3)*(c1+c2-c3)*(c1-c2+c3)*(-c1+c2+c3))/4);
            }
        }
    }
}
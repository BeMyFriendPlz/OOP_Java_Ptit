import java.util.Scanner;

public class J04019_LopTriangle_1 {
    public static class Point {
        private double x, y;

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

        public static Point nextPoint(Scanner sc){
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            return new Point(x,y);
        }

        public static double distance(Point p1, Point p2){
            return Math.sqrt(Math.pow(p1.getX() - p2.getX(),2) + Math.pow(p1.getY() - p2.getY(),2));
        }
    }

    public static class Triangle {
        private Point p1, p2, p3;
        private double c1, c2, c3;

        public Triangle(Point p1, Point p2, Point p3) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            c1 = Point.distance(p1, p2);
            c2 = Point.distance(p2, p3);
            c3 = Point.distance(p3, p1);
        }

        public boolean valid() {
            if((c1 + c2 <= c3) || (c1 + c3 <= c2) || (c2 + c3 <= c1)) {
                return false;
            }else {
                return true;
            }
        }

        public String getPerimeter() {
            return String.format("%.3f", c1 + c2 + c3);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
}

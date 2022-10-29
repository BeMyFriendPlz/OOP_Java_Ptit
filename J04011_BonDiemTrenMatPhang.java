import java.util.Scanner;

public class J04011_BonDiemTrenMatPhang {
    public static class Point3D {
        private int x, y, z;

        public Point3D(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public static boolean check(Point3D p1, Point3D p2, Point3D p3, Point3D p4) {
            int k=(-((p2.y - p1.y)*(p3.z - p1.z) - (p3.y - p1.y)*(p2.z - p1.z)) * p1.x - ((p3.x - p1.x)*(p2.z - p1.z) - (p2.x - p1.x)*(p3.z - p1.z)) * p1.y - ((p2.x - p1.x)*(p3.y - p1.y) - (p2.y - p1.y)*(p3.x - p1.x)) * p1.z);
            if(((p2.y - p1.y)*(p3.z - p1.z) - (p3.y - p1.y)*(p2.z - p1.z)) * p4.x + ((p3.x - p1.x)*(p2.z - p1.z) - (p2.x - p1.x)*(p3.z - p1.z)) * p4.y + ((p2.x - p1.x)*(p3.y - p1.y) - (p2.y - p1.y)*(p3.x - p1.x)) * p4.z + k== 0) return true;
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            Point3D p1 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            Point3D p2 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            Point3D p3 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            Point3D p4 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());

            if(Point3D.check(p1,p2,p3,p4)){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }
    }
}

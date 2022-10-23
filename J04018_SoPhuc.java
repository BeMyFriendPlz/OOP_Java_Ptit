import java.util.Scanner;

public class J04018_SoPhuc {
    public static class SoPhuc {
        private int x,y;

        public SoPhuc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public SoPhuc Nhan(SoPhuc soPhuc) {
            int a = x*soPhuc.getX() - y*soPhuc.getY();
            int b = x*soPhuc.getY() + y*soPhuc.getX();
            return new SoPhuc(a, b);
        }

        public SoPhuc Cong(SoPhuc soPhuc) {
            int a = x + soPhuc.getX();
            int b = y + soPhuc.getY();
            return new SoPhuc(a, b);
        }

        @Override
        public String toString() {
            String ans = "";
            if(y < 0) {
                ans = String.format("%d - %di", x, -y);
            } else if(y >= 0) {
                ans = String.format("%d + %di", x, y);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            SoPhuc a = new SoPhuc(sc.nextInt(), sc.nextInt());
            SoPhuc b = new SoPhuc(sc.nextInt(), sc.nextInt());
            SoPhuc c = a.Cong(b).Nhan(a);
            SoPhuc d = a.Cong(b).Nhan(a.Cong(b));
            System.out.println(c + ", " + d);
        }
    }
}

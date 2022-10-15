import java.util.Scanner;

public class J01025_HinhVuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();
        int maxx = Math.max(Math.max(Math.abs(a1-d1), Math.abs(b1-c1)), Math.max(Math.abs(a1-b1), Math.abs(c1-d1)));
        int maxy = Math.max(Math.max(Math.abs(a2-d2), Math.abs(b2-c2)), Math.max(Math.abs(a2-b2), Math.abs(c2-d2)));
        System.out.println((long) Math.pow(Math.max(maxx,maxy),2));
    }
}
